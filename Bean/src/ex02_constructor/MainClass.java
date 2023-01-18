package ex02_constructor;

public class MainClass {

	public static void main(String[] args) {
		
		// User객체 생성 생성자로 만들기
		User user = new User("admin", "123456");
		
		// 필드 값 확인
		System.out.println(user);

	}

}
