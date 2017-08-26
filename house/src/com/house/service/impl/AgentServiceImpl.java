package com.house.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.house.dao.AgentDao;
import com.house.domain.Agent;
import com.house.service.AgentService;
@Transactional
public class AgentServiceImpl extends BaseServiceImpl<Agent> implements
		AgentService {

	private AgentDao agentDao;
	public void setAgentDao(AgentDao agentDao) {
		super.setBaseDao(agentDao);
		this.agentDao = agentDao;
	}

	/**
	 * 通过区域名称查找
	 * @param area
	 * @return
	 */
	public List<Agent> findByArea(String area) {
		return agentDao.findByArea(area);
	}

}
