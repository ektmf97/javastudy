package practice_Person_Array;

public class MainClass {
	
	public static void ex01() {
		// 이름과 나이 만들어 주기 
		String[] nameList = {"정숙","상철", "미희"};
		int[] avgList = {20, 30, 40};
		
		Person[] arr = new Person[3]; // 사람이 3명 필요하다(배열의 생성)
		
		// 데이터를 저장 시켜주는 반복문
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Person(); // 여기에 저장할 수 있는 변수는 사람이다.
			arr[i].setName(nameList[i]); // 이름 리스트를 차례대로 가지고 와라
			arr[i].setAge(avgList[i]); // 나이 리스트를 차례대로 가지고 와라.
			// 출력문 같이 
			System.out.println("이름 : " + arr[i].getName() + ", 나이 :" + arr[i].getAge()); 
			// 이름확인 이름 바꾸기는setName
		}	
	}
	
	public static void ex02() {
		
		// 이름 3개 저장
		String[] nameList = {"정숙","상철", "미희"};
		int[] avgList = {20, 30, 40};
		
		// 3사람이 저장될 수 있는 배열 만들기
		Person[] arr = new Person[3];
		
		// getName , getAge 할 필요없이 만들어진다.
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Person(nameList[i], avgList[i]);
			System.out.println("이름 : " + arr[i].getName() + ", 나이 :" + arr[i].getAge()); 
		}
	}
	
	public static void ex03() {
		
		
		String[] nameList = {"정숙","상철", "미희"};
		int[] avgList = {20, 30, 40};
		
		Home home = new Home(3); // 3명이 사는 집이다.
		
		for(int i = 0; i < home.getArr().length; i++) {
			home.getArr()[i] = new Person(nameList[i], avgList[i]); 
			System.out.println("이름 : " + home.getArr()[i].getName() + ", 나이 : " + home.getArr()[i].getAge());
				
		}
	}
	public static void main(String[] args) {
		ex03();
	}

}
