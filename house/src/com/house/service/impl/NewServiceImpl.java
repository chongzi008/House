package com.house.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.NewDao;
import com.house.domain.News;
import com.house.domain.PageBean;
import com.house.service.NewService;

@Transactional
public class NewServiceImpl extends BaseServiceImpl<News> implements NewService {
 
	private NewDao newDao;
	
	
	public void setNewDao(NewDao newDao) {
		super.setBaseDao(newDao);
		this.newDao = newDao;
	}


	@Override
	public PageBean<News> findByHouseID(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return  newDao.findByHouseID(pageCode, pageSize, criteria);
	}

}
