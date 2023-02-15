package ex04_OutputStream;

import java.io.Serializable;

/*
 		ObjectOutputStream/ObjectInputStram을 통해서
 		객체 입출력을 수행하려면 "반드시" 직렬화 처리를 해야 한다.
	 */

	/*
 	직렬화 처리 방법
 	1. java.io.Serializable 인터페이스를 구현한다.(필수)
 	2. SerialVersionUID 필드 값을 정의한다.(선택)
	 */
public class Person implements Serializable { // 객체 생성 준비과정
	
	private static final long serialVersionUID = 7033755836244474051L;

	private String name;
	private int age;
	private double height;
	private boolean isAlive;
	
	// 생성자 2개
	public Person(){
		
	}

	public Person(String name, int age, double height, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
	}

	// get,set 만들기 
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + "]";
	}
	
	
}
