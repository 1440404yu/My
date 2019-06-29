package com.dao;

import java.util.List;

import com.commons.exception.DaoException;
import com.model.Company;

/**
 * CompanyDao接口
 * 
 * @author dougang
 *
 */
public interface CompanyDao {

	/**
	 * 查询全部记录
	 * 
	 * @return 查询结果
	 * @throws DaoException
	 */
	public List<Company> selectAll() throws DaoException;
}
