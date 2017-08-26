package com.house.service.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.CommentDao;
import com.house.domain.Comment;
import com.house.domain.PageBean;
import com.house.service.CommentService;

@Transactional
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements
		CommentService {
	private CommentDao commentDao;
	public void setCommentDao(CommentDao commentDao) {
		super.setBaseDao(commentDao);
		this.commentDao = commentDao;
	}
	
	/**
	 * 通过房屋id查找评论
	 */
	public PageBean<Comment> findByHouseID(Integer pageCode,Integer pageSize,DetachedCriteria criteria){
		return commentDao.findByHouseId(pageCode,pageSize,criteria);
	}
	
	
	
}
