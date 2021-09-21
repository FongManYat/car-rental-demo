package com.fwy.carrentaldemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fwy.carrentaldemo.entity.Car;
import com.fwy.carrentaldemo.facade.IRentCarFacade;
import com.fwy.carrentaldemo.service.ICarService;
import com.fwy.carrentaldemo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class CarRentalController {

    @Autowired
    private ICarService carService;

    @Autowired
    private IRentCarFacade rentCarFacade;

    @GetMapping("/car")
    @ResponseBody
    public Object getAllCar(){
        List<Car> carList = carService.queryAllCar();
        JSONObject response = new JSONObject();

        response.put("errcode","0000");
        response.put("errmsg","Success");
        response.put("data",carList);

        return response;
    }

    @PostMapping("/rentcar")
    @ResponseBody
    public Object rentCar(@RequestBody JSONObject jsonParam) {
        JSONObject response = new JSONObject();
        Date begindate;
        Date returndate;
        //Field Validation
        //Begin Date
        try{
            begindate = DateUtils.strToDate(jsonParam.getObject("begindate",String.class));
        } catch (Exception e) {
            response.put("errcode","0401");
            response.put("errmsg","Invalid Begin Date");
            response.put("data",null);
            return response;
        }
        //End Date
        try{
            returndate = DateUtils.strToDate(jsonParam.getObject("returndate",String.class));
        } catch (Exception e) {
            response.put("errcode","0402");
            response.put("errmsg","Invalid Return Date");
            response.put("data",null);
            return response;
        }
        //Cross Checking
        if (returndate.compareTo(begindate) == -1){
            response.put("errcode","0402");
            response.put("errmsg","Invalid Return Date");
            response.put("data",null);
            return response;
        }
        if (begindate.compareTo(new Date())==-1){
            response.put("errcode","0401");
            response.put("errmsg","Invalid Begin Date");
            response.put("data",null);
            return response;
        }

        int carId = jsonParam.getObject("carid", Integer.class);
        String customerInfo = jsonParam.getObject("customerinfo", String.class);

        return rentCarFacade.rentCar(begindate, returndate, carId, customerInfo);
    }

}
