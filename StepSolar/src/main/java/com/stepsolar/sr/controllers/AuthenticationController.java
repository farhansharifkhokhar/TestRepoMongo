package com.stepsolar.sr.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stepsolar.sr.dto.UserDto;
import com.stepsolar.sr.dto.UserTokenStateDto;
import com.stepsolar.sr.entities.User;
import com.stepsolar.sr.security.TokenHelper;
import com.stepsolar.sr.security.auth.JwtAuthenticationRequest;
import com.stepsolar.sr.services.UserService;
import com.stepsolar.sr.util.BcryptHashGenerator;
import com.stepsolar.sr.util.DeviceProvider;

import exceptionHandler.ApiErrorRespone;
import exceptionHandler.ErrorTypeConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by Farhan Sharif Khokhar 16/11/2017.
 */
@Api(tags = ("AuthenticationController"))
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
	private static Logger log = LogManager.getLogger(AuthenticationController.class);
	@Autowired
	TokenHelper tokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private DeviceProvider deviceProvider;
	@Autowired
	private Environment env;
	@Autowired
	private MessageSource messageSource;
	private Locale locale = LocaleContextHolder.getLocale();
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	private LinkedHashMap<Object, Object> apiResponse = new LinkedHashMap<Object, Object>();
	private LinkedHashMap<String, Object> serviceResponse = new LinkedHashMap<String, Object>();

	private static final Logger logger = LogManager.getLogger(AuthenticationController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response, Device device) throws AuthenticationException, IOException {

		User authenticationUser = userService.findByEmail(authenticationRequest.getEmail());
		if (authenticationUser == null) {
			apiResponse = exceptionHandler.ApiErrorRespone.buildGenericError(ErrorTypeConstants.NOT_FOUND_EXCEPTION,
					HttpStatus.NOT_FOUND.toString(), messageSource.getMessage("login.user.not.found", null, locale));
			return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
		if (!BcryptHashGenerator.checkPassword(authenticationRequest.getPassword(), authenticationUser.getPassword())) {
			apiResponse = ApiErrorRespone.buildGenericError(ErrorTypeConstants.NOT_FOUND_EXCEPTION,
					HttpStatus.NOT_FOUND.toString(), messageSource.getMessage("login.user.not.found", null, locale));
			return new ResponseEntity<Object>(apiResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
		logger.info("Start Perform the security");
		// Perform the security
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
						authenticationRequest.getPassword()));

		// Inject into security context
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// token creation
		User user = (User) authentication.getPrincipal();
		String jws = tokenHelper.generateToken(user.getUsername(), user.getId().toString(), device);
		int expiresIn = tokenHelper.getExpiredIn(device);
		UserDto getUser = modelMapper.map(userService.findByEmail(authenticationRequest.getEmail()), UserDto.class);
		// Add cookie to response
		response.addCookie(createAuthCookie(jws, expiresIn));
		// Return the token
		return ResponseEntity.ok(new com.stepsolar.sr.entities.LoginResponseDto(jws, getUser));
	}

	@ApiOperation(value = "Update Token", notes = "Update Token")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "header") })
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response,
			Principal principal) {

		String authToken = tokenHelper.getToken(request);

		Device device = deviceProvider.getCurrentDevice(request);

		if (authToken != null && principal != null) {

			// TODO check user password last update
			String refreshedToken = tokenHelper.refreshToken(authToken, device);
			int expiresIn = tokenHelper.getExpiredIn(device);

			// Add cookie to response
			response.addCookie(createAuthCookie(refreshedToken, expiresIn));

			return ResponseEntity.ok(new UserTokenStateDto(refreshedToken, expiresIn));
		} else {
			UserTokenStateDto userTokenState = new UserTokenStateDto();
			return ResponseEntity.accepted().body(userTokenState);
		}
	}

	private Cookie createAuthCookie(String jwt, int expiresIn) {
		Cookie authCookie = new Cookie(tokenHelper.AUTH_TOKEN_COOKIE, (jwt));
		authCookie.setPath("/");
		authCookie.setHttpOnly(true);
		authCookie.setMaxAge(expiresIn);
		return authCookie;
	}
}