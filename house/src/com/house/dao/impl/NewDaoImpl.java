package com.house.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.house.dao.NewDao;
import com.house.domain.News;
import com.house.domain.PageBean;


@SuppressWarnings("all")
public class NewDaoImpl extends BaseDaoImpl<News> implements NewDao {

	

	@Override
	public PageBean<News> findByHouseID(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {

		PageBean<News> pb = new PageBean<News>();
		pb.setPageCode(pageCode);
		pb.setPageSize(pageSize);
		// 求出总记录数 select count(*);
		criteria.setProjection(Projections.rowCount());
		List<Number> list = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(list != null && list.size() > 0){
			int total = list.get(0).intValue();
			pb.setTotalCount(total);
		}
		// 清空上一条语句
		criteria.setProjection(null);	
		// 查询出分页的记录数
		List<News> beanList = (List<News>) this.getHibernateTemplate().findByCriteria(criteria,(pageCode-1)*pageSize,pageSize);
		pb.setBeanList(beanList);
		return pb;
	}

}
