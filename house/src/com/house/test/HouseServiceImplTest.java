package com.house.test;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.house.domain.House;
import com.house.service.HouseService;

@SuppressWarnings("all")
public class HouseServiceImplTest {

	private ApplicationContext ioc;
	
	@Before
	public void init(){
		ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试保存房子
	 */
	@Test
	public void testSave() {
		HouseService h = (HouseService) ioc.getBean("houseService");
	}
	
	/**
	 * 测试主键查询
	 */
	@Test
	public void testFindById(){
		HouseService h = (HouseService) ioc.getBean("houseService");
		h.findById(1l);
	}
	
	/**
	 * 测试删除
	 */
	@Test
	public void testDelete(){
		HouseService hs = (HouseService) ioc.getBean("houseService");
//		hs.delete(6l);
//		hs.delete(7l);
//		hs.delete(8l);
//		hs.delete(9l);
	}
	
	@Test
	public void testFindByPage(){
		HouseService hs = (HouseService) ioc.getBean("houseService");
		int pageCode = 1;
		int pageSize = 3;
		DetachedCriteria criteria = DetachedCriteria.forClass(House.class);
		hs.findByPage(pageCode,pageSize,criteria);
	}
	
	
	
}
