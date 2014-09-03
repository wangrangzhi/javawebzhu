package edu.freshen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.freshen.entity.LoginUser;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) req;
		HttpServletResponse response =(HttpServletResponse) res;
		String uri =request.getRequestURI();
		String url =request.getRequestURL().toString();
		
		System.out.println("客户端企图访问 ：uri="+uri+" ;url="+url);
		LoginUser lu =(LoginUser) request.getSession().getAttribute("loginUser");
		if(lu==null){
			response.sendRedirect("/web02/index.jsp");
			return;
		}
		System.out.println("Filter 开始了！");
		//继续
		chain.doFilter(req, res);
		
		System.out.println("Filter 结束了！");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
