package classes;

public class MethodExe5 {
	public static void main(String[] args) {
		// 상수선언
		int num1 = 10;
		num1 = 20;
		
		final int num2 = 20;
//		num2 = 499; // 상수는 변경이안됨
		
		final Product p1 = new Product();
		p1.setProductCode("A001");
		p1.setProductCode("B001");
		
//		p1 = new Product(); // 상수
	}
}
