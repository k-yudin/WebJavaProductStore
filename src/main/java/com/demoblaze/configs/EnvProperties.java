package com.demoblaze.configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvProperties {

    private static Properties instance;

    private EnvProperties() {}

    public static Properties getInstance() {
        if (instance == null) {
            Properties prop = new Properties();
            try {
                InputStream input = EnvProperties.class.getResourceAsStream("/env.properties");
                prop.load(input);
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
            instance = prop;
        }
        return instance;
    }
}
