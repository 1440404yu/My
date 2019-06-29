package com.commons.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * JDBC操作模板类
 * 
 * @author dougang
 */
@SuppressWarnings("all")
public class JdbcTemplate<T> {
	private Class<T> clazz;

	public JdbcTemplate(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 根据指定参数查询单行数据，并将查询结果封装为实体类对象返回
	 * 
	 * @param sql    要执行的SQL查询语句
	 * @param params 查询参数
	 * @return 封装查询结果的实体类对象
	 */
	public T queryForBean(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		BeanProcessor bean = new GenerousBeanProcessor();
		RowProcessor processor = new BasicRowProcessor(bean);

		T result = null;
		if (params != null && params.length > 0) {
			result = runer.query(con, sql, new BeanHandler<T>(this.clazz, processor), params);
		} else {
			result = runer.query(con, sql, new BeanHandler<T>(this.clazz, processor));
		}

		return result;
	}

	/**
	 * 根据指定参数查询单行数据，并将查询结果封装为实体类对象返回
	 * 
	 * @param sql 要执行的SQL查询语句
	 * 
	 * @return 封装查询结果的实体类对象
	 */
	public T queryForBean(String sql) throws SQLException {
		return this.queryForBean(sql, null);
	}

	/**
	 * 根据指定参数查询单行单列数据，并将查询结果以Object对象形式返回
	 * 
	 * @param sql    要执行的SQL查询语句
	 * @param params 查询参数
	 * @return 封装查询结果的Object
	 */
	public Object queryForObject(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		Object[] result = null;

		if (params != null && params.length > 0) {
			result = runer.query(con, sql, new ArrayHandler(), params);
		} else {
			result = runer.query(con, sql, new ArrayHandler());
		}

		if (result != null && result.length > 0) {
			return result[0];
		} else {
			return null;
		}
	}

	/**
	 * 根据指定参数查询单行单列数据，并将查询结果以Object对象形式返回
	 * 
	 * @param sql 要执行的SQL查询语句
	 * @return 封装查询结果的Object
	 */
	public Object queryForObject(String sql) throws SQLException {
		return this.queryForObject(sql, new Object[] {});
	}

	/**
	 * 根据指定参数查询单行多列数据，并将查询结果以数组形式返回
	 * 
	 * @param sql    要执行的SQL查询语句
	 * @param params 查询语句参数
	 * @return 封装查询结果的数组
	 */
	public Object[] queryForArray(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		Object[] result = null;

		if (params != null && params.length > 0) {
			result = runer.query(con, sql, new ArrayHandler(), params);
		} else {
			result = runer.query(con, sql, new ArrayHandler());
		}

		return result;

	}

	/**
	 * 查询单行多列数据，并将查询结果以数组形式返回
	 * 
	 * @param sql 要执行的SQL查询语句
	 * @return 封装查询结果的数组
	 */
	public Object[] queryForArray(String sql) throws SQLException {
		return this.queryForArray(sql, null);
	}

	/**
	 * 根据指定参数查询多行数据，并将查询结果封装为List集合返回,集合泛型为实体类
	 * 
	 * @param sql    要执行的SQL查询语句
	 * @param params SQL查询参数
	 * @return 封装查询结果的List集合
	 */
	public List<T> queryForBeanList(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		BeanProcessor bean = new GenerousBeanProcessor();
		RowProcessor processor = new BasicRowProcessor(bean);

		List<T> list = null;
		if (params != null && params.length > 0) {
			list = (List<T>) runer.query(con, sql, new BeanListHandler<T>(this.clazz, processor), params);
		} else {
			list = (List<T>) runer.query(con, sql, new BeanListHandler<T>(this.clazz, processor));
		}

		return list;

	}

	/**
	 * 查询多行数据，并将查询结果封装为List集合返回，集合泛型为实体类
	 * 
	 * @param sql   要执行的SQL查询语句
	 * @param clazz 实体类对象
	 * @return 封装结果集的List集合
	 */
	public List<T> queryForBeanList(String sql) throws SQLException {
		return this.queryForBeanList(sql, null);
	}

	/**
	 * 根据指定参数查询多行数据，并将查询结果封装为List集合返回，集合泛型为Object数组
	 * 
	 * @param sql    要执行的SQL查询语句
	 * @param params SQL查询参数
	 * @return 封装结果集的List集合
	 */
	public List<Object[]> queryForArrayList(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		List<Object[]> list = null;

		if (params != null && params.length > 0) {
			list = runer.query(con, sql, new ArrayListHandler(), params);
		} else {
			list = runer.query(con, sql, new ArrayListHandler());
		}

		return list;

	}

	/**
	 * 查询多行数据，并将查询结果封装为List集合返回，集合泛型为Object数组
	 * 
	 * @param sql 要执行的SQL查询语句
	 * @return 封装结果集的List集合
	 */
	public List<Object[]> queryForArrayList(String sql) throws SQLException {
		return this.queryForArrayList(sql, new Object[] {});
	}

	/**
	 * 查询单行数据，并将查询结果封装为Map集合返回
	 * 
	 * @param sql 要执行的SQL查询语句
	 * @return 封装结果集的Map集合
	 * @throws SQLException
	 */
	public Map<String, Object> queryForMap(String sql) throws SQLException {
		return this.queryForMap(sql, null);
	}

	/**
	 * 查询单行数据，并将查询结果封装为Map集合返回
	 * 
	 * @param sql    要执行的SQL查询语句
	 * @param params SQL查询参数
	 * @return 封装结果集的Map集合
	 * @throws SQLException
	 */
	public Map<String, Object> queryForMap(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		Map<String, Object> result = null;

		if (params != null && params.length > 0) {
			result = runer.query(con, sql, new MapHandler(), params);
		} else {
			result = runer.query(con, sql, new MapHandler());
		}

		return result;
	}

	/**
	 * 查询多行数据，并将查询结果封装为List集合返回,集合泛型为Map
	 * 
	 * @param sql 要执行的SQL查询语句
	 * @return 封装结果集的List集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> queryForMapList(String sql) throws SQLException {
		return this.queryForMapList(sql, null);
	}

	/**
	 * 查询多行数据，并将查询结果封装为List集合返回,集合泛型为Map
	 * 
	 * @param sql    要执行的SQL查询语句
	 * @param params SQL查询参数
	 * @return 封装结果集的List集合
	 * @throws SQLException
	 */
	public List<Map<String, Object>> queryForMapList(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		List<Map<String, Object>> lists = null;

		if (params != null && params.length > 0) {
			lists = runer.query(con, sql, new MapListHandler(), params);
		} else {
			lists = runer.query(con, sql, new MapListHandler());
		}

		return lists;
	}

	/**
	 * 执行SQL更新操作
	 * 
	 * @param sql    要执行的SQL更新语句
	 * @param params 更新语句参数
	 * @return 受影响的行数
	 */
	public int update(String sql, Object... params) throws SQLException {
		Connection con = DBConnectionUtil.getConnection();
		QueryRunner runer = new QueryRunner();
		int result = 0;

		if (params != null && params.length > 0) {
			result = runer.update(con, sql, params);
		} else {
			result = runer.update(con, sql);
		}

		return result;

	}

	/**
	 * 执行SQL更新操作
	 * 
	 * @param sql 要执行的SQL更新语句
	 * @return 受影响的行数
	 */
	public int update(String sql) throws SQLException {
		return this.update(sql, null);
	}

}
