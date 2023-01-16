package practice04_Shape;

public class MainClass {

	public static void main(String[] args) {
		
		// 원의 면적 확인방법 
		// 쉐입은 서클의 부모 자식을 부모의 저장 업캐스팅 부모가 가진 메소드만 호출 
		Shape circle  = new Circle(1.5);
		System.out.println("원 면적 : "	+ circle.getArea());
		
		Shape rectangle = new Rectangle(1.5, 2.5); // 너비 1.5 , 높이 2.5인 사각형
		System.out.println("사각형 면적: " + rectangle.getArea());
		
		Shape square = new Square(1.5); // 너비, 높이가 1.5인 정사각형 
		System.out.println("정사각형 면적 : " + square.getArea());
		
		

	}

}
