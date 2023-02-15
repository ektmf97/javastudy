package ex01;

public class MainClass {

	public static void main(String[] args) {
		BankAccount myAcc = new BankAccount("010-1111-1111", 50_000);
		BankAccount yourAcc = new BankAccount("010-9999-9999", 100_000);
		
		myAcc.transfer(yourAcc, 50_000);
		
		// 성공, 실패 확인 
		myAcc.inquiry(); 
		yourAcc.inquiry();
		

	}

}
