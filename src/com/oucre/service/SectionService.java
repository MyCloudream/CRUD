package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Section;

public interface SectionService {

	public AjaxJson addSectionManager(Section entity);

	public AjaxJson updSectionManager(Section entity);

	public AjaxJson delSectionManager(String id);

	public Map<String, Object> findSectionSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}	
