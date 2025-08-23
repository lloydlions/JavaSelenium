package org.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties;

    static {
        try(FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
