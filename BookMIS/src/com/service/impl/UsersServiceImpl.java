package com.service.impl;

import com.commons.exception.DaoException;
import com.commons.exception.ServiceException;
import com.dao.UsersDao;
import com.factory.DaoFactory;
import com.model.Users;
import com.service.UsersService;

/**
 * UsersService实现类
 * 
 * @author yu
 *
 */
public class UsersServiceImpl extends GenericServiceImpl implements UsersService {
	private UsersDao usersDao = DaoFactory.getUsersDaoInstance();

	/**
	 * 根据参数查询Users数据
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public Users findBy(String username, String password) throws ServiceException {
		try {
			return this.usersDao.selectBy(username, password);
		} catch (DaoException e) {
			throw new ServiceException("UsersServiceImpl#public Users findBy(String username, String password)#异常", e);
		}
	}
}
