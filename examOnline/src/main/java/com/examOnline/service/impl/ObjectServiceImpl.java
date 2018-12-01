package com.examOnline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examOnline.dao.ObjectDao;
import com.examOnline.service.ObjectService;
@Service("objectService")
public class ObjectServiceImpl implements ObjectService{
	
	@Autowired
	ObjectDao objectDao;
	@Override
	public List selectObjectName() {
		return objectDao.selectAll();
	}

}
