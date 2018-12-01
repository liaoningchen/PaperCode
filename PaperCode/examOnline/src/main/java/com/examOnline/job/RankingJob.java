package com.examOnline.job;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import com.examOnline.dao.ScoreDao;
import com.examOnline.model.Score;

public class RankingJob extends AbstractSimpleElasticJob{

	private static ScoreDao scoreDao;
	static{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		if(scoreDao == null){
			scoreDao = (ScoreDao) context.getBean("scoreDao");
		}
	}
	@Override
	public void process(JobExecutionMultipleShardingContext arg0) {
		//获得所有班级
		List<Score> list =  scoreDao.selectClass();
		for(Score s:list){
			//获得每个班级中所有的学生成绩记录
			List PeoByClaList = scoreDao.selectByClass(s.getClass1());
			
		}
	}

}
