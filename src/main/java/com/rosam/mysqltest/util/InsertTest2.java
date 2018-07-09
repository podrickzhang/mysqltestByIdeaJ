package com.rosam.mysqltest.util;

import com.rosam.mysqltest.entity.Insurance;
import com.rosam.mysqltest.entity.User;

public class InsertTest2 {

    public static void main(String args[]){
        Insurance insurance=new Insurance();
        insurance.setRequestDate(20621031);
        insurance.setBatchNum(00000);
        insurance.setOrderNum(300004054);
        insurance.setInsuranceNum("192062041300004054A0");
        insurance.setProductNum("AA2016111400001");
        insurance.setPaxType("季缴");
        insurance.setInsuranceOfYear("01-1");
        insurance.setReferenceNum(230510000);
        insurance.setCardNum("0006 ********1393012");
        insurance.setCardType("我行信用卡");
        insurance.setBussinessType("消费");
        insurance.setTransationType("保险");
        insurance.setDistrict("SZ");
        insurance.setPoint(98);
        insurance.setCommisionMoney(5.00);
        insurance.setCommisionRate(0.10);
        insurance.setRemark("优质客户保单");
        insurance.setInsertDate("20180604");
        insurance.setUserName("张超帅");
        insurance.setUserId(110);
        insurance.setUserSex("男");
        insurance.setUserAddress("南山区科技中一路招银研发大厦");

        InsertThread t1=new InsertThread(insurance);
        InsertThread t2=new InsertThread(insurance);
        t1.start();
        t2.start();
    }
}
