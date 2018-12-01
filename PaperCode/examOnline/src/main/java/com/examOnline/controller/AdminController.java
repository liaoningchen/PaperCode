package com.examOnline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examOnline.common.Url;
import com.examOnline.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	public AdminService adminService;
	@RequestMapping("/abc")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println(adminService.selectCount());
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		return adminService.selectCount();
	}
}
