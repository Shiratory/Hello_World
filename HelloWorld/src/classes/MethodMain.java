package classes;

public class MethodMain {
	public static void main(String[] args) {
		// 상품코드 : M001, 상품명 : 만년필, 가격 : 10000
		MethodExe2 m2 = new MethodExe2();
//		if(m2.add(new Product("M001", "만년필", 10000))) {
//			System.out.println("등록되었습니다");
//		}
//		Product prod = new Product("A001", "지우개", 300);
//		if (m2.modify(prod)) {
//			System.out.println("수정되었습니다");
//		}
		
		// 상품코드, 상품명, 가격 modify(Product prod)
//		if(m2.remove("A001")) {
//			System.out.println("삭제되었습니다");	
//		}
		
	MethodExe3 m3 = new MethodExe3();
	System.out.print(m3.gugudan(3, 9));
	m3.printStar(5, "*");
	m3.printCard();
		
//		Product search = new Product();
//		search.setProductName("ALL");
//		search.setPrice(3000);
//		
//		Product[] list = m2.productList(search);
//		for(int i=0; i<list.length; i++) {
//			if(list[i] !=null) {
//				System.out.println(list[i].showList());
//			}
//		}
//		
	}
	
	
	void method1() {
		MethodExe1 m1 = new MethodExe1();
		/* System.out.println(m1); 메소드 호철 */
		int n = 5;
		m1.printString(n, "*");
		
		double result = m1.sum(n, 11.2);
		System.out.println(result);
		
		int sum = m1.sum(new int[] {10,20,30});
		System.out.println(sum);
		
		double dsum = m1.sum(new double[] {10.4, 20.5, 40.5});
		System.out.println(dsum);
	}
}
