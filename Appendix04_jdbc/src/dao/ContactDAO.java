package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.ContactDTO;

/*
 	DAO
 	1. Database Access Object
 	2. Database에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받아온다.
 	3. 여러 객체가 만들어 지지 않도록 singleton 패턴으로 생성한다.
 	
 */
public class ContactDAO {
	
	/********* 1. singleton**********/
	private static ContactDAO dao = new ContactDAO(); 			// 미리 하나 다오를 만든다. 내부에서는 호출가능 외부에서는 NEW가 안된다
	private ContactDAO() { } 									// 디폴트 생성자 만들어 준다. 프라이빗으로 외부에서는 못 만드세요.
	public static ContactDAO getInstance() { 					// 외부 사람들은 getInstance 메소드만 보인다. 내가 만들어 둔 다오를 가져다 써라
		return dao;
	}
	
	public void  목록보기() { }
	
	

	/********* 2. field **********/
	// ContactDAO 클래스의 메소드들이 공통으로 사용할 요소를 선언한다.
	private Connection con;   		// DB 접속
	private PreparedStatement ps; 	// 쿼리문 실행
	private ResultSet rs; 			// SELECT 결과
	private String sql;				// 쿼리문 자체
	private int res;  				// INSERT, UPDATE, DELETE 결과
	
	
	/********* 3. method **********/
	
	// CRUD (DB 기본작업) : CREATE(INSERT), READ(SELECT), UPDATE, DELETE
	
	// CRUD 메소드의 진행 순서 : Connection 얻기 -> CRUD 작업 -> 사용한 자원 반납
	// 화장실을 몇번을 가든 화장실 열쇠를 얻고 볼일 보고 화장실 열쇠 반납하기
	
	// 공통 메소드 - 1 (Connection 얻기)
	private Connection getConnection() {

		
		
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			con = DriverManager.getConnection(p.getProperty("url"), p);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 공통 메소드 - 2 (사용한 자원 반납)
	private void close() {
		try {
			if(rs != null)rs.close();
			if(ps != null)ps.close();
			if(con != null)con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// CRUD 메소드 - 1 (연락처 추가하기)
	// 1. 반환값 : 0(실패) 또는 1(성공)
	// 2. 매개변수 : ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다.
	public int insertContact(ContactDTO contact) {
	// 삽입할 연락처 정보를 매개변수로 받아온다. / import 해주기
		
		
		try {
			
			// 1. con은 필드로 사용해논 커넥션
			con = getConnection();
			// 2. 쿼리문 작성
			sql = "INSERT INTO CONTACT_TBL(CONTACT_NO, NAME, TEL, EMAIL, ADDRESS) VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ? )";
			// 3. 쿼리문 실행 객체 PS만들기
			ps = con.prepareStatement(sql);
			// 4. 변수(?) 채우기  get를 불러서 실행해서 ps변수자리에 채워준다.
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			//
			res = ps.executeUpdate();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
			}
		return res;
		}
		
		
	// CRUD 메소드 - 2 (연락처 삭제하기)	
	// 1. 반환값 : 0(실패) 또는 1(성공)
	// 2. 매개변수 : int contact_no 변수에는 삭제할 연락처의 고유 번호가 저장되어 있다.
	public int deleteContact(int contact_no) {
		
		try {
			
			con = getConnection();
			sql = "DELETE FROM CONTACT_TBL WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			
			res = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	// CRUD 메소드 - 3 (이름을 이용한 연락처 조회하기)
	// 1. 반환값 : List<ContactDTO> // 연락처가 여러 개 나올 수 있어서 LIST
	// 2. 매개변수 : String name 변수에는 조회할 연락처의 이름이 저장되어 있다.
	public List<ContactDTO> selectContactsByName(String name){
		
		List<ContactDTO> contactList = new ArrayList<ContactDTO>();
		
		try {
			
			con = getConnection();
			sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery(); // 셀렉트 실행 메소드
			
			while(rs.next()) { // 조회 결과가 있으면
				
				// 해당 조회 결과 rs 객체는 행 단위로 처리한다.
				 ContactDTO contact = new ContactDTO();
				 contact.setContact_no(rs.getInt("CONTACT_NO"));
				 contact.setName(rs.getString("NAME"));
				 contact.setTel(rs.getString("TEL"));
				 contact.setEmail(rs.getString("EMAIL"));
				 contact.setAddress(rs.getString("ADDRESS"));
				 
				 // 해당 연락처를 리스트에 추가해주기
				 contactList.add(contact);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return contactList;
	}
	
	// CRUD 메소드 - 4 (연락처 수정하기)
	// 1. 반환값 : 0(실패) 또는 1(성공)
	// 2. 매개변수 :  ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다.
	public int updateContact(ContactDTO contact) {
		
		try {
			
			con = getConnection();
			sql  = "UPDATE CONTACT_TBL";
			sql += "   SET NAME = ?, TEL = ?, EMAIL = ?, ADDRESS = ?";
			sql += "  WHERE CONTACT_NO = ?"; // 조건 번호를 이용해서 
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			ps.setInt(5, contact.getContact_no());
			res = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}

	// CRUD 메소드 -5 (연락처 No를 이용한 연락처 조회하기)
	// 1. 반환값 : ContactDTO 
	// 2. 매개변수 :  int contact_no 변수에는 조회할 연락처의 고유 번호가 저장되어 있다.
	public ContactDTO selectContactByNo(int contact_no) {
		
		ContactDTO contact = null; // null값이 반환되도 가능하다 초기값이 null이기 때문에 
		
		try {
			con = getConnection();
			sql  = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				contact = new ContactDTO(); // 결과가 있으면 DTO를 만들어라.
				contact.setContact_no(contact_no);
				contact.setName(rs.getString(2));
				contact.setTel(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setAddress(rs.getString(5));
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return contact; 
		}
	
		// CRUD 메소드 - 6 (전체 연락처 조회하기)
		// 1. 반환값 : List<ContactDTO> // 연락처가 여러 개 나올 수 있어서 LIST
		// 2. 매개변수 : 없다.
		public List<ContactDTO> selectALLContacts(){
			
			List<ContactDTO> contactList = new ArrayList<ContactDTO>();
			
			try {
				
				con = getConnection();
				sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
				sql += "  FROM CONTACT_TBL";
				sql += " ORDER BY CONTACT_NO DESC"; // 최근에 등록한 연락처가 맨 위로 정렬
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery(); // 셀렉트 실행 메소드
				
				while(rs.next()) { // 조회 결과가 있으면
					
					// 해당 조회 결과 rs 객체는 행 단위로 처리한다.
					 ContactDTO contact = new ContactDTO();
					 contact.setContact_no(rs.getInt("CONTACT_NO"));
					 contact.setName(rs.getString("NAME"));
					 contact.setTel(rs.getString("TEL"));
					 contact.setEmail(rs.getString("EMAIL"));
					 contact.setAddress(rs.getString("ADDRESS"));
					 
					 // 해당 연락처를 리스트에 추가해주기
					 contactList.add(contact);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return contactList;
		}
		
	}
