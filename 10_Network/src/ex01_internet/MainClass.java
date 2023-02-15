package ex01_internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MainClass {

	/* ★ 자세하게 듣기 (다음주 수요일 평가문제 1개 나옴) 
	 	URL
	 	1. Uniform Resource Locator
	 	2. 정형화된 자원의 경로 
	 	3. 실제로는 웹 주소를 의미한다.
	 	4. 구성
	 	 프로토콜://     호스트      /  서버경로 ?  파라미터= 값&파라미터=값...
	 		https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=삼성전자
			1) 프로토콜 : 데이터를 주고 받을 때 사용하는 통신규약 , https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
			2) 호스트 	: 서버의 대표 주소  
			3) 서버경로 : URL Mapping(URL Pattern)
			4) 파라미터 : 서버로 보내는(전달하는) 데이터를 의미(변수라고 생각하면 된다.)
	 */
	
	public static void ex01() {
		
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		URL url = null;
		
		try {
			
			url = new URL(apiURL); // 반드시 예외 처리가 필요한 코드
			
			System.out.println("프로토콜 : " + url.getProtocol()) ;
			System.out.println("호스트   : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery() );
			
		}catch (MalformedURLException e) { // 잘못된 모양 
			System.out.println("apiURL 주소 오류");
		}
		
		
	}
	
	public static void ex02() { // 응답코드 
	
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null; 
		try {
			url = new URL(apiURL); // MalformedURLException 처리가 필요하다.
			con = (HttpURLConnection)url.openConnection(); // IOException 처리가 필요하다.
			
			/*
			  	HTTP 응답 코드 공부하기
			  	1. 200 : 정상접속 
		  		2. 40X : 400번대 번호 잘못된 요청(사용자가 잘못하였음)
		  		3. 50X : 500번대 에러 서버측 오류
			*/
			
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK); // HttpURLConnection.HTTP_OK <- 200 뜻
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND); //404
			System.out.println("Internal : " + HttpURLConnection.HTTP_INTERNAL_ERROR );//500
			
			// apiURL 접속 확인
			int responseCode = con.getResponseCode();
			if(responseCode ==  200) {
				System.out.println(apiURL + " 접속 완료");
				
			}
			
			// 요청 방식(요청 메소드) ★앞으로 많이사용 
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod);
			
			// 컨텐트 타입(웹 상으로 주고 받는 데이터 타입)
			String contentType = con.getContentType();
			System.out.println("컨텐트 타입 : " + contentType);
			
			// 요청 헤더 
			String userAgent = con.getRequestProperty("User-Agent");
			System.out.println("User-Agent" + userAgent);
			
			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer); // 이전 주소가 나옴 새 주소로 넘어가기 전 
			
			// 접속 종료
			con.disconnect();
			
		}catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		}catch(IOException e) {
			System.out.println("apiURL 접속 오류");
		}
	}
	
	public static void ex03() { // 로고 다운로드 받기 (속도를 빠르게 하기 위해서 버퍼사용)
	
		String apiURL= "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;
		 
		BufferedInputStream in = null; // Daum 로그를 읽어 들이는 입력 스트림
		BufferedOutputStream out = null; // C:\storage\daum.png로 내보내는 출력 스트림
		File file = new File("C:" + File.separator + "storage","daum.png");
		
		try {
			
			url = new URL(apiURL);
			con =(HttpURLConnection) url.openConnection();
			
			int responstCode = con.getResponseCode();
			if(responstCode == HttpURLConnection.HTTP_OK){ //접속 되었다면 작업을 수행하겠다.
				
				in = new BufferedInputStream(con.getInputStream());
				out = new BufferedOutputStream(new FileOutputStream(file)); 
				
				//바이트 읽어들일 준비 
				byte[] b = new byte[10];
				int readByte = 0; 
				
				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte);
				}
				
				System.out.println("다운로드 완료");
				
				out.close();
				in.close();
				con.disconnect();
			}
		}catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		}catch (IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
	}
	public static void ex03_1 () { // 나혼자 연습 (버퍼 쓰기전 코드) 
		
		String apiURL = "https://w7.pngwing.com/pngs/1007/564/png-transparent-java-script-logo-javascript-web-development-logo-script-text-computer-programming-internet-thumbnail.png";
		URL url = null;
		HttpURLConnection con = null;
		
		InputStream in = null;
		FileOutputStream out = null;
		
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responstCode = con.getResponseCode();
			if(responstCode == HttpURLConnection.HTTP_OK);
			
			in = con.getInputStream();
			out = new FileOutputStream("C:" + File.separator + "storage" + File.separator + "java.png");
			
			byte[] c = new byte[10];
			int readByte = 0;
			
			while((readByte = in.read(c)) != -1) {
				out.write(c, 0, readByte);
				
			}
			
			System.out.println("다운로드 완료");
			in.close();
			out.close();
			con.disconnect();
			
		}catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ex04() { // 문서 다운받기 (txt 다운로드)
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		
		URL url = null;
		HttpURLConnection con = null;
		
		InputStreamReader reader = null;
		FileWriter writer = null; 
		
		// 경로
		File file = new File("C:" + File.separator + "storage","다운로드문서.txt");
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new InputStreamReader(con.getInputStream()); // 네트워크는 바이트 스트림 바이트 스트림이 제공되면 캐릭터 스트림으로 변환해서 사용해야한다.
			}else {
				reader = new InputStreamReader(con.getErrorStream()); 
				
			}
			
			// 준비 
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2];
			int readCount = 0;
			
			while((readCount = reader.read(cbuf))!= -1) {
				sb.append(cbuf, 0, readCount);
			}
				
			writer = new FileWriter(file);
			writer.write(sb.toString()); // 스트링빌더에 저장된 모든 파일을 한번에 내보냄
			
			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println("다운로드 완료");
			
			}catch(MalformedURLException e) {
				System.out.println("apiURL 주소 오류");
			}catch(IOException e) {
				e.printStackTrace();
			
		}
		
	}
	public static void ex04_1() { // 문서 다운받기 (버퍼이용)
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null; 
		
		// 경로
		File file = new File("C:" + File.separator + "storage","다운로드문서.txt");
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream())); // 네트워크는 바이트 스트림 바이트 스트림이 제공되면 캐릭터 스트림으로 변환해서 사용해야한다.
			
			
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
			}
			
			// 준비 
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2];
			int readCount = 0;
			
			while((readCount = reader.read(cbuf))!= -1) {
				sb.append(cbuf, 0, readCount);
			}
				
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString()); 
			
			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println("다운로드 완료");
			
			}catch(MalformedURLException e) {
				System.out.println("apiURL 주소 오류");
			}catch(IOException e) {
				e.printStackTrace();
			
		}
		
	}
	public static void ex04_2() { //실패 
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/63d8848f7d506.txt";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null; 
		File file = null;
		// 경로
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			String message = null;
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream())); // 네트워크는 바이트 스트림 바이트 스트림이 제공되면 캐릭터 스트림으로 변환해서 사용해야한다.
				file = new File("C:" + File.separator + "storage","다운로드문서.txt");
				message = "다운로드 성공";
			
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				file = new File("C:" + File.separator + "storage", "다운로드실패.html");
				message = "다운로드 실패";
				
			}
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2];
			int readCount = 0;
			
			while((readCount = reader.read(cbuf))!= -1) {
				sb.append(cbuf, 0, readCount);
			}
				
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString()); 
			
			writer.close();
			reader.close(); 
			con.disconnect();
			
			System.out.println(message);
			
			}catch(MalformedURLException e) {
				System.out.println("apiURL 주소 오류");
			}catch(IOException e) {
				e.printStackTrace();
			
		}
		
	}
	
	public static void ex05() { // 인코딩 디코딩
		
		/*
		 	인코딩(암호화) : 원본 데이터를 UTF-8 방식으로 암호화
		 	디코딩(복호화) : UTF-8 방식으로 암호화된 데이터를 복원
	
		 */
		
		String data = "한글 english 12345 !@#$+-";
		
		try {
			
			// 인코딩
			String encodeData = URLEncoder.encode(data, "UTF-8");
			System.out.println(encodeData);
			
			// 디코딩
			String decodeData = URLDecoder.decode(encodeData, "UTF-8");
			System.out.println(decodeData);
			
		}catch(UnsupportedEncodingException e){
			System.out.println("인코딩 실패");// 지원되지 않는 인코딩이다.
		}
	}
	
	public static void ex06() { // 연습
		
		// 1시간마다 갱신되는 전국 날씨 정보 
		
		String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		
		// storage/sfc_web_map.xml로 다운로드 받기
		
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader re = null;
		BufferedWriter wr = null;
		// storage/sfc_web_map.xml로 다운로드 받기
		
		File file = new File("C:" + File.separator + "storage","날씨정보.xml");
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				re = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
			}else {
				re = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[4];
			int readCount;
			
			while((readCount = re.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
			
			wr = new BufferedWriter(new FileWriter(file));
			wr.write(sb.toString());
			
			wr.close();
			re.close();
			con.disconnect();
			
			System.out.println("다운로드 완료");
			
			}catch (MalformedURLException e) {
				System.out.println("apiURL 주소 오류");
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		
	
			}
				
		
	public static void main(String[] args) {
	
		ex06();
	}

}
