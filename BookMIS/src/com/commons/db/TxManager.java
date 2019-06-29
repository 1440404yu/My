package com.commons.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库事务管理工具类
 * 
 * @author dougang
 * 
 */
public class TxManager {
	/**
	 * 开启数据库事务
	 */
	public static void begin() {
		Connection con = DBConnectionUtil.getConnection();
		try {
			if (con != null) {
				con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			System.err.println("#TXManager#public static void begin()#开启事务异常");
			e.printStackTrace();
		}

	}

	/**
	 * 事务提交
	 */
	public static void commit() {
		Connection con = DBConnectionUtil.getConnection();
		try {
			if (con != null) {
				con.commit();
				con.setAutoCommit(true);
			}
		} catch (SQLException e) {
			System.err.println("#TXManager#public static void commit()#事务提交异常");
			e.printStackTrace();
		}

	}

	/**
	 * 事务回滚
	 */
	public static void rollback() {
		Connection con = DBConnectionUtil.getConnection();
		try {
			if (con != null) {
				con.rollback();
				con.setAutoCommit(true);
			}
		} catch (Exception e) {
			System.err.println("#TXManager#public static void rollback()#事务回滚异常");
			e.printStackTrace();
		}

	}
}
