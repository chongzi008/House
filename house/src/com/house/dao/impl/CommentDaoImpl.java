package com.house.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.house.dao.CommentDao;
import com.house.domain.Comment;
import com.house.domain.PageBean;

@SuppressWarnings("all")
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao {

	/**
	 * 通过房屋id查找
	 */
	public PageBean<Comment> findByHouseId(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {

		PageBean<Comment> pb = new PageBean<Comment>();
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
		List<Comment> beanList = (List<Comment>) this.getHibernateTemplate().findByCriteria(criteria,(pageCode-1)*pageSize,pageSize);
		pb.setBeanList(beanList);
		return pb;

	}

}
