package com.uni.section02.delete;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteSessionServlet
 */
@WebServlet("/delete")
public class DeleteSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 객체가 유효시 가져옴
		HttpSession session = request.getSession();
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		/* 세션의 데이터를 지우는 방법은 여러 가지가 있다.
		 * 1. 만료시간 설정 후 시간이 지나면 세션이 만료된다. (xml 설정도 가능)
		 * 2. removeAttribute()로 session의 Attribute를 지운다. 
		 * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
		 * */
		
		session.removeAttribute("firstName");
		sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		// 세션을 무효화 시킨다.
		session.invalidate();
		sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
	}

}
