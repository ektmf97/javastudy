package ex04_override;

public class MainClass {

	public static void main(String[] args) {
		
		
		//에소프레소 만들기
		Espresso coffee1 = new Espresso(); 
		coffee1.taste();  // 커피1의 맛 테스트 

		// 두번째 커피 아메리카노
		Americano coffee2 = new Americano();
		coffee2.taste();
	}

}
