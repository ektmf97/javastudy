package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {

	public static void ex01() {
		
		// 클래스를 로드하는 방법
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // oracle.jdbc.driver.OracleDriver 경로도 가능 
			System.out.println("클래스가 로드되었습니다.");
			// 클래스 앞에 첫 글자 대문자
			// 클래스 이름 클래스로 부르기 
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
	
		// Oracle DataBase와 연결할 때 사용하는 Connection 클래스
		
		Connection con = null; // 선언만 한다 이유는 예외처리가 필요하기 때문에 
		
		// Oracle 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "GDJ61";
		String password = "1111";
		
		// DriverManager 클래스로부터 Connection 객체를 받아 온다.
		
		try {
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB에 접속되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		// 사용이 끝난 Connection 객체는 반드시 닫아야 한다.
		try {
			if(con != null) {
				con.close();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ex02();
		
		
	}

}
