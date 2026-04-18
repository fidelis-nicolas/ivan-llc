package com.ivanllc.ivanllc.service;

import com.ivanllc.ivanllc.entity.User;

public interface UserService {
    void registerUser(User user);

    User authUser(String email, String password);
}

