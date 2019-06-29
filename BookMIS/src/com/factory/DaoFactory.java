package com.factory;



import com.dao.BookDao;
import com.dao.CompanyDao;
import com.dao.UsersDao;
import com.dao.impl.BookDaoImpl;
import com.dao.impl.CompanyDaoImpl;
import com.dao.impl.UsersDaoImpl;

/**
 * Dao工厂类
 * 
 * @author dougang
 * 
 */
public class DaoFactory {
	public static UsersDao getUsersDaoInstance() {
		return new UsersDaoImpl();
	}
	public static BookDao getBookDaoInstance() {
		// TODO Auto-generated method stub
		return new BookDaoImpl();
	}

	public static CompanyDao getCompanyDaoInstance() {
		return new CompanyDaoImpl();
	}

//	public static MajorDao getMajorDaoInstance() {
//		return new MajorDaoImpl();
//	}
}
