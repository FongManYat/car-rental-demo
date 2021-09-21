package com.fwy.carrentaldemo.facade;

import java.util.Date;

public interface IRentCarFacade {
    int rentCar(Date begindate, Date returndate, int carId, String customerInfo);
}
