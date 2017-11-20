package com.stepsolar.sr.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptHashGenerator {

	public static String passwordHash(String passwordPlaintext) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(passwordPlaintext);
		return hashedPassword;
	}

	/**
	 * This method can be used to verify a computed hash from a plaintext (e.g.
	 * during a login request) with that of a stored hash from a database. The
	 * password hash from the database must be passed as the second variable.
	 *
	 * @param password_plaintext
	 *            The user's plaintext password, as provided during a login request
	 * @param stored_hash
	 *            The user's stored password hash, retrieved from the authorization
	 *            database
	 * @return boolean - true if the password matches the password of the stored
	 *         hash, false otherwise
	 */
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
		}

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return (password_verified);
	}

}
