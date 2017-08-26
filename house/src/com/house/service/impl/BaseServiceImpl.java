package com.house.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.BaseDao;
import com.house.domain.PageBean;
import com.house.service.BaseService;

@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> baseDao;
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	/**
	 * 保存
	 */
	public void save(T t) {
		baseDao.save(t);
	}

	/**
	 * 删除
	 */
	public void delete(T t) {
		baseDao.delete(t);
	}

	/**
	 * 更新
	 */
	public void update(T t) {
		baseDao.update(t);
	}

	/**
	 * 根据主键查询
	 */
	public T findById(Long id) {
		return (T) baseDao.findById(id);
	}

	/**
	 * 查询所有
	 */
	public List<T> findAll() {
		return baseDao.findAll();
	}

	/**
	 * 分页查询
	 */
	public PageBean<T> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		return baseDao.findByPage(pageCode, pageSize, criteria);
	}

}
