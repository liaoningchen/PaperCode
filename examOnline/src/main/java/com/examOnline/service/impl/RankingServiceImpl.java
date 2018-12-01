package com.examOnline.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examOnline.dao.ScoreDao;
import com.examOnline.service.RankingService;

public class RankingServiceImpl implements RankingService {

	private static ScoreDao scoreDao;
	static{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		if(scoreDao == null){
			scoreDao = (ScoreDao) context.getBean("scoreDao");
		}
	}
	@Override
	public void rankingMethod() {

	}

}
