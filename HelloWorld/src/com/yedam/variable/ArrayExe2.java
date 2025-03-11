package com.yedam.variable;

public class ArrayExe2 {
	public static void main(String[] args) {
		String[] strAry = {"Hello", "World", "20", "23.4"};
		/* 확장 for */
		for(String str : strAry) {
			System.out.println(str);
		}
		
		/* 크기지정 */
		strAry = new String[10]; // {null, null ..., null}
		strAry[0] = new String ("Sex");
		for(String str : strAry) {
			System.out.println(str);
		}
		/* Member 클라스 */
		Member[] memAry = new Member[10]; // {null, null ..., null}
		memAry[0] = new Member();
		memAry[0].setMember("홍길동", 90); // 90> 80
		memAry[0].setScore(80);
		memAry[0].showInfo();
		
		memAry[1] = new Member();
		memAry[1].setMember("홍흥흠", 74); // 74 > 95
		memAry[1].setScore(95);
		memAry[1].showInfo();
		
		memAry[2] = new Member("최민혁", 77);
		memAry[2].showInfo();
		for(int i=0; i<memAry.length; i++) {
			if(memAry[i] != null) {
//			   memAry[i].showInfo();
			}
		}	
	}
		
}

