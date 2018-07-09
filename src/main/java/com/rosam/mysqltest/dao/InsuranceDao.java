package com.rosam.mysqltest.dao;

import com.rosam.mysqltest.entity.Insurance;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsuranceDao {

    public void insertInsurance(Insurance insurance);

    public void insertBatchData(Insurance insurance);
}
