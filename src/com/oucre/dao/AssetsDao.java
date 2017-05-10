package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Assets;

public interface AssetsDao extends BaseDao<Assets>{
	public Map<String, Object> findAssetsSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
