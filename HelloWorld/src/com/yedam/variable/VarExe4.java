package com.yedam.variable;

import java.util.Scanner;

public class VarExe4 {
	public static void main(String[] arsg ) {
    Scanner scn = new Scanner(System.in);		
		
		/* 점수를 입력하세요. */
    	/* 값 입력 */
		int[] scores = new int[3]; /* {0, 0, 0} */
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum = sum + scores[i];
			System.out.print("점수를 입력하세요.");
			scores [i] = scn.nextInt();
		}
		
		
		
		

	    for(int i=0; i<scores.length; i++) {
	    	sum = sum + scores[i];
	    	}
	    System.out.print("값은 " + sum + " 입니다.");
		
		/* 입력한 값의 합을 콘솔에 출력*/
		/* "합은 240 입니다*/
		
	}
}
