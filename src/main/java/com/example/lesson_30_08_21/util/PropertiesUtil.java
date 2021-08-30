package com.example.lesson_30_08_21.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Properties PROPERTIES=new Properties();

    static {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

}
