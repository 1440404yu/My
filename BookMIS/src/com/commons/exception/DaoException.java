package com.commons.exception;

/**
 * Dao异常类
 * 
 * @author dougang
 * 
 */
public class DaoException extends RuntimeException {
	private static final long serialVersionUID = -2497331288743160972L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable e) {
		super(e);
	}

	public DaoException(String message, Throwable e) {
		super(message, e);
	}

}
