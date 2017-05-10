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
import com.oucre.pojo.Qanda;
import com.oucre.service.QandaService;

@Controller
@RequestMapping(value = "/busi")
public class QandaManagerController {
	@Resource
	private QandaService qandaService;

	@RequestMapping(value = "/QandaManager.do")
	public @ResponseBody
	Map<String, Object> findQandaSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return qandaService.findQandaSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/QandaManagerAdd.do")
	public @ResponseBody
	AjaxJson aadQandaManager(@ModelAttribute Qanda entity) {
		return qandaService.addQandaManager(entity);
	}

	@RequestMapping(value = "/QandaManagerUpd.do")
	public @ResponseBody
	AjaxJson updQandaManager(@ModelAttribute Qanda entity) {
		return qandaService.updQandaManager(entity);
	}

	@RequestMapping(value = "/QandaManagerDel.do")
	public @ResponseBody
	AjaxJson delQandaManager(HttpServletRequest req) {
		return qandaService.delQandaManager(req.getParameter("id"));
	}
}
