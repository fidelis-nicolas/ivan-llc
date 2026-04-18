package com.ivanllc.ivanllc.service;

import com.ivanllc.ivanllc.dao.UserDAO;
import com.ivanllc.ivanllc.entity.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAO();

    @Override
    public void registerUser(User user) {
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            throw new RuntimeException("User details can't be empty");
    }
        //TODO add check for email
        //TODO add check for confirm password
        userDAO.registerUser(user);
    }
}
