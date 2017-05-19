package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Workorder;

public interface WorkorderService {

	public AjaxJson updWorkorderManager(Workorder entity);

	public Map<String, Object> findWorkorderSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
