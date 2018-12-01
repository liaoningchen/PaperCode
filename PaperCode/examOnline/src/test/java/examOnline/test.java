package examOnline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examOnline.service.AdminService;


public class test {
	//Spring核心容器
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	
	//service对象
	private AdminService adminService = (AdminService) context.getBean("adminService");
	@Test
	public String test1(){
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println(adminService.selectCount());
		return adminService.selectCount();
	}
	public static void main(String[] args) {
		
	}

}
