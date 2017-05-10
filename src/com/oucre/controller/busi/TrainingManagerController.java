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
import com.oucre.pojo.Training;
import com.oucre.service.TrainingService;

@Controller
@RequestMapping(value = "/busi")
public class TrainingManagerController {
	@Resource
	private TrainingService trainingService;

	@RequestMapping(value = "/TrainingManager.do")
	public @ResponseBody
	Map<String, Object> findTrainingSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return trainingService.findTrainingSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/TrainingManagerAdd.do")
	public @ResponseBody
	AjaxJson aadTrainingManager(@ModelAttribute Training entity) {
		System.out.println("-----------------------------"+entity+"--------------------------------");
		return trainingService.addTrainingManager(entity);
	}

	@RequestMapping(value = "/TrainingManagerUpd.do")
	public @ResponseBody
	AjaxJson updTrainingManager(@ModelAttribute Training entity) {
		return trainingService.updTrainingManager(entity);
	}

	@RequestMapping(value = "/TrainingManagerDel.do")
	public @ResponseBody
	AjaxJson delTrainingManager(HttpServletRequest req) {
		return trainingService.delTrainingManager(req.getParameter("id"));
	}
}
