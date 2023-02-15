package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import sun.awt.image.BufferedImageDevice;

public class ApiMain {

	public static void ex01() { // 내 코드
		
		
		
		
		String serviceKey = "ztaE5KsIFSOYcxrR6Pc3gp104FQSHOp4HOMmlu+I3/mkkr9/syCHNjMjbL3oP0Kd7oLE9xvoM24rzN41cQuXUg==";
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		// BufferedWriter writer = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&searchYear=2021");
			sbURL.append("&siDo=1100");
			sbURL.append("&guGun=1125");
			sbURL.append("&numOfRows=10");
			sbURL.append("&pageNo=1");
			
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type","application/json; charset=UTF-8");
			
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line=reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			System.out.println(sb.toString());
			
			JSONArray items = new JSONObject(sb.toString())
                    .getJSONObject("items")
                    .getJSONArray("item");
      
			List<JSONObject> list = new ArrayList<>();
      
			for(int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);
			list.add(item);
			}
    

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ex02() { // 스터디 코드 

        String serviceKey = "HTH+GuFVSHV08Xp5UnBTYr9Z5H0xYtsU1LQXZe1XuqP1umWgGSUMlMc0JtnkzyAlxDQ8r5O2c2OiqtN2vxbYjA==";
        String apiURl = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
        URL url = null;
        HttpURLConnection con = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {

            StringBuilder sbURL = new StringBuilder(apiURl);

            sbURL.append("?ServiceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
            sbURL.append("&searchYear=2021");
            sbURL.append("&siDo=1100");
            sbURL.append("&guGun=1125");
            sbURL.append("&type=json");
            sbURL.append("&numOfRows=10");
            sbURL.append("&pageNo=1");

            url = new URL(sbURL.toString());
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            if (con.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String line = null;
            StringBuilder sb = new StringBuilder();
            writer = new BufferedWriter(new FileWriter("C:" + File.separator + "storage","accident.txt"));

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            con.disconnect();

            writer.write(sb.toString());

            writer.close();

            JSONArray items = new JSONObject(sb.toString())
                    .getJSONObject("items")
                    .getJSONArray("item");

            String[] dayName = {"", "일","월","화","수","목","금","토"};
            List<JSONObject> list = new ArrayList<>();

            for (int i = 0; i < items.length(); i++) {
                JSONObject obj = items.getJSONObject(i);

                String occrrnc_dt = obj.getString("occrrnc_dt");
                String occrrnc_day_cd = obj.getString("occrrnc_day_cd");
                Integer dth_dnv_cnt = obj.getInt("dth_dnv_cnt");
                Integer injpsn_cnt = obj.getInt("injpsn_cnt");

                Accident acc = new Accident();
                acc.setOccrrncDt(occrrnc_dt);
                acc.setOccrrncDayCd(dayName[Integer.parseInt(occrrnc_day_cd)] + "요일");
                acc.setDthDnvCnt(dth_dnv_cnt);
                acc.setInjpsnCnt(injpsn_cnt);

                list.add(obj);
            }

            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



	
	public static void ex03() {
		
		String serviceKey = "I9D5ug/pCPp10+pv7KJBemPzO/qWSj+cAAmRzKspUCjvqxTRvM3YdAUoilwDrT/7k1UU02s5WHmzhsDP/Xyp7w==";
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		FileWriter writer = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&type=json&searchYear=2021&siDo=1100&guGun=1125&numOfRows=10&pageNo=1");
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage", "accident.txt");
			
			//System.out.println(sb.toString());
			String[] w = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
			Accident accident = null;
			StringBuilder result = new StringBuilder();
			List<Accident> accidentList = new ArrayList<Accident>();
			JSONArray item = new JSONObject(sb.toString()).getJSONObject("items").getJSONArray("item");
			for(int i = 0; i < item.length(); i++) {
				JSONObject obj = item.getJSONObject(i);
				accident = new Accident(obj.getString("occrrnc_dt"), obj.getString("occrrnc_day_cd"), obj.getInt("dth_dnv_cnt"), obj.getInt("injpsn_cnt"));
				accidentList.add(accident);
				result.append("발생일자 : " + obj.getString("occrrnc_dt") + " " + w[Integer.parseInt(obj.getString("occrrnc_day_cd")) -1] + ", 사망자수 ");
				result.append(obj.getInt("dth_dnv_cnt") + "명, 부상자수 " + obj.getInt("injpsn_cnt") + "명\n");
			}
			System.out.println(result.toString());
			
		    writer = new FileWriter(file);
			writer.write(result.toString());
			writer.close();
		  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex04() { // 보충
		
		try {
			// 주소 만들어 주는 방법 API주소 완성
			String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath"; // 주소 
			// 서비스키 & 들어간거 아닌 인코드 주소 적어주기
			apiURL += "?serviceKey=" + URLEncoder.encode("ztaE5KsIFSOYcxrR6Pc3gp104FQSHOp4HOMmlu+I3/mkkr9/syCHNjMjbL3oP0Kd7oLE9xvoM24rzN41cQuXUg==","UTF-8");
			apiURL += "&searchYear=" + URLEncoder.encode("2021","UTF-8");
			apiURL += "&siDo=" + URLEncoder.encode("1100","UTF-8");
			apiURL += "&guGun=" + URLEncoder.encode("1125","UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json","UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("10","UTF-8");
			apiURL += "&pageNo=" + URLEncoder.encode("1","UTF-8");
			
			// URL 객체 생성(API주소의 형식 검증)
			URL url = new URL(apiURL);
			
			// API주소로 접속하기
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); // 접속 완료
			
			// GET 방식의 요청임을 먼저 처리해주기 (요청방법) 
			con.setRequestMethod("GET"); // get은 대문자로 적어주기 주소창에 파라미터?& 주렁주렁 매달아서 요청 방식을 겟방식
			
			// 응답 데이터는 "json"임을 처리
			// 웹 상에서 주고 받는 데이터의 타입 : Content-Type
			con.setRequestProperty("Content-Type", "application/json"); // 제이슨 타입이다 캐릭터셋은 생략가능
			
			// 접속된 API로부터 데이터를 읽어 들일 입력 스트림 생성 (" ")
			// 1. 정상 스트림과 에러 스트림으로 구분해서 생성하는게 기본
			// 2. API 입력 스트림은 오직 바이트 입력 스트림만 지원하므로 문자 입력 스트림으로 바꾸는 작업이 필요하다.
			// 3. 속도 향상을 위해서 Buffer가 있는 내장된 스트림을 생성하자.
			BufferedReader reader = null; // 선언
			if(con.getResponseCode() == 200) {// 정상 코드 : 200
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// BufferedReader는 readLine 메소드를 지원한다.
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
				
			// 이제 API의 응답 데이터는 sb에 저장되어 있다.
			// System.out.println(sb.toString());
			
			// {} 객체 [] 배열
			
			// API의 응답 데이터를 분석하기 위해서 JSONObject로 변환한다.
			// json 라이브러리 사용을 위해서 Build Path 작업을 수행한다.
			
//			JSONObject obj = new JSONObject(sb.toString());
//			JSONObject items = new JSONObject("items");
//			JSONArray itemlist = items.getJSONArray("item");
//			
			JSONArray itemList = new JSONObject(sb.toString())
									.getJSONObject("items")
									.getJSONArray("item");
			
			List<Accident> list = new ArrayList<Accident>(); // for문 위에 ArrayList 한개를 만들고 Accident 9개를 저장.
			// for문 돌리기
			for(int i = 0; i < itemList.length(); i++) {
				JSONObject item = itemList.getJSONObject(i); // 모든 요소가 하나씩 완성되서 나옴
				// JSONObject 이걸 사용하는 이유는 items에서 끝나는 요소가 {}로 끝나서 JSONObject 사용해줌
				
				// 데이터 타입은 모두 스트링이라고 봐도 무방함
				// 앞에 변수는 변경 가능 뒤에는 변경 불가
				// _소문자 나오면 대문자로 바꿔주기 - 자바규칙
				//Accident 객체로 만들다
				// 응답 데이터에서 필요한 데이터를 분석(파싱) 한다.
				String occrrncDt = item.getString("occrrnc_dt"); 
				String occrrncDayCd = item.getString("occrrnc_day_cd");
				int dthDnvCnt = item.getInt("dth_dnv_cnt");
				int injpsnCnt = item.getInt("injpsn_cnt");
				// Accident 객체를 만들다. Accident 객체 1개가 4개의 값을 모두 저장
				// 응답 데이터에서 추출한 데이터를 하나의 객체(Bean)로 만든다.
				Accident accident = new Accident(); // 디폴트 생성
				accident.setOccrrncDt(occrrncDt);
				accident.setOccrrncDayCd(occrrncDayCd);
				accident.setDthDnvCnt(dthDnvCnt);
				accident.setInjpsnCnt(injpsnCnt);
				// 객체를 ArrayList에 저장한다.
				list.add(accident); // 저장하기 
				// 금천구에 사망자가 9개 나와서 for문에 넣으면 9번 발생하니깐 1번만 나오게 arraylist에 넣어주는 작업 필요 
				
				// 확인코드 
//				System.out.println(occrrncDt); 	  // 발생월일시
//				System.out.println(occrrncDayCd); // 발생요일코드
//				System.out.println(dthDnvCnt);	  //사망자수
//				System.out.println(injpsnCnt);    //부상자수
//				System.out.println("----------");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex05() {
		public static void main(String[] args) {
			

			try {
				String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
				
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/xml");
				
				BufferedReader reader = null;
				if(con.getResponseCode() == 200) {
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
				
				// 응답데이터(xml) 확인
				System.out.println(sb.toString());
				
				// 응답데이터(xml)를 json데이터로 바꿔주기
				JSONObject obj = XML.toJSONObject(sb.toString());
				// System.out.println(obj);
				
				// pubDate 조회
				String pubDate = obj.getJSONObject("rss")
									.getJSONObject("channel")
									.getString("pubDate");
				System.out.println(pubDate);
				
				// category 조회
				String category = obj.getJSONObject("rss")
									 .getJSONObject("channel")
									 .getJSONObject("item")
									 .getString("category");
				System.out.println(category);
				
				// data 속성에 저장된 날씨 배열 가져오기
				JSONArray dataList = obj.getJSONObject("rss")	
										.getJSONObject("channel")
										.getJSONObject("item")
										.getJSONObject("description")
										.getJSONObject("body")
										.getJSONArray("data");
		//	StringBuilder sbd = new StringBuilder();
				
				List<Map<String, Object>> day = new ArrayList<Map<String,Object>>();

				// 순회
				for(int i = 0; i < dataList.length(); i++) {
					JSONObject data = dataList.getJSONObject(i);
					
					 Map<String, Object> weather = new HashMap<String, Object>();

					   weather.put("온도", data.getInt("temp") + "도");
			           weather.put("날짜", data.getString("wfKor"));
			           weather.put("시간", data.getInt("hour") + "시");
			            
			           day.add(weather);

//					int temp = data.getInt("temp");
//					String wfKor = data.getString("wfKor");
//					int hour = data.getInt("hour");
//					
//					Weader weader = new Weader();
//					weader.setTemp(temp);
//					weader.setWfKor(wfKor);
//					weader.setHour(hour);
//					list.add(weader);
//					System.out.println(list.get(i).toString());
//					sbd.append(temp).append(wfKor).append(hour).append("\n");
					
					// 파일에 누적 될 수 있게 코드 바꾸기 DKLWEIP
					System.out.println(data.getInt("temp"));
					System.out.println(data.getString("wfKor"));
					System.out.println(data.getInt("hour"));
				}
				
				
				// 결과 파일 만들기
				BufferedWriter writer = new BufferedWriter(new FileWriter("weather.txt")); // 경로를 지정 안하면 프로젝트에 생김
				writer.write(pubDate + "\n");
				writer.write(category + "\n");
				for(int i = 0; i < day.size(); i++) {
					writer.write(day.get(i).toString()+"\n");
				}
				writer.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		ex04();

	}
}