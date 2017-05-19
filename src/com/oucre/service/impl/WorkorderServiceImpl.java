package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.WorkorderDao;
import com.oucre.pojo.Workorder;
import com.oucre.service.WorkorderService;

@Service
public class WorkorderServiceImpl implements WorkorderService{
	@Autowired
	private WorkorderDao workorderDao;

	@Override
	public AjaxJson updWorkorderManager(Workorder entity) {
		AjaxJson a = new AjaxJson();
		if (workorderDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("ÐÞ¸Ä³É¹¦");
			return a;
		}
		return a;
	}

	@Override
	public Map<String, Object> findWorkorderSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return workorderDao.findWorkorderSearch(map, easyUiPager);
	}
}
