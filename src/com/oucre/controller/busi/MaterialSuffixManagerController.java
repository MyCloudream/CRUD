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
import com.oucre.pojo.MaterialSuffix;
import com.oucre.service.MaterialSuffixService;

@Controller
@RequestMapping(value = "/busi")
public class MaterialSuffixManagerController {
	@Resource
	private MaterialSuffixService materialSuffixService;

	@RequestMapping(value = "/MaterialSuffixManager.do")
	public @ResponseBody
	Map<String, Object> findMaterialSuffixSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ValidateUtil.neNull(req.getParameter("name"))) {
			map.put("name", req.getParameter("name"));
		}
		if (ValidateUtil.neNull(req.getParameter("tid"))) {
			map.put("tid", req.getParameter("tid"));
		}
		return materialSuffixService.findMaterialSuffixSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/MaterialSuffixManagerAdd.do")
	public @ResponseBody
	AjaxJson aadMaterialSuffixManager(@ModelAttribute MaterialSuffix entity) {
		return materialSuffixService.addMaterialSuffix(entity);
	}

	@RequestMapping(value = "/MaterialSuffixManagerUpd.do")
	public @ResponseBody
	AjaxJson updMaterialSuffixManager(@ModelAttribute MaterialSuffix entity) {
		return materialSuffixService.updMaterialSuffix(entity);
	}

	@RequestMapping(value = "/MaterialSuffixManagerDel.do")
	public @ResponseBody
	AjaxJson delMaterialSuffixManager(HttpServletRequest req) {
		return materialSuffixService.delMaterialSuffix(req.getParameter("id"));
	}


}
