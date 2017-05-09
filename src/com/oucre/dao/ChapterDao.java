package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Chapter;

public interface ChapterDao extends BaseDao<Chapter>{
	public Map<String, Object> findChapterSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
