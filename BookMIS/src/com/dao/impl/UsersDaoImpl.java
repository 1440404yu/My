package com.dao.impl;

import java.sql.SQLException;

import com.commons.exception.DaoException;
import com.dao.UsersDao;
import com.model.Users;

/**
 * UsersDao实现类
 * 
 * @author dougang
 *
 */
public class UsersDaoImpl extends GenericDaoImpl<Users> implements UsersDao {

	/**
	 * 根据参数查询记录
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 查询结果
	 * @throws DaoException
	 */
	public Users selectBy(String username, String password) throws DaoException {
		try {
			String sql = "select * from users where USERNAME = ? and PASSWORD = ?";
			return this.getJdbcTemplate().queryForBean(sql, new Object[] { username, password });
		} catch (SQLException e) {
			throw new DaoException("UsersDaoImpl#public Users selectBy(String username, String password)#异常", e);
		}
		
	}
}
