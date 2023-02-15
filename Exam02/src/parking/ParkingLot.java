package parking;

import java.util.Scanner;

public class ParkingLot {

	// 필드 
	private String name; // 자동차 이름 
	private Car[] cars;  // 자동차 배열 
	private int idx;	// 배열 뒤에 따라다니는 인덱스
	private Scanner sc;	// 전반적으로 스캐너를 쓰겠다.
	
	// 생성자 
	public ParkingLot(String name) {  //주차장 이름 초기화 
		this.name = name;
		cars = new Car[10]; // 배열의 길이가 10
		sc = new Scanner(System.in);
	}
	
	// 현재 들어있는 차량이 몇 대인지 보여주기 위해 만들기 
	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(idx == cars.length) { // 현재 등록된 차량이 10대 이거나 자동차의 길이가 10대 이면 
			System.out.println("더 이상 차량 등록이 불가능합니다."); // 10대가 꽉 차면 등록 불가 메시지 만들기 
			return;
		}
		// 입력 
		System.out.println("차량번호 >>>");
		String carNo = sc.next();
		System.out.println("모델 >>>");
		String model = sc.next();
		cars[idx++] = new Car(carNo,model);
		System.out.println("차량번호" + carNo + "차량이 등록되었습니다.");
		
	}
	// 자동차들 지우기
	public void deleteCar() {
		
		
		if(idx == 0) {
		System.out.println("등록된 차량이 없습니다.");
		return;
		}
		
		System.out.println("제거할 차량번호 >>>");
		String carNo = sc.next();
		for(int i = 0; i < idx; i++) {
			if(cars[i].getCarNo().equals(carNo)) {
				cars[i] = cars[--idx];
				System.out.println("차량번호 " + carNo  + " 차량이 삭제되었습니다.");
				return;
			}
		}
			System.out.println("대상 차량이 존재하지 않습니다.");
		
			/* 선생님 문제풀이
			if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
			}
			System.out.println("제거할 차량번호 >>>");
			String carNo = sc.next();
			for(int i = 0; i < idx; i++) {
				Car car = cars[i];
				if(carNo.equals(car.getCarNo())) {
				// 방법 1. 삭제할 요소의 뒤에 있는 것들을 모두 한 칸씩 앞으로 옮기기 
				syste.arraycopy(cars, i + 1, cars, i , idx - 1);
				cars[--idx] = null;
				System.out.println("차량번호" + carNo + "인 차량이 삭제되었습니다.);
				return;
				
					방법 2. 마지막 차량을 옮겨오기 
					제거할 차량의 위치 : i
					마지막 차량의 위치 : idx - 1
					cars[i] = cars[idx - 1];
					cars[--idx] = null;
					return;
				}
			}
			System.out.println("대상 차량이 존재하지 않습니다.");
			
			*/
		}
	
	// 현재 주차장에 들어있는 모든 자동차들 
	public void printAllCars() {
		
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
	
		System.out.println("대박주차장 차량목록");
		for(int i = 0; i < idx; i++) {
			System.out.println(cars[i]);
		}
	}
	// 관리 메소드 
	public void manage() {
		while (true) { // 무한루프
			// 1. 메뉴판 보여주기
			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>>");
			// 입력 받는건 숫자로 받겠다.
			int choice = sc.nextInt();
			// 입력 받는건 문자로 받겠다.
		// 	String choice = sc.next();
			
			// 정수로 받은걸 스위치 
			switch(choice) {
			case 1:
				addCar(); // addCar 호출해서 사용 
				break;
			case 2:
				deleteCar(); // deleteCar 호출 
				break;
			case 3:
				printAllCars(); // printAllCars 호출
				break;
			case 0:
				return; // 리턴은 메소드를 끝내자 , 이때 브레이크를 입력하면 그건 스위치문 종료 
			default:
				System.out.println("존재하지 않는 메뉴입니다.");
			}
			
		}
	}
}
