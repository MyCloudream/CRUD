package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.ChapterDao;
import com.oucre.pojo.Chapter;
import com.oucre.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService{
	@Autowired
	private ChapterDao ChapterDao;

	@Override
	public AjaxJson addChapterManager(Chapter entity) {
		AjaxJson a = new AjaxJson();
		if (ChapterDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("��ӳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updChapterManager(Chapter entity) {
		AjaxJson a = new AjaxJson();
		if (ChapterDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("�޸ĳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delChapterManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (ChapterDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findChapterSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return ChapterDao.findChapterSearch(map, easyUiPager);
	}
}
