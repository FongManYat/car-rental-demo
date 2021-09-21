package com.fwy.carrentaldemo.mapper;

import com.fwy.carrentaldemo.entity.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface ContractMapper {
    int addNewContract(Contract contract);

    //查询
    //public List<ContractMapper> queryAllRent(ContractMapper rent);
}
