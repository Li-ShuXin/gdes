package com.gdes.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 * 完成登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 0. 强制转换
		HttpServletRequest hRequest = (HttpServletRequest)request;
		
		// 1. 获取资源的请求路径
		String uri = hRequest.getRequestURI();
		
		// 2.判断是否包含登录相关资源
		// 注意：css,js，图片，验证码等资源
		if(uri.contains("/login.jsp") || uri.contains("/logInServlet") 
				|| uri.contains("/css/") || uri.contains("/js/")
				|| uri.contains("/verifyCodeServlet")) {
			// 包含：用户就是想登录，放行
			chain.doFilter(request, response);
		}else {
			// 不包含，需要验证用户是否登录
			//3. 从session中获取user
			Object user = hRequest.getSession().getAttribute("user");
			if (user != null) {
				// 登录了，放行
				chain.doFilter(request, response);
			}else {
				// 没有登录，跳转登录页面
				hRequest.setAttribute("login_msg", "您尚未登录，请登录");
				hRequest.getRequestDispatcher("/login.jsp").forward(hRequest, response);;
			}
		}
		
		

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
