package com.rosam.mysqltest.entity;

public class Insurance {
    private int requestDate;
    private int batchNum;
    private int orderNum;
    private String insuranceNum;
    private String productNum;
    private String paxType;
    private String insuranceOfYear;
    private double referenceNum;
    private String cardNum;
    private String cardType;
    private String bussinessType;
    private String transationType;
    private String district;
    private int point;
    private double commisionMoney;
    private double commisionRate;
    private String remark;  //备注
    private String insertDate;   //unix时间戳
    private String userName;
    private int userId;
    private String userSex;
    private String userAddress;

    public int getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(int requestDate) {
        this.requestDate = requestDate;
    }

    public int getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(int batchNum) {
        this.batchNum = batchNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getInsuranceNum() {
        return insuranceNum;
    }

    public void setInsuranceNum(String insuranceNum) {
        this.insuranceNum = insuranceNum;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getPaxType() {
        return paxType;
    }

    public void setPaxType(String paxType) {
        this.paxType = paxType;
    }

    public String getInsuranceOfYear() {
        return insuranceOfYear;
    }

    public void setInsuranceOfYear(String insuranceOfYear) {
        this.insuranceOfYear = insuranceOfYear;
    }

    public double getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(double referenceNum) {
        this.referenceNum = referenceNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(String bussinessType) {
        this.bussinessType = bussinessType;
    }

    public String getTransationType() {
        return transationType;
    }

    public void setTransationType(String transationType) {
        this.transationType = transationType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getCommisionMoney() {
        return commisionMoney;
    }

    public void setCommisionMoney(double commisionMoney) {
        this.commisionMoney = commisionMoney;
    }

    public double getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(double commisionRate) {
        this.commisionRate = commisionRate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
