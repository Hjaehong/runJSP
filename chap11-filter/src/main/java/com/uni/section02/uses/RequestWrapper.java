package com.uni.section02.uses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper{
	
	public RequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String key) {
		String value= "";
		System.out.println("오버라이드한 get 파라미터 동작함");
		if("password".equals(key)) {
			/* BCrypt 는 단방향 해시 알고리즘이다, 즉 암호화 한 다이제스트를 복화화 하지못하고 , 어떤 길이의 문자열을 넣어도 일정한 길이의 문자열을 반환한다.
			 * 비밀번호를 데이터 베이스에 저장할 목적으로 설계된 암호화 알고리즘
			 * 랜덤 솔팅 기법을 적용
			 * */
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key));
		}else {
			return super.getParameter(key);
		}
		
		return value;
	}
	
}
