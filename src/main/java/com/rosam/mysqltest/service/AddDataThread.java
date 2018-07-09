package com.rosam.mysqltest.service;

import com.rosam.mysqltest.dao.InsuranceDao;
import com.rosam.mysqltest.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;

public class AddDataThread extends Thread{

    Insurance insurance;

    @Autowired
    private InsuranceDao insuranceDao;


    public AddDataThread (Insurance insurance){
        this.insurance=insurance;
    }

    @Override
    public void run(){
        insuranceDao.insertInsurance(insurance);
    }
}
