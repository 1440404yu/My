package com.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.commons.db.JdbcTemplate;
import com.commons.util.Pager;
import com.dao.GenericDao;


/**
 * Dao基类
 * 
 * @author dougang
 * 
 * @param <T>
 */
@SuppressWarnings("all")
public class GenericDaoImpl<T> implements GenericDao<T> {
	private JdbcTemplate<T> jdbcTemplate;

	public GenericDaoImpl() {
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.jdbcTemplate = new JdbcTemplate<T>(clazz);
	}

	public JdbcTemplate<T> getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate<T> jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 分页查询
	 * 
	 * @param sql   原始SQL查询语句
	 * @param pager 封装分页信息的实体对象
	 * @return 封装查询结果的集合
	 */
	protected List<T> queryBeanListForPages(String sql, Pager pager) throws SQLException {
		if (pager != null) {
			Object cnt = this.getJdbcTemplate().queryForObject("SELECT COUNT(*) FROM (" + sql + ")");
			pager.setRowCount(Integer.parseInt(String.valueOf(cnt)));
			sql = "SELECT * FROM (SELECT rownum AS no, t.* FROM (" + sql + ") t" + ") WHERE no >= "
					+ pager.getFirstRow() + " AND no < " + pager.getLastRow();
		}
		return this.getJdbcTemplate().queryForBeanList(sql);
	}

	/**
	 * 分页查询
	 * 
	 * @param sql   原始SQL查询语句
	 * @param pager 封装分页信息的实体对象
	 * @return 封装查询结果的集合
	 */
	protected List<Map<String, Object>> queryMapListForPages(String sql, Pager pager) throws SQLException {
		if (pager != null) {
			Object cnt = this.getJdbcTemplate().queryForObject("SELECT COUNT(*) FROM (" + sql + ")");
			pager.setRowCount(Integer.parseInt(String.valueOf(cnt)));
			sql = "SELECT * FROM (SELECT rownum AS no, t.* FROM (" + sql + ") t" + ") WHERE no >= "
					+ pager.getFirstRow() + " AND no < " + pager.getLastRow();
		}
		return this.getJdbcTemplate().queryForMapList(sql);
	}

}
