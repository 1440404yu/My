package com.dao;

import com.commons.exception.DaoException;
import com.model.Users;

/**
 * UsersDao接口
 * 
 * @author dougang
 *
 */
public interface UsersDao {

	/**
	 * 根据参数查询记录
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询结果
	 * @throws DaoException
	 */
	public Users selectBy(String username, String password) throws DaoException;
}
