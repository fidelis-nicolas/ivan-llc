package com.ivanllc.ivanllc.dao;

import com.ivanllc.ivanllc.entity.User;

import java.sql.*;

public class UserDAO {

    public void registerUser(User user) {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "INSERT into users VALUES(null,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUserRole());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()){
                int  key = rs.getInt(1);
                System.out.println("Primary inserted last: " + key);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User authUser(String email,String password) {
        User dUser = null;
        try {
            //TODO Write the join for the SQL to authUser
            Connection connection = DBConnect.getConnection();
            String sql = "SELECT email, password, user_role FROM users WHERE email=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                dUser = new User();
                dUser.setEmail(resultSet.getString("email"));
                dUser.setPassword(resultSet.getString("password"));
                dUser.setUserRole(resultSet.getString("user_role"));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dUser;
    }


}
