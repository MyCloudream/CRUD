package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.AssetsDao;
import com.oucre.pojo.Assets;
import com.oucre.service.AssetsService;

@Service
public class AssetsServiceImpl implements AssetsService{
	@Autowired
	private AssetsDao assetsDao;

	@Override
	public AjaxJson addAssetsManager(Assets entity) {
		AjaxJson a = new AjaxJson();
		if (assetsDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("��ӳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updAssetsManager(Assets entity) {
		AjaxJson a = new AjaxJson();
		if (assetsDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("�޸ĳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delAssetsManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (assetsDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findAssetsSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return assetsDao.findAssetsSearch(map, easyUiPager);
	}
}
