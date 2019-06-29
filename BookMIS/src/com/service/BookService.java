package com.service;

import java.util.List;
import java.util.Map;

import com.commons.exception.ServiceException;
import com.commons.util.Pager;
import com.model.Book;
import com.model.BookQuery;
import com.model.Company;




/**
 * BookService接口
 * 
 * @author yu
 *
 */
public interface BookService {

	/**
	 * 查询全部图书
	 * 
	 * @return 查询结果
	 * @throws ServiceException
	 */
//	public List<Map<String, Object>> findAllBook() throws ServiceException;

	

	/**
	 * 查询全部系别信息
	 * 
	 * @return
	 * @throws ServiceException
	 */
//	public List<Depart> findAllDeparts() throws ServiceException;

	/**
	 * 查询出版社信息
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<Company> findCName() throws ServiceException;

	/**	 * 增加图书
	 * 
	 * @param obj 封装对象
	 * @return 操作成功返回true,失败返回false
	 * @throws ServiceException
	 */
	public boolean addBook(Book obj) throws ServiceException;



	/**
	 * 根据bid查询图书信息
	 * 
	 * @param bid 主键
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public Book findBookByBid(String bid) throws ServiceException;


	/**
	 * 更新图书信息
	 * 
	 * @param obj 封装对象
	 * @return 操作成功返回true,失败返回false
	 * @throws ServiceExcepton
	 */
	public boolean modifyBook(Book obj) throws ServiceException;

	/**
	 * 根据bid删除图书
	 * 
	 * @param bid 主键
	 * @return 操作成功返回true,失败返回false
	 * @throws ServiceException
	 */
	public boolean removeBook(String bid) throws ServiceException;


	





	


	
	/**
	 * 根据bid查询图书信息
	 * 
	 * @param bid 主键
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public Book findBookById(String bid) throws ServiceException;

	/**
	 * 查询全部图书信息
	 * 
	 * @return 查询结果
	 * @throws ServiceException
	 */
public List<Map<String, Object>> findAllBook() throws ServiceException;

	/**
	 * 分页查询所有图书信息
	 * 
	 * @param pager 封装分页信息
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> findAllBook(Pager pager) throws ServiceException;

	/**
	 * 条件查询所有图书信息
	 * 
	 * @param query 封装查询条件
	 * @param pager 封装分页信息
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> findAllBook(BookQuery query, Pager pager) throws ServiceException;


	
}
