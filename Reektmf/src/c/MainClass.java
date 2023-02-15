package c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MainClass {

	public static void ex01() {
		                 
		// ArrayList 생성
		List<String> list = new ArrayList<String>();
		
		// 저장 메소드 순서대로
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		// 하나씩 꺼내보기 순서대로 확인 
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		// list 일반 for문
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			
			System.out.println("---");
			
		//향상 for문 앞: 변수 하나씩 빼는 값 뒤: 여러개 있는 값 
		for(String season : list) {
			System.out.println(season);
		}
		}
		
		
		/*
		 	일반 for문 , 향상 for문 차이점
		 	
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		 //일반 for
		for(int i = 0; i < arr.length; i++) {
			(배열요소)arr[i] += 10; // 20 30 40 
		}
		// 향상 for
			for(int n : arr) {
			(배열요소 복사본 또 다른변수 )n += 10; // 10 20 30 
		}
		System.out.println(Arrays.toString(arr));
		 */
		
	}
	public static void ex02( ) { // map
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(90, "제시카");
		treeMap.put(100, "블랑카");
		treeMap.put(50, "제레미");
		treeMap.put(80, "사만다");
		
		
		System.out.println(treeMap);
		
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1 , "a");
		map.put(10 , "b");
		map.put(101, "c");
		map.put(11 , "d");
		System.out.println(map);
		
	}
	public static void ex03() {
		//둘다 스트링 쓰는 경우
		
		String name = "제시카";
		String phone = "010-1111-2222";
		int age  = 20;
		
		Map<String, String> map = new HashMap<String, String>();
			
			map.put("name", name);
			map.put("phone", phone);
			map.put("age", age + "");
			
	
		System.out.println(map);
	}
	
	public static void ex04() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Service-Key", "fjkdfndf");
		map.put("Content-Type", "application/xml");
		
		System.out.println(map.get("Service-Key"));
		System.out.println(map.get("Content-Type"));
		
		ex05(map);
		
	}
	
	public static void ex05(Map<String, Object> map) {
		// ex04 받아서 map 출력하기 
		
		
		/*Set<Entry<String, Object>> set = map.entrySet();
		for(Entry<String, Object> entry : set);{
			
		}
		 */
		// 위에랑 똑같은 코드 
		for(Entry<String, Object> entry :map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	public static void main(String[] args) {
		ex04();
	}

}
