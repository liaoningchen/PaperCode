package com.examOnline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.examOnline.common.Url;
import com.examOnline.service.ExamPaperService;
import com.examOnline.service.StuExamPaperService;
@Controller
public class ExamPaperController {
	
	@Autowired
	ExamPaperService examPaperService;
	@Autowired
	StuExamPaperService stuExamPaperService;
	@RequestMapping(Url.GETEXAMQUES)
	@ResponseBody
	public JSONObject  login(String password, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
    	String code = (String) session.getAttribute("code");
		JSONObject json = examPaperService.selectByStatus(code);
		return json;
	}
	@RequestMapping(Url.SAVEDATA)
	@ResponseBody
	public int  saveData(HttpServletRequest request, HttpServletResponse response){
		String jsonStr = request.getParameter("jsonStr");
		String object = request.getParameter("object");
		HttpSession session = request.getSession();
    	String code = (String) session.getAttribute("code");
		int result = stuExamPaperService.insert(code,object, jsonStr);
		//返回1是成功，0是失败
		return result;
	}
}
