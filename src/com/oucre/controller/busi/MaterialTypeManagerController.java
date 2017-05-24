package com.oucre.controller.busi;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.core.util.ValidateUtil;
import com.oucre.pojo.MaterialType;
import com.oucre.service.MaterialTypeService;

@Controller
@RequestMapping(value = "/busi")
public class MaterialTypeManagerController {
	@Resource
	private MaterialTypeService materialTypeService;

	@RequestMapping(value = "/MaterialTypeManager.do")
	public @ResponseBody
	Map<String, Object> findMaterialTypeSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ValidateUtil.neNull(req.getParameter("name"))) {
			map.put("name", req.getParameter("name"));
		}
		return materialTypeService.findMaterialTypeSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/MaterialTypeManagerAdd.do")
	public @ResponseBody
	AjaxJson aadMaterialTypeManager(@ModelAttribute MaterialType entity) {
		return materialTypeService.addMaterialType(entity);
	}

	@RequestMapping(value = "/MaterialTypeManagerUpd.do")
	public @ResponseBody
	AjaxJson updMaterialTypeManager(@ModelAttribute MaterialType entity) {
		return materialTypeService.updMaterialType(entity);
	}

	@RequestMapping(value = "/MaterialTypeManagerDel.do")
	public @ResponseBody
	AjaxJson delMaterialTypeManager(HttpServletRequest req) {
		return materialTypeService.delMaterialType(req.getParameter("id"));
	}


}
