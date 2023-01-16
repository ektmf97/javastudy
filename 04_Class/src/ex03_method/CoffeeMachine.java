package ex03_method;

public class CoffeeMachine {

	
	// 필드
	int moneypot; // 초기화 0
	String[] menu = {"아메리카노", "카페라떼", "마키아또"};
	int[] prices = {900, 1500 , 2000};
	
	
	// 메소드
	CoffeeAndChange buyCoffee(int money, int choice) { 
		
		// 돈이 모자르면 money 그대로 반환 
		int price = prices[choice -1];
		if(money < price) {
			CoffeeAndChange cnc = new CoffeeAndChange();
			cnc.change = money;
			return cnc;
			
		}
		
		String coffee = menu[choice -1];
		
		
		moneypot += price;  // 돈 통에 쌓이는 것
		
		
		
		CoffeeAndChange cnc = new CoffeeAndChange();
		cnc.coffee = coffee;
		cnc.change = money - price;	// 사용자한테 잔돈 주기
		return cnc;  // return을 한 다음에는 아무작업도 못함. 값을 반환하고 나면 실행이 끝남
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
