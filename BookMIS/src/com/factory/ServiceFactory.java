package com.factory;

import com.service.BookService;
import com.service.UsersService;
import com.service.impl.BookServiceImpl;
import com.service.impl.UsersServiceImpl;

/**
 * Service工厂类
 * 
 * @author dougang
 * 
 */
public class ServiceFactory {
	public static UsersService getUsersServiceInstance() {
		return new UsersServiceImpl();
	}

	public static BookService getBookServiceInstance() {
		return new BookServiceImpl();
	}

}
