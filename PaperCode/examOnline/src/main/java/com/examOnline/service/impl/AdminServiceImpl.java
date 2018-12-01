package com.examOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examOnline.dao.AdminDao;
import com.examOnline.service.AdminService;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	public AdminDao adminDao;
	
	@Override
	public String selectCount() {
		return adminDao.selectCount();
	}

}
