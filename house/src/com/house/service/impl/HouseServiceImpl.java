package com.house.service.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.house.dao.AgentDao;
import com.house.dao.HouseDao;
import com.house.domain.House;
import com.house.service.HouseService;

/**
 * 房屋业务层接口实现类
 * @author ming
 *
 */
@Transactional
@SuppressWarnings("all")
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService{
	private HouseDao houseDao;
	public void setHouseDao(HouseDao houseDao) {
		super.setBaseDao(houseDao);
		this.houseDao = houseDao;
	}
	@Override
	public List<House> houseList(DetachedCriteria criteria) {
		
		return houseDao.houseList(criteria);
	}
	
}
