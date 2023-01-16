package practice_BankAccount;

public class BankAccount {

	// 필드 
	private long balance; // 계좌 잔액
	private String accNo; // 계좌 번호
	
	// 생성자
	
	public BankAccount (String accNo, long balance)	{
		this.accNo = accNo;
		this.balance = balance;
		
	}
	
	// 메소드(입금, 출금, 이체, 조회)
	
	// 1. 입금(마이너스 입금 불가 처리)
	public void deposit(long money) {// 반환이 없다(void)
		if(money <= 0) { // 0 이랑 같아도 메소드 종료 ( 통장에 0원이 안찍음) if(money < 0) <- 0원도 찍힘
			return;// 메소드 종료. 오직 반환이 void인 경우에만 사용 가능.
		}
		balance += money;
	}
	
	// 2. 출금(마이너스 출금 + 잔액보다 큰 출금 불가 처리)
	public long withdrawal(long money) {
		if(money <= 0 || money > balance) { 
			return 0; // 0원 돌려준다. 반환 타입 있을때는 그냥 종료 못한다 얼마를 반환해야 하는지 역활
		}
		balance -= money;
		return money;// 요청한 금액 반환
	}
	
	// 3. 이체 
	public void transfer(BankAccount other, long money) { // 누구에게 얼마를 보내주세요. 
		// 1. 내 통장에서 money 출금 : withdrawal(money) // this.withdrawal는 구지 안적음
		// 2. 상대 통장에 실제로 내 통장에서 출금된 금액 입금 : other.deposit(withdrawal(money))
		
		other.deposit(withdrawal(money));
	}
	
	// 4. 조회
	public void inquiry()	{
		System.out.println("계좌번호: " + accNo);
		System.out.println("잔액 : "  + balance + "원");
		
	}
}
