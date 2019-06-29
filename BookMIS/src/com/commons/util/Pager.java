package com.commons.util;

/**
 * 分页实体类
 * 
 * @author dougang
 * 
 */
public class Pager {
	private Integer rowCount;// 总记录数
	private Integer pageSize;// 每页记录数
	private Integer pageNo;// 当前页码
	private Integer pageCount;// 总页数

	public Pager() {

	}

	public Pager(Integer rowCount, Integer pageSize, Integer pageNo) {
		super();
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.pageCount = (int) Math.ceil((double) rowCount / pageSize);
	}

	public Pager(Integer rowCount, Integer pageSize, Integer pageNo, Integer pageCount) {
		super();
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.pageCount = pageCount;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageCount() {
		this.pageCount = (int) Math.ceil((double) rowCount / pageSize);
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 返回分页起始行位置
	 * 
	 * @return
	 */
	public int getFirstRow() {
		return (this.pageNo - 1) * this.pageSize + 1;
	}

	/**
	 * 返回分页结束行位置
	 * 
	 * @return
	 */
	public int getLastRow() {
		return this.getFirstRow() + this.pageSize;
	}

}
