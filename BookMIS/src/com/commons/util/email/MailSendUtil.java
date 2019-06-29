package com.commons.util.email;

/**
 * 邮件发送工具类
 * 
 * @author dougang
 * 
 */
public class MailSendUtil {
	private static MailSenderInfo mailInfo = new MailSenderInfo();
	static {
		mailInfo.setMailServerHost("smtp.163.com");// 邮件发送服务器
		mailInfo.setMailServerPort("25");// 端口号
		mailInfo.setValidate(true);
		mailInfo.setUserName("dgriver");// 用户名
		mailInfo.setPassword("1385318");// 密码
		mailInfo.setFromAddress("dgriver@163.com");// 邮箱
	}

	/**
	 * 发送文本格式的邮件
	 * 
	 * @param address：目标地址
	 * @param subject:邮件主题
	 * @param content:邮件内容
	 */
	public static void sendTextMail(String address, String subject, String content) {
		mailInfo.setToAddress(address);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
		SimpleMailSender.sendTextMail(mailInfo);// 发送邮件
	}

	/**
	 * 发送HTML格式的邮件
	 * 
	 * @param address：目标地址
	 * @param subject:邮件主题
	 * @param content:邮件内容
	 */
	public static void sendHTMLMail(String address, String subject, String content) {
		mailInfo.setToAddress(address);
		mailInfo.setSubject(subject);
		mailInfo.setContent(content);
		SimpleMailSender.sendHtmlMail(mailInfo);// 发送邮件
	}

}
