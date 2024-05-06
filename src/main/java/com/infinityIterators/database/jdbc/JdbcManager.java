package com.infinityIterators.database.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

public class JdbcManager {
    private final String propertyPath = "src/main/java/com/infinityIterators/config/dbcon.properties";
    private Properties properties = new Properties();
    private Connection connection;

    private class JdbcManagerHolder {
        private static final JdbcManager INSTANCE = new JdbcManager();
    }

    private JdbcManager() {
    }

    public static JdbcManager getInstance() {
        return JdbcManagerHolder.INSTANCE;
    }

    private void loadProperties() throws IOException {
        properties.load(new FileReader(propertyPath));
    }

    public Connection getConnection() {
        try {
            loadProperties();
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
