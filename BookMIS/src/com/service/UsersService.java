package com.service;

import com.commons.exception.ServiceException;
import com.model.Users;

/**
 * UsersService接口
 * 
 * @author dougang
 *
 */
public interface UsersService {

	/**
	 * 根据参数查询Users数据
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public Users findBy(String username, String password) throws ServiceException;
}
