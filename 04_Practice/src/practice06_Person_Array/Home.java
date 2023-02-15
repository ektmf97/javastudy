package practice06_Person_Array;

public class Home {

	// 필드 
	private Person[] arr; // 사람이 여러명 저장된다. 집집마다 사람의 수는 다르기 때문에 new를 안함 (선언만 함)
	private int count; // 사람이 몇명 있다.
	
	// 생성자 
	public Home(int count) {
		arr = new Person[count]; // 배열 생성해준다. 선언만 하고 생성을 안했기 때문
		this.count = count; //  없어도 된다. count = arr.길이랑 동일 
		
	}

	
	// 메소드  (arr은 프라이빗이기 때문에 get,set 먼저 작업해주기
	public Person[] getArr() {
		return arr;
	}
	
	public void setArr(Person[] arr) {
		this.arr = arr;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	
	
	
	
}

