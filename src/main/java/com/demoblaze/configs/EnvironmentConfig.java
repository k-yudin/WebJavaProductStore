package com.demoblaze.configs;

import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = EnvProperties.getInstance();

    public static String getBrowser() {
        String browser = properties.getProperty("BROWSER");
        return browser;
    }
}
