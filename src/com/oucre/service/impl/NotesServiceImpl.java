package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.NotesDao;
import com.oucre.pojo.Notes;
import com.oucre.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService{
	@Autowired
	private NotesDao notesDao;

	@Override
	public AjaxJson addNotesManager(Notes entity) {
		AjaxJson a = new AjaxJson();
		if (notesDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("��ӳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updNotesManager(Notes entity) {
		AjaxJson a = new AjaxJson();
		if (notesDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("�޸ĳɹ�");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delNotesManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (notesDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findNotesSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return notesDao.findNotesSearch(map, easyUiPager);
	}
}
