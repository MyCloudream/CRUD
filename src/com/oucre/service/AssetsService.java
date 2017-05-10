package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Assets;

public interface AssetsService {

	public AjaxJson addAssetsManager(Assets entity);

	public AjaxJson updAssetsManager(Assets entity);

	public AjaxJson delAssetsManager(String id);

	public Map<String, Object> findAssetsSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
