package com.examOnline.service;

import java.util.List;

import com.examOnline.common.Page;
import com.examOnline.model.Score;

public interface ScoreServcie {

	public List<Score> getScoreList(Page page);
	
	public Integer getCount();
}
