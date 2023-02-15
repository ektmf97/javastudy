package ex01;

public class BankAccount {

	// 필드
	private long balance; // 계좌 잔액
	private String accNo; // 계좌 번호
	// 생성자
	public BankAccount(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	// 메소드
	
	// 1. 입금(마이너스 입금 불가 처리 )
	public void deposit(long money) {
		if(money <= 0) {
			return;
		}	
			balance += money;
	}
	// 2. 출금(마이너스 출금 + 잔액보다 큰 출금 불가 처리)
	public long withdrawal(long money) {
		if(money <= 0 || money > balance) {
			return 0;
		}
		balance -= money;
		return money;
	}
	
	// 3. 이체
	public void transfer(BankAccount other, long money) {
		other.deposit(withdrawal(money));
		}
	// 4. 조회 
	
	public void inquiry () {
		System.out.println("계좌번호 : " +accNo) ;
		System.out.println("잔액 : " + balance + "원");
		}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

