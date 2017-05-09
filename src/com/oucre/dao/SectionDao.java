package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Section;

public interface SectionDao extends BaseDao<Section>{
	public Map<String, Object> findSectionSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
