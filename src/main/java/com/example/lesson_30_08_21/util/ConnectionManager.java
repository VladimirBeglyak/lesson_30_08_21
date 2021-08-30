package com.example.lesson_30_08_21.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

private static final String URL_KEY="url";
private static final String USER_KEY="user";
private static final String PASSWORD_KEY="password";
private static final String DRIVER_KEY="driver";

static {
    try {
        Class.forName(PropertiesUtil.get(DRIVER_KEY));
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}

public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(
            PropertiesUtil.get(URL_KEY),
            PropertiesUtil.get(USER_KEY),
            PropertiesUtil.get(PASSWORD_KEY)
    );
}

}
