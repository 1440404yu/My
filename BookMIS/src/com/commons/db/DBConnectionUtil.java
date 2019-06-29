package com.commons.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 数据库连接封装类
 * 
 * @author dougang
 */
public class DBConnectionUtil {

	private static BasicDataSource dataSource;// 数据库连接池
	private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	/**
	 * 初始化数据库连接池
	 * 
	 */
	static {
		/****************************** 初始化DBCP连接池 *************************************/
		Properties properties = new Properties();
		try {
			properties.load(DBConnectionUtil.class.getResourceAsStream("jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("文件找不到");
		}
		try {
			dataSource = new BasicDataSource(); // 实例化数据库连接池
			dataSource.setDriverClassName(properties.getProperty("driver").trim()); // 设置连接池所需的驱动
			dataSource.setUrl(properties.getProperty("url").trim()); // 设置连接数据库的URL
			dataSource.setUsername(properties.getProperty("user").trim()); // 设置连接数据库的用户名
			dataSource.setPassword(properties.getProperty("password").trim()); // 设置连接数据库的密码
			dataSource.setInitialSize(Integer.parseInt(properties.getProperty("InitialSize").trim())); // 设置连接池的初始连接数
			dataSource.setMaxActive(Integer.parseInt(properties.getProperty("MaxActive").trim())); // 设置连接池最多可有多少个活动连接数
			dataSource.setMinIdle(Integer.parseInt(properties.getProperty("MinIdle").trim())); // 设置连接池中最少空闲连接数
			dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("MaxIdle").trim()));// 设置连接池中最大空闲连接数
		} catch (Exception e) {
			System.err.println("#DBConnectionUtil#:初始化数据库连接池异常");
			e.printStackTrace();
		}
		/**********************************************************************************/
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return 数据库连接对象
	 */
	public static Connection getConnection() {
		Connection con = (Connection) threadLocal.get();

		if (con == null) {
			try {
				con = dataSource.getConnection();
			} catch (SQLException e) {
				System.err.println("#DBConnectionUtil#public static Connection getConnection()#获取数据库连接异常");
				e.printStackTrace();
			}
			threadLocal.set(con);
		}

		return con;
	}

	/**
	 * 关闭数据库连接
	 * 
	 */
	public static void closeConnection() {

		Connection con = (Connection) threadLocal.get();
		threadLocal.set(null);

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("#DBConnectionUtil#public static void closeConnection()#关闭数据库连接异常");
				e.printStackTrace();
			}
		}

	}
}
