package com.greedy.section02.sessionlistener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserDTO implements HttpSessionBindingListener {
	// 상속받아야 한다. 해당 userdto 가 세션에 추가 됬는지 삭제됬는지 확인해서 출력 해준다. 선택적 오버라이딩 가능하다  

	private String name;
	private int age;
	
	public UserDTO() {}
	
	public UserDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		/* 해당 클래스로 만든 인스턴스가 세션에 바인딩(값이 추가) 되는 경우 먼저  동작함 */
		System.out.println("value bound!!" + event);
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		/* 해당 클래스로 만든 인스턴스가 세션에 바인딩 해제(값 제거 혹은 세션 만료) 되는 경우 동작함 */
		System.out.println("value unbounded!!");
	}
	
	
}
