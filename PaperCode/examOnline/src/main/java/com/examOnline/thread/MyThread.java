package com.examOnline.thread;

import java.util.List;

import com.examOnline.common.JsScore;
import com.examOnline.model.Answer;

public class MyThread extends Thread{
	private List<Answer> list;
	private String code;
	private String object;
	@Override
	public void run() {
		JsScore jsScore = new JsScore();
		jsScore.jsScore(this.list,code,object);
	}
	public void jsScore(List list,String code, String object){
		this.list = list;
		this.code = code;
		this.object = object;
		MyThread myThread = new MyThread();
		myThread.list = list;
		myThread.code = code;
		myThread.object = object;
		System.out.println("----------------------------线程开始-————————————--------------------------");
		myThread.start();
	}
}
