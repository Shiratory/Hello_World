package classes;

public class MethodExe2 {
	// 필드
	Product[] store;
	
	// 생성자
	MethodExe2(){
		store = new Product[10];
		store[0] = new Product("A001", "지우개", 500);
		store[1] = new Product("B001", "테이프", 900);
		store[2] = new Product("C001", "볼펜", 1500);
		store[3] = new Product("D001", "종이", 5000);
		store[4] = new Product("E001", "치킨", 20000);
		store[5] = new Product("F001", "빌딩", 900000000);
		store[6] = new Product("G001", "지우개", 1500);
	}
	// 메소드
	boolean add(Product prd) {
		for(int i=0; i<store.length; i++) {
			if(store[i] == null) {
				store[i] = prd;
				return true;
			}
		}
		return false;
	}
	// 상품이름, ALL
	Product[] productList(Product prd) {
		Product[] list = new Product[10];
		int idx = 0;
		for(int i=0; i<store.length; i++) {
			if(store[i] != null) {
				if(prd.getProductName().equals("ALL") || store[i].getProductName().equals(prd.getProductName())) {
					// 상품가격이 조건으로 추가됨
					if(prd.getPrice() > 0 && store[i].getPrice() >= prd.getPrice()) {
						list[idx++] = store[i];
					}
				}
			}
		}
		return list;
	}
	// 삭제 > boolean remove(String code)
	
	boolean remove(String code) {
		for(int i=0; i<store.length; i++) {
			if(store[i] != null) {
				if(code.equals("ALL") || store[i].getProductCode().equals(code)){
					store[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	// 수정 > boolean modify(Product prod)
	
	boolean modify(Product prod) {
		for(int i=0; i<store.length; i++) {
			if(store[i] != null && store[i].getProductCode().equals(prod.getProductCode())) {
				
				if(prod.getProductName() != null) {
					store[i].setProductName(prod.getProductName());
				}
				if(prod.getPrice() != 0) {
					store[i].setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}
}// end of add(Product prd)

