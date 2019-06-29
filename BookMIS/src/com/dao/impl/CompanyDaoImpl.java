package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.commons.exception.DaoException;
import com.dao.CompanyDao;
import com.model.Company;


/**
 * CompanyDao实现类
 * 
 * @author dougang
 *
 */
public class CompanyDaoImpl extends GenericDaoImpl<Company> implements CompanyDao {
	/**
	 * 查询全部记录
	 * 
	 * @return 查询结果
	 * @throws DaoException
	 */
	public List<Company> selectAll() throws DaoException {
		try {
			String sql = "select * from company";
			return this.getJdbcTemplate().queryForBeanList(sql);
		} catch (SQLException e) {
			throw new DaoException("CompanyDaoImpl#public List<Depart> selectAll()#异常", e);
		}
	}

	public static void main(String[] args) {
		List<Company> companyList=new CompanyDaoImpl().selectAll();
		for (Company item : companyList) {
			System.out.println(item.getcName());
		}
	}
}
