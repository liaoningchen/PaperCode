package com.examOnline.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 
 *发送邮件工具类
 *
 */
@Component
public class EmailUtil {
	/**
	 * 
	 * @param title 邮件标题
	 * @param contents 邮件内容
	 * @param accepter 收件人
	 * @throws AddressException
	 * @throws MessagingException
	 */
	
	public boolean sendEmail(String title,String contents,String accepter) throws AddressException, MessagingException{

		try{
			PropertiesUtil resource = PropertiesUtil.getInstance("configure");
			String sendEmailName = resource.getValue("sendEmailName");
			String sendEmailPwd = resource.getValue("sendEmailPwd");
			String sendEmailKey = resource.getValue("sendEmailKey");
			Properties properties = new Properties();
		    properties.put("mail.transport.protocol", "smtp");// 连接协议        
		    properties.put("mail.smtp.host", "smtp.qq.com");// 主机名        
		    properties.put("mail.smtp.port", 465);// 端口号        
		    properties.put("mail.smtp.auth", "true"); 
		    //设置是否使用ssl安全连接  ---一般都使用        
		    properties.put("mail.smtp.ssl.enable", "true");
		    //设置是否显示debug信息  true 会在控制台显示相关信息        
		    properties.put("mail.debug", "true");

			//得到回话对象        
			Session session = Session.getInstance(properties);        

			// 获取邮件对象        

			Message message = new MimeMessage(session);        

			//设置发件人邮箱地址       

			 message.setFrom(new InternetAddress(sendEmailName));       

			 //设置收件人地址      
			 message.setRecipients(RecipientType.TO,new InternetAddress[] { new InternetAddress(accepter) });       
			//设置邮件标题        
			message.setSubject(title);   
			// 复杂邮件主结构
			Multipart multipart = new MimeMultipart();
			// 第一次实例化结构体
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			//messageBodyPart.setText(contents);
			messageBodyPart.setText(contents, "gb2312");
			messageBodyPart.setContent(contents, "text/html;charset=\"gbk\"");
			multipart.addBodyPart(messageBodyPart);
			// 把主复杂结构体放进message对象
			message.setContent(multipart);
			message.saveChanges();
			//得到邮差对象        
			Transport transport = session.getTransport();        
			//连接自己的邮箱账户        
			transport.connect(sendEmailName,sendEmailKey);//密码为刚才得到的授权码        
			//transport.connect("smtp.qq.com","1335431995@qq.com", "15641681111");
			//发送邮件    
			transport.sendMessage(message, message.getAllRecipients()); 
			transport.close();
			return true;
		}catch(Exception e){
			System.out.println("发送邮件失败");
			e.printStackTrace();
			return false;
			
		}   

	}
	public static void main(String[] args) throws AddressException, MessagingException {
		EmailUtil emailUtil = new EmailUtil();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String name = "狗屎";
		String product = "粑粑";
		String title = "大破车乐队";
		String compentName = "大破车乐队"; 
		String accepter ="1054253510@qq.com";
		String sex = ("1".equals("0"))?"先生":"女士";
		String contents="<div>尊敬的"+name+sex+":您好!</div><br/>"
				+ "<div style=\"text-indent: 2em;line-height:20px\"></div>"
				+ "<div style=\"text-indent: 2em;\">感谢您购买我公司"+product +"产品,祝你生活愉快！ </div><br/><br/>"
				+ "<div align=\"right\">" +compentName+"</div><br/>"
				+ "<div align=\"right\">"+format.format(new Date())+"</div>";
		Boolean result = emailUtil.sendEmail(title, contents,accepter);
		if(result){
			System.out.println("-------------邮件发送成功----------------");
		}else{
			System.out.println("-------------邮件发送失败----------------");
		}
		
	}
}
