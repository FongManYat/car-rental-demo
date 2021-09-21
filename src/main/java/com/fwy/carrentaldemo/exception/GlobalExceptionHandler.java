package com.fwy.carrentaldemo.exception;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public Object handlerParseException(ParseException e){
        log.error("Error Message: "+e);
        JSONObject response = new JSONObject();

        response.put("errcode","0403");
        response.put("errmsg","Date Invalid");
        response.put("data",null);

        return response;

    }

    @ExceptionHandler
    @ResponseBody
    public Object handlerDatabaseException(DataIntegrityViolationException e){
        log.error("Error Message: "+e);
        JSONObject response = new JSONObject();

        response.put("errcode","0402");
        response.put("errmsg","Data Integrity Violated");
        response.put("data",null);

        return response;

    }

    @ExceptionHandler
    @ResponseBody
    public Object handlerDatabaseDownException(MyBatisSystemException e){
        log.error("Error Message: "+e);
        JSONObject response = new JSONObject();

        response.put("errcode","0403");
        response.put("errmsg","Database Down");
        response.put("data",null);

        return response;

    }


    @ExceptionHandler
    @ResponseBody
    public Object handlerException(Exception e){
        log.error("Error Message: "+e);
        JSONObject response = new JSONObject();

        response.put("errcode","0400");
        response.put("errmsg","System Error");
        response.put("data",null);

        return response;

    }
}
