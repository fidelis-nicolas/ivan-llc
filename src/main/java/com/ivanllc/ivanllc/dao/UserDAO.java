package com.ivanllc.ivanllc.dao;

import com.ivanllc.ivanllc.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void registerUser(User user) {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT into users VALUES(null,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getEmail());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getUserRole());
            statement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authUser(User user){
        return  false;
    }
}
