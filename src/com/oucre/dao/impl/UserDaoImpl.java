package com.oucre.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.oucre.core.dao.impl.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.UserDao;
import com.oucre.pojo.User;

@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Integer add(User entity) {
		try {
			Serializable sz = super.saveEntity(entity);
			if (sz != null) {
				return (Integer) sz;
			}
			return 0;
		} catch (Exception e) {
			logger.error("dao´íÎó", e);
			return 0;
		}
	}

	@Override
	public boolean upd(User entity) {
		try {
			super.updateEntity(entity);
		} catch (Exception e) {
			logger.error("dao´íÎó", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean del(Integer id) {
		try {
			super.deleteEntity(new User(id));
			return true;
		} catch (Exception e) {
			logger.error("dao´íÎó", e);
			return false;
		}
	}

	@Override
	public User findById(Integer id) {
		try {
			return super.get(User.class, id);
		} catch (Exception e) {
			logger.error("dao´íÎó", e);
			return null;
		}
	}

	@Override
	public User loginUser(String mobile, String passwd) {
		try {
			String hql = "from User where mobile ='" + mobile + "' and passwd = '"
					+ passwd + "' ";
			List<User> list = super.findHql(hql);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (Exception e) {
			logger.error("dao´íÎó", e);
			return null;
		}
	}

	@Override
	public List<User> findUserRoleid(Integer roleid) {
		try {
			String hql = "from User where roleid =" + roleid;
			List<User> list = super.findHql(hql);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (Exception e) {
			logger.error("dao´íÎó", e);
			return null;
		}
	}
}
