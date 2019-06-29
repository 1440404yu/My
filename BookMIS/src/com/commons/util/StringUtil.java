package com.commons.util;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串工具类
 * 
 * @author dougang
 * 
 */
public class StringUtil {
	/**
	 * 判断字符串是否为Null或空字符串
	 * 
	 * @param String
	 *            要判断的字符串
	 * @return String true-是空字符串,false-不是空字符串
	 */
	public static boolean nil(String s) {
		if (s == null || s.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 字符串数组转换为字符串,使用逗号分隔
	 */
	public static String split(String[] s, String spliter) {
		if (StringUtil.nil(s))
			return "";
		if (s.length == 1)
			return s[0];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]).append(spliter);
		}
		sb.deleteCharAt(sb.lastIndexOf(spliter));
		return sb.toString();
	}

	/**
	 * 如果第一个字符串不为空则返回该字符串,否则返回第二个
	 */
	public static String nil(String s, String _default) {
		if (StringUtil.nil(s))
			return _default;
		else
			return s;
	}

	/**
	 * 判断字符串数组是否为空
	 */
	public static boolean nil(String[] s) {
		return (s == null || s.length == 0);
	}

	/**
	 * 如果数组为空,则返回空数组
	 */
	public static String[] notNil(String[] s) {
		if (s == null || s.length == 0) {
			return new String[0];
		}
		return s;
	}

	/**
	 * 改变字符串编码到gbk
	 */
	public static String toGBK(String src) {
		if (nil(src))
			return "";
		String s = null;
		try {
			s = new String(src.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 改变字符串编码到utf8
	 */
	public static String toUTF8(String src) {
		if (nil(src))
			return "";
		String s = null;
		try {
			s = new String(src.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 转换String到boolean
	 */
	public static boolean parseBoolean(String flag) {
		if (nil(flag))
			return false;
		else if (flag.equals("true") || flag.equals("1") || flag.equals("是") || flag.equals("yes"))
			return true;
		else if (flag.equals("false") || flag.equals("0") || flag.equals("否") || flag.equals("no"))
			return false;
		return false;
	}

	/**
	 * 转换String到int <br>
	 * null或空字符,返回0 <br>
	 * true返回1 <br>
	 * false返回0
	 */
	public static int parseInt(String flag) {
		if (nil(flag))
			return 0;
		else if (flag.equals("true"))
			return 1;
		else if (flag.equals("false"))
			return 0;
		return Integer.parseInt(flag);
	}

	/**
	 * 转换String到long
	 */
	public static long parseLong(String flag) {
		if (nil(flag))
			return 0;
		return Long.parseLong(flag);
	}

	/**
	 * 字符填充
	 * 
	 * @param source
	 *            源字符串
	 * @param filler
	 *            填充字符,如0或*等
	 * @param length
	 *            最终填充后字符串的长度
	 * @return 最终填充后字符串
	 */
	public static String fill(String source, String filler, int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length - source.length(); i++) {
			sb.append(filler);
		}
		sb.append(source);
		return sb.toString();
	}

	/**
	 * 从开头到spliter字符,截取字符串数组中的每一项
	 * 
	 * @param arr
	 *            源字符串数组
	 * @param spliter
	 *            切割符
	 * @return 切割后的字符串数组
	 */
	public static String[] subStrBefore(String[] arr, String spliter) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].substring(0, arr[i].indexOf(spliter));
		}
		return arr;
	}

	/**
	 * 
	 * 将字串转成日期，字串格式: yyyy-MM-dd
	 * 
	 * @param string
	 *            String
	 * @return Date
	 */
	public static Date parseDate(String string) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return (Date) formatter.parse(string);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @param caseSensitive
	 *            是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean contains(String[] strings, String string, boolean caseSensitive) {
		for (int i = 0; i < strings.length; i++) {
			if (caseSensitive == true) {
				if (strings[i].equals(string)) {
					return true;
				}
			} else {
				if (strings[i].equalsIgnoreCase(string)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符串数组中是否包含指定的字符串。大小写敏感。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean contains(String[] strings, String string) {
		return contains(strings, string, true);
	}

	/**
	 * 不区分大小写判定字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean containsIgnoreCase(String[] strings, String string) {
		return contains(strings, string, false);
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String[]
	 * @return int[]
	 */
	public static int[] parseInt(String[] s) {
		if (s == null) {
			return (new int[0]);
		}
		int[] result = new int[s.length];
		try {
			for (int i = 0; i < s.length; i++) {
				result[i] = Integer.parseInt(s[i]);
			}
		} catch (NumberFormatException ex) {
		}
		return result;
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String
	 * @return int[]
	 */
	public static int[] split(String s) {
		if (nil(s))
			return new int[0];
		if (s.indexOf(",") > -1) {
			return StringUtil.split(s, ",");
		} else {
			int[] i = new int[1];
			i[0] = Integer.parseInt(s);
			return i;
		}
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String
	 * @param spliter
	 *            分隔符如逗号
	 * @return int[]
	 */
	public static int[] split(String s, String spliter) {
		if (s == null || s.indexOf(spliter) == -1) {
			return (new int[0]);
		}
		String[] ary = s.split(spliter);
		int[] result = new int[ary.length];
		try {
			for (int i = 0; i < ary.length; i++) {
				result[i] = Integer.parseInt(ary[i]);
			}
		} catch (NumberFormatException ex) {
		}
		return result;
	}

	/**
	 * 将整型数组合并为用字符分割的字符串
	 * 
	 * @param int[]
	 * @return String
	 */
	public static String join(int[] arr) {
		if (arr == null || arr.length == 0)
			return "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0, len = arr.length; i < len; i++) {
			sb.append(",").append(arr[i]);
		}
		sb.deleteCharAt(0);
		return sb.toString();
	}

	/**
	 * 将字符串的第一个字母大写
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String firstCharToUpperCase(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		char[] arrC = s.toCharArray();
		arrC[0] = Character.toUpperCase(arrC[0]);
		return String.copyValueOf(arrC);
	}

	/**
	 * 根据当前字节长度取出加上当前字节长度不超过最大字节长度的子串
	 * 
	 * @param str
	 * @param currentLen
	 * @param MAX_LEN
	 * @return
	 */
	public static String getSubStr(String str, int currentLen, int MAX_LEN) {
		int i;
		for (i = 0; i < str.length(); i++) {
			if (str.substring(0, i + 1).getBytes().length + currentLen > MAX_LEN) {
				break;
			}
		}
		if (i == 0) {
			return "";
		} else {
			return str.substring(0, i);
		}
	}
}