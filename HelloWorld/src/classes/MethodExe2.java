package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MethodExe2 {
	// 필드
	private List<Product> store;
	
	// 생성자
	public MethodExe2(){
		init();
	}
	// 데이터 초기화
	void init() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			store = (List<Product>) ois.readObject(); // 기본 -> 객체타입
			ois.close();
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end of init
	
	
	
	void init1() {
		store = new ArrayList<Product>();
		try {
			Scanner scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
				while(true) {
					String msg = scn.nextLine();
					String[]msgAry = msg.split(" ");
					store.add(new Product(msgAry[0], msgAry[1], Integer.parseInt(msgAry[2])));
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(NoSuchElementException e) {
				
			}
//		store.add(new Product("A001", "지우개", 500));
//		store.add(new Product("B001", "테이프", 900));
//		store.add(new Product("C001", "볼펜", 1500));
//		store.add(new Product("D001", "종이", 5000));
//		store.add(new Product("E001", "치킨", 20000));
//		store.add(new Product("F001", "빌딩", 900000000));
//		store.add(new Product("G001", "지우개", 1500));
	}
	//종료시점에 store 정보를 message.txt.에 저장
	void save() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(fos);
			oos.writeObject(store); // ArrayList<Product>()
			oos.flush();
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void save1() {
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			for(int i=0; i<store.size(); i++) {
				Product p = store.get(i);
				String msg = p.showList();
				
				writer.write(msg+ "\n"); // "공백"
				writer.flush();
			}
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("end of frog");
	}
	// 메소드
	public boolean add(Product prd) {
		boolean result = store.add(prd);
		return  result;
	}
	// 상품이름, ALL
	List<Product> productList(Product prd) {
		List<Product> list = new ArrayList<Product>(); 
		for(int i=0; i<store.size(); i++) {
			if(prd.getProductName().equals("ALL")
					|| store.get(i).getProductName()
					   .equals(prd.getProductName())) {
				if(store.get(i).getPrice() >= prd.getPrice()) {
					list.add(store.get(i));	
				}
			}
		}
		return list;
	}

	// 삭제 > boolean remove(String code)
	
	public boolean remove(String code) {
		for(int i=0; i<store.size(); i++) {
			if(store.get(i).getProductCode().equals(code)) {
				store.remove(i);
				return true;
			}
		}
		return false;
	}
	// 수정 > boolean modify(Product prod)
	
	public boolean modify(Product prod) {
		for(int i=0; i<store.size(); i++) {
			if(store.get(i) != null && store.get(i).getProductCode().equals(prod.getProductCode())) {
				
				// 상품명수정
				if(prod.getProductName() != null) {
					store.get(i);
				}
				
				// 상품가격수정
				if(prod.getPrice() != 0) {
					store.get(i).setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}
}// end of add(Product prd)

