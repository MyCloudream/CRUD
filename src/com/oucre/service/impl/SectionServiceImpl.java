package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.SectionDao;
import com.oucre.pojo.Section;
import com.oucre.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{
	@Autowired
	private SectionDao sectionDao;

	@Override
	public AjaxJson addSectionManager(Section entity) {
		AjaxJson a = new AjaxJson();
		if (sectionDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("添加成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updSectionManager(Section entity) {
		AjaxJson a = new AjaxJson();
		if (sectionDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("修改成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delSectionManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (sectionDao.del(Integer.parseInt(id))) {
				a.setSuccess(true);
				a.setMsg("操作成功");
			} else {
				a.setSuccess(false);
				a.setMsg("删除失败");
			}
		} else {
			a.setSuccess(false);
			a.setMsg("非法类型");
		}
		return a;
	}

	@Override
	public Map<String, Object> findSectionSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return sectionDao.findSectionSearch(map, easyUiPager);
	}
}
