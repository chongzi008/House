package com.house.dao.impl;

import com.house.dao.UserDao;
import com.house.domain.User;

/**
 * 房屋持久层实现类
 * @author ming
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByNameAndPwd(String name,String pwd) {
		
		return (User) this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery(" from User where username=? and upassword=?")
				.setString(0, name).setString(1, pwd)
				.uniqueResult();
	}
	
}
