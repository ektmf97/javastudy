package ex03_insert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;


public class MainClass {

		
		// 상수 삽입
		public static void ex01() {
			
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				
				Properties p = new Properties();
				p.load(new BufferedReader(new FileReader("db.properties")));
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				con = DriverManager.getConnection(url, p);
				
				// con.setAutoCommit(false); jdbc는 커밋이 오토커밋 오토커밋을 안하고 싶을때 사용 
				
				String sql = "INSERT INTO  MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
				sql += " VALUES(MEMBER_SEQ.NEXTVAL, 'admin2', '관리자', '서울', TO_DATE('2023-02-15', 'YYYY-MM-DD'))";
			
				// 특정날짜 
				// 1. 오라클의 기본형식 11/11/11/ <- 직접적으로 년 월 일 순서 
				// 2. 날짜를 만드는 함수 사용 TO_DATE('사용할 날짜', '날짜 형식 ')
				
				ps = con.prepareStatement(sql);
				int insResult = ps.executeUpdate();
				
				System.out.println(insResult + "개의 행이 삽입되었습니다.");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) ps.close();  
					// ps를 먼저 닫아주는 이유는 나중에 만든걸 제일 먼저 닫아준다. 
					if (con != null)con.close();
					// 먼저 만든걸 나중에 닫기 
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// 변수 삽입
		public static void ex021() {
			
				
				Connection con = null;
				PreparedStatement ps = null;
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					
					Properties p = new Properties();
					p.load(new BufferedReader(new FileReader("db.properties")));
					
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					
					con = DriverManager.getConnection(url,p);
					
					String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
					sql += " VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
							
					ps = con.prepareStatement(sql);
					
					String id = "master";
					String name = "운영자";
					String address = "경기";
					
					ps.setString(1, id); // 첫번째 물음표(?) 자리에 id를 넣으시오.
					ps.setString(2, name); // 두번째 물음표 자리에 name을 넣으시오.
					ps.setString(3, address); // 세번째 물음표 자리에 address를 넣으시오.
					
					int insResult = ps.executeUpdate();
					
					System.out.println(insResult + "개의 행이 삽입되었습니다.");
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(ps != null) ps.close();
						if(con != null) con.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}

			
		public static void ex02() {
			
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Properties p = new Properties();
				p.load(new BufferedReader(new FileReader("db.properties")));
				
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				con = DriverManager.getConnection(url, p);
				
				String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
				// 변수처리
				sql += "  VALUES(_SEQ.NEXTVAL, ? , ? , ?, SYSDATE)";
				
				ps = con.prepareStatement(sql);
				
				String id = "master";
				String name = "운영자";
				String address = "경기";
				
				ps.setString(1, id); 		// 1번째 물음표(?) 자리에 id를 넣으시오.
				ps.setString(2, name); 		// 2번째 물음표(?) 자리에 name를 넣으시오.
				ps.setString(3, address);	// 3번째 물음표(?) 자리에 address를 넣으시오.
				
				int insResult = ps.executeUpdate();
				System.out.println(insResult + "개의 행이 삽입되었습니다.");
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(ps != null)ps.close();
					if(con != null)con.close();
				}catch (Exception e) { 
					e.printStackTrace();
				}
			}
		}

	public static void ex03() {
		// admin이 작성한 임의의 게시글을 삽입해 보자.
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
			
			String sql = "INSERT INTO BOARD_TBL(BOARD_NO, MEMBER_NO, TITLE, CONTENT, CREATE_DATE)";
			sql += " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			
			ps = con.prepareStatement(sql);
			
			int memberNo = 1;
			String title = "오늘은 목요일";
			String content = "보충이 취소되었소";
		
			ps.setInt(1, memberNo);
			ps.setString(2, title);
			ps.setString(3, content);
			
			int insResult = ps.executeUpdate();
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(ps != null)ps.close();
				if(con != null)con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
public static void main(String[] args) {
	ex021();
}

}