package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.sun.source.tree.CatchTree;

public class MainClass {

	// 문제 1. 현재 시간을 이용하여 디렉터리를 생성하시오.
	// 예시)
	// C:\14\31\30
	public static void ex01() {
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
				
		String sep = File.separator; // 쉽게 쓰기 위해서 줄임말 만들어주기
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
	}
	public static void ex02() throws IOException{ // 예외 처리를 ex02 메소드를 호출한 곳으로 넘긴다.
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs(); // 폴더 만들기
		}
		
		File file = new File(dir,"myfile.txt");
		if(file.exists() == false) {
		file.createNewFile(); // 파일 만들기 반드시 예외 처리가 필요한 코드
	}else {
			file.delete();
		}
	}
	public static void ex03() throws IOException{ 
		
		File dir = new File("C:" + File.separator + "storage");
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
			File file = new File(dir,"myfile.txt");
			
			if(file.exists() == false) {
				file.createNewFile();
			}
		
		// 파일의 정보 확인 
		System.out.println("파일명 : " + file.getName());
		System.out.println("디렉터리명 : " + file.getParent());
		System.out.println("경로명 : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModified = file.lastModified(); // 최종 수정일의 타임 스탬프
		System.out.println("최종 수정일 : " + lastModified);
		
		String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(lastModified);
		System.out.println("최종 수정일 : " + lastModifiedDate);
		
		long size = file.length(); // 파일의 크기가 바이트 단위로 저장
		long kb = (size / 1024) + (size % 1024 != 0 ? 1 : 0);
		System.out.println("파일 크기 :" + kb + "KB");	// 킬로 바이트 출력(1024바이트 = 1킬로바이트)
	}
	public static void ex04() {
		File dir = new File("C:" + File.separator + "Program Files");
		
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isHidden() == false) {
				System.out.println(files[i].getName());				
			}
		}
	}
	
	// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
	/*
		2023-01-04  오후 02:19    <DIR>          bin
		2023-01-04  오후 02:19    <DIR>          conf
		2023-01-04  오후 02:19    <DIR>          include
		2023-01-04  오후 02:19    <DIR>          jmods
		2023-01-04  오후 02:19    <DIR>          legal
		2023-01-04  오후 02:19    <DIR>          lib
		2023-01-04  오후 02:19               160 README.html
		2023-01-04  오후 02:19             1,302 release
		               2개 파일               1,462 바이트
	 */
	
	public static void ex05(){

		File dir = new File("C:" + File.separator + "Program Files" + File.separator + "Java" + File.separator + "jdk-11.0.17");
		if(dir.exists()) {
			File[] list = dir.listFiles();
			
			// 반복문 들어오기 전에 있어야 하는 변수 
			int fileCount = 0;
			long totalFileSize = 0;
			for(File file : list) {
				if(file.isHidden()) { // 숨긴 파일은 아무것도 안하겠다.
					continue; // 실행에서 제외하겠다.
				}
				// 날짜 구현하기
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm").format(file.lastModified());
				String directory = file.isDirectory() ? "<DIR>" : ""; // 디렉터리가 맞으면 DIR 이라고 표시해주기
				// 파일이면 크기를 구해서 천 단위 표시를 구해주고 아니면 빈 문자열로 나타내라
				String size ="";
				if(file.isFile()) {
					long length = file.length();
					size = new DecimalFormat("#,##0").format(length);
					fileCount++;
					totalFileSize += length;
				}
				String name = file.getName();
				// 자리수 맞춰서 출력한다
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
				System.out.print(result);
				}
			System.out.println(fileCount + "개 파일 " + new DecimalFormat("#,##0").format(totalFileSize) + "바이트");
			}
		}
		
	// 문제3. C:\storage 디렉터리를 삭제하시오.
	// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
	public static void ex06() {
		
		File dir = new  File("C:" + File.separator + "storage");
		File file = new File(dir ,"myfile.txt");
		if(file.exists()) {
			file.delete();
		}
		if(dir.exists()) {
			dir.delete();
		}
	}
	// 문제4. 사용자로부터 입력 받은 문자열을 C:\storage\diary.txt 파일로 보내시오.
	// 총 5개 문장을 입력 받아서 보내시오. Scanner 사용 
	public static void ex07() {
		
		Scanner sc = new Scanner(System.in);
		String[] sentencers = new String[5];
		System.out.println("5문장을 입력하세요." );
		for(int i = 0; i < sentencers.length; i++) {
			sentencers[i] = sc.nextLine();
		}
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir,"diary.txt");
		
		try (PrintWriter out = new PrintWriter(file)){
			for(int i = 0; i < sentencers.length; i++) {
				out.printf(sentencers[i]);
			}
			System.out.println("diary.txt 파일이 생성되었다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
		
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생시간을 저장한  C:\storage\log.txt
	// 예시)
	// 2023-01-26 12:08:30 / by zero
	public static void ex08() {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("첫 번째 정수를 입력하세요 >>> ");
			int number1 = sc.nextInt();
			
			System.out.println("두 번째 정수를 입력하세요 >>> ");
			int number2 = sc.nextInt();
		
				int add = number1 + number2;
				int sub = number1 - number2;
				int mul = number1 * number2;
				int div = number1 / number2;
				
				System.out.println(number1 + "+" + number2 + "=" + add);
				System.out.println(number1 + "-" + number2 + "=" + sub);
				System.out.println(number1 + "*" + number2 + "=" + mul);
				System.out.println(number1 + "/" + number2 + "=" + div);
			
				sc.close();
		
				}catch(Exception e) {
					// 날짜
					LocalDateTime now = LocalDateTime.now();
					DateTimeFormatter dtr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String dateTime = dtr.format(now);
					// 예외 클래스 이름
					String classname = e.getClass().getName();
					// 예외 메시지 
					String message = e.getMessage();
					// 로그 파일 만들기
					File dir = new File("C:" + File.separator + "storage");
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					File file = new File(dir,"log.txt");
					
					// 생성모드(언제나 새로 만든다.) new FileWriter(file)
					// 추가모드(기존 내용에 추가한다.) new FileWriter(file,true)
					try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
						bw.write(dateTime + " " + classname + " " + message + "\n");
						// bw.nextLine(); \n을 대신할 수 있는 코드
						System.out.println("예외 메시지가 log.txt 파일에 기록되었습니다.");
				}catch(IOException e2) {
					e2.printStackTrace();
				}
				
		}
	}
	// 문제6. C:\storage\diary.txt 파일을 C:\storage2\diary.txt 파일로 이동하시오.
	// 이동에 소요된 시간을 출력하시오.
	public static void ex09() {
		
		File from = new File("C:" + File.separator + "storage", "diary.txt");		
		File toDir = new File("C:" + File.separator + "storage2");
		if(toDir.exists() == false) {
			toDir.mkdirs();
		}
		File to = new File(toDir, from.getName());
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			long startTime = System.currentTimeMillis();

			br = new BufferedReader(new FileReader(from));
			bw = new BufferedWriter(new FileWriter(to));
			
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			br.close();	
			
			if(from.length() == to.length()) {  // 복사 성공했다면 삭제
				from.deleteOnExit();
			}

			long stopTime = System.currentTimeMillis();
			
			System.out.println("이동에 걸린 시간 : " + (stopTime - startTime) + "밀리초");
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	// 문제7. System.in은 키보드로부터 바이트 데이터를 입력 받는 InputStream이다.
	// System.in으로부터 문장 1개를 입력 받아서 출력하시오.
	// Scanner 대신 BufferedReader를 사용하시오.
	public static void ex10() {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("문장 입력 >>>");
			String sentence = br.readLine();
			
			System.out.println("입력된 문장 : " + sentence);
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	// 문제8. C:\GDJ61\installer\eclipse-jee-2021-03-R-win32-x86.zip 파일을
	// C:stoage\eclipse.zip으로 복사하시오.
	public static void ex11() {
		
		String sep = File.separator; // 경로가 길어지니까 sep을 사용해서 짧게 정리
		File from = new File("C:" + sep + "GDJ61"+ sep +"lnstaller"+ sep + "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File to = new File("C:" + File.separator + "storage","eclipse.zip");
		
		// 읽어들이기
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			
			bin = new BufferedInputStream(new FileInputStream(from));
			bout = new BufferedOutputStream(new FileOutputStream(to));
			
			byte[] b = new byte[1024];
			int readByte = 0;
			
			while((readByte = bin.read(b)) != -1) {
				bout.write(b, 0, readByte);
			}
				System.out.println("복사 완료되었습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bout != null) {bout.close();}
				if(bin != null) {bin.close();}
			
		}catch (IOException e) {
			e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {	// main 메소드를 호출하는 곳으로 예외 처리를 넘긴다.(개발자가 try - cahch 하지 않겠다.)
		ex11();
		

	}

}
