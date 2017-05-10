package com.oucre.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.oucre.core.dao.impl.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.NotesDao;
import com.oucre.pojo.Notes;

@Repository
public class NotesDaoImpl extends BaseDao<Notes> implements NotesDao{

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Integer add(Notes entity) {
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
	public boolean upd(Notes entity) {
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
			super.deleteEntity(new Notes(id));
			return true;
		} catch (Exception e) {
			logger.error("dao���Ҵ���", e);
			return false;
		}
	}

	@Override
	public Notes findById(Integer id) {
		try {
			return super.get(Notes.class, id);
		} catch (Exception e) {
			logger.error("dao���Ҵ���", e);
			return null;
		}
	}

	@Override
	public Map<String, Object> findNotesSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		try {
			/*
			 * String select =
			 * "select new Notes(id,title,type,subdate,upddate) ";
			 */
			String Hql = " from Notes where 1=1 ";
			String orderby = "";
			if (easyUiPager.getOrderby() != null) {
				orderby = " " + easyUiPager.getOrderby() + " ";
			}
			List<Notes> list = super.findHqlByPager(/* select + */Hql + orderby, (easyUiPager.getPage() - 1) * easyUiPager.getRows(), easyUiPager.getRows());
			Hql = "select COUNT(*) " + Hql;
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
