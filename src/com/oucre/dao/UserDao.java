package com.oucre.dao;

import java.util.List;
import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.User;

public interface UserDao extends BaseDao<User> {

	public User loginUser(String mobile, String passwd);

	public List<User> findUserRoleid(Integer roleid);

}
