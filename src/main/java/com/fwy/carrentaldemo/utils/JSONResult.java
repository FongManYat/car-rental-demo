package com.fwy.carrentaldemo.utils;

import com.alibaba.fastjson.JSONObject;

public class JSONResult {
        public static String fillResultString(String status, String message, Object result){
            JSONObject jsonObject = new JSONObject(){{
                put("errcode", status);
                put("errmsg", message);
                put("data", result);
            }};

            return jsonObject.toString();
        }
}
