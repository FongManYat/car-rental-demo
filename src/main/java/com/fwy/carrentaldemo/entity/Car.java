package com.fwy.carrentaldemo.entity;

public class Car {

    private int carId;

    private String carType;

    private double carPrice;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    private int rentFlag;



    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public int getRentFlag() {
        return rentFlag;
    }

    public void setRentFlag(int rentFlag) {
        this.rentFlag = rentFlag;
    }
}
