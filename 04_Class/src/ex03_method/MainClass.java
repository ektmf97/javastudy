package ex03_method;

public class MainClass {

	public static void ex01() {
		
		// Calculator 객체 선언 + 생성
		Calculator calc = new Calculator(); 	// calc : 객체이름
		
		double add = calc.addition(1.5, 2.5); 	// addition 메소드 호출 
		System.out.println(add);
		
		double sub = calc.subtaction(2.5, 1.3); // subtaction 메소드 호출 
		System.out.println(sub);
	}
	
	public static void ex02() { // 	반환타입x , 매개변수 x
		
		CoffeeMachine coffeeMachine = new CoffeeMachine(); // 커피 자판기 1대 
		
		CoffeeAndChange coffeeAndChange = coffeeMachine.buyCoffee(1000, 1);
		System.out.println(coffeeAndChange.coffee);
		System.out.println(coffeeAndChange.change);
		
		System.out.println(coffeeMachine.moneypot);
		
		
		
		
	}

	public static void main(String[] args) {
		ex02();
		

	}
	}
