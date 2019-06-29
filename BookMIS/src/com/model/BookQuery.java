package com.model;

public class BookQuery {
	private String isbn;//书号
	private String bname;//书名
	private String author;//作者
	private String companyId;//出版社编号
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public BookQuery(String isbn, String bname, String author, String companyId) {
		super();
		this.isbn = isbn;
		this.bname = bname;
		this.author = author;
		this.companyId = companyId;
	}
	public BookQuery() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
