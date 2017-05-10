package com.oucre.dao;

import java.util.Map;

import com.oucre.core.dao.BaseDao;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.pojo.Notes;

public interface NotesDao extends BaseDao<Notes>{
	public Map<String, Object> findNotesSearch(Map<String, Object> map, EasyUiPager easyUiPager);
}
