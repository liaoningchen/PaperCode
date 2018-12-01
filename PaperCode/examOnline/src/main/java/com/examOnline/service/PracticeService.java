package com.examOnline.service;

import java.util.Map;


public interface PracticeService {

	public Map selectByNumberAndObj(Integer number,String object);
	//获得习题个数
	public int  getCount(String objCode);
}
