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
import com.oucre.pojo.Projecttraining;
import com.oucre.service.ProjecttrainingService;

@Controller
@RequestMapping(value = "/busi")
public class ProjecttrainingManagerController {
	@Resource
	private ProjecttrainingService projecttrainingService;

	@RequestMapping(value = "/ProjecttrainingManager.do")
	public @ResponseBody
	Map<String, Object> findProjecttrainingSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return projecttrainingService.findProjecttrainingSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/ProjecttrainingManagerAdd.do")
	public @ResponseBody
	AjaxJson aadProjecttrainingManager(@ModelAttribute Projecttraining entity) {
		return projecttrainingService.addProjecttrainingManager(entity);
	}

	@RequestMapping(value = "/ProjecttrainingManagerUpd.do")
	public @ResponseBody
	AjaxJson updProjecttrainingManager(@ModelAttribute Projecttraining entity) {
		return projecttrainingService.updProjecttrainingManager(entity);
	}

	@RequestMapping(value = "/ProjecttrainingManagerDel.do")
	public @ResponseBody
	AjaxJson delProjecttrainingManager(HttpServletRequest req) {
		return projecttrainingService.delProjecttrainingManager(req.getParameter("id"));
	}
}
