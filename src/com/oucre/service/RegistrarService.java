package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.User;

public interface RegistrarService {

	public AjaxJson addRegistrarManager(User entity);

	public AjaxJson updRegistrarManager(User entity);

	public AjaxJson delRegistrarManager(String id);

	public Map<String, Object> findRegistrarSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
