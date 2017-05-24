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
import com.oucre.pojo.Score;
import com.oucre.service.ProjectScoreService;

@Controller
@RequestMapping(value = "/busi")
public class ProjectScoreManagerController {
	@Resource
	private ProjectScoreService projectScoreService;

	@RequestMapping(value = "/ProjectScoreManager.do")
	public @ResponseBody
	Map<String, Object> findStudentProjectScores(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return projectScoreService.findStudentProjectScores(map, new EasyUiPager(rows, page, sort, order));
	}
	
	
	@RequestMapping(value = "/ProjectScoreManagerUpd.do")
	public @ResponseBody
	AjaxJson updProjectScoreManagerUpd(@ModelAttribute Score entity) {
		return projectScoreService.updProjectScoreManagerUpd(entity);
	}
	
}
