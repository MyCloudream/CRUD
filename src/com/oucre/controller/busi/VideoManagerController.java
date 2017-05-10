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
import com.oucre.pojo.Video;
import com.oucre.service.VideoService;

@Controller
@RequestMapping(value = "/busi")
public class VideoManagerController {
	@Resource
	private VideoService videoService;

	@RequestMapping(value = "/VideoManager.do")
	public @ResponseBody
	Map<String, Object> findVideoSearch(@RequestParam(value = "rows") Integer rows, @RequestParam(value = "page") Integer page, @RequestParam(value = "sort") String sort, @RequestParam(value = "order") String order, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		return videoService.findVideoSearch(map, new EasyUiPager(rows, page, sort, order));
	}

	@RequestMapping(value = "/VideoManagerAdd.do")
	public @ResponseBody
	AjaxJson aadVideoManager(@ModelAttribute Video entity) {
		return videoService.addVideoManager(entity);
	}

	@RequestMapping(value = "/VideoManagerUpd.do")
	public @ResponseBody
	AjaxJson updVideoManager(@ModelAttribute Video entity) {
		return videoService.updVideoManager(entity);
	}

	@RequestMapping(value = "/VideoManagerDel.do")
	public @ResponseBody
	AjaxJson delVideoManager(HttpServletRequest req) {
		return videoService.delVideoManager(req.getParameter("id"));
	}
}
