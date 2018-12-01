package com.examOnline.dao;

import com.examOnline.model.QuestionLib;
import com.examOnline.model.QuestionLibWithBLOBs;

public interface QuestionLibDao {
    int deleteByPrimaryKey(Integer numebr);

    int insert(QuestionLibWithBLOBs record);

    int insertSelective(QuestionLibWithBLOBs record);

    QuestionLibWithBLOBs selectByPrimaryKey(Integer numebr);

    int updateByPrimaryKeySelective(QuestionLibWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QuestionLibWithBLOBs record);

    int updateByPrimaryKey(QuestionLib record);
    
    QuestionLibWithBLOBs selectById(String id);
}