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
import com.oucre.pojo.Material;
import com.oucre.service.MaterialService;

@Controller
@RequestMapping(value = "/busi")
public class MaterialManagerController {
	@Resource
	private MaterialService materialService;

	@RequestMapping(value = "/MaterialManager.do")
	public @ResponseBody
	Map<String, Object> findMaterialSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ValidateUtil.neNull(req.getParameter("title"))) {
			map.put("title", req.getParameter("title"));
		}
		return materialService.findMaterialSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/MaterialManagerAdd.do")
	public @ResponseBody
	AjaxJson aadMaterialManager(@ModelAttribute Material entity) {
		return materialService.addMaterial(entity);
	}

	@RequestMapping(value = "/MaterialManagerUpd.do")
	public @ResponseBody
	AjaxJson updMaterialManager(@ModelAttribute Material entity) {
		return materialService.updMaterial(entity);
	}

	@RequestMapping(value = "/MaterialManagerDel.do")
	public @ResponseBody
	AjaxJson delMaterialManager(HttpServletRequest req) {
		return materialService.delMaterial(req.getParameter("id"));
	}


}
