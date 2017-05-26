package com.oucre.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.dao.MaterialDao;
import com.oucre.pojo.Material;
import com.oucre.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialDao materialDao;

	@Override
	public AjaxJson addMaterial(Material entity) {
		// 金豆为金额数量*100
		entity.setBean((int) (entity.getPrice()*100));
		entity.setMtime(new Date());
		AjaxJson a = new AjaxJson();
		if (materialDao.add(entity) > 0) {
			a.setSuccess(true);
			a.setMsg("添加成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson updMaterial(Material entity) {
		// 金豆为金额数量*100
		entity.setBean((int) (entity.getPrice()*100));
		entity.setMtime(new Date());
		AjaxJson a = new AjaxJson();
		if (materialDao.upd(entity)) {
			a.setSuccess(true);
			a.setMsg("修改成功");
			return a;
		}
		return a;
	}

	@Override
	public AjaxJson delMaterial(String id) {
		AjaxJson a = new AjaxJson();
		if (ValidateUtil.isInt(id)) {
			if (materialDao.del(Integer.parseInt(id))) {
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
	public Map<String, Object> findMaterialSearch(Map<String, Object> map, EasyUiPager easyUiPager) {
		return materialDao.findMaterialSearch(map, easyUiPager);
	}

	@Override
	public Material findMaterial(Integer id) {
		return materialDao.findById(id);
	}

}
