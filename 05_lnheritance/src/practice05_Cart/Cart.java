package practice05_Cart;

public class Cart {

	// 제품을 여러개 담는다
	
	// 카트 관리 
	private Product[] products; 	// 배열 선언 
	private int prodCount;			// 카트 관리할 때 필요한 프로덕의 개수 
									// 실제로 products 배열에 저장된 product의 개수 
	
	// new Cart(10), new Cart(20)    카트 두 가지 만들기 
	public Cart(int cartSize) {
		products = new Product[cartSize]; // 배열 생성
		prodCount = 0; // 현재 카트에 들어있는 제품은 0개 안 써도 됨 필드 초기값이 0이라서 
	}
	
	
	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}
	public int getProdCount() {
		return prodCount;
	}
	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	
	// 실제로 구현 해줘야 할 메소드
	
	// 카트에 물건 담기
	// addProduct(new Meat(1, "소고기" , 5000)
	// addProduct(new Pizza(2, "고구마피자", 3000)
	// addProduct(new Noodle (3, "누들면",1500);
	public void addProduct(Product product) { // 물건을 담아와서 배열에 입력 자식 객체를 부모 객체로 사용 
		// 카트가 가득 차면 물건을 담지 못한다.
		if(products.length == prodCount ) {
			System.out.println("카드가 가득 찼습니다.");
			return;
		}
		// 카트에 물건 담기 addProduct완성 
		products[prodCount++] = product; // 변수가 늘어야 한다. 제품의 개수가 늘었으니까 prodCount 사용하고 늘리기 
	}
	
	
	// 카트에 물건 빼기 
	// deletProduct(1)
	// deletProduct(2)
	// deletProduct(3)
	public void deletProduct(int prodNo) {
		
		// 카트가 비어 있으면 뺄 문건이 없다.
		if(prodCount == 0) {
			System.out.println("카트가 비어있습니다.");
			return;
		}
		
		// 카트에서 물건 빼기 
		for(int i = 0; i < prodCount; i++ ) { 
			if(products[i].getProdNo() == prodNo) {
				products[i] = products[--prodCount]; // 마지막 물건을 뺀 물건 자리로 옮기기 
				break; // for문 끝내주기
				
			
			}
		
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
