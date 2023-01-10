package ex01_field;

public class User { // 이런 정보를 저정할 수 있는 데이터

	/*
	 	필드
	 	1. 클래스가 가지는 변수
	 	2. 일반 변수와 달리 자동으로 초기화된다.
	 */
	
	String id;      // 아이디 (null)
	String pw; 	    // 비밀번호 (null)
	int point;		// (0)
	boolean isVip; 	// 이 사용자가 Vip인지 확인 (false)
	Address addr; 	// null
		
}
