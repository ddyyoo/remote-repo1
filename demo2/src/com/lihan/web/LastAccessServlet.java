package com.lihan.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lastAccessServlet")
public class LastAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String lastAccessTime = null;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		if(lastAccessTime == null) {
			resp.getWriter().print("您首次访问本站！！！");
		} else {
			lastAccessTime = URLDecoder.decode(lastAccessTime,"utf-8");
			resp.getWriter().print("您上次的访问时间是：" + lastAccessTime);
		}
		String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		currentTime = URLEncoder.encode(currentTime,"utf-8");
		Cookie cookie = new Cookie("lastAccess",currentTime);
		resp.addCookie(cookie);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
