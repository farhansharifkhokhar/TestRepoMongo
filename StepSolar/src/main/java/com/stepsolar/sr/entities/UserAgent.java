package com.stepsolar.sr.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgent {
    public static final String USER_AGENT_REGX = "Step Solar/(?<appVersion>.*) \\((?<platform>.*); (?<osVersion>.*)\\) Version/(?<versionCode>.*) Mobile/(?<mobileModel>.*)";
    public static final String PLATFORM_ANDROID = "Android";
    public static final String PLATFORM_IOS = "iOS";

    private String appVersion;
    private String platform;
    private String osVersion;
    private String versionCode;
    private String mobileModel;

    public UserAgent() {
    }

    public UserAgent(String appVersion, String platform, String osVersion, String versionCode, String mobileModel) {
        this.appVersion = appVersion;
        this.platform = platform;
        this.osVersion = osVersion;
        this.versionCode = versionCode;
        this.mobileModel = mobileModel;
    }

    public static UserAgent parseAgent(String userAgentStr) {
        Pattern pattern = Pattern.compile(USER_AGENT_REGX);
        Matcher matcher = pattern.matcher(userAgentStr);
        UserAgent userAgent = null;
        if (matcher.find()) {
            userAgent = new UserAgent(
                    matcher.group("appVersion"),
                    matcher.group("platform"),
                    matcher.group("osVersion"),
                    matcher.group("versionCode"),
                    matcher.group("mobileModel"));
        }
        return userAgent;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getMobileModel() {
        return mobileModel;
    }

    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel;
    }

    public boolean isPlatformAndroid() {
        return PLATFORM_ANDROID.equals(platform);
    }

    public boolean isPlatformiOS() {
        return PLATFORM_IOS.equals(platform);
    }
}
