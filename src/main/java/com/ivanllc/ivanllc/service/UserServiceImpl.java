package com.ivanllc.ivanllc.service;

import com.ivanllc.ivanllc.dao.UserDAO;
import com.ivanllc.ivanllc.dao.UserDAOImpl;
import com.ivanllc.ivanllc.entity.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private String name;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void registerUser(User user) {
        if (user == null
                || user.getEmail() == null || user.getEmail().isBlank()
                || user.getPassword() == null || user.getPassword().isBlank()) {
            throw new RuntimeException("User details can't be empty");
        }
        //TODO add check for email
        //TODO add check for confirm password
        userDAO.registerUser(user);
    }

    @Override
    public User authUser(String email, String password) {
        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return null;
        }
        return userDAO.authUser(email.trim(), password);
    }
}
