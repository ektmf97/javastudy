package ex04_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir,"ex01.bin" );
		
		FileOutputStream fos = null; // 선언만 하는 이유 트라이캐치때문
		
		try {
			
			fos = new FileOutputStream(file); // 파일로 내보낼 수 있는 통로를 만들다 . 통로의 이름은 fos
			
			// 출력단위 
			// 1. int	 : 1개
			// 2. byte[] : 2개 이상
		
			int c = 'A';
			String str = "pple";// 바이트 배열로 변환할 스트링을 준비
			byte[] b = str.getBytes();
				
			// 출력
			fos.write(c);
			fos.write(b);
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos != null) {
					fos.close();
					
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir,"ex02.bin");
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			//getBytes(Charset charset)
			byte[] b = str.getBytes(StandardCharsets.UTF_8); // UTF_8로 인코딩 해서 만들어주세요 
			
			//getBytes(String charsetName)
			//byte[] b = str.getBytes("UTF-8)
			
			fos.write(b);
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if( fos != null){
					fos.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 사이즈 확인하는 방법
		System.out.println("ex02.bin 파일의 크기 :" + file.length() +"바이트");
	}
	
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir,"ex03.bin");
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			// 데이터 내보내기 (스트링으로 전달)
			bos.write("반갑습니다\n또만나요".getBytes("UTF-8")); 
			// bos.close <- 여기로도 사용가능 (현실적으로 많이 사용)
			// 여기다 사용하면 finally 필요없음
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos != null) {
					bos.close(); // 권장 코드
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex03.bin 파일의 크기 :" + file.length() +"바이트");
	}
	public static void ex04() {
		
		// 변수를 그대로 출력하는 DataOutputStream
		
		File dir = new File("C:" + File.separator + "storage");
		File file  = new File(dir,"ex04.dat");
		
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(file));
			
			// 출력할 변수
			String name = "에밀리"; //9바이트
			int age = 30;			//4바이트
			double heigth = 180.5;	//8바이트
			boolean isAlibve = true;//boolean 크기는 자바에서 정한다
			
			// 출력(변수 타입에 따라서 메소드가 다름)
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(heigth);
			dos.writeBoolean(isAlibve);
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos != null) {
					dos.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex04.dat 파일의 크기 :" + file.length() +"바이트");
	}
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutputStream
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir,"ex05.dat");
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 출력할 객체 
			List<Person> people = Arrays.asList(
				new Person("에밀리" ,30, 180.5, true),
				new Person("제시카", 35, 190.5, true)
			);
			
			// 출력할 객체 
			Person person = new Person();
			person .setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			
			// 출력 
			oos.writeObject(people);
			oos.writeObject(person);
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) {
					oos.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex05.dat 파일의 크기 :" + file.length() +"바이트");
	}
	public static void main(String[] args) {
		ex05();
		

	}

}
