package com.fwy.carrentaldemo.facade.impl;

import com.fwy.carrentaldemo.entity.Contract;
import com.fwy.carrentaldemo.facade.IRentCarFacade;
import com.fwy.carrentaldemo.service.ICarService;
import com.fwy.carrentaldemo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class RentCarFacadeImpl implements IRentCarFacade {

    @Autowired
    ICarService carService;

    @Autowired
    IContractService contractService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int rentCar(Date begindate, Date returndate, int carId, String customerInfo) {
        carService.updateCarRentFlag(carId);
        Contract contract = new Contract();
        contract.setCarId(carId);
        contract.setBegindate(begindate);
        contract.setReturndate(returndate);
        contract.setCustomerInfo(customerInfo);
        return contractService.addNewContract(contract);
    }
}
