package com.uni.section01.sessino;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionHandlerServlet
 */
@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		System.out.println("이름 :" +fName + lName);
		
		// web.xml에 30분으로 기본 셋팅이 되어있다.
		HttpSession session = request.getSession();
		// 기본 유지 시간
		System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());
		
		session.setMaxInactiveInterval(60 * 10);
		System.out.println("변경 후 session 유지 시간 : " + session.getMaxInactiveInterval());
		// session의 id 확인
		System.out.println("session id : " + session.getId());
		// request보다 훨씬 넓은 범위 이며 application > session > request
		session.setAttribute("firstName", fName);
		session.setAttribute("lastName", lName);
		
		response.sendRedirect("redirect");
		
	}

}
