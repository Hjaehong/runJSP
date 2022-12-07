package com.uni.section01.error;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show404ErrorServlet
 */
@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExceptionHandlerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * javax.servlet.forward.request_uri - 어떤경로에서 에러가 발생해서 넘어왔는지 (위임된(forward) 서블릿 )
		 * 경로 javax.servlet.forward.context_path - 루트명
		 * javax.servlet.forward.servlet_path - 서블릿경로 javax.servlet.forward.mapping
		 * javax.servlet.error.status_code - 에러상태코드 javax.servlet.error.message - 에러메세지
		 * javax.servlet.error.servlet_name - 에러발생한서블릿명 javax.servlet.error.request_uri
		 * - 에러발생한 사용자 요청 경로
		 */

		Enumeration<String> attrName = request.getAttributeNames();
		while (attrName.hasMoreElements()) {
			System.out.println(attrName.nextElement());
		}
		// 어떤 경로에서 에러가 발생해서 넘어왔는지
		String forwardRequestURI = (String) request.getAttribute("javax.servlet.forward.request_uri");
		// 경로 루트명
		String contextPath = (String) request.getAttribute("javax.servlet.forward.context_path");
		// 서블릿 경로
		String servletPath = (String) request.getAttribute("javax.servlet.forward.servlet_path");
		// 에러 상태 코드
		int statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		// 에러메세지 
		String message = (String) request.getAttribute("javax.servlet.error.message");
		// 에러발생한 서블릿 이름
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		// 에러발생한 사용자 경로
		String errorRequestURI = (String) request.getAttribute("javax.servlet.error.request_uri");

		System.out.println(forwardRequestURI);
		System.out.println(contextPath);
		System.out.println(servletPath);

		System.out.println(statusCode);
		System.out.println(message);
		System.out.println(servletName);
		System.out.println(errorRequestURI);

		StringBuilder errorPage = new StringBuilder();
		errorPage.append("<!doctype html>\n")
		.append("<html>\n")
		.append("<head>\n")
		.append("</head>\n")
		.append("<body>\n")
		.append("<h1 align=\"center\">")
		.append(statusCode)
		.append(" - ")
		.append(message)
		.append("</h1>")
		.append("</body>\n")
		.append("</html>\n");

		response.setContentType("text/html; charset=UTF-8");
		// 바이트를 문자열 객체로 변환시켜주며 getWriter로 인스턴스 생성해준다.
		PrintWriter out = response.getWriter();

		out.print(errorPage.toString());
		// 파일(errorPage)에 쓰기 메소드 flush
		out.flush();
		out.close();
	}

}
