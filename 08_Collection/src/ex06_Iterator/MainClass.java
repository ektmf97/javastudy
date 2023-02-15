package ex06_Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainClass {

	/*
	 	Iterator 인터페이스
	 	1. 특정 Collection(컬렉션)을 순회할 때 사용한다.
	 	2. 주요 메소드
	 		1) hasNext() : 남아 있는 요소가 있으면 true 반환
	 		2) next()	 : 저장된 요소를 하나 꺼냄
	 */
	
	public static void ex01() {
	
		List<String> list = new ArrayList<String>();
		
		// 추가 
		list.add("동그랑땡");
		list.add("동태전");
		list.add("굴전");
		
		// 순회
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) { // list의 요소가 남아있으면 반복문을 돌려라
			String food = itr.next();
			System.out.println(food);
		}	
	}
	public static void ex02() {
		
		// set 구조
		
		Set<Integer> set = new HashSet<Integer>();
		// 같은 사용이면 사용법이 같다.
		set.add(5);
		set.add(15);
		set.add(105);
		
		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			Integer number = itr.next();
			System.out.println(number);  // 실행결과 순서는 자기 마음대로 뒤죽박죽 
			}
	}
	public static void ex03() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name","민경태");
		map.put("age", 46);
		map.put("isAlive", true);
		
		Set<String> keySet = map.keySet();
		
		Iterator<String> itr = keySet.iterator();
		
		while(itr.hasNext()) {
			String key = itr.next();
			System.out.println(map.get(key));
		}
	
		/*
		// key랑 value랑 같이 나오는 방법
		while(itr.hasNext()) {
			String key = itr.next();
			Object value = map.get(key);
			System.out.println(key + ":" + value );
		}
		*/
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
