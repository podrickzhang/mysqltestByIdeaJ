package com.rosam.mysqltest.util;

import com.rosam.mysqltest.entity.Insurance;

public class InsertTest3 {

    public static void main(String args[]) {
        Insurance insurance = new Insurance();
        insurance.setRequestDate(2062);
        insurance.setBatchNum(00000);
        insurance.setOrderNum(30000);
        insurance.setInsuranceNum("1920620413");
        insurance.setProductNum("AA2016111400001");
        insurance.setPaxType("季缴");
        insurance.setInsuranceOfYear("01-1");
        insurance.setReferenceNum(23051);
        insurance.setCardNum("00061393012");
        insurance.setCardType("我行信用卡");
        insurance.setBussinessType("消费");
        insurance.setTransationType("保险");
        insurance.setDistrict("SZ");
        insurance.setPoint(98);
        insurance.setCommisionMoney(5.00);
        insurance.setCommisionRate(0.10);
        insurance.setRemark("优质客户");
        insurance.setInsertDate("20180604");
        insurance.setUserName("张超帅");
        insurance.setUserId(110);
        insurance.setUserSex("男");
        insurance.setUserAddress("南山区");

        for (int i = 0; i < 2; i++) {
            new MyThread(insurance).start();
        }
    }
}