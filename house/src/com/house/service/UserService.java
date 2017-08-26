package com.house.service;

import com.house.domain.User;

/**
 * 房屋业务层接口
 * @author ming
 *
 */
public interface UserService extends BaseService<User>{
	public User findUser(String username,String upassword);
		
	
}
