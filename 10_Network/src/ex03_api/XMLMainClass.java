package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



public class XMLMainClass {

	
	public static void ex01() {
		
		/*
		 	한국공항공사_항공기 운항정보 : 공항 코드 정보
		 	1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		 	2. 요청변수(Request Parameter)
		 		1) ServiceKey : 인증키를 의미한다.
		*/
	
		String serviceKey = "ztaE5KsIFSOYcxrR6Pc3gp104FQSHOp4HOMmlu+I3/mkkr9/syCHNjMjbL3oP0Kd7oLE9xvoM24rzN41cQuXUg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		
		// 접속을 위한 단계
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null; 
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8");
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			// 요청 메시지 작성
			con.setRequestMethod("GET"); // 항상 대문자로 작성 소문자X 요청 파라미터를 주소창에 붙혀서 보내는 방식은 GET
			// xml의 문서의 데이터 타입
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); // ; 
			
			int responseCode = con.getResponseCode();
			// 입력스트림
			if(responseCode == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				
			}
			// 입력  (내려받기)
			String line =null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine())!= null) {
				sb.append(line + "\n");
			}
			reader.close();
			con.disconnect();
			
			
			// 파일 보내기 생성
			File file = new File("C:" + File.separator + "storage","공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("공항코드정보.xml이 생성되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}
		
	}
	
	public static void ex02() {
		
		/*
	 	한국공항공사_항공기 운항정보 : 국제선 운행 스케줄
	 	1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
	 	2. 요청변수(Request Parameter)
	 		1) ServiceKey : 인증키를 의미한다.
	 		2) pageNo : 페이지번호
	 		3) schDate : 검색일자
	 		4) schDeptCityCode : 출발도시코드
	 		5) schArrvCityCode : 도착도시코드
	 		
		 */
		String serviceKey = "ztaE5KsIFSOYcxrR6Pc3gp104FQSHOp4HOMmlu+I3/mkkr9/syCHNjMjbL3oP0Kd7oLE9xvoM24rzN41cQuXUg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8");
			apiURL += "&pageNo=1";
			apiURL += "&schDate=20230201";
			apiURL += "&schDeptCityCode=ICN";
			apiURL += "&schArryCityCode=JFK";
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			con.disconnect();
		
			File file = new File("C:" + File.separator + "storage","국제선 운항스케줄.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선 운항스케줄.xml이 생성되었습니다.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ex02();

	}

}
