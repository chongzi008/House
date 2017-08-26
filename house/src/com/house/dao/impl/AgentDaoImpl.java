package com.house.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.house.dao.AgentDao;
import com.house.domain.Agent;

public class AgentDaoImpl extends BaseDaoImpl<Agent> implements AgentDao {
	/**
	 * 通过区域名称查找
	 */
	public List<Agent> findByArea(String area) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Agent.class);
		criteria.add(Restrictions.eq("aservice_address", area));
		return (List<Agent>) this.getHibernateTemplate().findByCriteria(criteria);
	}

}
