package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.User;

public interface RegistrarDao extends BaseDao<User>{
	public Map<String, Object> findRegistrarSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
