package com.house.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.house.domain.Comment;
import com.house.domain.PageBean;

public interface CommentDao extends BaseDao<Comment> {
	
	public PageBean<Comment> findByHouseId(Integer pageCode,Integer pageSize,DetachedCriteria criteria);
		
}
