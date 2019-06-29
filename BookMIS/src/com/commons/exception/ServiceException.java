package com.commons.exception;

/**
 * Service异常类
 * 
 * @author dougang
 * 
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 3709493307303114001L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String message, Throwable e) {
		super(message, e);
	}

}
