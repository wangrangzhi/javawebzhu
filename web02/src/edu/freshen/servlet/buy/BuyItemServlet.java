package edu.freshen.servlet.buy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyItemServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemId=request.getParameter("itemId");
		String count=request.getParameter("count");
		System.out.println("购物物品ID ="+itemId+", 数量"+count);
		
		List<String> items =(List<String>) request.getSession().getAttribute("items");
		if(items==null){
			items=new ArrayList<String>();
		}
		if(itemId!=null&&itemId.trim().length()>0){
			items.add(itemId);
			request.getSession().setAttribute("items", items);
		}
		request.getRequestDispatcher("/auth/QueryMusicInfoServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
