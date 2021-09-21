package com.fwy.carrentaldemo.service.impl;

import com.fwy.carrentaldemo.entity.Car;
import com.fwy.carrentaldemo.mapper.CarMapper;
import com.fwy.carrentaldemo.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> queryAllCar() {
        List<Car> carList = carMapper.queryAllCar();
        return carList;
    }

    @Override
    public int updateCarRentFlag(int carId) {
        return carMapper.updateCarRentFlag(carId);
    }
}
