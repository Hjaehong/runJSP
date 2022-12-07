package com.uni.section01.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter("/first/*")
public class FirstFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     * 
     */
    public FirstFilter() {
    	/* 기본 생성자 */
    	/* 필터는 톰캣을 start할 시점부터 인스턴스를 미리 생성한다. */
    	System.out.println("FirstFilter 인스턴스 생성!");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		/* 필터 인스턴스가 소멸될 때 호출되는 메소드 (톰캣 종료 시)*/
		System.out.println("filter destroy 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* Servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드 */
		
		//서블릿 호출하기 이전에 수행할 내용작성 
		System.out.println("filter doFilter 호출");
		
		/* 뭔가 처리하기 위해서는 여기에 코드를 작성한다. */

		/* 위에서 뭔가 처리를 한 뒤 다음 필터 혹은 서블릿의 doGet/doPost를 호출한다.  서블릿을 호출했다가 다시 복귀한다. */
		chain.doFilter(request, response);
		
		/* 서블릿에서 처리 후에 다시 수행할 내용이 있으면 작성*/
		System.out.println("서블릿 요청 처리 완료!");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/* 필터 인스턴스가 최초 생성될 때 호출되는 메소드 */
		System.out.println("filter init 호출");
	}

}
