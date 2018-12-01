package com.examOnline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.examOnline.dao.ExamPaperDao;
import com.examOnline.dao.QuestionLibDao;
import com.examOnline.dao.StudentDao;
import com.examOnline.model.QuestionLibWithBLOBs;
import com.examOnline.model.Student;
import com.examOnline.model.examPaper;
import com.examOnline.service.ExamPaperService;
@SuppressWarnings("all")
@Service("examPaperService")
public class ExamPaperServiceImpl implements ExamPaperService {

	@Autowired
	private ExamPaperDao examPaperDao;
	@Autowired
	private QuestionLibDao questionLibDao;
	@Autowired
	StudentDao studentDao;
	@Override
	public JSONObject selectByStatus(String code) {
		//更加学号查询学生信息
		Student student = studentDao.queryByLoginName(code);
		//根据学生信息中存储的状态查询对应试卷中状态一致的试题
		List<examPaper> examPaperList = examPaperDao.selectByStatus(student.getOther2());
		List list = new ArrayList();
		for(examPaper examPaper:examPaperList){
			QuestionLibWithBLOBs lib = questionLibDao.selectById(examPaper.getQuestionlibid());
			Map map = new HashMap();
			map.put("id", examPaper.getId());
			map.put("question", lib.getQuestion());
			map.put("obj",examPaper.getObject());
			map.put("answerA", lib.getAnswera());
			map.put("answerB", lib.getAnswerb());
			map.put("answerC", lib.getAnswerc());
			map.put("answerD", lib.getAnswerd());
			list.add(map);
		}
		JSONObject question = new JSONObject();
		question.put("question", list);
		JSONObject json = new JSONObject();
		json.put("json", question);
		return json;
	}

}
