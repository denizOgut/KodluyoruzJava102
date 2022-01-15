package com.patikadev.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
    private Connection connection = null;

    public Connection connectDB() throws SQLException {
        connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        return this.connection;
    }

    public static Connection getInstance() throws SQLException {
        DBConnecter dbConnecter = new DBConnecter();
        return dbConnecter.connectDB();
    }

}
