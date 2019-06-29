package com.model;
/**
 * 出版社实体类
 * 
 * @author yu
 *
 */
public class Company {
private String cId;
private String cName;
private String cTel;
public String getcId() {
	return cId;
}
public void setcId(String cId) {
	this.cId = cId;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public String getcTel() {
	return cTel;
}
public void setcTel(String cTel) {
	this.cTel = cTel;
}
public Company(String cId, String cName, String cTel) {
	super();
	this.cId = cId;
	this.cName = cName;
	this.cTel = cTel;
}
public Company() {
	super();
	// TODO Auto-generated constructor stub
}

}
