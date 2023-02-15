package ppp;

import java.util.Scanner;

public class WeekScheduler {

	// 선언
	private Scanner sc;
	private Day[] days; // 7개의 값 
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	
	// 몇 주차 관리하기
	private int nthWeek;
	
	// new WeekScheduler(4)
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		sc = new Scanner(System.in);
		days = new Day[7];
		// 7번 반복되야 해서 반복문 돌리기 (이 방법으로 하면 나중에 추가할 때 편해짐 set만 불러오면 되서 )
		for(int i = 0; i < days.length; i++) {
			days[i] = new Day();
			
		}
	}
	// 스케줄 추가하기
	public void addSchedule() {
	
		System.out.println("요일 입력 >>> ");
		String dayName = sc.next().trim().substring(0,1); // 요일과 엔터 입력
		sc.nextLine(); // 엔터 제거
		
		// 배열 순회 
		for(int i = 0; i < dayNames.length; i++) {
			if(dayName.equals(dayNames[i])) { // equals string 비교할 때 사용 
				if(days[i].getSchedule() == null) { // get을 꺼내서 하나씩 꺼내봐야한다.
					System.out.println("스케쥴 입력 >>> ");
					String schedule = sc.nextLine(); // 공백 포함 스케쥴 일력
					days[i].setSchedule(schedule);
					System.out.println(dayName + "요일에 스케쥴 등록 완료");
				}else {
					System.out.println(dayName + "요일은 이미 스케쥴 있음");
				}
				break; // 입력받은 스케쥴이 있든 없든 끝내준다.
			}
		}
	}
	// 삭제
	public void deletSchedule() {
		
		System.out.println("요일 입력 >>> ");
		String dayName = sc.next().trim().substring(0,1); // 요일과 엔터 입력
		sc.nextLine(); // 엔터 제거
		
		for(int i = 0; i < dayNames.length; i++	) {
			if(dayName.equals(dayNames[i])) {
				days[i].setSchedule(null); // 스케쥴을 지운다. null값을 넣어서 
				System.out.println(dayName + "요일 스케쥴 삭제 완료");
				break;
			}
		
		}
		
	}
	// 수정 
	public void changeSchedule() {
		
	}
	// 출력 
	public void printAllSchedule() {
		System.out.println(nthWeek + "주차 스케줄");
		for(int i = 0; i < days.length; i++) {
			System.out.print(dayNames[i] + "요일 : ");
			System.out.println(days[i].getSchedule() == null ? "스케쥴없음" : days[i].getSchedule());
		}
	}
	public void manage() {
		while(true) {
			System.out.println("1.추가 2.삭제 3.수정 4.출력 0.종료 >>>");
			String choice = sc.next();
			switch(choice){
			case "1" :
				addSchedule();
				break;
			case "2" :
				deletSchedule();
				break;
			case "4" :
				printAllSchedule();
				break;
			case "0" : return;	
				
				
			}
		}
	}
	public static void main(String[] args) {
		new WeekScheduler(4).manage();
	}
}
