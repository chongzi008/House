package com.house.dao;

import org.hibernate.criterion.DetachedCriteria;

import com.house.domain.News;
import com.house.domain.PageBean;

public interface NewDao extends BaseDao<News> {
	public PageBean<News> findByHouseID(Integer pageCode,Integer pageSize,DetachedCriteria criteria);

}
