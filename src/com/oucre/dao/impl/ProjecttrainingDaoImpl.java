package com.oucre.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.oucre.core.dao.impl.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.ProjecttrainingDao;
import com.oucre.pojo.Projecttraining;

@Repository
public class ProjecttrainingDaoImpl extends BaseDao<Projecttraining> implements ProjecttrainingDao{

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Integer add(Projecttraining entity) {
		try {
			Serializable sz = super.saveEntity(entity);
			if (sz != null) {
				return (Integer) sz;
			}
			return 0;
		} catch (Exception e) {
			logger.error("daoÃÌº”¥ÌŒÛ", e);
			return 0;
		}
	}

	@Override
	public boolean upd(Projecttraining entity) {
		try {
			super.updateEntity(entity);
		} catch (Exception e) {
			logger.error("dao–ﬁ∏ƒ¥ÌŒÛ", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean del(Integer id) {
		try {
			super.deleteEntity(new Projecttraining(id));
			return true;
		} catch (Exception e) {
			logger.error("dao≤È’“¥ÌŒÛ", e);
			return false;
		}
	}

	@Override
	public Projecttraining findById(Integer id) {
		try {
			return super.get(Projecttraining.class, id);
		} catch (Exception e) {
			logger.error("dao≤È’“¥ÌŒÛ", e);
			return null;
		}
	}

	@Override
	public Map<String, Object> findProjecttrainingSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		try {
			/*
			 * String select =
			 * "select new Projecttraining(id,title,type,subdate,upddate) ";
			 */
			String Hql = " from Projecttraining where 1=1 ";
			String orderby = "";
			if (easyUiPager.getOrderby() != null) {
				orderby = " " + easyUiPager.getOrderby() + " ";
			}
			List<Projecttraining> list = super.findHqlByPager(/* select + */Hql + orderby, (easyUiPager.getPage() - 1) * easyUiPager.getRows(), easyUiPager.getRows());
			Hql = "select COUNT(*) " + Hql;
			Integer total = super.findByHqlForPageCountEasyUi(Hql);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("rows", list);
			m.put("total", total);
			return m;
		} catch (Exception e) {
			logger.error("dao¥ÌŒÛ", e);
			return null;
		}
	}

}
