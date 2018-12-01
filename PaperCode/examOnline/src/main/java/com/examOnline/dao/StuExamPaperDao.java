package com.examOnline.dao;

import java.util.List;

import com.examOnline.common.Page;
import com.examOnline.model.StuExamPaper;

public interface StuExamPaperDao {
    int deleteByPrimaryKey(String id);

    int insert(StuExamPaper record);

    int insertSelective(StuExamPaper record);

    StuExamPaper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StuExamPaper record);

    int updateByPrimaryKey(StuExamPaper record);
    
    List<StuExamPaper> selectByCodeAndObj(String code, String object);
    
    List<StuExamPaper> selectPaper(Page page);
    
    int getCount(String code);
}