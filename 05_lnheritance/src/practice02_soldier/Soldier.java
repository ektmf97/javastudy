package practice02_soldier;

public class Soldier {

	// 필드
	private Gun gun;// 군인이 총을 가지고 있다. 초기값은 null 
	
	// 생성자
	public Soldier() {
		gun = new Gun(); // 상속 분리 
	}
	// 메소드
	public void reload(int bullet) {
		gun.reload(bullet); // 내 총에 장전을 하겠다.
	}
	
	public void shoot() {
		gun.shoot();
		
	}
	
}
