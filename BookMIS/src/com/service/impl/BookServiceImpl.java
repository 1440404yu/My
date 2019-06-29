package com.service.impl;

import java.util.List;
import java.util.Map;

import com.commons.exception.DaoException;
import com.commons.exception.ServiceException;
import com.commons.util.Pager;
import com.commons.util.SqlUtil;
import com.dao.BookDao;
import com.dao.CompanyDao;
import com.factory.DaoFactory;
import com.model.Book;
import com.model.BookQuery;
import com.model.Company;
import com.service.BookService;

/**
 * BookdentService实现类
 * 
 * @author yu
 *
 */
public class BookServiceImpl extends GenericServiceImpl implements BookService {
	private BookDao bookDao = DaoFactory.getBookDaoInstance();
	private CompanyDao companyDao = DaoFactory.getCompanyDaoInstance();

	/**
	 * 查询全部图书信息
	 * 
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> findAllBook() throws ServiceException {
		try {
			return this.bookDao.selectAll();
		} catch (DaoException e) {
			throw new ServiceException("BookServiceImpl#public List<Map<String, Object>> findAll()#异常", e);
		}
	}

	/**
	 * 查询全部出版社信息
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<Company> findCName() throws ServiceException {
		try {
			return this.companyDao.selectAll();
		} catch (DaoException e) {
			throw new ServiceException("BookServiceImpl#public List<Depart> findAllDeparts()#异常", e);
		}
	}
	/**
	 * 增加图书
	 * 
	 * @param obj 封装
	 * @return 操作成功返回true,失败返回falseY
	 * @throws ServiceException
	 */
	public boolean addBook(Book obj) throws ServiceException{
		try {	
			
			obj.setBid(SqlUtil.getUUID().substring(0, 6));
			obj.setIsbn("ISBN 962-"+SqlUtil.getUUID().substring(0, 3)+"-"+"002-"+SqlUtil.getUUID().substring(0, 1));
			if (this.bookDao.insert(obj) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (DaoException e) {
			throw new ServiceException("BookServiceImpl#public boolean add(Book obj)#异常", e);
		}
	}

	/**
	 * 更新图书信息
	 * 
	 * @param obj 封装对象
	 * @return 操作成功返回true,失败返回false
	 * @throws ServiceExcepton
	 */
	public boolean modifyBook(Book obj) throws ServiceException {
		try {
			int i= (int) ((Math.random() * 6 + 1) * 1);
			obj.setIsbn("ISBN"+SqlUtil.random3Code() +"-"+SqlUtil.random3Code()+"-"+"0"+i+i+"-"+i);
			
			if (this.bookDao.updateById(obj)>0) {
				return true;
			} else {
				return false;
			}
		} catch (DaoException e) {
			throw new ServiceException("BookServiceImpl#public boolean modifyBook(Book obj)#异常", e);
		}
	}

	/**
	 * 根据bid删除图书信息
	 * 
	 * @param bid 主键
	 * @return 操作成功返回true,失败返回false
	 * @throws ServiceException
	 */
	public boolean removeBook(String bid) throws ServiceException {
		try {
			if (this.bookDao.deleteById(bid) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (DaoException e) {
			throw new ServiceException("BookServiceImpl#public boolean removeBook(String id)#异常", e);
		}
	}

	/**
	 * 根据bid查询图书
	 * 
	 * @param bid 主键
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public Book findBookByBid(String bid) throws ServiceException {
		try {
			return this.bookDao.selectByBid(bid);
		} catch (DaoException e) {
			throw new ServiceException("BookServiceImpl#public Book findBookById(String id)#异常", e);
		}
	}


	

	/**
	 * 分页查询所有图书信息
	 * 
	 * @param pager 封装分页信息
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> findAllBook(Pager pager) throws ServiceException {
		try {
			return this.bookDao.selectAll(pager);
		} catch (DaoException e) {
			throw new ServiceException(
					"BookServiceImpl#public List<Map<String, Object>> findAllBook(Pager pager)#异常", e);
		}
	}


	
	/**
	 * 条件查询所有图书信息
	 * 
	 * @param query 封装查询条件
	 * @param pager 封装分页信息
	 * @return 查询结果
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> findAllBook(BookQuery query, Pager pager) throws ServiceException {
		try {
			
			return this.bookDao.selectBy(query, pager);
		} catch (DaoException e) {
			throw new ServiceException(
					"BookServiceImpl#public List<Map<String, Object>> findAllBook(BookQuery query, Pager pager)#异常",
					e);
		}
	}

	
	public Book findBookById(String bid) throws ServiceException {
		try {
			return this.bookDao.selectById(bid);
		} catch (DaoException e) {
			throw new ServiceException("BookServiceImpl#public Book findBookById(String id)#异常", e);
		}
	}

	

	
}
