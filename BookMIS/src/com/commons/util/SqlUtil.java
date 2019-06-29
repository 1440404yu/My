package com.commons.util;

import java.util.UUID;

/**
 * sql工具类
 * 
 * @author dougang
 *
 */
public class SqlUtil {
	//
	public static int random3Code() {
	    return (int) ((Math.random() * 6 + 1) * 100);
	    
	}
	
	//
	
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public String parseToSQLStringComma(int[] strArray) {
		if (strArray == null || strArray.length == 0)
			return "";
		String myStr = "";
		for (int i = 0; i < strArray.length - 1; i++) {
			myStr += "'" + strArray[i] + "',";
		}
		myStr += "'" + strArray[strArray.length - 1] + "'";
		return myStr;
	}

	public String parseToSQLStringComma(String[] strArray) {
		if (strArray == null || strArray.length == 0) {
			return "";
		}
		String myStr = "";
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < strArray.length - 1; i++) {
			stringBuffer.append("'");
			stringBuffer.append(strArray[i]);
			stringBuffer.append("',");
		}
		stringBuffer.append("'");
		stringBuffer.append(strArray[strArray.length - 1]);
		stringBuffer.append("'");

		myStr = stringBuffer.toString();
		return myStr;
	}
}
