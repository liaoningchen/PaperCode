package com.examOnline.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.examOnline.dao.StudentDao;
import com.examOnline.model.Student;
import com.examOnline.service.StudentService;
import com.examOnline.util.EmailUtil;
import com.examOnline.util.RandomUtil;
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;
	@Value(value = "${sendEmailName}")
	private String sendEmailName;
	@Override
	public int insert(Student record) {
		
		return studentDao.insert(record);
	}
	/**
	 * 0验证通过，1用户名不存在，2密码错误
	 */
	@Override
	public int queryByLoginName(String code,String password) {
		Student student = studentDao.queryByLoginName(code);
		if(student == null){
			return 1;
		}else if(!student.getPassword().equals(password)){
			return 2;
		}
		return 0;
	}
	@Override
	public int modifyPassword(String code, String prePass, String noePass,String num) {
		Student student = studentDao.queryByLoginName(code);
		if(student == null){
			return 1;//用户名不存在
		}else if(!student.getPassword().equals(prePass)){
			return 2; //初始密码错误
		}else if(student.getOther1().equals(num)){
			student.setPassword(noePass);
			studentDao.updateByPrimaryKey(student);
			return 3;//验证通过
		}
		return 0;
	}
	/**
	 * 邮箱验证
	 */
	@Override
	public boolean emailVai(String email,String code) {
		System.out.println(sendEmailName+"-----------------------------------------");
		boolean boo = false;
		Student student = studentDao.queryByLoginName(code);
		String num = RandomUtil.randomNo(6);
		//记录验证码
		student.setOther1(num);
		studentDao.updateByPrimaryKeySelective(student);
		try {
			boo = sendEmail(email,student);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return boo;
	}
	
	//发送邮件
	public static boolean sendEmail(String email,Student student) throws AddressException, MessagingException{
		EmailUtil emailUtil = new EmailUtil();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String title = "在线考试系统";
		String compentName = "在线考试系统"; 
		String sex = ("0".equals(student.getSex()))?"先生":"女士";
		String contents="<div>尊敬的"+student.getName()+sex+":您好!</div><br/>"
				+ "<div style=\"text-indent: 2em;line-height:20px\"></div>"
				+ "<div style=\"text-indent: 2em;\">您的验证码为："+student.getOther1()+" </div>"
				+ "<div align=\"right\">" +compentName+"</div><br/>"
				+ "<div align=\"right\">"+format.format(new Date())+"</div>";
		Boolean result = emailUtil.sendEmail(title, contents,email);
		return result;
	}

}
