package com.house.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.house.domain.Agent;
import com.house.domain.House;

@SuppressWarnings("all")
public class DemoCreateDataBase {
	private static final  Configuration config;
	private static final  SessionFactory factory;
	
	static {
		config = new Configuration().configure();
		factory = config.buildSessionFactory();
	}
	
	@Test
	public void test(){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		House h = new House();
		h.setHname("万科");
		h.setHaddress("熊安");
		h.setHintroduction("中心地带");
		h.setHprice(56435.89);
		
		
		House h2 = new House();
		h2.setHname("长龙");
		h2.setHaddress("金湾区");
		h2.setHintroduction("边缘地带");
		h2.setHprice(56435.99);
		
		Agent a = new Agent();
		a.setAname("蜗牛");
		a.setAcompany("碧桂园");
		a.setAimage("fasdfea");

		//  通过多方保存一方
		h.setAgent(a);
		h2.setAgent(a);
		
//		KeyWord k1 = new KeyWord();
//		k1.setName("漂亮");
//		k1.setHouse(h);
//		
//		KeyWord k2 = new KeyWord();
//		k2.setName("大气");
//		k2.setHouse(h);
		
		session.save(h);
		session.save(h2);
//		session.save(k1);
//		session.save(k2);
		
		transaction.commit();
		session.close();
	}

	
}
