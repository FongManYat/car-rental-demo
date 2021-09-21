package com.fwy.carrentaldemo.service.impl;

import com.fwy.carrentaldemo.entity.Car;
import com.fwy.carrentaldemo.entity.Contract;
import com.fwy.carrentaldemo.mapper.ContractMapper;
import com.fwy.carrentaldemo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    ContractMapper contractMapper;

    @Override
    public List<Contract> queryAllContract() {
        List<Contract> list = contractMapper.queryAllContract();
        return list;
    }

    @Override
    public int addNewContract(Contract contract) {
        return contractMapper.addNewContract(contract);
    }
}
