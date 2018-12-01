package com.examOnline.service;

import com.examOnline.model.Student;

public interface StudentService {

	public int insert(Student record);
	
	public int  queryByLoginName(String code,String password);
	
	public int modifyPassword(String code,String prePass,String noePass,String num);
	
	public boolean emailVai(String email,String code);
}
