package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.MaterialSuffix;

public interface MaterialSuffixService {

	public AjaxJson addMaterialSuffix(MaterialSuffix entity);

	public AjaxJson updMaterialSuffix(MaterialSuffix entity);

	public MaterialSuffix findMaterialSuffix(Integer id);

	public AjaxJson delMaterialSuffix(String id);

	public Map<String, Object> findMaterialSuffixSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
