package com.house.service;

import org.hibernate.criterion.DetachedCriteria;

import com.house.domain.News;
import com.house.domain.PageBean;

public interface NewService extends BaseService<News> {
	public PageBean<News> findByHouseID(Integer pageCode,Integer pageSize,DetachedCriteria criteria);

}
