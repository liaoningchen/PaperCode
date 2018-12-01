package com.examOnline.dao;

import com.examOnline.model.Question;

public interface QuestionDao {
    int deleteByPrimaryKey(Integer number);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer number);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}