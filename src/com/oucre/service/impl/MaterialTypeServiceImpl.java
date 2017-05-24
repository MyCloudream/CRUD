package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.MaterialTypeDao;
import com.oucre.pojo.MaterialType;
import com.oucre.service.MaterialTypeService;

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {
	@Autowired
	private MaterialTypeDao materialTypeDao;

	@Override
	public AjaxJson addMaterialType(MaterialType entity) {
		AjaxJson a = new AjaxJson();
		if (materialTypeDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("添加成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updMaterialType(MaterialType entity) {
		AjaxJson a = new AjaxJson();
		if (materialTypeDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("修改成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delMaterialType(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (materialTypeDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findMaterialTypeSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return materialTypeDao.findMaterialTypeSearch(map, easyUiPager);
	}

	@Override
	public MaterialType findMaterialType(Integer id) {
		return materialTypeDao.findById(id);
	}

}
