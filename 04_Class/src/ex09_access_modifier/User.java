package ex09_access_modifier;

public class User {

	/*
	 	접근 제어 지시자(access_modifier)
	 	1. private 	: 클래스 내부에서만 접근할 수 있다.
	 	2. default 	: 동일한 패키지에서만 접근할 수 있다.
	 	3. protected : 동일한 패키지 또는 상속 관계의 클래스에서만 접근할 수 있다.
	 	4. public	: 누구나 접근할 수 있다.
	 */
	
	/*
	 	정보 은닉(Information Hiding)
	 	1. 클래스의 내부 정보를 외부에 노출하지 않는 것을 만한다.
	 	2. 클래스의 내부 정보는 "필드"를 의미하므로 "필드"값을 외부에 공개하지 않는 것을 말한다.
	 	3. "필드"는 private 하게 처리한다.
	 	4. "메소드"는 public 하게 처리한다. "필드"에 접근하기 위해서는 "메소드"를 통해서 접근해야 한다.
	 */
	/*
	 	Getter와 Setter
	 	1. Getter
	 		1) 필드값을 외부로 반출하는 메소드 
	 		2) get + 필드 이름을 가지는데 이를 수정하면 안 된다.
	 	2. Setter
	 		1) 외부로부터 필드값ㄷ을 받아오는 메소드
	 		2) set + 필드 이름을 가지늗네 이를 수정하면 안 된다.
	 */
	
	// 필드
	private String id;	// default 접근 권한( String id)
	private String pw;
	private boolean isVip; // vip 회원여부

	// 메소드
	
	public String getId() { // 메소드를 시작할 때 public를 맨 앞에 넣어주기
		return id;// 직접 id를 접근 못하니까 메소드를 통해 필드에 접근한다.(간접 접근 허용)
	}
	public void setId(String id) { // 필드 안에 있는 id 전달해주기
		this.id = id;	// id를 반화시켜주기	
	}
	// 메소드
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) { // 필드 밖으로 클래스를 빼주는 메소드
		this.pw = pw;
	}
	// 메소드
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	
	}


