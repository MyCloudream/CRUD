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
import com.oucre.pojo.Workorder;
import com.oucre.service.WorkorderService;

@Controller
@RequestMapping(value = "/busi")
public class WorkorderManagerController {
	@Resource
	private WorkorderService workorderService;

	@RequestMapping(value = "/WorkorderManager.do")
	public @ResponseBody
	Map<String, Object> findWorkorderSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String answer = req.getParameter("answer");
		if(answer!=null){
			map.put("answer", answer);
		}
		return workorderService.findWorkorderSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/WorkorderManagerUpd.do")
	public @ResponseBody
	AjaxJson updWorkorderManager(@ModelAttribute Workorder entity) {
		System.out.println("--------------------"+entity+"-------------------------");
		return workorderService.updWorkorderManager(entity);
	}
}
