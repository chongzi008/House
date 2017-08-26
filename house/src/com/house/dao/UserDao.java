package com.house.dao;

import com.house.domain.User;

/**
 * 用户持久层
 * @author ming
 *
 */
public interface UserDao extends BaseDao<User> {
	User findByNameAndPwd(String name,String pwd);
}
