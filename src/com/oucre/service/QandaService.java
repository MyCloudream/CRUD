package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Qanda;

public interface QandaService {

	public AjaxJson addQandaManager(Qanda entity);

	public AjaxJson updQandaManager(Qanda entity);

	public AjaxJson delQandaManager(String id);

	public Map<String, Object> findQandaSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
