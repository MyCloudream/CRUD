package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Chapter;

public interface ChapterService {

	public AjaxJson addChapterManager(Chapter entity);

	public AjaxJson updChapterManager(Chapter entity);

	public AjaxJson delChapterManager(String id);

	public Map<String, Object> findChapterSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
