package com.rosam.mysqltest.service;

import com.rosam.mysqltest.dao.InsuranceDao;

import com.rosam.mysqltest.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceDao insuranceDao;

    public void insertInsurance(Insurance insurance){
        long preTime=System.currentTimeMillis();
        System.out.println("preTime:"+preTime);
        for(int i=0;i<2000000;i++){
            insuranceDao.insertInsurance(insurance);
        }
        long aftTime=System.currentTimeMillis();
        System.out.println("afterTime:"+aftTime);
        long finishTime=aftTime-preTime;
        System.out.println("完成花了 "+finishTime);   //20000   844719
        //两时间戳相减计算分钟的方式  Long s = (System.currentTimeMillis() - pretime) / (1000 * 60);

    }

    public void insertBatchData(Insurance insurance){
        AddDataThread thread1=new AddDataThread(insurance);
        AddDataThread thread2=new AddDataThread(insurance);
        AddDataThread thread3=new AddDataThread(insurance);
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
