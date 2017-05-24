package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.MaterialSuffixDao;
import com.oucre.pojo.MaterialSuffix;
import com.oucre.service.MaterialSuffixService;

@Service
public class MaterialSuffixServiceImpl implements MaterialSuffixService {
	@Autowired
	private MaterialSuffixDao materialSuffixDao;

	@Override
	public AjaxJson addMaterialSuffix(MaterialSuffix entity) {
		AjaxJson a = new AjaxJson();
		if (materialSuffixDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("添加成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updMaterialSuffix(MaterialSuffix entity) {
		AjaxJson a = new AjaxJson();
		if (materialSuffixDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("修改成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delMaterialSuffix(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (materialSuffixDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findMaterialSuffixSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return materialSuffixDao.findMaterialSuffixSearch(map, easyUiPager);
	}

	@Override
	public MaterialSuffix findMaterialSuffix(Integer id) {
		return materialSuffixDao.findById(id);
	}

}
