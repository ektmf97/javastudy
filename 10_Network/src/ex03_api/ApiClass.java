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
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;



public class ApiClass {

	  public static void main(String[] args) {

		  String serviceKey = "ztaE5KsIFSOYcxrR6Pc3gp104FQSHOp4HOMmlu+I3/mkkr9/syCHNjMjbL3oP0Kd7oLE9xvoM24rzN41cQuXUg==";
			String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
			URL url = null;
			HttpURLConnection con = null;
			BufferedReader reader = null;
			BufferedWriter writer = null;

	        try {
	        	String stationName = "종로구";
	    		StringBuilder sbURL = new StringBuilder();
	    		sbURL.append(apiURL);
	            sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
	    		sbURL.append("&returnType=json");
	    		sbURL.append("&stationName=" + URLEncoder.encode(stationName, "UTF-8"));
	    		sbURL.append("&dataTerm=DAILY" );


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

	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }

	            reader.close();
	            con.disconnect();

	            JSONArray items = new JSONObject(sb.toString())
	                    .getJSONObject("response")
	                    .getJSONObject("body")
	                    .getJSONArray("items");

//	            dataTime, coValue,          coGrade,         pm10Grade,           coFlag
//	             측정일 , 일산화탄소농도, 일산화탄소지수, 미세먼지24시간등급,  일산화탄소플래그

	            List<JSONObject> list = new ArrayList<>();
	            
	            for (int i = 0; i < items.length(); i++) {
	                JSONObject item = items.getJSONObject(i);
	                list.add(item);
//	                System.out.println("측정일 : " + item.getString("dataTime"));
//					System.out.println("일산화탄소농도 : " + item.getString("coValue"));
//					System.out.println("일산화탄소지수 :" +item.getString ("coGrade"));
//					System.out.println("미세먼지24시간등급 " +item.getString("pm10Grade"));
//			
//
//	                String dataTime = item.getString("dataTime");
//	                String coValue = item.getString("coValue");
//	                String coGrade = item.getString("coGrade");
//	                String pm10Grade = item.getString("pm10Grade");
//
//	                System.out.println("측정일 : " + dataTime + " 일산화탄소농도 : " + coValue + " 일산화탄소지수 : " + coGrade
//	                                    + " 미세먼지24시간등급 : " + pm10Grade);
//	                System.out.println();

					System.out.println(list.get(i));
					System.out.println();
	            }
	            File file = new File("C:" + File.separator + "storage","API테스트.json");
	            writer = new BufferedWriter(new FileWriter(file));

	            // 리스트에 객체 
	           for(int i = 0; i < list.size(); i++) {
	        	   writer.write(list.get(i).toString());
	           }
	           writer.close();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	}










