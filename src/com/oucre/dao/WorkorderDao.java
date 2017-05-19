package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Workorder;

public interface WorkorderDao extends BaseDao<Workorder>{
	public Map<String, Object> findWorkorderSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
