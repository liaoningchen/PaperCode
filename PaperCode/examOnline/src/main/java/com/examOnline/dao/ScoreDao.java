package com.examOnline.dao;

import java.util.List;

import com.examOnline.common.Page;
import com.examOnline.model.Score;

public interface ScoreDao {
    int deleteByPrimaryKey(String id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
    
    int deleteByCodeAndObj(String code,String object);
    
    List selectClass();
    
    List selectByClass(String class1);
    
    List<Score> getScoreList(Page page);
    
    Integer getCount();
}