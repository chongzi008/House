package com.house.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.house.domain.House;

/**
 * 房屋dao
 * @author ming
 *
 */
public interface HouseDao extends BaseDao<House> {
	
	List<House> houseList(DetachedCriteria criteria);
	
	
}
