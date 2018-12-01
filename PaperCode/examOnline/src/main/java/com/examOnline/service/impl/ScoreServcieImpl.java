package com.examOnline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examOnline.common.Page;
import com.examOnline.dao.ObjectDao;
import com.examOnline.dao.ScoreDao;
import com.examOnline.dao.StudentDao;
import com.examOnline.model.Score;
import com.examOnline.model.Student;
import com.examOnline.service.ScoreServcie;
@Service("scoreServcie")
public class ScoreServcieImpl implements ScoreServcie {

	@Autowired
	private ScoreDao scoreDao;
	@Autowired
	private ObjectDao objectDao;
	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Score> getScoreList(Page page) {
		page.setPageNo(page.getPageNo()-1);
		//计算分页终止页
		int endPage = page.getPageNo() + page.getPageSize();
		page.setPageSize(endPage);
		System.out.println(page.getPageNo());System.out.println(endPage);
		List<Score> list = scoreDao.getScoreList(page);
		for(Score s:list){
			String name = objectDao.selectByCode(s.getObject());
			Student student = studentDao.queryByLoginName(s.getStuid());
			s.setQuesid(student.getSex());
			s.setObject(name);
		}
		return list;
	}

	@Override
	public Integer getCount() {
		return scoreDao.getCount();
	}

}
