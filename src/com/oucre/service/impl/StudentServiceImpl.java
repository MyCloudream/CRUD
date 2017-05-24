package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.StudentDao;
import com.oucre.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Map<String, Object> findStudentProjectScores(Map<String, Object> map, EasyUiPager easyUiPager) {
		return studentDao.findStudentProjectScores(map, easyUiPager);
	}
	
}
