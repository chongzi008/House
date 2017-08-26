package com.house.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.house.dao.UserDao;
import com.house.domain.User;
import com.house.service.UserService;

@Transactional
@SuppressWarnings("all")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{ 
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}
	@Override
	public User findUser(String username,String upassword){
		return userDao.findByNameAndPwd(username, upassword);
	}



}
