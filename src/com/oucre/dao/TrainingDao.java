package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Training;

public interface TrainingDao extends BaseDao<Training>{
	public Map<String, Object> findTrainingSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
