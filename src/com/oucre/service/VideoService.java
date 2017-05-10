package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Video;

public interface VideoService {

	public AjaxJson addVideoManager(Video entity);

	public AjaxJson updVideoManager(Video entity);

	public AjaxJson delVideoManager(String id);

	public Map<String, Object> findVideoSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
