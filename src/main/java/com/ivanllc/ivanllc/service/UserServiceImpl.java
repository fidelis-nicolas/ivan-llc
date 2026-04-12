package com.ivanllc.ivanllc.service;

import com.ivanllc.ivanllc.dao.UserDAO;
import com.ivanllc.ivanllc.entity.User;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAO();

    @Override
    public void registerUser(User user) {
        userDAO.registerUser(user);
    }
}
