package classes;

import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	// 필드
	List<Product> store = new ArrayList<Product>();
	
	// 생성자
	public MethodExe2(){
		store.add(new Product("A001", "지우개", 500));
		store.add(new Product("B001", "테이프", 900));
		store.add(new Product("C001", "볼펜", 1500));
		store.add(new Product("D001", "종이", 5000));
		store.add(new Product("E001", "치킨", 20000));
		store.add(new Product("F001", "빌딩", 900000000));
		store.add(new Product("G001", "지우개", 1500));
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

