package ex03_method;

public class Calculator {
	
	// 메소드 (함수) 어떤 기능을 만든다. 
	
	/*
	 	메소드 형식
	 	
	 	반환타입 메소드명(매개변수) { 
	 		메소드 본문
	 		return 반환값
	 	}
	 	
	 	1. 반환값 + 반환타입
	 		메소드 실행(메소드 호출)의 결과
	 	2. 메소드명
	 		개발자 마음대로 정함
	 	3. 매개변수
	 		메소드로 전달되는 값(인수, argument)을 저장하는 변수
	 */
	
	/*
	 	메소드의 4가지 형식							메소드 호출 
	 	
	 	1. 반환값 X, 인수 X
	 		void method() {							method();
	 			메소드 본문
	 		}
	 	2. 반환값 X, 인수 O							int a = 0;
	 		void method(int arg) {					method(a);
	 			메소드 본문
	 		}
	 		
	 	3. 반환값 O, 인수 X
	 		int method() {							int result;							
	 			메소드 본문							result = method();
	 			return 반화값;
	 		}
	 	4. 반환값 O, 인수 O							int a = 0;
	 		int method(int arg) {					int result;	
	 			메소드 본문							result = method(a);
	 			return 반환값;
	 		}
	 */
	// addition 메소드 정의 
	double  addition(double a, double b) {
		
		return a + b; // 간단한 덧셈 기능
	}

	// subtraction 메소드 정의
	double subtaction(double a, double b)	{
		
		return a - b; // 뺄셈 기능
		
	}
	
}
