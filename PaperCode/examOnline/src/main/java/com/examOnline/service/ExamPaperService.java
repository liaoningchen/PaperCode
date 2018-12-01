package com.examOnline.service;

import com.alibaba.fastjson.JSONObject;

public interface ExamPaperService {

	public JSONObject selectByStatus(String code);
}
