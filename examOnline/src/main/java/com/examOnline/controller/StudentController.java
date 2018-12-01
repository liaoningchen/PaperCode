package com.examOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examOnline.common.Url;
import com.examOnline.model.Student;
import com.examOnline.service.StudentService;
import com.examOnline.util.UUIDTool;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Value(value = "${test}")
	private String test;
	@RequestMapping(Url.STUDENTINSERT)
	@ResponseBody
	public String  insert(){
		Student student = new Student();
		student.setId(UUIDTool.getUUID());
		studentService.insert(student);
		return test;
	}
}
