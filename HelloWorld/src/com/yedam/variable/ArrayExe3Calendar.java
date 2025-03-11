package com.yedam.variable;

public class ArrayExe3Calendar {
	/* 2025년 기준으로 달을 넣으면 1일의 위치를 반환*/
	public static int getFirstDay(int month) {
		switch(month) {
		case 1:
			return 3;
		case 2:
			return 6;
		case 3:
			return 6;
		case 4:
			return 2;
		case 5:
			return 4;
		case 6:
			return 0;
		case 7:
			return 2;
		case 8:
			return 5;
		case 9:
			return 1;
		case 10:
			return 3;
		case 11:
			return 6;
		case 12:
			return 1;
		default:
			return 1;
		}
	}
	/* 2025년 기준으로 월의 마지막날 반환 */
	public static int getLastDate(int month) {
		int date = 31; //1, 3, 5, 7, 8, 10, 12월
		switch(month) {
		case 2:
			date = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			date = 30;
		}
		return date;
	}
	public static void main(String[] args) {
		/* 콩솔출력(print vs println) */
		
	String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	/*요일출력*/
	
	System.out.print(" ");
	for (String day : days) {
		System.out.print(" " + day);
	}
		System.out.println(); // 줄바꿈
		int month = 9;
		int space = getFirstDay(month); // 1일의 위치값
		int lastdate = getLastDate(month); // 마지막날
		/* 공백갯수만큼 빈 칸 */
		for(int i = 0; i < space; i++) {
			System.out.print("    ");
		}
		
		for(int i=1; i<=lastdate; i++) {
			if(String.valueOf(i).length() == 1) {
				System.out.print("   " + i);
			}else if(String.valueOf(i).length() == 2) {
				System.out.print("  " + i);
			}
			
			if((space + i) % 7 == 0) {
				System.out.println();
			}
		}
	}

}
