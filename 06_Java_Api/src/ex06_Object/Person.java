package ex06_Object;

public class Person {

	// 필드
	private String name;
	
	// 생성자 2개
	
	// 이름 안 받는 방법
	public Person() {    // 메인클래스에 ex01 때문에 만듬
		
	}
	// 이름 받아오는 방법 
	public Person(String name) {
		this.name = name;
	}
	
	// 메소드 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println("먹는다.");
	}
	public void sleep() {
		System.out.println("잔다.");
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	 
	 

	
	
	
	
	
	
	
	
	
	
	
	
}
