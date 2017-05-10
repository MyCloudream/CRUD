package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Training;

public interface TrainingService {

	public AjaxJson addTrainingManager(Training entity);

	public AjaxJson updTrainingManager(Training entity);

	public AjaxJson delTrainingManager(String id);

	public Map<String, Object> findTrainingSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
