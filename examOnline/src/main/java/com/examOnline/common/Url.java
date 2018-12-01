package com.examOnline.common;

public interface Url {
	//插入学生信息
	public static final String  STUDENTINSERT = "/student/insert";
	//用户登录
	public static final String  LOGIN = "/student/login";
	//用户密码修改
	public static final String  MODIFPASS = "/student/modifpass";
	//修改密码是验证码发送
	public static final String  SENDNUMTOEMAIL = "/student/sendnumtoemail";
	//上一题 下一题
	public static final String  SELECTPRACTICE = "/student/selectPractice";
	//指定某一体
	public static final String  CHOOOSE = "/student/choose";
	//左侧导航栏
	public static final String  LEFTBAR = "/student/leftbar";
	//获得练习题数量
	public static final String  GETCOUNT = "/student/getCount";
	//获得试题
	public static final String  GETEXAMQUES = "/student/getExamQues";
	//保存学生答案
	public static final String  SAVEDATA = "/student/saveData";
	//获得学生试卷
	public static final String  GETPAPER = "/student/getPaper";
	//获得学生成绩
	public static final String  GETSCORE = "/student/getScore";
}
