package com.oucre.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.oucre.core.dao.impl.BaseDao;
import com.oucre.core.entity.StudentProjectScore;
import com.oucre.core.mode.search.EasyUiPager;
import com.oucre.dao.StudentDao;
import com.oucre.pojo.Student;

@Repository
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao{

	@Override
	public Integer add(Student entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean upd(Student entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> findStudentProjectScores(Map<String, Object> map,
			EasyUiPager easyUiPager) {
		try {
			String sql = "select sco.id as id,stu.nick as name,stu.mobile as mobile,pro.content as content,sco.score as score,sco.url as url,sco.stime as stime ";
			String where = " from student stu,score sco,projecttraining pro where stu.id = sco.sid and sco.pid = pro.id ";
			/*if (map.get("orderid") != null) {
				where += " and m.orderid = '" + map.get("orderid") + "' ";
			}
			if (map.get("eid") != null) {
				where += " and m.eid = " + map.get("eid") + " ";
			}
			if (map.get("uid") != null) {
				where += " and m.uid = " + map.get("uid") + " ";
			}
			if (map.get("status") != null) {
				where += " and m.status = '" + map.get("status") + "' ";
			}*/
			String orderby = "";
			if (easyUiPager.getSort() != null && easyUiPager.getOrder() != null) {
				orderby = "order by sco." + easyUiPager.getSort() + " "
						+ easyUiPager.getOrder() + " ";
			}
			Query query = getSession().createSQLQuery(sql + where + orderby)
					.addScalar("id").addScalar("name").addScalar("mobile")
					.addScalar("content").addScalar("score").addScalar("url")
					.addScalar("stime");
			query.setResultTransformer(Transformers
					.aliasToBean(StudentProjectScore.class));
			query.setFirstResult((easyUiPager.getPage() - 1)
					* easyUiPager.getRows());
			query.setMaxResults(easyUiPager.getRows());
			Integer total = super
					.findByHqlForPageCountEasyUi("select COUNT(*) " + where);
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("rows", query.list());
			m.put("total", total);
			return m;
		} catch (Exception e) {
			return null;
		}
	}

}
