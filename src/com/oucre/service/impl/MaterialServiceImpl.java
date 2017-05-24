package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.MaterialDao;
import com.oucre.pojo.Material;
import com.oucre.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialDao materialDao;

	@Override
	public AjaxJson addMaterial(Material entity) {
		AjaxJson a = new AjaxJson();
		if (materialDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("��ӳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updMaterial(Material entity) {
		AjaxJson a = new AjaxJson();
		if (materialDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("�޸ĳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delMaterial(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (materialDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findMaterialSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return materialDao.findMaterialSearch(map, easyUiPager);
	}

	@Override
	public Material findMaterial(Integer id) {
		return materialDao.findById(id);
	}

}
