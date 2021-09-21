package com.fwy.carrentaldemo.facade;

import java.util.Date;

public interface IRentCarFacade {
    int rentCar(String begindate, String returndate, int carId, String customerInfo);
}
