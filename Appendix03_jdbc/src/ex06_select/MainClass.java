package ex06_select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainClass {

	public static void ex01() {
		
	
		// select 결과 행이 1개 인 경우
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 오직 SELECT문에서만 사용한다.
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
			
			String sql = "SELECT MEMBER_NO , ID, NAME, ADDRESS, JOIN_DATE";
			sql += " FROM MEMBER_TBL";
			sql += " WHERE MEMBER_NO = ?";
			
			ps = con.prepareStatement(sql);
			
			// 변수처리
			int memberNO = 2;
			ps.setInt(1, memberNO);
			
			rs = ps.executeQuery(); // SELECT문 실행 메소드
			
//			System.out.println(rs.next()); // 첫 번째 결과 행이 있으면 true, 없으면 false
//			System.out.println(rs.next()); // 두 번째 결과 행이 있으면 true, 없으면 false
			
			// Member 객체 선언
			Member member = null;
			
			// 결과 행이 최대 1개 있으므로 if문으로 분기 처리
			 if(rs.next()) {
				 
				 // 결과 행의 각 칼럼 정보 읽어서 Member 객체 만들기
				 member = new Member();
				 member.setMember_no(rs.getInt("MEMBER_NO"));
				 member.setId(rs.getString("ID"));
				 member.setName(rs.getString("NAME"));
				 member.setAddress(rs.getString("ADDRESS"));
				 member.setJoin_date(rs.getDate("JOIN_DATE"));
				 
			 } // else는 안 만든다. 아무일도 안할거기 때문에 
			 
			 // if문이 종료된 뒤, member가 null이라면 조회된 결과가 없었다는 의미가 된다.
			 System.out.println(member);
			/*
			 	| MEMBER_NO |   ID   |  NAME  | ADDRESS | JOIN_DATE | 최초 rs가 가리키는 위치 : 없음
			 	|    1      | admin  | 관리자 |  서울   | 23/02/15  | ← 첫 번째 rs.next() 호출한 경우
			 	|    2      | master | 운영자 |  경기   | 23/02/16  | ← 두 번째 rs.next() 호출한 경우
			 														  ← 세 번째 rs.next() 호출한 경우
			 	1. ResultSet rs 객체는 하나의 행(Row)을 가리키는 포인터 역활이다.
			 	2. next 메소드를 통해서 각 행(Row)을 가리킬 수 있다. 
			 		1) next 메소드를 1번 호출하면 SELECT 전체 결과 중 1행을 가리킨다.
					2) next 메소드를 2번 호출하면 SELECT 전체 결과 중 2행을 가리킨다.
					
				3. next 메소드의 호출 결과는 boolean이다.
					1) 조회된 결과 행이 있으면 true가 반환된다.
					2) 조회된 결과 행이 없으면 false가 반환된다.
					
				4. 결과 행의 칼럼 정보 가져오는 방법
				 	1) 칼럼의 이름 그대로 사용한다. 
				 		rs.getInt(" MEMBER_NO칼럼 이름 ")
				 		rs.getString(" ID ")
				 		rs.getString(" NAME ")
				 		rs.getString(" ADDRESS ")
				 		rs.getDate("JOIN_DATE")
				 	2) 결과 행의 칼럼 순서대로 번호를 붙여서 사용한다.
				 		rs.getInt(1)
				 		rs.getString(2)
				 		rs.getString(3)
				 		rs.getString(4)
				 		rs.getDate(5)
				 		
			 */
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(ps != null)ps.close();
				if(con != null)con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void ex02() {
				
				// 결과 행이 2개 이상인 경우
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null; // 오직 SELECT문에서만 사용한다.
				
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
					
					Properties p = new Properties();
					p.load(new BufferedReader(new FileReader("db.properties")));
					
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					
					con = DriverManager.getConnection(url, p);
					
					String sql = "SELECT MEMBER_NO , ID, NAME, ADDRESS, JOIN_DATE";
					sql += " FROM MEMBER_TBL";
					sql += " WHERE MEMBER_NO = ?";
					
					ps = con.prepareStatement(sql);
					
					// 변수처리
					int memberNO = 3;
					ps.setInt(1, memberNO);
					
					rs = ps.executeQuery(); // SELECT문 실행 메소드는 executeQuery()이다.
					
					// 결과 행이 여러 개 있으므로 ArrayList를 준비한다.
					List<Member> memberList = new ArrayList<Member>();
				
					// 결과 행이 여러 개 있으므로 while문으로 분기 처리
					 while(rs.next()) { 
						 
						 // 결과 행의 각 칼럼 정보 읽어서 Member 객체 만들기
						 Member member = new Member();
						 member.setMember_no(rs.getInt("MEMBER_NO"));
						 member.setId(rs.getString("ID"));
						 member.setName(rs.getString("NAME"));
						 member.setAddress(rs.getString("ADDRESS"));
						 member.setJoin_date(rs.getDate("JOIN_DATE"));
						 
						 // Member 객체를 ArrayList에 저장하기
						 memberList.add(member); // add: 추가
						 
					 } 
					 
					 // while문이 종료된 뒤, ???이라면 조회된 결과가 없었다는 의미가 된다.
					 for(int i = 0; i < memberList.size(); i++) {
						 System.out.println(memberList.get(i));
					 }
				
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs != null)rs.close();
						if(ps != null)ps.close();
						if(con != null)con.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}

		
	}
	public static void main(String[] args) {
		ex02();
	}
	}
