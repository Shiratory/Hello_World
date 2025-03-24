package com.yedam.project;

import java.util.List;
import java.util.Scanner;


/*
 *        public
 * 검색, 조회, 사이트 모음 출력, 종료
 *         admin
 * 등록, 삭제, 수정
 */


public class Proj_main {
	
	private static Proj_main instance = new Proj_main();
	
	private Proj_main() {}
	
	public static Proj_main getInstance() {
		return instance;
	}
	
	
	Scanner scn = new Scanner(System.in);
	DeviceJdbc dao = new DeviceJdbc();
	
	private Userdata login(String id, String pw) {
		UserJdbc dao = new UserJdbc();
		return dao.login(id, pw);
	}
	
	private int getSequenceNo() {
		int max = 0;
		return max + 1;
	}
	
	// 유용한 사이트 모음
	private void useful() {
		Scanner scn = new Scanner(System.in);
		System.out.println("어떤 정보를 찾고 계십니까? \n 1.중고기기를 거래하고 싶어요 \n 2.테크 소식과 뉴스를 보고 싶어요 \n 3.내 기기와 다른 기기의 성능비교를 원해요");
		int num = Integer.parseInt(scn.nextLine());
		
		if(num == 1) {
			System.out.println(Device.num_one());
		}
		if(num == 2) {
			System.out.println(Device.num_two());
		}
		if(num == 3) {
			System.out.println(Device.num_two());
		} else {
			System.out.println("올바른 숫자를 입력하세요.");
			return;
		}
	}
	
	
	// 상품추가
	private void add() {
		System.out.println("기기코드를 입력하세요: ");
		String code = scn.nextLine();
		if((code) != null) {
			System.out.println("이미 등록된 제품코드입니다.");
			return;
		}
		System.out.println("기기명을 입력하세요: ");
		String name = scn.nextLine();
		System.out.println("출시년도를 입력하세요: ");
		String year = scn.nextLine();
		System.out.println("재고를 입력하세요: ");
		String stock = scn.nextLine();
		
		if(code.isBlank() || name.isBlank() || year.isBlank() || stock.isBlank()) {
			System.out.println("입력되지 않은 항목이 있습니다.");
			return;
		}
		Device device = new Device(code, name, Integer.parseInt(year), stock);
		if(dao.insert(device)) {
			System.out.println("항목이 추가되었습니다.");
		}
	}

	
	// 상품삭제
	private void delete() {
		String dcode = "";
		while(true) {
			System.out.println("삭제할 제품코드를 입력하세요: ");
			dcode : scn.nextLine();
			if(!dcode.isBlank()) {
				break;
			}
			System.out.println("제품코드는 필수 입력항목입니다.");
		}
		if (dao.delete(dcode)) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제할 항목이 없습니다.");
		}
	}
	
	
	// 상품수정
	private void edit() {
		System.out.print("정보를 수정할 제품코드를 입력하세요: ");
		String dcode = scn.nextLine();
		if(dcode.isBlank()) {
			System.out.println("제품코드는 필수 입력항목입니다.");
			return;
		}
		System.out.print("수정할 제품명을 입력하세요.");
		String name = scn.nextLine();
		System.out.print("수정할 출시년도를 입력하세요.");
		String year = scn.nextLine();
		System.out.print("재고를 몇 개로 수정하시겠습니까?");
		String stock = scn.nextLine();
		
		Device device = new Device();
		device.setDeviceCode(dcode);
		device.setDeviceName(name);
		device.setUnpack(Integer.parseInt(year));
		device.setStock(stock);
		
		if(dao.update(device)) {
			System.out.println("수정되었습니다.");
		}
	}
		
	
	// 상품리스트
	private void list_all() {
		Device temp = null;
		
		int seqNo = 1;
		System.out.println("----------------------------------------");
		System.out.println("제품코드        제품명        출시년도   재고");
		List<Device>list = searchList("");
		for(Device dev : list) {
			if(dev != null) {
				System.out.println(" " + seqNo++ + " " + dev.showList());
			}
		}
	}
	
	
	// 상품검색
	private void search() {
		String name = "";
		while(true) {
			System.out.println("제품명을 입력해주세요: ");
			name = scn.nextLine();
			if(!name.isBlank()) {
				break;
			}
			System.out.println("제품명은 필수입력 항목입니다.");
		}
		
		Device result = searchDevice(name);
		if(result == null) {
			System.out.println("검색결과가 없습니다.");
			return;
		}
		System.out.println(result.showListInfo());
	}
	
	
	
	// list_all와 검색결과에서 사용
	private List<Device> searchList(String keyword){
		List<Device> list = dao.list(keyword);
		return list;
	}

	// 기기명으로 조회
	private Device searchDevice(String dcode) {
		return dao.select(dcode);
	}
	
	
	public void main() {
		while(true) {
			System.out.println("아이디를 입력하세요: ");
			String id = scn.nextLine();
			System.out.println("비밀번호를 입력하세요: ");
			String pw = scn.nextLine();
			
			Userdata user = login(id, pw);
			if (user != null) {
				System.out.println("========================================");
				System.out.println("            환영합니다, " + (user.getUserName()) + "님");
				System.out.println("========================================");
//				System.out.println("     ");
				break;
			}
			System.out.println("아이디, 비밀번호를 다시 확인해주세요.");
		}
		
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------\n"
					+          "1.상품검색 2.모든상품 조회  3.유용한 사이트 모음\n"
					+          "4.상품 등록    5.상품 삭제     6.상품정보 수정\n"
					+          "----------------------------------------\n"
					+          "                           0.프로그램 종료");
			System.out.println("메뉴를 선택하세요: ");
			int menu = 0;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				} catch(NumberFormatException e) {
					System.out.println("숫자만 입력 가능합니다.");
				}
			}
			
			switch(menu) {
			case 1 : search();
			break;
			case 2 : list_all();
			break;
			case 3 : useful();
			break;
			case 4 : add();
			break;
			case 5 : delete();
			break;
			case 6 : edit();
			break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default : 
				System.out.println("올바른 메뉴를 입력해주세요.");
			}
		}
	}		
}
