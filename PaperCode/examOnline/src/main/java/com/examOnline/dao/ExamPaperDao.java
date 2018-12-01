package com.examOnline.dao;

import java.util.List;

import com.examOnline.model.examPaper;

public interface ExamPaperDao {
    int deleteByPrimaryKey(String id);

    int insert(examPaper record);

    int insertSelective(examPaper record);

    examPaper selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(examPaper record);

    int updateByPrimaryKey(examPaper record);
    
    List<examPaper> selectByStatus(String status);
}