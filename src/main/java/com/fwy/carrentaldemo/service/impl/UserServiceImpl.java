package com.fwy.carrentaldemo.service.impl;

import com.fwy.carrentaldemo.entity.User;
import com.fwy.carrentaldemo.mapper.UserMapper;
import com.fwy.carrentaldemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        User userDB = userMapper.login(user);
        if (userDB != null) {
            return userDB;
        }
        throw new RuntimeException("认证失败");
    }

    @Override
    public User queryByUsername(String username) {
        return userMapper.queryUser(username);
    }

    @Override
    public int signup(User user) {
        if (queryByUsername(user.getUsername())==null){
            return userMapper.signup(user);
        }else{
            return -1;
        }
    }
}
