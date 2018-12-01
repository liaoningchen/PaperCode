package com.examOnline.model;

public class StuPaper {
	//试卷id
	private String id;
	//性别
	private String sex;
	//题号
	private String number;
	//正确答案
	private String trueAnswer;
	//学生答案
	private String answer;
	//问题
	private String question;
	//详情
	private String detail;
	//学号
	private String code;
	//学科
	private String object;
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTrueAnswer() {
		return trueAnswer;
	}
	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
