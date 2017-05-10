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
import com.oucre.pojo.Notes;
import com.oucre.service.NotesService;

@Controller
@RequestMapping(value = "/busi")
public class NotesManagerController {
	@Resource
	private NotesService notesService;

	@RequestMapping(value = "/NotesManager.do")
	public @ResponseBody
	Map<String, Object> findNotesSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return notesService.findNotesSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/NotesManagerAdd.do")
	public @ResponseBody
	AjaxJson aadNotesManager(@ModelAttribute Notes entity) {
		return notesService.addNotesManager(entity);
	}

	@RequestMapping(value = "/NotesManagerUpd.do")
	public @ResponseBody
	AjaxJson updNotesManager(@ModelAttribute Notes entity) {
		return notesService.updNotesManager(entity);
	}

	@RequestMapping(value = "/NotesManagerDel.do")
	public @ResponseBody
	AjaxJson delNotesManager(HttpServletRequest req) {
		return notesService.delNotesManager(req.getParameter("id"));
	}
}
