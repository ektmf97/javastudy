package ex07_constructor;

public class User {

	// 필드
	String id;
	String pw;
	
	// 생성자
	User() {
		id = "anonymous";
		pw = "1234";
		
	}
	// 두번째 생성자 
	User(String userId, String userPw) {
		id = userId; // 필드 이름이랑 매개변수 이름을 다르게 해줘야 한다.
		pw = userPw;
	}
	
	// 메소드
	void info() {
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
	}
}
