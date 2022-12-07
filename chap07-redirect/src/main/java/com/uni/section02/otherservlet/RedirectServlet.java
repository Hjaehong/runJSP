package com.uni.section02.otherservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 타입 정하기
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("이 서블릿으로 redirect 성공!");
		System.out.println(request.getParameter("name"));
		StringBuilder redirectText = new StringBuilder();
		redirectText.append("<!doctype html>\n")
					.append("<head>\n")
					.append("</head>\n")
					.append("<body>\n")
					.append("<h1>이 서블릿으로 redirect 성공!</h1>")
					.append("</body>\n")
					.append("</html>\n");
		
		PrintWriter out = response.getWriter();
		out.print(redirectText.toString());
		
		out.flush();
		out.close();
	}



}
