package com.fwy.carrentaldemo.service;

import com.fwy.carrentaldemo.entity.Car;
import com.fwy.carrentaldemo.entity.Contract;

import java.util.List;

public interface IContractService {

    /**
     *
     * @return
     */

    public List<Contract> queryAllContract();
    /**
     *
     * @param contract
     * @return
     */
    public int addNewContract(Contract contract);


}
