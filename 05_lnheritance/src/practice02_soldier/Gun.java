package practice02_soldier;

	/*
	 	has a 관계 
	 	1. 상속 관계로 만들 수 있는 관계이다.
	 	2. Soldier has a Gun
	 	3. 자식 has a 부모  (총이 부모, 자식이 군인)
	 	Soldier가 Gun의  관계를 사용한다.
	 */

public class Gun {

	// 필드
	private String model;
	private int bullet;
	private final int MAX_BULLET = 20;
	
	// 메소드 
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getBullet() {
		return bullet;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	// 총알 넣기(장전)
	public void reload(int bullet) { // 총알을 몇개 넣어준다.
	/*	if(bullet)  // 이건 받아온 총알
	 
	 */
		if(this.bullet == MAX_BULLET ) { // 넣을 필요 없을 때
			return;
		}
		this.bullet += bullet; // 아니라면 총알을 
		this.bullet = (this.bullet > MAX_BULLET) ? MAX_BULLET : this.bullet;
		// 현재 들어있는 총알을 바꾸겠다.
		// 총알이 20발이 넘어가면 20발로 하자 . 20발이 안 넘어가면 그대로 쓰자.
	}
	
	// 총 쏘기 
	public void shoot () {
		if(this.bullet == 0) {
			System.out.println("헛빵"); // 총알이 0개면 헛빵을 실행
			return;
		}
		bullet--; // 매개변수랑 구분할 필요 없기 때문에 this.bullet라고 안 적어도 된다.
			System.out.println("빵");  // 총알이 들어 있으면 빵을 실행 
	}
}
