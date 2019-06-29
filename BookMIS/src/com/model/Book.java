package com.model;
/**
 * 图书实体类
 * 
 * @author yu
 *
 */
public class Book {
private String bid;//uuid
private String isbn;//书号
private String bname;//书名
private String author;//作者
private String companyId;//出版社编号
private String publication;//出版日期
private double price;//价格
private String page;//页数
private String content;//摘要
public String getBid() {
	return bid;
}
public void setBid(String bid) {
	this.bid = bid;
}
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
public String getPublication() {
	return publication;
}
public void setPublication(String publication) {
	this.publication = publication;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getPage() {
	return page;
}
public void setPage(String page) {
	this.page = page;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Book(String bid, String isbn, String bname, String author, String companyId, String publication, double price,
		String page, String content) {
	super();
	this.bid = bid;
	this.isbn = isbn;
	this.bname = bname;
	this.author = author;
	this.companyId = companyId;
	this.publication = publication;
	this.price = price;
	this.page = page;
	this.content = content;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}


}
