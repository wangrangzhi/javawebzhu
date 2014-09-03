package edu.freshen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.freshen.dao.MusicInfoDao;
import edu.freshen.entity.MusicInfo;
import edu.freshen.idao.ImusicInfoDao;

public class QueryMusicInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		//验证session中有误登录信息
//		HttpSession sn =request.getSession();
//		if(sn.getAttribute("loginUser")==null){
//			response.sendRedirect("/web02/index.jsp");
//			return;
//		}
		
		ImusicInfoDao musicDao =new MusicInfoDao();
		List<MusicInfo> ms =musicDao.queryAllMusic();
		System.out.println("服务器共查处 歌曲数量 "+ms.size());
		request.setAttribute("musics", ms);
		request.getRequestDispatcher("/WEB-INF/music/musiclist.jsp").forward(request, response);
	}

}
