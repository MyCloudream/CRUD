package com.oucre.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.oucre.core.dao.impl.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.MaterialSuffixDao;
import com.oucre.pojo.MaterialSuffix;

@Repository
public class MaterialSuffixDaoImpl extends BaseDao<MaterialSuffix> implements MaterialSuffixDao {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Integer add(MaterialSuffix entity) {
		try {
			Serializable sz = super.saveEntity(entity);
			if (sz != null) {
				return (Integer) sz;
			}
			return 0;
		} catch (Exception e) {
			logger.error("dao��Ӵ���", e);
			return 0;
		}
	}

	@Override
	public boolean upd(MaterialSuffix entity) {
		try {
			super.updateEntity(entity);
		} catch (Exception e) {
			logger.error("dao�޸Ĵ���", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean del(Integer id) {
		try {
			super.deleteEntity(new MaterialSuffix(id));
			return true;
		} catch (Exception e) {
			logger.error("dao���Ҵ���", e);
			return false;
		}
	}

	@Override
	public MaterialSuffix findById(Integer id) {
		try {
			return super.get(MaterialSuffix.class, id);
		} catch (Exception e) {
			logger.error("dao���Ҵ���", e);
			return null;
		}
	}

	@Override
	public Map<String, Object> findMaterialSuffixSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		try {
			/*
			 * String select =
			 * "select new MaterialSuffix(id,title,type,subdate,upddate) ";
			 */
			String Hql = " from MaterialSuffix where 1=1 ";
			String orderby = "";
			if (map.get("name") != null) {
				Hql += " and name like '%" + map.get("name") + "%' ";
			}
			if (map.get("tid") != null) {
				Hql += " and tid = " + map.get("tid");
			}
			if (easyUiPager.getOrderby() != null) {
				orderby = " " + easyUiPager.getOrderby() + " ";
			}
			List<MaterialSuffix> list = super.findHqlByPager(/* select + */Hql + orderby, (easyUiPager.getPage() - 1) * easyUiPager.getRows(), easyUiPager.getRows());
			Hql = "select COUNT(*) " + Hql;
			// Ӣ�����ݿ��еı�����material_suffix
			Hql = Hql.replace("MaterialSuffix", "material_suffix");
			Integer total = super.findByHqlForPageCountEasyUi(Hql);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("rows", list);
			m.put("total", total);
			return m;
		} catch (Exception e) {
			logger.error("dao����", e);
			return null;
		}
	}
}
