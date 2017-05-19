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
import com.oucre.pojo.Chapter;
import com.oucre.service.ChapterService;

@Controller
@RequestMapping(value = "/busi")
public class ChapterManagerController {
	@Resource
	private ChapterService chapterService;

	@RequestMapping(value = "/ChapterManager.do")
	public @ResponseBody
	Map<String, Object> findChapterSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String name = req.getParameter("name");
		if (ValidateUtil.neNull(name)) {
			map.put("name", name);
		}
		return chapterService.findChapterSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/ChapterManagerAdd.do")
	public @ResponseBody
	AjaxJson aadChapterManager(@ModelAttribute Chapter entity) {
		return chapterService.addChapterManager(entity);
	}

	@RequestMapping(value = "/ChapterManagerUpd.do")
	public @ResponseBody
	AjaxJson updChapterManager(@ModelAttribute Chapter entity) {
		return chapterService.updChapterManager(entity);
	}

	@RequestMapping(value = "/ChapterManagerDel.do")
	public @ResponseBody
	AjaxJson delChapterManager(HttpServletRequest req) {
		return chapterService.delChapterManager(req.getParameter("id"));
	}
}
