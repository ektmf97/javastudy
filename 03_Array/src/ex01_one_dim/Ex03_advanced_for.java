package ex01_one_dim;

public class Ex03_advanced_for {

	public static void ex01() {
		
		int[] scores = {50, 90, 60, 100, 80};
		
		int total = 0;
		int max = 0;
		int min = 100;
		for(int n : scores) {  // 향상 for문
			total += n;
			if(max < n ) {
				max = n;
			}
			if(min > n) {
				min = n;
				
			}
		}
		
		/*
		for(int i = 1; i < scores.length; i++) { // 일반 for문
			total += scores[i];
		}
		*/
		
		System.out.println(total);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void ex02() {
		
		String[] files = {"hello.txt","hi.txt","안녕.txt"};
		
		for(String file : files) {
			System.out.println(file);
		}
	}
	public static void main(String[] args) {
		ex02();
		

	}

}
