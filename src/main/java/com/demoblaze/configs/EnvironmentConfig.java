package com.demoblaze.configs;

import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = EnvProperties.getInstance();

    public static String getBrowser() {
        String browser = properties.getProperty("BROWSER");
        if (browser != null && !browser.contains("$")) {
            return browser;
        }
        else
            return System.getenv("BROWSER");
    }

    public static String getHost() {
        String host = System.getenv("HOST");
        if (host == null)
            return "LOCAL";
        else
            return host;
    }

    public static String getRemoteURL() { return System.getenv("REMOTE_URL"); }
}
