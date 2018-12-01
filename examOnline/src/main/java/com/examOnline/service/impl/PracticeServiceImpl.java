package com.examOnline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.examOnline.dao.PracticeDao;
import com.examOnline.dao.QuestionLibDao;
import com.examOnline.model.Practice;
import com.examOnline.model.QuestionLibWithBLOBs;
import com.examOnline.service.PracticeService;
@SuppressWarnings("all")
@Service
public class PracticeServiceImpl implements PracticeService{

	@Autowired
	private PracticeDao practiceDao;
	@Autowired
	private QuestionLibDao questionLibDao;
	@Override
	public Map selectByNumberAndObj(Integer number, String object) {
		//根据编号查询试题库，如果该编号 对应的试题为空，则在map 中放一个空值返回上一层
		Practice practice = practiceDao.selectByNumAndObj(number, object);
		Map map1 = new HashMap();
		if(practice!=null){
			QuestionLibWithBLOBs lib = questionLibDao.selectById(practice.getQueslibid());
			Map map = new HashMap();
			List list = new ArrayList();
			map.put("id", practice.getId());
			map.put("question", lib.getQuestion());
			map.put("answerA", lib.getAnswera());
			map.put("answerB", lib.getAnswerb());
			map.put("answerC", lib.getAnswerc());
			map.put("answerD", lib.getAnswerd());
			map.put("detail", lib.getDetail());
			map.put("trueAnswer", lib.getTrueanswer());
			list.add(map);
			JSONObject orders = new JSONObject();
			orders.put("question", list);
			JSONObject json = new JSONObject();
			json.put("json", orders);
			map1.put("json", json);
		}else{
			map1.put("json", "");
		}
		return map1;
	}
	@Override
	public int getCount(String objCode) {
		return practiceDao.getCount(objCode);
	}

}
