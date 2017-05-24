package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.search.EasyUiPager;

public interface StudentService {
	public Map<String, Object> findStudentProjectScores(Map<String, Object> map,
			EasyUiPager easyUiPager);
}
