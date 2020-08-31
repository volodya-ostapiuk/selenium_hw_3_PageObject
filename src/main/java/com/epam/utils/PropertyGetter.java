package com.epam.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertyGetter {
    private static final String PROPERTY_PATH = "config.properties";
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertyGetter.class.getClassLoader().getResourceAsStream(PROPERTY_PATH)){
            properties.load(Objects.requireNonNull(inputStream));
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
