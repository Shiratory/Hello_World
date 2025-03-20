package classes;

import java.util.List;
import java.util.Scanner;

public class MethodMain {

	public static void main(String[] args) {

		officeApp();
		System.out.println("end of prog.");

	} // end of main.

	static void officeApp() {
		Scanner scn = new Scanner(System.in);
		// 목록,추가,수정,삭제......
		MethodExe2 m2 = new MethodExe2(); // 기능정의.

		// 사용자입력 받아서 1.목록,2.추가,3.수정,4.삭제 9.종료 구현.
		// 입력메세지 정의 구현.
		boolean run = true;
		while (run) {

			System.out.println("1.목록 2.추가 3.수정 4.삭제 9.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("상품명입력>> ");
				String name = scn.nextLine();
				if (name.isBlank()) {
					name = "ALL";
				}
				System.out.print("상품가격입력>> ");
				String price = scn.nextLine();
				if (price.isBlank()) {
					price = "0";
				}

				Product product = new Product();
				product.setProductName(name);
				product.setPrice(Integer.parseInt(price));

				List<Product> list = m2.productList(product);
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).showList());
				}
				break;

			case 2:
				System.out.print("상품코드입력>> ");
				String code = scn.nextLine();
				System.out.print("상품명입력>> ");
				name = scn.nextLine();
				System.out.print("상품가격입력>> ");
				price = scn.nextLine();

				product = new Product(code, name, Integer.parseInt(price));
				if (m2.add(product)) {
					System.out.println("등록성공.");
				}
				break;

			case 3:
				System.out.print("상품코드입력>> ");
				code = scn.nextLine();
				System.out.print("상품명입력>> ");
				name = scn.nextLine();
				System.out.print("상품가격입력>> ");
				price = scn.nextLine();

				product = new Product(code, name, Integer.parseInt(price));
				if (m2.modify(product)) {
					System.out.println("수정성공.");
				}
				break;

			case 4:
				System.out.print("상품코드입력>> ");
				code = scn.nextLine();
				if (m2.remove(code)) {
					System.out.println("삭제성공.");
				}
				break;

			case 9:
				System.out.println("저장 완료" +"\n" + "프로그램을 종료합니다.");
				run = false;
				m2.save();
			default:
				System.out.println("메뉴를 선택하세요.");
			}
		}
	}
}
	