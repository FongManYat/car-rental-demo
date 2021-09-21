package com.fwy.carrentaldemo.exception;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Object handlerDatabaseException(Exception e){
        log.error("Error Message: "+e);
        JSONObject response = new JSONObject();

        response.put("errcode","0400");
        response.put("errmsg","System Error");
        response.put("data",null);

        return response;

    }
}
