package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.ProjecttrainingDao;
import com.oucre.pojo.Projecttraining;
import com.oucre.service.ProjecttrainingService;

@Service
public class ProjecttrainingServiceImpl implements ProjecttrainingService{
	@Autowired
	private ProjecttrainingDao projecttrainingDao;

	@Override
	public AjaxJson addProjecttrainingManager(Projecttraining entity) {
		AjaxJson a = new AjaxJson();
		if (projecttrainingDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("添加成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updProjecttrainingManager(Projecttraining entity) {
		AjaxJson a = new AjaxJson();
		if (projecttrainingDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("修改成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delProjecttrainingManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (projecttrainingDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findProjecttrainingSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return projecttrainingDao.findProjecttrainingSearch(map, easyUiPager);
	}
}
