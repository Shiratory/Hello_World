package com.yedam.variable;

import java.util.Arrays;

public class ArrayExe4 {
	public static void main(String[]args) {
		int[] intAry = {8,7,6,5,4};
		int temp = intAry[0];
		intAry[0] = intAry[1];
		intAry[1] = temp;
		
		for(int j=0; j<intAry.length -1; j++) {
			for(int i=0;i<intAry.length -1; i++) {
				if(intAry[i] > intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i+1];
					intAry[i+1] = temp;
				}
				System.out.println(intAry[i]);
				
			}
		}
		for(int i=0; i<intAry.length; i++) {
			for(int j=0; j<intAry.length; j++) {
				Arrays.sort(intAry);
//				System.out.println(intAry[i]);
			}
		}
	}
}
