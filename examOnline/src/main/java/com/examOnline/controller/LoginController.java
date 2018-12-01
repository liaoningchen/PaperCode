package com.examOnline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examOnline.common.Url;
import com.examOnline.service.StudentService;

@Controller
public class LoginController {
	@Autowired
	private StudentService studentService;
	
	/**
	 * 登录验证
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(Url.LOGIN)
	@ResponseBody
	public int  login(String code,String password, HttpServletRequest request, HttpServletResponse response){
		int result = studentService.queryByLoginName(code, password);
		HttpSession session = request.getSession();
    	session.setAttribute("code",code);
    	session.setAttribute("PNum",1);
    	session.setAttribute("QNum",1);
		return result;
	}
	
	/**
	 * 发送验证码到邮箱
	 * @param email
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(Url.SENDNUMTOEMAIL)
	@ResponseBody
	public boolean  sendNumToEmail(String email,HttpServletRequest request, HttpServletResponse response){
		String code = request.getParameter("code");
		boolean boo = studentService.emailVai(email, code);
		return boo;
	}
	
	
	
	/**
	 * 密码修改
	 * @param name
	 * @param prePass
	 * @param noePass
	 * @param num
	 * @return 1-用户不存在 2-出事密码错误，3-验证通过 0-其他
	 */
	@RequestMapping(Url.MODIFPASS)
	@ResponseBody
	public int  modifPass(String code,String prePass,String nowPass,String num){
		int result = studentService.modifyPassword(code, prePass, nowPass, num);
		return result;
	}

}
