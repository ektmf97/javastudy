package ex08_this;

public class User {

	/*
	 	this 
	 	1. 현재 객체의 참조값이다.
	 	2. 클래스 내부에서만 사용할 수 있다.
	 	3. 클래스의 구성요소(필드,메소드)를 호출할 때 사용할 수 있다.
	 		1) 필드 	: this.필드
	 		2) 메소드	: this.메소드()
	 */
	// 필드
	String id; // this.id 
	String pw; // this.pw
	
	// 생성자
	User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// 메소드
	void printThis() { // 내부에서 부를 때 객체 이름 
		System.out.println(this);
	}
	
	void info() {
		System.out.println("아이디 :" + id); // ("아이디 : " +  this.id); 라고 안적음
		System.out.println("비밀번호 :" + pw);
	}
}
