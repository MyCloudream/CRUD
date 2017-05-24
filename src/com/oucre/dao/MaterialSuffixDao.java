package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.MaterialSuffix;

public interface MaterialSuffixDao extends BaseDao<MaterialSuffix> {
	public Map<String, Object> findMaterialSuffixSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
