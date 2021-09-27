package com.fwy.carrentaldemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fwy.carrentaldemo.entity.User;
import com.fwy.carrentaldemo.service.IUserService;
import com.fwy.carrentaldemo.utils.JSONResult;
import com.fwy.carrentaldemo.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @GetMapping("/user/login")
    public Object login(String username, String password) {
        log.info("username：{}", username);
        log.info("password: {}", password);

        Map<String, Object> map = new HashMap<>();

        try {
            User userDB = userService.login(new User(username, password));

            Map<String, String> payload = new HashMap<>();
            payload.put("userid", Integer.toString(userDB.getUserid()));
            payload.put("name", userDB.getName());
            String token = JWTUtils.getToken(payload);

            map.put("token", token);
            return JSONResult.fillResultString("0200","Successful",map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
            map.put("token", "");
            return JSONResult.fillResultString("0910","Login Failed","");
        }
    }

    @PostMapping("/user/signup")
    public String signup(@RequestBody JSONObject jsonParam){
        String username = jsonParam.getObject("username",String.class);
        String password = jsonParam.getObject("password",String.class);
        if (userService.signup(new User(username, password))<0){
            return JSONResult.fillResultString("0403","User Already Exist!", "null");
        }
        else{
            return  JSONResult.fillResultString("0200","Successful", "null");
        }

    }

}
