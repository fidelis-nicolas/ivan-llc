package com.ivanllc.ivanllc.dao;

import com.ivanllc.ivanllc.entity.User;

public interface UserDAO {
    User authUser(String email, String password);
    public void registerUser(User user);
}
