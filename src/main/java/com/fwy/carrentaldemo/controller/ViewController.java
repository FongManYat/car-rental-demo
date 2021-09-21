package com.fwy.carrentaldemo.controller;

import com.fwy.carrentaldemo.entity.Car;
import com.fwy.carrentaldemo.entity.Contract;
import com.fwy.carrentaldemo.facade.IRentCarFacade;
import com.fwy.carrentaldemo.service.ICarService;
import com.fwy.carrentaldemo.service.IContractService;
import com.fwy.carrentaldemo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private ICarService carService;

    @Autowired
    private IRentCarFacade rentCarFacade;

    @Autowired
    private IContractService contractService;

    @GetMapping(value = "/")
    public String main(){
        return "index";
    }

    @GetMapping(value = "/carlist")
    public String carlist(Model model){

        List<Car> listCar = carService.queryAllCar();
        List<Contract> listContract = contractService.queryAllContract();
        model.addAttribute("carinfo", listCar);
        model.addAttribute("contractinfo", listContract);
        return "carlist";
    }

    @RequestMapping(value = "/carRent", method = RequestMethod.POST)
    public String rentcar(@RequestParam(value="custname")String custname,
                          @RequestParam(value="carid")int carid,
                          @RequestParam(value="bgndte")String bgndte,
                          @RequestParam(value="enddte")String enddte) throws ParseException {

        Date begindate = DateUtils.strToDate(bgndte);
        Date returndate = DateUtils.strToDate(enddte);
        int carId = carid;
        String customerInfo = custname;

        rentCarFacade.rentCar(DateUtils.dateToStr(begindate), DateUtils.dateToStr(returndate), carId, customerInfo);

        return "redirect:carlist";
    }
}
