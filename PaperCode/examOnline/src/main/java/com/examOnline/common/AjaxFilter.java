package com.examOnline.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器
 * 
 * @author Administrator
 *
 */
@WebFilter("/*")
public class AjaxFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		// 转换为子接口类型
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//设置响应报头允许当前应用被跨域请求（CROS）
		response.setHeader("Access-Control-Allow-Origin", "*");

		// 统一设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 登录验证		
		String uri = request.getRequestURI();
		String app = request.getContextPath();
		
		System.out.println("请求uri=" + uri);
						
		/*if ( !uri.equals(app + "/") 
				&& !uri.equals(app + "/Login.html") 
				&& !uri.equals(app + "/logout.html")
				&& !uri.equals(app + "/student/login")
				&& !uri.equals(app + "/student/modifpass")
				&& !uri.equals(app + "/student/sendnumtoemail")
				&& !uri.equals(app + "/view/modifyPassword.html")
				&& !uri.equals(app + "/view/main.html")
				&& !uri.startsWith(app + "/css")
				&& !uri.startsWith(app + "/scripts")
				&& !uri.startsWith(app + "/images")) {
			
			HttpSession session = request.getSession();			
			String code = (String) session.getAttribute("code");
			
			if (code == null) {				
				
				//判断是否是ajax请求	，在响应报头中设置一个标识			
				if (request.getHeader("x-requested-with") != null && 
				    request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
					response.setHeader("sessionStatus", "timeout");					
				} else {
					response.sendRedirect(app + "/logout.html");
				}				
				
				return;
			}
			
		}	*/
		
		// 继续向下执行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}