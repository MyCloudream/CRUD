package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Projecttraining;

public interface ProjecttrainingDao extends BaseDao<Projecttraining>{
	public Map<String, Object> findProjecttrainingSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
