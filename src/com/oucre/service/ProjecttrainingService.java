package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Projecttraining;

public interface ProjecttrainingService {

	public AjaxJson addProjecttrainingManager(Projecttraining entity);

	public AjaxJson updProjecttrainingManager(Projecttraining entity);

	public AjaxJson delProjecttrainingManager(String id);

	public Map<String, Object> findProjecttrainingSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
