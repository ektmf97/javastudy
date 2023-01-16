package ex06_downcasting;

public class MainClass {

	public static void ex01() {
		
		//upcasting
		Person person = new Person(); 
		// 자식을 부모 타입의 저장 upcasting의 개념
		// person이 가지고 있는 메소드를 호출할 수 있다. 
		
		// downcasting 잘못된 캐스팅
		Student student = (Student)person;
		
		// 잘못된 캐스팅은 컴파일 오류로 걸러지지 않는다.
		student.eat();
		student.sleep();
		student.study(); // 오류 발새 부분
	
	}
	public static void ex03() {
		 
		// Person
		Person person = new Person();
		
		// Student 객체(인스턴스, instance)가 맞다면 Student 타입으로 캐스팅 하자.
		if(person instanceof Student) {
			
		Student student = (Student)person;
		student.eat();
		student.sleep();
		student.study();
			
		person.eat();
		person.sleep();
		((Student)person).study(); // eat,sleep 다른곳에 있다.
				
		}
	}

	public static void main(String[] args) {
	
		ex03();
	}

}
