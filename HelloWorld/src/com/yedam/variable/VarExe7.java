package com.yedam.variable;

import java.util.Scanner;

/* 추가, 수정, 삭제, 목록출력 */

public class VarExe7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		// Member 값을 저장
		Member[] storage = new Member[100]; // {null, null, ... null}
		storage[0] = new Member("홍길동", 84);
		storage[1] = new Member("김민혁", 86);
	    storage[2] = new Member("한수아", 90);
		
		while(run) {
			System.out.println("1.등록 2.수정 3.삭제 4.출력 5.평균 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); // 1 엔터
			
			
			switch(menu) {
			case 1:
				System.out.print("이름을 입력하새요 ");
				String name = scn.nextLine();
				System.out.print("점수를 입력하세요 ");
				int score = Integer.parseInt(scn.nextLine());
				Member member = new Member(); // 인스턴트 생성
//				member.name = name;
//				member.score = score;
				member.setMember(name, score);
				// 빈공간에 값을 할당
				for(int i=0; i<storage.length; i++) {
					if(storage[i] == null) {
					   storage[i] = member;
					   break;
					}
				}
				break; // case 1 종료
				
			case 2: 
				int index = -1;
				System.out.print("수정할 이름을 입력하세요 ");
				String overwrite_name = scn.nextLine();
				System.out.print("수정할 점수를 입력하세요 ");
				int overwrite_score = Integer.parseInt(scn.nextLine());
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null && overwrite_name.equals(storage[i].getName())){
						storage[i].setScore(overwrite_score);
						System.out.println("수정되었읍니다.");
						index = i;
						break;
					}
				}
				if(index == -1) {
					System.out.println("이름을 찾을수 없습니다");
				}
				break;
				
				
			case 3: // 삭제, 이름입력 조회 후 => null 대입
				int remove = -1;
				System.out.print("삭제할 이름을 입력하세요 ");
				name = scn.nextLine();
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)) {
						storage[i] = null; //삭제
						System.out.println("삭제되었습니다.");
						remove = i;
						break;
					}
				}
				if(remove == -1) {
					System.out.println("삭제할 이름이 없습니다");
				}
				break;
				
			case 4: // 목록 출력
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null) {
						System.out.println(storage[i].getName() + "" + storage[i].getScore());
					}
				}
				break;
			case 5: // 평균
				int sum = 0; 
				int counter = 0; 
				for(int i=0; i<storage.length; i++) {
					if(storage[i] != null) {
					sum = storage[i].getScore() + sum;
					counter++;
					}
				}
				int avg = sum / counter; 
				System.out.println("평균은 " + avg + "입니다");
				break;
			case 6: // 종료
				run = false;
			}
		}
		System.out.println("end of prog");
	} // end of main();
}