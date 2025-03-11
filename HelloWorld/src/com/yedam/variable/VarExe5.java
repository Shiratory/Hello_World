package com.yedam.variable;

import java.util.Scanner;

/* 예금, 출금, 잔고확인 기능 */

public class VarExe5 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0; /* 예금액을 저장하는 변수 */
		int hando = 0;
		Scanner scn = new Scanner(System.in); /* import 단축키 : Ctrl + Shift + O */
		while(run) {
			System.out.println("1.예금 2.출금 3.잔고확인 4.종료");
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				System.out.print("금액을 입력>>");
				int in = scn.nextInt();
				if(in > 100000){
					System.out.print("잔액이 부족합니다");
				}else {
					balance = balance + in;
				}
				break; /* case 1 종료 */
			case 2:
				System.out.print("금액을 입력>>");
				int out = scn.nextInt();
				if(balance < out) {
					System.out.print("잔액이 부족합니다");
				}else {
					 balance = balance - out;
				}
				break; /* case 2 종료 */
			case 3:
				System.out.print("잔액은 " + balance + "원");
				break; /* case 3 종료 */
			case 4:
				run = false;
			}
		}
		System.out.println("end of game.");
	}/* end of main() */
}
