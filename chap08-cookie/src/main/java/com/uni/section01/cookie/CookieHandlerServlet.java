package com.uni.section01.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieHandlerServlet
 */
@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieHandlerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		System.out.println("이름 :" +fName + lName);
		
//		response.sendRedirect("redirect");
		//쿠키를 사용하는 방법
		/* 1. 쿠키를 생성한다.
		 * 2. 해당 쿠키의 만료 시간을 설정한다.
		 * 3. 응답 헤더에 쿠키를 담는다.
		 * 4. 응답한다.
		 * 
		 * 하지만 쿠키는 일부 제약항목이 있다.
		 * 쿠키의 이름(키값)은 ascii 문자만을 사용해야 하며 한 번 설정한 쿠키의 이름은 변경할 수 없다.
		 * 또한 공백문자와 일부 특수문자([ ] ( ) = , " \ ? @ : ;)를 사용할 수 없다.
		 * */
		
		// 1. 쿠키 생성
		Cookie firstNameCookie = new Cookie("firstName", fName);
		Cookie lastNameCookie = new Cookie("lastName", lName);
		// 2. 만료 시간(하루) 생성 
		firstNameCookie.setMaxAge(60 * 60 * 24);
		lastNameCookie.setMaxAge(60 * 60 * 24);
		// 3. 응답 헤더에 쿠키 담는다.
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
		// 4. 응답한다.
		response.sendRedirect("redirect");
	}

}
