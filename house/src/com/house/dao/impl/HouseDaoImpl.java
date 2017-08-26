package com.house.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.house.dao.HouseDao;
import com.house.domain.Agent;
import com.house.domain.House;

/**
 * 房屋持久层实现类
 * @author ming
 *
 */
public class HouseDaoImpl extends BaseDaoImpl<House> implements HouseDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<House> houseList(DetachedCriteria criteria) {
		
		return (List<House>) this.getHibernateTemplate().findByCriteria(criteria);
	}


}
