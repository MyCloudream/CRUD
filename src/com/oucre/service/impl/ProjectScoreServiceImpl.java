package com.oucre.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.ProjectScoreDao;
import com.oucre.pojo.Score;
import com.oucre.service.ProjectScoreService;

@Service
public class ProjectScoreServiceImpl implements ProjectScoreService{

	@Autowired
	private ProjectScoreDao projectScoreDao;
	
	@Override
	public Map<String, Object> findStudentProjectScores(Map<String, Object> map, EasyUiPager easyUiPager) {
		return projectScoreDao.findStudentProjectScores(map, easyUiPager);
	}

	@Override
	public AjaxJson updProjectScoreManagerUpd(Score entity) {
		AjaxJson a = new AjaxJson();
		if (projectScoreDao.updateEntityBySql(entity.getScore(),entity.getId())) {
			a.setSuccess(true);
			a.setMsg("ÐÞ¸Ä³É¹¦");
			return a;
		}
		return a;
	}
	
}
