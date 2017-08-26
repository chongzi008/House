package com.house.dao;

import java.util.List;

import com.house.domain.Agent;

public interface AgentDao extends BaseDao<Agent>{
	public List<Agent> findByArea(String area);
}
