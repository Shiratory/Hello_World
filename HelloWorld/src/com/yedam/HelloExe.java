package com.yedam;

class Address{
	String name;
	String tel;
	int age;
	}
public class HelloExe {
	// 기능(함수) => main 메소드
	public static void main(String[] args) {
		// 1. 32000 변수선언과 할당
				int i = 32000;
		// 2. 34, 32, 88, 23
				int[] j = {34, 32, 88, 23};
		// 3. 문자 : 32
				String str = "32";
		// 4. 정수를 변수에 저장
				
		// 5. Hello, Nice, Good
				System.out.println("Hello, Nice, Good");
		// 6. 정수 5개 저장 Math.random() -> 60 - 100
				for(int n=0; n<5; n++) {
					System.out.println((int)(Math.random() * 41) + 60 ); 
				}
		// 7. 이름, 연락처, 나이 선언.
	    // 홍길덩, 010-1234-1234, 20
				Address add = new Address();
				add.name = "홍길동";
				add.tel = "010-1234-1234";
				add.age = 20;
				
		// 8. [3]
		// 홍길동, 010-1234-1234, 20
		// 김민식, 010-2222-2222, 22
		// 최문식, 010-3333-3333, 23
				Address[] ess = new Address[3];
				ess[0].name = "홍길동";
				ess[0].tel = "010-1234-1234";
				ess[0].age = 20;
				
				ess[1].name = "김문식";
				ess[1].tel = "010-2222-2222";
				ess[1].age = 22;
				
				ess[2].name = "최민식";
				ess[2].tel = "010-3333-3333";
				ess[2].age = 23;
						
					
				}
				
		// 9. 나이가 가장 많은 사람 이름출력
	
	}


