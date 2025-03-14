package inharrydance;
/*
 * 상속
 * 친구1: 이름, 연락처
 * 친구2: 이름, 연락처, 학교, 학과
 * 친구3: 이름, 연락처 ,회사, 부서
 */
public class FriendExe {
	public static void main(String[] args) {
		Friend[] friends = new Friend[10];
		
		// 인스턴트
		Friend f1 = new Friend();
		f1.setName("강원기");
		f1.setTel("010-1111-1111");
		System.out.println(f1.toString());
		
		UnivFriend f2 = new UnivFriend();
		f2.setName("신창섭");
		f2.setTel("010-2222-2222");
		f2.setUnivName("연세대학교");
		f2.setMajor("국어국문학과");
		System.out.println(f2.toString());
		
		CompanyFriend f3 = new CompanyFriend("김용식", "010-2323-2323", "아마존", "개발팀");
		System.out.println(f3.toString());
		
		// 부모클라스의 변수에 자식 인스턴트 입대 가능.
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		
		
		// Friend[] -> toString()
		for(int i=0; i<friends.length; i++) {
			if(friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
		
		// 성전환
		int num = 20;
		double num2 = num; // 자동형변환 promotion
		num = (int) num2; // 강제성전환 casting
		
		Friend f4 = new CompanyFriend("대머리", "010-1234-5678", "자회사", "인사팀");
		CompanyFriend cf = (CompanyFriend) f4; // 부모클래스 자식클래스 대입
		Friend f5 = new Friend ("박성길", "010-3333-3333");
		if(f4 instanceof CompanyFriend) {
			cf = (CompanyFriend) f4;
			System.out.println(cf.getCompany());
		}else {
			System.out.println("Casting 할수 없습니다");
		}
	}
		
		
		
	}  // end of main

