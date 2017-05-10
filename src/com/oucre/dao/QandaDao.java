package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Qanda;

public interface QandaDao extends BaseDao<Qanda>{
	public Map<String, Object> findQandaSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
