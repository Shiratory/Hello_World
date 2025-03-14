package bookApp;

import java.security.PublicKey;

/*
 * 실행클래스(main메소드)
 */
public class Bookapp {
	public static void main (String[] args) {
		BookMain_teach mainApp1 = BookMain_teach.getInstance();
//		mainApp.main(args);
		BookMain_teach mainApp2 = BookMain_teach.getInstance();
		
		mainApp1.add(); // 1번 등록
		mainApp1.list();
		
		mainApp2.list(); // 2번 목록
		
	}
}
