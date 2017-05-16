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
import com.oucre.pojo.User;
import com.oucre.service.RegistrarService;

@Controller
@RequestMapping(value = "/busi")
public class RegistrarManagerController {
	@Resource
	private RegistrarService registrarService;

	@RequestMapping(value = "/RegistrarManager.do")
	public @ResponseBody
	Map<String, Object> findRegistrarSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return registrarService.findRegistrarSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/RegistrarManagerAdd.do")
	public @ResponseBody
	AjaxJson aadRegistrarManager(@ModelAttribute User entity) {
		return registrarService.addRegistrarManager(entity);
	}

	@RequestMapping(value = "/RegistrarManagerUpd.do")
	public @ResponseBody
	AjaxJson updRegistrarManager(@ModelAttribute User entity) {
		return registrarService.updRegistrarManager(entity);
	}

	@RequestMapping(value = "/RegistrarManagerDel.do")
	public @ResponseBody
	AjaxJson delRegistrarManager(HttpServletRequest req) {
		return registrarService.delRegistrarManager(req.getParameter("id"));
	}
}
