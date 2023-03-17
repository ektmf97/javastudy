package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberTableMainClass {

	public static void main(String[] args) {
		
		/* 1. Connection 생성 첫 번째 */
		
		Connection con = null;  // Connection 선언
		
		try {
			
			// 오라클 드라이버 로드를 수행
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 프로퍼티 파일 읽어서 프로퍼티 객체 생성
			// 우리가 만든 프로퍼티는 이름이 정해져 있지 않다. / 나중에는 프로퍼티 이름이 정해져 있다.
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			// 프로퍼티 객체에 저장된 각 프로퍼티(속성) 가져오기
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			// Connection 생성
			con = DriverManager.getConnection(url, user, password);
			
			
		}catch(Exception e){ 
			e.printStackTrace();
			
		}

		/* 2. 쿼리문 작성 및 실행 */
		
		/*
		 	PreparedStatement 인터페이스 준비된 구문이란 뜻
		 	1. Prepared  : 미리 준비하시오.
		 	2. Statement : 쿼리문을 
		 	3. 작성된 쿼리문을 전달하면 해당 쿼리문을 실행해 주는 역할을 수행한다.
		 	4. Statement 인터페이스는 보안 문제로 사용하지 않는 것이 좋다. 
		 */
		
//		SELETE * FROM ID = 변수 AND PW = 변수;
//		
//		아이디에 입력한 값 	 : SELETE * FROM ID = aaa OR 1 = 1 -- 
//		비밀번호에 입력한 값 : AND PW = aaa
//		
//		SELETE * FROM ID = aaa OR 1 = 1 -- AND PW = aaa;

		// 1. 쿼리문 미리 준비해주고 사용 
		// 주의! JDBC에서는 쿼리문의 마지막에 세미콜론(;)을 붙이지 않는다.
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE MEMBER_TBL ("); // 회원 테이블 
		sb.append("MEMBER_NO NUMBER NOT NULL"); // 회원 번호 PK
		sb.append(", ID VARCHAR2(30 BYTE) NOT NULL UNIQUE"); // 아이디 필수 중복금지
		sb.append(", NAME VARCHAR2(30 BYTE) NOT NULL"); // 이름 필수
		sb.append(", ADDRESS VARCHAR2(30 BYTE)"); // 주소 
		sb.append(", JOIN_DATE DATE NOT NULL"); // 가입일
		sb.append(", CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NO))"); // 가입일에 ) 안 넣어주고 마지막에 )) 두개
		
		// 스트링으로 바꿔주기
		String sql = sb.toString();
		
		// 2. PreparedStatement 선언
		PreparedStatement ps = null;
		
		try {
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행하기
			ps.execute();
			System.out.println("쿼리문이 실행되었습니다.");
			
		}catch (Exception e) { // 문제가 생겼다면 SQLException
			e.printStackTrace();
		}
		
		
		/* 3. 사용한 자원 반납하기 */
		
		try {
			
			if(ps != null) ps.close(); // ps 값이 널이 아니면 ps 종료
			if(con != null) con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
