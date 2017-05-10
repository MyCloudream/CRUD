package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.TrainingDao;
import com.oucre.pojo.Training;
import com.oucre.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService{
	@Autowired
	private TrainingDao trainingDao;

	@Override
	public AjaxJson addTrainingManager(Training entity) {
		AjaxJson a = new AjaxJson();
		if (trainingDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("添加成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updTrainingManager(Training entity) {
		AjaxJson a = new AjaxJson();
		if (trainingDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("修改成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delTrainingManager(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (trainingDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findTrainingSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return trainingDao.findTrainingSearch(map, easyUiPager);
	}
}
