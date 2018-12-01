package com.examOnline.dao;

import java.util.List;

import com.examOnline.model.Object;

public interface ObjectDao {
    int insert(Object record);

    int insertSelective(Object record);
    
    List<Object> selectAll();
    
    String selectByCode(String code);
}