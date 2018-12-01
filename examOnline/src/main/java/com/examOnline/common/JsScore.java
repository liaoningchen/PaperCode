package com.examOnline.common;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.examOnline.dao.QuestionLibDao;
import com.examOnline.dao.ScoreDao;
import com.examOnline.dao.StudentDao;
import com.examOnline.model.Answer;
import com.examOnline.model.QuestionLibWithBLOBs;
import com.examOnline.model.Score;
import com.examOnline.model.Student;
import com.examOnline.util.UUIDTool;
@Component
public class JsScore {

	private static QuestionLibDao questionLibDao;
	@Autowired
	private static StudentDao studentDao;
	@Autowired
	private  static ScoreDao scoreDao;
	public void jsScore(List<Answer> list,String code, String object){
		System.out.println("开始计算成绩");
		//删除之前的记录
		scoreDao.deleteByCodeAndObj(code, object);
		Score s = new Score();
		float score = 0;
		for(int i = 0;i<list.size();i++){
			//对应题库中的id 
			QuestionLibWithBLOBs ques = questionLibDao.selectById(list.get(i).getId());
			//判断学生答案是否正确，如果正确则计算得分
			if(ques.getTrueanswer().equals(list.get(i).getAnswer())){
				score += Integer.parseInt(ques.getOther1());
			}
		}
		s.setId(UUIDTool.getUUID());
		s.setCreteTime(new Date());
		s.setScore(score);
		s.setObject(object);
		s.setStuid(code);
		s.setObject(object);
		Student stu= studentDao.queryByLoginName(code);
		s.setCollage(stu.getCollege());
		s.setMajor(stu.getMajor());
		s.setClass1(stu.getSchool());
		scoreDao.insert(s);
	}
	static{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		if(questionLibDao == null){
			questionLibDao = (QuestionLibDao) context.getBean("questionLibDao");
		}
		if(studentDao == null){
			studentDao = (StudentDao) context.getBean("studentDao");
		}
		if(scoreDao == null){
			scoreDao = (ScoreDao) context.getBean("scoreDao");
		}
	}
}
