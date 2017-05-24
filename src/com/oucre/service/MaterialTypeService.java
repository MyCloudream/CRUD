package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.MaterialType;

public interface MaterialTypeService {

	public AjaxJson addMaterialType(MaterialType entity);

	public AjaxJson updMaterialType(MaterialType entity);

	public MaterialType findMaterialType(Integer id);

	public AjaxJson delMaterialType(String id);

	public Map<String, Object> findMaterialTypeSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
