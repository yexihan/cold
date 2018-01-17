package cn.itcast.jx.util;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtil {

	public static void sendMail(String to,String subject,String text) throws Exception {
		//1 准备发送邮件需要的参数
		Properties props = new Properties();
		//设置主机地址  smtp.qq.com   smtp.126.com   smtp.163.com  
		props.put("mail.smtp.host", "smtp.163.com");
		//是否打开验证:只能设置true，必须打开
		props.put("mail.smtp.auth", true);
		
		//2 连接邮件服务器
		Session session = Session.getDefaultInstance(props);
		//3 创建邮件信息
		MimeMessage message = new MimeMessage(session);
		//4 设置发送者
		InternetAddress fromAddress = new InternetAddress("shitcast@163.com");
		message.setFrom(fromAddress);
		//5 设置接收者
		InternetAddress toAddress = new InternetAddress(to);
		// to:直接接收者  cc：抄送  bcc暗送
		message.setRecipient(RecipientType.TO, toAddress);
		//6 设置主题
		message.setSubject(subject);
		//7 设置正文
		message.setText(text);
		
		//8 发送:坐火箭
		Transport transport = session.getTransport("smtp");//参数不能少，表示的是发送协议
		//登录邮箱,此处的密码是授权码
		transport.connect("shitcast@163.com", "q7w8e9a4s5d6");
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		
		System.out.println("ok");

	}

}
