package com.oucre.service;

import java.util.Map;

import com.oucre.core.mode.json.AjaxJson;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Notes;

public interface NotesService {

	public AjaxJson addNotesManager(Notes entity);

	public AjaxJson updNotesManager(Notes entity);

	public AjaxJson delNotesManager(String id);

	public Map<String, Object> findNotesSearch(Map<String, Object> map, EasyUiPager easyUiPager);

}
