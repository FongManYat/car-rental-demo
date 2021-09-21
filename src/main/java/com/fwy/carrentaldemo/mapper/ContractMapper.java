package com.fwy.carrentaldemo.mapper;

import com.fwy.carrentaldemo.entity.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ContractMapper {

    int addNewContract(Contract contract);

    List<Contract> queryAllContract();
}
