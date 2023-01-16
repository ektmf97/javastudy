package ex03_method;

public class Car {

	// 필드
	int oilPot; 	// 기름통
	int carSpeed;  	// 자동차 속도 pushAccel 마다 속도는 10씩 증가, 최대 속도는 100, pushBrake 마다 속도 10씩 감소
	
	
	/*
	void addoil(int oil) {
		oilPot += oil; 		// 기름통에 전달받은 기름을 넣어준다.
		if(oilPot > 50) { 	// 기름통에 기름이 50보다 크면 50으로 잘라버리자.
			oilPot = 50;
		}
	}
			*/
	// 기름 넣기 메소드
		
	void addoil1(int oil) {
		if(oilPot + oil > 50) {
			oilPot = 50;
			return; 		// 메소드를 종료하시오. 반환값이 적어 주지 않으면 메소드를 종료하라고 해석도 가능.
							// 반환타입이 없을때만 사용가능 "void"인 경우에만 사용
			
		}
		oilPot += oil;
	}	
	// 달리기 메소드
	void pushAcce1() {	// 속도가 늘어난다.
		if(oilPot == 0 ) { //  속도랑 상관없이 기름을 줄인다.
			return;		
		}
		oilPot--;
	
		// 속도 처리 
		if(carSpeed + 10 > 100)	{ // 현재 자동차 속도에 100을 더했는데 100보다 커 
			carSpeed = 100; // 그냥 속도를 100으로 하자.
			return;
		}
		
		carSpeed += 10;		
	}
	// 멈추기 메소드
	void pushBrake() {  // 브레이크를 밟으면 속도가 줄어든다.
		if(carSpeed == 0) { // 현재 자동차 속도가 0일때
			return;
		}
		carSpeed -= 10;
		if(carSpeed < 0) { // 자동차 속도를 0으로 줄여 봤는데 0보다 작아
			carSpeed = 0; // 그냥 자동차 속도를 0으로 하자.
		}
		
		}
	
	}

