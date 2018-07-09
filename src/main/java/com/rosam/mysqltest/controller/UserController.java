package com.rosam.mysqltest.controller;

import com.rosam.mysqltest.entity.User;
import com.rosam.mysqltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find/{id}")
    public void find(@PathVariable("id") int id){
      User user  =userService.findById(id);
      System.out.println(user.getUserName());
    }
}
