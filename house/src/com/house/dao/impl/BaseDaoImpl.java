package com.house.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.house.dao.BaseDao;
import com.house.domain.PageBean;

/**
 * 基类Dao的实现类：实现常用的功能
 * @author ming
 *
 * @param <T>
 */
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	// 保存成员属性T
	private Class claxx;
	
	/**
	 * 获取clazz
	 * CustomerDaoImpl extends BaseDaoImpl<T>()
	 */
	public BaseDaoImpl(){
		/**
		 * AgentDaoImpl extends BaseDaoImpl<Agent>()
		 */
		// this表示的子类，c表示当前子类对象
		Class c = this.getClass();
		// 第2步：获取到是BaseDaoImpl<T> 获取父类
		Type type = c.getGenericSuperclass();
		
		// 目的：把type接口转换成子接口
		if(type instanceof ParameterizedType){
			ParameterizedType ptype = (ParameterizedType) type;
			// 获取到 T
			Type[] types = ptype.getActualTypeArguments();
			// 保存当前实例对象
			this.claxx = (Class) types[0];
		}
	}
	
	/**
	 * 保存
	 */
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	/**
	 * 删除
	 */
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	/**
	 * 修改
	 */
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	/**
	 * 主键查询
	 */
	public T findById(Long id) {
		return (T) this.getHibernateTemplate().get(claxx, id);
	}

	/**
	 * 查询所有数据
	 */
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+claxx.getSimpleName());
	}

	/**
	 * 分页查询所有数据
	 */
	public PageBean<T> findByPage(Integer pageCode, Integer pageSize,
			DetachedCriteria criteria) {
		PageBean<T> pb = new PageBean<T>();
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
		List<T> beanList = (List<T>) this.getHibernateTemplate().findByCriteria(criteria,(pageCode-1)*pageSize,pageSize);
		pb.setBeanList(beanList);
		return pb;
	}

}
