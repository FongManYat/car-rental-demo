package com.fwy.carrentaldemo.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Contract {
    private String contractId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begindate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returndate;

    private int carId;

    private String customerInfo;

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}
