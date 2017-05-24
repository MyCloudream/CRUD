package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Material;

public interface MaterialDao extends BaseDao<Material> {
	public Map<String, Object> findMaterialSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
