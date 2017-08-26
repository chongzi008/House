package com.house.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.house.domain.House;

/**
 * 房屋业务层接口
 * @author ming
 *
 */
public interface HouseService extends BaseService<House>
{
	List<House> houseList(DetachedCriteria criteria);
}
