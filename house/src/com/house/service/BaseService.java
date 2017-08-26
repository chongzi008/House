package com.house.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.house.domain.PageBean;

/**
 * 业务层基类
 * @author ming
 *
 * @param <T>
 */
public interface BaseService<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public T findById(Long id);
	public List<T> findAll();
	public PageBean<T> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

}
