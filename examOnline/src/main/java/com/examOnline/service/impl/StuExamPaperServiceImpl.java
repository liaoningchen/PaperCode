package com.examOnline.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examOnline.common.Page;
import com.examOnline.dao.ObjectDao;
import com.examOnline.dao.QuestionLibDao;
import com.examOnline.dao.StuExamPaperDao;
import com.examOnline.model.Answer;
import com.examOnline.model.QuestionLibWithBLOBs;
import com.examOnline.model.StuExamPaper;
import com.examOnline.model.StuPaper;
import com.examOnline.service.StuExamPaperService;
import com.examOnline.thread.MyThread;
import com.examOnline.util.UUIDTool;
@Service("stuExamPaperService")
public class StuExamPaperServiceImpl implements StuExamPaperService {

	@Autowired
	private StuExamPaperDao stuExamPaperDao;
	@Autowired
	private QuestionLibDao questionLibDao;
	@Autowired
	private ObjectDao objectDao;
	@Override
	public int insert(String code, String object, String jsonStr) {
		int res=1;
		try{
			List<StuExamPaper> stuExamPaperlist = stuExamPaperDao.selectByCodeAndObj(code, object);
			for(StuExamPaper stuExamPaper:stuExamPaperlist){
				stuExamPaper.setOther2("0");
				stuExamPaperDao.updateByPrimaryKeySelective(stuExamPaper);
			}
			JSONObject jsonObject = JSONObject.fromObject(jsonStr);
			JSONObject json = jsonObject.getJSONObject("json");
			JSONArray answer = json.getJSONArray("answer");
			 List<Answer> list = (List) JSONArray.toCollection(answer,Answer.class); 
			for(int i = 0;i<list.size();i++){
				StuExamPaper StuExamPaper = new StuExamPaper();
				StuExamPaper.setId(UUIDTool.getUUID());
				//记录试题id
				StuExamPaper.setParcid(list.get(i).getId());
				//记录学生选择的答案
				StuExamPaper.setStuanswer(list.get(i).getAnswer());
				//借用字段，保存学号
				StuExamPaper.setOther1(code);
				//保存学科
				StuExamPaper.setObject(object);
				StuExamPaper.setOther2("1");
				stuExamPaperDao.insert(StuExamPaper);
				
			}
			//开启线程，计算成绩
			MyThread myThread = new MyThread();
			myThread.jsScore(list,code,object);
		}catch(Exception e){
			res=0;
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List selectPaper(Page page,String code) {
		List<StuPaper> paperList = new ArrayList();
		page.setPageNo(page.getPageNo()-1);
		//计算分页终止页
		int endPage = page.getPageNo() + page.getPageSize();
		page.setPageSize(endPage);
		System.out.println(page.getPageNo());System.out.println(endPage);
		//借用字段存放学号
		page.setOther1(code);
		List<StuExamPaper> list = stuExamPaperDao.selectPaper(page);
		for(StuExamPaper stuExamPaper:list){
			StuPaper stuPaper = new StuPaper();
			QuestionLibWithBLOBs question = questionLibDao.selectById(stuExamPaper.getParcid());
			stuPaper.setQuestion(question.getQuestion());
			stuPaper.setTrueAnswer(question.getTrueanswer());
			stuPaper.setDetail(question.getDetail());
			stuPaper.setAnswer(stuExamPaper.getStuanswer());
			stuPaper.setId(stuExamPaper.getId());
			String object =  objectDao.selectByCode(stuExamPaper.getObject());
			stuPaper.setObject(object);
			stuPaper.setNumber(stuExamPaper.getOther3());
			stuPaper.setCode(code);
			paperList.add(stuPaper);
			
		}
		return paperList;
	}

	@Override
	public Integer getCount(String code) {
		return stuExamPaperDao.getCount(code);
	}

	


}
