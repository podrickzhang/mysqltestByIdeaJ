package com.rosam.mysqltest.util;

import com.rosam.mysqltest.entity.Insurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class InsertThread extends Thread {

    Insurance insurance;
    public InsertThread(Insurance insurance){
        this.insurance=insurance;
    }


    @Override
    public void run(){
        final String url = "jdbc:mysql://127.0.0.1/sqltest";
        final String name = "com.mysql.jdbc.Driver";
        final String user = "root";
        final String password = "root";
        try{
            Connection conn = null;
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            if (conn!=null) {
                System.out.println("获取连接成功");
                insert(conn,insurance);
            }else {
                System.out.println("获取连接失败");
            }


        }catch (Exception e){

        }



    }

    public static void insert(Connection conn, Insurance insurance) {
        // 开始时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO sqlTest (id,requestDate,batchNum,orderNum,insuranceNum,productNum,paxType,insuranceOfYear,referenceNum,cardNum,cardType,bussinessType,transationType,district,point,commisionMoney,commisionRate,remark,insertDate,userName,userId,userSex,userAddress) SELECT ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 20000; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长

                    // 构建SQL后缀
                    suffix.append("'" +"1','"+ insurance.getRequestDate()+"','"+insurance.getBatchNum()+"','"+insurance.getOrderNum() +"','"+insurance.getInsuranceNum()+"','"+insurance.getProductNum()+"','"+insurance.getPaxType()+"','"+insurance.getInsuranceOfYear()+"','"+insurance.getReferenceNum()
                            +"','"+insurance.getCardNum()+"','"+insurance.getCardType()+ "','"+insurance.getBussinessType()+"','"+insurance.getTransationType()+"','"+insurance.getDistrict()+"','"+insurance.getPoint()+"','"+insurance.getCommisionMoney()+"','"+insurance.getCommisionRate()+"','"+insurance.getRemark()+"','"+insurance.getInsertDate()+"','"+insurance.getUserName()+"','"+insurance.getUserId()+"','"+insurance.getUserSex()+"','"+insurance.getUserAddress()+"',");

                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1)+" from dual where not exists (select id from sqlTest group by id HAVING  COUNT(*)>20000)";
               // System.out.println(sql);
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
        System.out.println("200万条数据插入花费时间 : " + (end - begin) / 1000 + " s");
        System.out.println("插入完成");
    }
}
