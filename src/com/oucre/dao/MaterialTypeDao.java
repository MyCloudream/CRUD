package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.MaterialType;

public interface MaterialTypeDao extends BaseDao<MaterialType> {
	public Map<String, Object> findMaterialTypeSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
