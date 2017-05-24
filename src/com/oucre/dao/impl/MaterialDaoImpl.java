package com.oucre.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.oucre.core.dao.impl.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.MaterialDao;
import com.oucre.pojo.Material;

@Repository
public class MaterialDaoImpl extends BaseDao<Material> implements MaterialDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Integer add(Material entity) {
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
	public boolean upd(Material entity) {
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
			super.deleteEntity(new Material(id));
			return true;
		} catch (Exception e) {
			logger.error("dao≤È’“¥ÌŒÛ", e);
			return false;
		}
	}

	@Override
	public Material findById(Integer id) {
		try {
			return super.get(Material.class, id);
		} catch (Exception e) {
			logger.error("dao≤È’“¥ÌŒÛ", e);
			return null;
		}
	}

	@Override
	public Map<String, Object> findMaterialSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		try {
			/*
			 * String select =
			 * "select new Material(id,title,type,subdate,upddate) ";
			 */
			String Hql = " from Material where 1=1 ";
			String orderby = "";
			if (map.get("title") != null) {
				Hql += " and title like '" + map.get("title") + "%' ";
			}
			if (easyUiPager.getOrderby() != null) {
				orderby = " " + easyUiPager.getOrderby() + " ";
			}
			List<Material> list = super.findHqlByPager(/* select + */Hql + orderby, (easyUiPager.getPage() - 1) * easyUiPager.getRows(), easyUiPager.getRows());
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

	@Override
	public Material findMaterialTopOne() {
		try {
			super.hql = "from Material order by id desc ";
			List<Material> a = super.findHqlByPager(super.hql, 0, 1);
			if (a != null && a.size() > 0) {
				return a.get(0);
			}
			return null;
		} catch (Exception e) {
			logger.error("dao¥ÌŒÛ", e);
			return null;
		}
	}
}
