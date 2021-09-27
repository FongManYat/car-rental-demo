package com.fwy.carrentaldemo.service;

import com.fwy.carrentaldemo.entity.User;

public interface IUserService {

    User login(User user);

    User queryByUsername(String username);

    int signup(User user);
}
