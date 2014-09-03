package edu.freshen.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.freshen.dao.LoginUserDao;
import edu.freshen.entity.LoginUser;
import edu.freshen.idao.IloginUserDao;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String name=request.getParameter("loginName");
			String pwd =request.getParameter("loginPwd");
			//封装对象
			LoginUser user =new LoginUser();
			user.setLoginName(name);
			user.setLoginPwd(pwd);
			//创建Dao，检验登录
			IloginUserDao iLoginDao =new LoginUserDao();
			LoginUser temp =iLoginDao.checkLogin(user);
			System.out.println("校验结果 "+temp);
			if(temp!=null){
				//保存登录信息
				request.getSession().setAttribute("loginUser", temp);
				//查 数据
				request.getRequestDispatcher("/auth/QueryMusicInfoServlet").forward(request, response);
			}else{
				request.setAttribute("errMsg", "登录信息错误，请重新尝试！");
				request.getRequestDispatcher("/common/error.jsp").forward(request, response);
			}
	}
	
	

}
