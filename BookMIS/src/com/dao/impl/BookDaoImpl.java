package com.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.commons.exception.DaoException;
import com.commons.util.Pager;
import com.commons.util.StringUtil;
import com.dao.BookDao;
import com.model.Book;
import com.model.BookQuery;






/**
 * BookDao实现类
 * 
 * @author yu
 *
 */
public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao {

	/**
	 * 查询全部记录
	 * 
	 * @return 查询结果
	 * @throws DaoException
	 */
	public List<Map<String, Object>> selectAll() throws DaoException {
		try {
			String sql = "select book.*,C_NAME from company inner join book on company.C_ID = book.COMPANY_ID ";
			return this.getJdbcTemplate().queryForMapList(sql);
		} catch (SQLException e) {
			throw new DaoException("BookDaoImpl#public List<Map<String, Object>> selectAll()#异常", e);
		}
	}

	/**
	 * 根据参数统计记录数
	 * 
	 * @param departId 系别编号
	 * @param majorId  专业编号
	 * @return 统计结果
	 * @throws DaoException
	 */


	/**
	 * 插入新记录
	 * 
	 * @param obj 封装新记录的对象
	 * @return 操作结果
	 * @throws DaoException
	 */
	public int insert(Book obj) throws DaoException {
		try {
			String sql = "insert into book values(?,?,?,?,?,?,?,?,?)";
			return this.getJdbcTemplate().update(sql,
					new Object[] { obj.getBid(), obj.getIsbn(), obj.getBname(), obj.getAuthor(), obj.getCompanyId(),
							obj.getPublication(), obj.getPrice(), obj.getPage(),obj.getContent() });
		} catch (SQLException e) {
			throw new DaoException("BookDaoImpl#public int insert(Book obj)#异常", e);
		}
	}

	public int updateById(Book obj) throws DaoException {
		try {
			String sql = "update book set ISBN=?,BNAME=?,AUTHOR=?,COMPANY_ID=?,PUBLICATION=?,PRICE=?,PAGE=?,CONTENT=? where BID=?";
			return this.getJdbcTemplate().update(sql,
					new Object[] { obj.getIsbn(), obj.getBname(), obj.getAuthor(), obj.getCompanyId(), obj.getPublication(),
							obj.getPrice(), obj.getPage(), obj.getContent(), obj.getBid() });
		} catch (SQLException e) {
			throw new DaoException("BookDaoImpl#public int updateById(Book obj)#异常", e);
		}
	}

	/**
	 * 根据id删除记录
	 * 
	 * @param id 主键
	 * @return 操作结果
	 * @throws DaoException
	 */
	public int deleteById(String bid) throws DaoException {
		try {
			String sql = "delete from book where bid = ?";
			return this.getJdbcTemplate().update(sql, new Object[] { bid });
		} catch (SQLException e) {
			throw new DaoException("BookDaoImpl#public int deleteById(String id)#异常", e);
		}
	}

	@Override
	/**
	 * 根据bid查询记录
	 * 
	 * @param bid 主键
	 * @return 查询结果
	 * @throws DaoException
	 */
	public Book selectByBid(String bid) throws DaoException {
		try {
			String sql = "select * from book where bid = ?";
			return this.getJdbcTemplate().queryForBean(sql, new Object[] { bid });
		} catch (SQLException e) {
			throw new DaoException("BookDaoImpl#public Book selectById(String id)#异常", e);
		}
	}
	/**
	 * 分页查询全部记录
	 * 
	 * @param pager 封装分页信息
	 * @return 查询结果 
	 * @throws DaoException
	 */
	public List<Map<String, Object>> selectAll(Pager pager) throws DaoException {
		try {
		String sql = "select book.*,C_NAME from company inner join book on company.C_ID = book.COMPANY_ID ";
			return this.getJdbcTemplate().queryForMapList(sql,pager);
		} catch (SQLException e) {
			throw new DaoException("BookDaoImpl#public List<Map<String, Object>> selectAll()#异常", e);
		}
    }
	

	/**
	 * 根据条件参数查询记录
	 * 
	 * @param query 封装条件参数
	 * @param pager 封装分页信息
	 * @return 查询结果
	 * @throws DaoException
	 */
//	

	


	public Book selectById(String bid) throws DaoException {
		try {
			String sql = "select * from Book  where BID = ?";
			return this.getJdbcTemplate().queryForBean(sql, new Object[] { bid });
		} catch (SQLException e) {
			throw new DaoException("BookDaoImpl#public Book selectById(String id)#异常", e);
		}
	}

	
	
	
	
	
	
	
	public List<Map<String, Object>> selectBy(BookQuery query, Pager pager) throws DaoException {
		try {
			StringBuffer sql = new StringBuffer(
					"select book.*,C_NAME from company inner join book on company.C_ID = book.COMPANY_ID  where 1=1");
			if (query != null) {
				if (!StringUtil.nil(query.getIsbn())) {
					sql.append(" and ISBN = '" + query.getIsbn() + "' ");
				}
				if (!StringUtil.nil(query.getBname())) {
					sql.append(" and BNAME = '" + query.getBname() + "' ");
				}
				if (!StringUtil.nil(query.getAuthor())) {
					sql.append(" and AUTHOR = '" + query.getAuthor() + "' ");
				}
			
				if (!StringUtil.nil(query.getCompanyId())) {
					sql.append(" and COMPANY_ID = '" + query.getCompanyId() + "' ");
				}
			
			}
			System.out.println(sql.toString());
			return this.queryMapListForPages(sql.toString(), pager);
		} catch (SQLException e) {
			throw new DaoException(
					"BookDaoImpl#public List<Map<String, Object>> selectBy(BookQuery query, Pager pager)#异常", e);
		}
	}
	
	
	
}
