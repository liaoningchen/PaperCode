package com.examOnline.dao;

import com.examOnline.model.Practice;

public interface PracticeDao {
    int deleteByPrimaryKey(Integer number);

    int insert(Practice record);

    int insertSelective(Practice record);

    Practice selectByPrimaryKey(Integer number);

    int updateByPrimaryKeySelective(Practice record);

    int updateByPrimaryKey(Practice record);
    
    Practice selectByNumAndObj(Integer number,String object);
    
    int getCount(String objCode);
}