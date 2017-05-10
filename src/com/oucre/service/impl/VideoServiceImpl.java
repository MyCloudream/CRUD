package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.VideoDao;
import com.oucre.pojo.Video;
import com.oucre.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{
	@Autowired
	private VideoDao videoDao;

	@Override
	public AjaxJson addVideoManager(Video entity) {
		AjaxJson a = new AjaxJson();
		if (videoDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("��ӳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updVideoManager(Video entity) {
		AjaxJson a = new AjaxJson();
		if (videoDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("�޸ĳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delVideoManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (videoDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findVideoSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return videoDao.findVideoSearch(map, easyUiPager);
	}
}
