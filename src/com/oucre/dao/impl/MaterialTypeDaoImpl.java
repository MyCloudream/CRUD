package com.oucre.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.oucre.core.dao.impl.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.MaterialTypeDao;
import com.oucre.pojo.MaterialType;

@Repository
public class MaterialTypeDaoImpl extends BaseDao<MaterialType> implements MaterialTypeDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Integer add(MaterialType entity) {
		try {
			Serializable sz = super.saveEntity(entity);
			if (sz != null) {
				return (Integer) sz;
			}
			return 0;
		} catch (Exception e) {
			logger.error("dao添加错误", e);
			return 0;
		}
	}

	@Override
	public boolean upd(MaterialType entity) {
		try {
			super.updateEntity(entity);
		} catch (Exception e) {
			logger.error("dao修改错误", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean del(Integer id) {
		try {
			super.deleteEntity(new MaterialType(id));
			return true;
		} catch (Exception e) {
			logger.error("dao查找错误", e);
			return false;
		}
	}

	@Override
	public MaterialType findById(Integer id) {
		try {
			return super.get(MaterialType.class, id);
		} catch (Exception e) {
			logger.error("dao查找错误", e);
			return null;
		}
	}

	@Override
	public Map<String, Object> findMaterialTypeSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		try {
			/*
			 * String select =
			 * "select new MaterialType(id,title,type,subdate,upddate) ";
			 */
			String Hql = " from MaterialType where 1=1 ";
			String orderby = "";
			if (map.get("name") != null) {
				Hql += " and name like '%" + map.get("name") + "%' ";
			}
			if (easyUiPager.getOrderby() != null) {
				orderby = " " + easyUiPager.getOrderby() + " ";
			}
			List<MaterialType> list = super.findHqlByPager(/* select + */Hql + orderby, (easyUiPager.getPage() - 1) * easyUiPager.getRows(), easyUiPager.getRows());
			Hql = "select COUNT(*) " + Hql;
			// 英文数据库中的表名叫material_type
			Hql = Hql.replace("MaterialType", "material_type");
			Integer total = super.findByHqlForPageCountEasyUi(Hql);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("rows", list);
			m.put("total", total);
			return m;
		} catch (Exception e) {
			logger.error("dao错误", e);
			return null;
		}
	}
}
