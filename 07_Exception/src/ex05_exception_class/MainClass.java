package ex05_exception_class;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Gun gun = new Gun();
		
		while(true) { 	// 무한루프 반복문
						// 사용자가 0을 적어야 프로그램이 끝나는 방식 
			try {
				
				System.out.println("1. 장전 2. 발사 0. 종료 >>>" );
				String choice = sc.next();
				
				
				switch(choice) {
				case "1" :
					gun.reldad(5);
					break;
				case "2" :
					gun.shoot();
					break;
				case "0" :
					System.out.println("프로그램 종료");
					sc.close(); // 스캐너 닫아주는 코드 
					return; // 반환타입이 void인 메소드는 리턴으로 전체 메소드 종료가능 
				default :
					throw new RuntimeException("잘못된 선택입니다");
				}
			
			}catch(GunException	e) {
				System.out.println("예외코드 :" + e.getExceptionCode());
				System.out.println("예외메시지 : " + e.getMessage());
			}catch(Exception e) {
				System.out.println("예외메시지 : " + e.getMessage());
			}
		}

	}

}
