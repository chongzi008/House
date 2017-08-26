package com.house.service;

import java.util.List;

import com.house.domain.Agent;

public interface AgentService extends BaseService<Agent> {
	public List<Agent> findByArea(String area);
}
