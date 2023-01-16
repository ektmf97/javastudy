package ex05_upcasting;

public class Student extends Person{
// 상속관계 주기
	
	@Override
	public void study() {
		System.out.println("공부한다.");
	}
}
