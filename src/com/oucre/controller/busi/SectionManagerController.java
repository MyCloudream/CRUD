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
import com.oucre.pojo.Section;
import com.oucre.service.SectionService;

@Controller
@RequestMapping(value = "/busi")
public class SectionManagerController {
	@Resource
	private SectionService sectionService;

	@RequestMapping(value = "/SectionManager.do")
	public @ResponseBody
	Map<String, Object> findSectionSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ValidateUtil.neNull(req.getParameter("name"))) {
			map.put("name", Integer.parseInt(req.getParameter("name")));
		}
		System.out.println("------------------"+req.getParameter("name"));
		return sectionService.findSectionSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/SectionManagerAdd.do")
	public @ResponseBody
	AjaxJson aadSectionManager(@ModelAttribute Section entity) {
		return sectionService.addSectionManager(entity);
	}

	@RequestMapping(value = "/SectionManagerUpd.do")
	public @ResponseBody
	AjaxJson updSectionManager(@ModelAttribute Section entity) {
		return sectionService.updSectionManager(entity);
	}

	@RequestMapping(value = "/SectionManagerDel.do")
	public @ResponseBody
	AjaxJson delSectionManager(HttpServletRequest req) {
		return sectionService.delSectionManager(req.getParameter("id"));
	}
}
