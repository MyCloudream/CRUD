package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.RegistrarDao;
import com.oucre.pojo.User;
import com.oucre.service.RegistrarService;

@Service
public class RegistrarServiceImpl implements RegistrarService{
	@Autowired
	private RegistrarDao registrarDao;

	@Override
	public AjaxJson addRegistrarManager(User entity) {
		AjaxJson a = new AjaxJson();
		entity.setStatus("y");
		if (registrarDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("��ӳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updRegistrarManager(User entity) {
		AjaxJson a = new AjaxJson();
		if (registrarDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("�޸ĳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delRegistrarManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (registrarDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findRegistrarSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return registrarDao.findRegistrarSearch(map, easyUiPager);
	}
}
