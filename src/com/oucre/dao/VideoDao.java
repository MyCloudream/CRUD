package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Video;

public interface VideoDao extends BaseDao<Video>{
	public Map<String, Object> findVideoSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
