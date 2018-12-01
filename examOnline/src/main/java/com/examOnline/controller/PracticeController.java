package com.examOnline.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.examOnline.common.Url;
import com.examOnline.service.ObjectService;
import com.examOnline.service.PracticeService;

@Controller
public class PracticeController {
	@Autowired
	PracticeService practiceService;
	@Autowired
	ObjectService objectService;
	
	/**
	 * 上一题 下一题
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(Url.SELECTPRACTICE)
	@ResponseBody
	public String  selectPractice(HttpServletRequest request, HttpServletResponse response){
		String step = request.getParameter("step");
		String obj = request.getParameter("obj");
		HttpSession session = request.getSession();
		String PNum = (String) session.getAttribute("PNum");
		int nowPNum = Integer.parseInt(PNum) + Integer.parseInt(step);
		Map map = practiceService.selectByNumberAndObj(new Integer(nowPNum),obj);
		do{
			if("".equals(map.get("json"))){
				nowPNum = nowPNum +1;
				map = practiceService.selectByNumberAndObj(new Integer(nowPNum),obj);
			}else{
				session.setAttribute("PNum", nowPNum);
				break;
			}
		}while(true);
		
		return (String) map.get("json");
	}
	/**
	 * 指定某一个题
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(Url.CHOOOSE)
	@ResponseBody
	public JSONObject  choosePractice(HttpServletRequest request, HttpServletResponse response){
		String number = request.getParameter("number");
		String obj = request.getParameter("objCode");
		HttpSession session = request.getSession();
		session.setAttribute("PNum", number);
		int num = Integer.parseInt(number);
		Map map = practiceService.selectByNumberAndObj(new Integer(num),obj);
		return  (JSONObject) map.get("json");
	}
	
	@RequestMapping(Url.LEFTBAR)
	@ResponseBody
	public List  getSidebar(HttpServletRequest request, HttpServletResponse response){
		
		return objectService.selectObjectName();
	}
	
	@RequestMapping(Url.GETCOUNT)
	@ResponseBody
	public int  getCount(HttpServletRequest request, HttpServletResponse response){
		String objCode = request.getParameter("objCode");
		return practiceService.getCount(objCode);
	}
	
}
