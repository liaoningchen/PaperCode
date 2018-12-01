package com.examOnline.service;

import java.util.List;

import com.examOnline.common.Page;


public interface StuExamPaperService {

	int insert(String code,String object,String jsonStr);
	public List selectPaper(Page page,String code);
	
	public Integer getCount(String code);
}
