package com.fwy.carrentaldemo.mapper;

import com.fwy.carrentaldemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    /*boolean existsByUsername(String username);*/

    User login(User user);

    User queryUser(String username);

    int signup(User user);


}
