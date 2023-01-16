package practice_Person_Array;

public class Person {
	
	// Bean의 형태 
	
	// 필드
	private String name; 
	private int age;
	
	// 생성자
	public  Person() {} // new Person() 
	public Person(String name, int age) { // new Person ("alice,20) 
		this.name = name;
		this.age = age;
	}
	
	// 이름과 나이를 바꿔줄 메소드가 필요해 (set)
	
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
	
}
