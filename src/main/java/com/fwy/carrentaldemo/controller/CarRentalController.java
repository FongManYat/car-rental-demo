package com.fwy.carrentaldemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fwy.carrentaldemo.entity.Car;
import com.fwy.carrentaldemo.entity.Contract;
import com.fwy.carrentaldemo.facade.IRentCarFacade;
import com.fwy.carrentaldemo.service.ICarService;
import com.fwy.carrentaldemo.service.IContractService;
import com.fwy.carrentaldemo.utils.DateUtils;
import com.fwy.carrentaldemo.utils.JSONResult;
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

    @Autowired
    private IContractService contractService;

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

    @GetMapping("/contract")
    @ResponseBody
    public Object getAllContract(){
        List<Contract> contractList = contractService.queryAllContract();
        JSONObject response = new JSONObject();

        response.put("errcode","0000");
        response.put("errmsg","Success");
        response.put("data",contractList);

        JSONResult.fillResultString("0000","Success",contractList);

        return JSONResult.fillResultString("0000","Success",contractList);
    }

    @PostMapping("/rentcar")
    @ResponseBody
    public Object rentCar(@RequestBody JSONObject jsonParam) throws ParseException {
        JSONObject response = new JSONObject();

        Date begindate;
        Date returndate;
        int carId;
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
        //Return Date
        try{
            returndate = DateUtils.strToDate(jsonParam.getObject("returndate",String.class));
        } catch (Exception e) {
            response.put("errcode","0401");
            response.put("errmsg","Invalid Return Date");
            response.put("data",null);
            return response;
        }
        //Cross Checking
        if (returndate.before(begindate)){
            response.put("errcode","0401");
            response.put("errmsg","Invalid Return Date");
            response.put("data",null);
            return response;
        }
        if (begindate.before(new Date())){
            response.put("errcode","0401");
            response.put("errmsg","Invalid Begin Date");
            response.put("data",null);
            return response;
        }
        try {
            carId = jsonParam.getObject("carid", Integer.class);
        }
        catch (Exception e){
            response.put("errcode","0401");
            response.put("errmsg","Invalid Car Id");
            response.put("data",null);
            return response;
        }
        String customerInfo = jsonParam.getObject("customerinfo", String.class);

        //Rental Service
        if (rentCarFacade.rentCar(DateUtils.dateToStr(begindate), DateUtils.dateToStr(returndate), carId, customerInfo) > 0){
            response.put("errcode","0000");
            response.put("errmsg","Success");
            response.put("data",null);
            return response;
        }else{
            response.put("errcode","0404");
            response.put("errmsg","Already Rented");
            response.put("data",null);
            return response;
        }
    }

}
