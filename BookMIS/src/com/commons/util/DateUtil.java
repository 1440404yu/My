package com.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author dougang
 * 
 */
public class DateUtil {

	/**
	 * 返回日期格式化工具
	 * 
	 * @param parttern
	 *            日期格式字符串
	 * @return 日期格式器对象
	 */
	private static SimpleDateFormat getDateFormat(String parttern) {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 将字符串转换成日期
	 * 
	 * @param date
	 *            日期字符串
	 * @param parttern
	 *            日期格式字符串
	 * @return 日期对象
	 */
	public static Date StringToDate(String date, String parttern) {
		Date d = null;
		try {
			d = getDateFormat(parttern).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 将日期转换成字符串
	 * 
	 * @param date
	 *            日期对象
	 * @param parttern
	 *            日期格式字符串
	 * @return 字符串
	 */
	public static String DateToString(Date date, String parttern) {
		String dateString = null;
		dateString = getDateFormat(parttern).format(date);
		return dateString;
	}

	public static void main(String[] args) {
		String stringDate = "2015-02-11";
		Date d = DateUtil.StringToDate(stringDate, "yyyy-MM-dd");
		System.out.println(d);

		stringDate = DateUtil.DateToString(d, "yyyy年MM月dd日");
		System.out.println(stringDate);
	}

}
