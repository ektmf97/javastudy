package ex05_exception_class;

public class Gun {
	
	private int bullet; // 총알
	private static final int MAX_BULLET = 10; // 최대 10개 총알 
	
	// 총알 넣기 
	public void reldad(int bullet) throws GunException { // 총알을 몇 발 넣을건지 받아오기
		if(this.bullet + bullet > MAX_BULLET) { // 미리 계산 해봤는데 최대 총알보다 내 총알이 크다면 
			throw new GunException ("장전 불가능","A-1");
		}
		this.bullet += bullet; // 아닌경우 총알을 넣어줘라
		System.out.println(this.bullet + "발 장전 완료");
	}
	
	// 총 쏘기
	public void shoot() throws GunException{
		if(bullet == 0) {
			throw new GunException("총알 부족 ","A-2");
			
		}
		bullet--;
		System.out.println("빵!!!!!" + bullet + "발 남았음" );
	}

	// bullet get,set 만들어주기 
	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
}
