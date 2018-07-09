package com.rosam.mysqltest.util;

import com.rosam.mysqltest.entity.Insurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class MyThread extends Thread{

    Insurance insurance;
    public MyThread(Insurance insurance){
        this.insurance=insurance;
    }


    public void run() {
        String url = "jdbc:mysql://127.0.0.1/sqltest";
        String name = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);//获取连接
            conn.setAutoCommit(false);//关闭自动提交，不然conn.commit()运行到这句会报错
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 开始时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO sqlTest (id,requestDate,batchNum,orderNum,insuranceNum,productNum,paxType,insuranceOfYear,referenceNum,cardNum,cardType,bussinessType,transationType,district,point,commisionMoney,commisionRate,remark,insertDate,userName,userId,userSex,userAddress) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 500; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 2000; j++) {
                    // 构建SQL后缀
                    suffix.append("('" +"1','"+ insurance.getRequestDate()+"','"+insurance.getBatchNum()+"','"+insurance.getOrderNum() +"','"+insurance.getInsuranceNum()+"','"+insurance.getProductNum()+"','"+insurance.getPaxType()+"','"+insurance.getInsuranceOfYear()+"','"+insurance.getReferenceNum()
                            +"','"+insurance.getCardNum()+"','"+insurance.getCardType()+ "','"+insurance.getBussinessType()+"','"+insurance.getTransationType()+"','"+insurance.getDistrict()+"','"+insurance.getPoint()+"','"+insurance.getCommisionMoney()+"','"+insurance.getCommisionRate()+"','"+insurance.getRemark()+"','"+insurance.getInsertDate()+"','"+insurance.getUserName()+"','"+insurance.getUserId()+"','"+insurance.getUserSex()+"','"+insurance.getUserAddress()+"'),");
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("100万条数据插入花费时间 : " + (end - begin) / 1000 + " s"+"  插入完成");
    }
}