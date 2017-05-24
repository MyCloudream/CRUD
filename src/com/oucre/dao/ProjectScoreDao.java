package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Score;

public interface ProjectScoreDao extends BaseDao<Score>{
	public Map<String, Object> findStudentProjectScores(Map<String, Object> map,
			EasyUiPager easyUiPager);
	
	public boolean updateEntityBySql(Integer score,Integer id);
}
