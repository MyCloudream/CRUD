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
import com.oucre.pojo.Assets;
import com.oucre.service.AssetsService;

@Controller
@RequestMapping(value = "/busi")
public class AssetsManagerController {
	@Resource
	private AssetsService assetsService;

	@RequestMapping(value = "/AssetsManager.do")
	public @ResponseBody
	Map<String, Object> findAssetsSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return assetsService.findAssetsSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/AssetsManagerAdd.do")
	public @ResponseBody
	AjaxJson aadAssetsManager(@ModelAttribute Assets entity) {
		return assetsService.addAssetsManager(entity);
	}

	@RequestMapping(value = "/AssetsManagerUpd.do")
	public @ResponseBody
	AjaxJson updAssetsManager(@ModelAttribute Assets entity) {
		return assetsService.updAssetsManager(entity);
	}

	@RequestMapping(value = "/AssetsManagerDel.do")
	public @ResponseBody
	AjaxJson delAssetsManager(HttpServletRequest req) {
		return assetsService.delAssetsManager(req.getParameter("id"));
	}
}
