package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Student;

public interface StudentDao extends BaseDao<Student>{
	public Map<String, Object> findStudentProjectScores(Map<String, Object> map,
			EasyUiPager easyUiPager);
}
