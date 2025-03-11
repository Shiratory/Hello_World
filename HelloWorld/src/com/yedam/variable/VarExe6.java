package com.yedam.variable;

import java.util.Scanner;

public class VarExe6 {
	public static void test() {
		/* 임의의 정수 1 - 50 임의의 값 */
		//	System.out.println((int) (Math.random() * 50) + 1); /* 0 <= x < 50 */
		/* 학생의 점수 30 - 100 사이 점수 */
		/* 정수(int) 5개 저장 */
		/* 홀수값 출력 */
			
		int[] score = new int[5];
		for(int i=1; i<score.length; i++) {
			score[i] = (int) (Math.random() * 70) + 30;
			System.out.println(score[i]);
		}
		
		for(int i=0; i<score.length; i++) {
			if (score[i] % 2 ==1) {
				System.out.println("홀수" + score[i]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		Member m1 = new Member(); /* 인스턴트 생성 */
		m1.setName ("홍길동");
		Member m2 = new Member(); /* 인스턴트 생성 */
		m2.setName ("영희");
		Member m3 = new Member(); /* 인스턴트 생성 */
		m3.setName ("철수");
		Member m4 = new Member(); /* 인스턴트 생성 */
		m4.setName ("박인만");
		
		//배열
		Member[] members = {m1, m2, m3, m4};
		/* 70 - 100 사이의 임의값으로 정수지정 */
		for(int i=0; i<members.length; i++) {
			members[i].score = (int) (Math.random()*31)+70;
		}
		
		/* 조회할 이름입력 > 점수출력 */
		System.out.println("조회할 이름 입력>> ");
		String search = scn.nextLine();
		for (int i=0; i<members.length; i++) {
			if(members[i].name.equals(search)) {
				System.out.println(members[i].name + members[i].score + "점");
			}
		}
		/* 점수가 가장 높은 사람이름 */
//	int max = members[0].score;
//	String name = members[0].name;
//	for(int i=0;i<members.length;i++) {
//		System.out.println(members[i].name+ ", " + members[i].score +"점");
//		if(max < members[i].score) {
//		   max = members[i].score;
//		   name = members[i].name;
//		}
//	}
//	System.out.println("최고점수는 " + name);
	}/*end of main*/
}
