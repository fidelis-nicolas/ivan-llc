package com.ivanllc.ivanllc.dao;

import com.ivanllc.ivanllc.entity.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO{

    @Override
    public void registerUser(User user)  {
        String sql = "INSERT INTO users (email, password, role_name) VALUES (?, ?, ?)";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUserRole());
            statement.executeUpdate();

            try (ResultSet rs = statement.getGeneratedKeys()) {
                while (rs.next()) {
                    int key = rs.getInt(1);
                    System.out.println("Primary inserted last: " + key);
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Email already exists", e);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to register user", e);
        }
    }

    @Override
    public User authUser(String email, String password) {
        User dUser = null;
        String sql = "SELECT email, role_name FROM users WHERE email = ? AND password = ?";
        try (Connection connection = DBConnect.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (!resultSet.next()) {
                    return null;
                }

                dUser = new User();
                dUser.setEmail(resultSet.getString("email"));
                dUser.setUserRole(resultSet.getString("role_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to authenticate user", e);
        }
        return dUser;
    }
}
