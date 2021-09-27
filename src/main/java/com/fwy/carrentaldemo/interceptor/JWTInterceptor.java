package com.fwy.carrentaldemo.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwy.carrentaldemo.utils.JSONResult;
import com.fwy.carrentaldemo.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(JWTInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        //获取请求头中的令牌
        String token = request.getHeader("token");
        log.info("当前token为：{}", token);

        //Map<String, Object> map = new HashMap<>();
        String res;
        try {
            JWTUtils.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            res =  JSONResult.fillResultString("0901","Signature Notvalid","null");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            res =  JSONResult.fillResultString("0902","Token expired","null");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            res =  JSONResult.fillResultString("0903","Algorithm unmatch","null");
        } catch (Exception e) {
            e.printStackTrace();
            res =  JSONResult.fillResultString("0904","Token Invalid","null");
        }

        //map.put("state", false);

        //响应到前台: 将map转为json
        //String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(res);
        return false;
    }
}
