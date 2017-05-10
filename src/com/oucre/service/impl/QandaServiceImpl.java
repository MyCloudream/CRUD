package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.QandaDao;
import com.oucre.pojo.Qanda;
import com.oucre.service.QandaService;

@Service
public class QandaServiceImpl implements QandaService{
	@Autowired
	private QandaDao qandaDao;

	@Override
	public AjaxJson addQandaManager(Qanda entity) {
		AjaxJson a = new AjaxJson();
		if (qandaDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("��ӳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updQandaManager(Qanda entity) {
		AjaxJson a = new AjaxJson();
		if (qandaDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("�޸ĳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delQandaManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (qandaDao.del(Integer.parseInt(id))) {
				a.setSuccess(true);
				a.setMsg("�����ɹ�");
			} else {
				a.setSuccess(false);
				a.setMsg("ɾ��ʧ��");
			}
		} else {
			a.setSuccess(false);
			a.setMsg("�Ƿ�����");
		}
		return a;
	}

	@Override
	public Map<String, Object> findQandaSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return qandaDao.findQandaSearch(map, easyUiPager);
	}
}
