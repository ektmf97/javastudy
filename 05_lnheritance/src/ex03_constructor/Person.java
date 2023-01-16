package ex03_constructor;

public class Person {

	// 생성자
	public Person() {
		System.out.println("Person 생성");
	}
	
/*************************************************/
	
	// 필드
	private String name;
	
	// 생성자
	public Person(String name) {
		this.name = name; // 받아온 이름을 필드에 저장
	}

	// 메소드 get , set 불러오기
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
