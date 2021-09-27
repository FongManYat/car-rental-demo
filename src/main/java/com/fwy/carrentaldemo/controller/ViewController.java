package com.fwy.carrentaldemo.controller;

import com.fwy.carrentaldemo.entity.Car;
import com.fwy.carrentaldemo.entity.Contract;
import com.fwy.carrentaldemo.entity.User;
import com.fwy.carrentaldemo.facade.IRentCarFacade;
import com.fwy.carrentaldemo.service.ICarService;
import com.fwy.carrentaldemo.service.IContractService;
import com.fwy.carrentaldemo.service.IUserService;
import com.fwy.carrentaldemo.utils.DateUtils;
import com.fwy.carrentaldemo.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @Autowired
    private ICarService carService;

    @Autowired
    private IRentCarFacade rentCarFacade;

    @Autowired
    private IContractService contractService;

    @GetMapping(value = "/")
    public String main(){
        return "web/login";
    }

    @GetMapping(value = "web/carlist")
    public String carlist(Model model){

        List<Car> listCar = carService.queryAllCar();
        List<Contract> listContract = contractService.queryAllContract();
        model.addAttribute("carinfo", listCar);
        model.addAttribute("contractinfo", listContract);
        return "web/carlist";
    }

    @RequestMapping(value = "/web/carRent", method = RequestMethod.POST)
    public String rentcar(@RequestParam(value="custname")String custname,
                          @RequestParam(value="carid")int carid,
                          @RequestParam(value="bgndte")String bgndte,
                          @RequestParam(value="enddte")String enddte) throws ParseException {

        Date begindate = DateUtils.strToDate(bgndte);
        Date returndate = DateUtils.strToDate(enddte);
        int carId = carid;
        String customerInfo = custname;

        rentCarFacade.rentCar(DateUtils.dateToStr(begindate), DateUtils.dateToStr(returndate), carId, customerInfo);

        return "redirect:web/carlist";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value="username")String username,
                          @RequestParam(value="password")String password) throws ParseException {

        log.info("username：{}", username);
        log.info("password: {}", password);

        Map<String, Object> map = new HashMap<>();

        try {
            User userDB = userService.login(new User(username, password));

            Map<String, String> payload = new HashMap<>();
            payload.put("userid", Integer.toString(userDB.getUserid()));
            payload.put("name", userDB.getName());
            String token = JWTUtils.getToken(payload);

            map.put("state", true);
            map.put("msg", "登录成功");
            map.put("token", token);
            return "web/index";
        } catch (Exception e) {
            map.put("msg","账号或者密码出错");
            return "/";
            }
        }


}
