package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMainClass {

	public static void main(String[] args) {
		
		// C:\storage\product.csv 읽기
		// 파일을 읽어 들일때는 이 방법을 사용 
		File file = new File("C:" + File.separator + "storage","product.csv");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			
			// 읽어들일 준비
			String line = null;
			while((line = br.readLine()) != null) {
				String[] items = line.split(",");//,로 쪼갠다 이걸 저장하려면 배열이 필요함 
				Map<String, Object> product = new HashMap<String, Object>();
				product.put("model", items[0]);
				product.put("maker", items[1]);
				product.put("price", Integer.parseInt(items[2])); // price는 정수라서 정수로 변환함
				products.add(product);
				
			}
			System.out.println(products);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

}
