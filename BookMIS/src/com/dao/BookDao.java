package com.dao;

import java.util.List;
import java.util.Map;

import com.commons.exception.DaoException;
import com.commons.util.Pager;
import com.model.Book;
import com.model.BookQuery;





/**
 * BookDao接口
 * 
 * @author yu
 *
 */
public interface BookDao {

	/**
	 * 查询全部记录
	 * 
	 * @return 查询结果
	 * @throws DaoException
	 */
	public List<Map<String, Object>> selectAll() throws DaoException;

	/**
	 * 根据参数统计记录数
	 * 
	 * @param departId 系别编号
	 * @param majorId  专业编号
	 * @return 统计结果
	 * @throws DaoException
	 */
//	public int countBy(String departId, String majorId) throws DaoException;

	/**
	 * 插入新记录
	 * 
	 * @param obj 封装新记录的对象
	 * @return 操作结果
	 * @throws DaoException
	 */
	public int insert(Book obj) throws DaoException;
	/**
	 * 根据id更新记录
	 * 
	 * @param obj 封装新记录的对象
	 * @return 操作结果
	 * @throws DaoException
	 */
	public int updateById(Book obj) throws DaoException;

	/**
	 * 根据id删除记录
	 * 
	 * @param id 主键
	 * @return 操作结果
	 * @throws DaoException
	 */
	public int deleteById(String id) throws DaoException;

	public Book selectByBid(String bid) throws DaoException;
	/**
	 * 分页查询全部记录
	 * 
	 * @param pager 封装分页信息
	 * @return 查询结果
	 * @throws DaoException
	 */
	public List<Map<String, Object>> selectAll(Pager pager) throws DaoException;

	/** 
	 * 
	 * @param query 封装条件参数
	 * @param pager 封装分页信息
	 * @return 查询结果
	 * @throws DaoException
	 */
	public List<Map<String, Object>> selectBy(BookQuery query, Pager pager) throws DaoException;
	
	/**
	 * 根据id查询记录
	 * 
	 * @param id 主键
	 * @return 查询结果
	 * @throws DaoException
	 */
	public Book selectById(String bid) throws DaoException;
	
	
	
	
	
}
