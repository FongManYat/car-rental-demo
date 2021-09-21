package com.fwy.carrentaldemo.mapper;

import com.fwy.carrentaldemo.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarMapper {

    List<Car> queryAllCar();

    int updateCarRentFlag(int carId);
}
