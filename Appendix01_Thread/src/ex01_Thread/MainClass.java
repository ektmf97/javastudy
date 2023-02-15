package ex01_Thread;

public class MainClass {

	public static void main(String[] args) {
		
		Calculator myCalc = new Calculator("영희"); // myCalc 스레드 생성 
		myCalc.start(); // run 메소드를 만들었지만 start를 호출한다. 
		// start 메소드는 run 메소드를 스스로 호출한다. main은 myCalc 스레드의 동작 시작만 처리하고 동작 완료까지 기다리지않는다.
		// 스레드 메뉴얼 
		Calculator youCalc = new Calculator("상철"); // youCale 스레드 생성
		youCalc.start();
		
		// myCalc 스레드가 youCalc 스레드보다 먼저 실행된다는 보장이 전혀 없다.
		// 스레드 실행 순서를 정하는 건 개발자가 아니라 JVM이다. 
		
		System.out.println("main 메소드를 종료합니다.");
		
	}

}
