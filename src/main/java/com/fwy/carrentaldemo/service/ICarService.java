package com.fwy.carrentaldemo.service;

import com.fwy.carrentaldemo.entity.Car;

import java.util.List;

public interface ICarService {
    /**
     * Query all the cars
     * @param
     * @return
     */
    public List<Car> queryAllCar();

    /**
     * Rent car
     * @param carId
     */
    public void updateCarRentFlag(int carId);
}
