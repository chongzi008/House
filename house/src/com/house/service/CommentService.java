package com.house.service;

import org.hibernate.criterion.DetachedCriteria;

import com.house.domain.Comment;
import com.house.domain.PageBean;

public interface CommentService extends BaseService<Comment> {
	
	public PageBean<Comment> findByHouseID(Integer pageCode,Integer pageSize,DetachedCriteria criteria);
}
