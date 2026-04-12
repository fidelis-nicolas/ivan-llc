package com.ivanllc.ivanllc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection () throws SQLException {
        Connection connect = DriverManager.getConnection("JDBC:mysql://localhost:3306/ivanllc",
                "root", "");
        return connect;
    }

}
