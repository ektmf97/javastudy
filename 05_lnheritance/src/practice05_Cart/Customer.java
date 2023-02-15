package practice05_Cart;

public class Customer {

	private int myMoney;
	private int myPoint;
	private Cart myCart; // 선언 
	
	// 고객 만들기 
	// 생성자 
	public Customer(int myMoney, int myPoint) {
		this.myMoney = myMoney;
		this.myPoint = myPoint;
		this.myCart = new Cart(10); // 생성 
	
	}

	public int getMyMoney() {
		return myMoney;
	}

	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}

	public int getMyPoint() {
		return myPoint;
	}

	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}

	public Cart getMyCart() {
		return myCart;
	}

	public void setMyCart(Cart myCart) {
		this.myCart = myCart;
	}
	
	// Customer 구현 
	
	// 카트에 물건 담기
	public void addToCart(Product prouct) { // 어떤 물건 담는지 받아와서 
		myCart.addProduct(prouct); 			// 호출하기 
	
	}
	// 카트에서 물건 빼기
	public void deleteFromCart(int prodNo) {
		myCart.deletProduct(prodNo);
	}
	
	// 구매
	// 구매하면 영수증을 String형태로 반환 
	public String buy() {
		
		int buyMoney = 0; // 구매한 물건들의 가격 합계
		int buyPoint = 0; // 구매한 물건들의 가격에 의한 포인트
		
		String receipt = "-------영수증-------\n"; // 영수증
		
		// 하나씩 잡히는 반복문 작성
		for(int i = 0; i < myCart.getProdCount(); i ++) { // 카트에 들어있는 배열 생성
			
			
			Product product = myCart.getProducts()[i];// 실제 카트에서 꺼낸 물건 1개
			buyMoney += product.getProdPrice();
			buyPoint += product.getProdPrice() * 0.05; // 제품가격의 5%를 포인트로 지급
			receipt += product.getProdName() + "   " + product.getProdPrice() + "원\n";// 한줄에 하나만 나오도록 줄바꿈
			
			//구매가 불가능한 경우 : 돈이 부족함
			if(myMoney < buyMoney) {
				System.out.println("돈이 부족합니다. 구매를 종료합니다.");
				return ""; // 영수증이 안 나온다. return null; 이것도 가능 
			}
		}
		
		myPoint += buyPoint; // 내가 구매한 포인트 만큼 포인트가 늘어야 하고
		myMoney -= buyMoney; // 내가 구매한 돈 만큼 돈이 줄어야 한다.
		
		receipt += "---------------------\n";
		receipt += "발생한 포인트" + buyPoint + "점\n";
		receipt += "보유 포인트" + myPoint + "점\n";
		receipt += "구매총액 " + buyMoney + "원\n";
		return receipt;
	}	
}
