package com.rosam.mysqltest.dao;

import com.rosam.mysqltest.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public User findById(int userId);
}
