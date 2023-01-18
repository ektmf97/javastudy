package ex04_builder;


public class MainClass {

	public static void main(String[] args) {
		/*
		User user = new User(); // 유저를 만들어야 빌더를 부를 수 있는 상황 
		Builder builder = new Builder();
		*/
		
		// builder 패턴
		User user = User.builder()
						.id("admin")
						.pw("123456")
						.build();
		
		System.out.println(user);
	}

}
