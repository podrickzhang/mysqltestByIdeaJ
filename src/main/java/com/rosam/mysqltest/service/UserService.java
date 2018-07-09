package com.rosam.mysqltest.service;

import com.rosam.mysqltest.dao.UserDao;
import com.rosam.mysqltest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findById(int userId){
        User user=userDao.findById(userId);
        return user;
    }
}
