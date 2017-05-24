package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Material;

public interface MaterialService {

	public AjaxJson addMaterial(Material entity);

	public AjaxJson updMaterial(Material entity);

	public Material findMaterial(Integer id);

	public AjaxJson delMaterial(String id);

	public Map<String, Object> findMaterialSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
