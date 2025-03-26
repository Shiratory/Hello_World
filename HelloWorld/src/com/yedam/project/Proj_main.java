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
	UserJdbc bao = new UserJdbc();
	
	// 로그인 (아이디 비번 입력)
	private Userdata login(String id, String pw) {
		UserJdbc dao = new UserJdbc();
		return dao.login(id, pw);
	}
	
	
	// 유용한 사이트 모음
	private void useful() {
		System.out.println("-----------------------------------");
		System.out.println("       어떤 정보를 찾고 계십니까? \n"
				          + "----------------------------------- \n"
				          + "1. 중고기기를 거래하고 싶어요 \n"
				          + "2. 테크 소식과 뉴스를 보고 싶어요 \n"
				          + "3. 내 기기와 다른 기기의 성능비교를 원해요");
		int num = Integer.parseInt(scn.nextLine());
		
		if(num == 1) {
			System.out.println(Device.num_one());			
		}
		if(num == 2) {
			System.out.println(Device.num_two());			
		}
		if(num == 3) {
			System.out.println(Device.num_thr());			
		}
	}
	
	
	// 상품추가
	private void add() {
		System.out.print("관리자 전용 메뉴입니다. 비밀번호를 입력하세요: ");
		String password = scn.nextLine();
		
		String intPassword = "admin";
		if(!password.equals(intPassword)) {
			System.out.println("----------------------------------------");
			System.out.print("비밀번호가 틀렸습니다. 이전 메뉴로 되돌아갑니다. \n");
			return;
		}
		
		
		String bcode = "";
		while(true) {
			System.out.println ("----------------------------");
			System.out.print("추가할 제품의 코드를 입력하세요: ");
			bcode = scn.nextLine();
			if(!bcode.isBlank()) {
				break;
			}
			System.out.println("제품코드는 필수 입력항목입니다.");
		}
		System.out.println ("----------------------------");
		System.out.print("제품명을 입력하세요: ");
		String name = scn.nextLine();
		System.out.println ("----------------------------");
		System.out.print("출시년도를 입력하세요: ");
		String year = scn.nextLine();
		System.out.println ("----------------------------");
		System.out.print("재고를 입력하세요: ");
		String stock = scn.nextLine();
		
		if(bcode.isBlank() || name.isBlank() || year.isBlank() || stock.isBlank()) {
			System.out.println("입력되지 않은 항목이 있습니다. 작업을 취소합니다.");
			return;
		}
		Device device = new Device(bcode, name, Integer.parseInt(year), stock);
		if(dao.insert(device)) {
			System.out.println ("----------------------------");
			System.out.println("상품이 추가되었습니다.");
		} else
			System.out.println ("----------------------------");
	}

	
	// 상품삭제
	private void delete() {
		System.out.print("관리자 전용 메뉴입니다. 비밀번호를 입력하세요: ");
		String password = scn.nextLine();
		
		String intPassword = "admin";
		if(!password.equals(intPassword)) {
			System.out.println("----------------------------------------");
			System.out.print("비밀번호가 틀렸습니다. 이전 메뉴로 되돌아갑니다. \n");
			return;
		}
		
		String bcode = "";
		while(true) {
			System.out.println ("----------------------------");
			System.out.print("삭제할 제품코드를 입력하세요: ");
			bcode = scn.nextLine();
			if(!bcode.isBlank()) {
				break;
			}
			System.out.println("제품코드는 필수 입력항목입니다.");
		}
		if (dao.delete(bcode)) {
			System.out.println ("----------------------------");
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println ("----------------------------");
			System.out.println("삭제할 항목이 없습니다.");
		}
	}
	
	
	// 상품수정
	private void edit() {
		System.out.print("관리자 전용 메뉴입니다. 비밀번호를 입력하세요: ");
		String password = scn.nextLine();
		
		String intPassword = "admin";
		if(!password.equals(intPassword)) {
			System.out.println("----------------------------------------");
			System.out.print("비밀번호가 틀렸습니다. 이전 메뉴로 되돌아갑니다. \n");
			return;
		}
		
		String bcode = "";
		while(true) {
			System.out.println ("----------------------------");
			System.out.print("수정할 제품코드를 입력하세요: ");
			bcode = scn.nextLine();
			if(!bcode.isBlank()) {
				break;
			}
			System.out.println("제품코드는 필수 입력항목입니다.");
		}
		System.out.println ("----------------------------");
		System.out.print("수정할 상품명을 입력하세요: ");
		String name = scn.nextLine();
		System.out.println ("----------------------------");
		System.out.print("수정할 출시년도를 입력하세요: ");
		String year = scn.nextLine();
		System.out.println ("----------------------------");
		System.out.print("재고를 몇 개로 수정하시겠습니까?: ");
		String stock = scn.nextLine();
		
		Device device = new Device();
		device.setDeviceCode(bcode);
		device.setDeviceName(name);
		device.setUnpack(Integer.parseInt(year));
		device.setStock(stock);
		
		if(dao.update(device)) {
			System.out.println("수정되었습니다.");
		} else {
			System.out.println("----------------------------------------");
			System.out.println("항목을 찾을 수 없습니다. 제품코드를 확인 후 다시 시도하세요.");
		}
		
	}
		
	
	// 전체상품리스트
	private void list_all() {
		
		int seqNo = 1;
		System.out.println("-------------------------------------------");
		System.out.println("     제품코드" + "\t" + "    제품명   " + "\t" + "출시년도  " + "재고");
		System.out.println("-------------------------------------------");
		List<Device>list = searchList("");
		for(Device dev : list) {
			if(dev != null) {
				System.out.println(" " + seqNo++ + " || " + dev.showList());
			}
		}
		int num = -1;
		num = num + seqNo;
		System.out.println("-------------------------------------------");
		System.out.println("총 " + num + "개의 상품이 있습니다.");
	}
	
	
	// 상품검색
	private void search() {
		int i = 0;
		String name = "";
		while(true) {
			System.out.println ("----------------------------");
			System.out.println("제품명을 입력해주세요: \n");
			name = scn.nextLine();
			if(!name.isBlank()) {
				break;
			}
			System.out.println("제품명은 필수입력 항목입니다.");
		}
		
		List<Device> result = searchDevice(name);
		if(result.isEmpty()) {
			System.out.println("----------------------------------------");
			System.out.println("검색결과가 없습니다.");
			return;
		}
		for(i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).showListInfo());
		}
		System.out.println("-------------------------------------------------");
		System.out.println("검색어 " + "'" + name + "'" + "을(를) 포함한 " + (i) + "개의 상품이 검색되었습니다.");
		
	}
	
	
	// 회원가입
	private void join() {
		System.out.print ("---------------------------- \n");
		System.out.println("가입할 아이디를 입력하세요: ");
		String id = scn.nextLine();
		System.out.print ("---------------------------- \n");
		System.out.println("사용할 닉네임을 입력하세요: ");
		String nn = scn.nextLine();
		System.out.print ("---------------------------- \n");
		System.out.println("비밀번호를 입력하세요: ");
		String pw = scn.nextLine();
	
		if(id.isBlank() || nn.isBlank() || pw.isBlank()) {
			System.out.println("입력하지 않은 항목이 있습니다.");
			return;
		}
		Userdata userdata = new Userdata(id, nn, pw);
			if(bao.join(userdata)) {
				System.out.println ("----------------------------");
				System.out.println("      회원가입을 환영합니다.");
				System.out.println ("----------------------------");
			} else {
				System.out.println("회원가입에 실패했습니다.");
			}
	}
	
	
	// list_all와 검색결과에서 사용
	private List<Device> searchList(String keyword){
		List<Device> list = dao.list(keyword);
		return list;
	}

	// 기기명으로 검색
	private List<Device> searchDevice(String bcode) {
		return dao.select(bcode);
	}
	
	


	public void main() {
		
		System.out.print ("---------------------------- \n");
		System.out.print ("     방문해주셔서 감사합니다 \n");
		System.out.print ("----------------------------\n");
		while(true) {
			int sign = 0;
			System.out.println("1. 로그인 " + "2. 회원가입");
			
				try {
					sign = Integer.parseInt(scn.nextLine());
				} catch(NumberFormatException e) {
					System.out.println("실행할 기능을 숫자로 입력해주세요.\n");
					System.out.println ("----------------------------");
				}
			
				if(sign == 1) {
					break;
				} else if(sign == 2){
					join();
				}	
			}
		
		
		
		
		while(true) {
			
			System.out.println ("----------------------------");
			System.out.println("아이디를 입력하세요: ");
			String id = scn.nextLine();
			System.out.println ("----------------------------");
			System.out.println("비밀번호를 입력하세요: ");
			String pw = scn.nextLine();
			
			Userdata user = login(id, pw);
			if (user != null) {
				System.out.println("=================================================");
				System.out.println("                환영합니다, " + (user.getUserName()) + "님");
				System.out.println("=================================================");
				break;
				}
			System.out.println("아이디, 비밀번호를 다시 확인해주세요.");
		}
		
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------------\n"
					+          "1.상품검색" + "\t" + "2.모든상품 조회" + "\t" + "3.유용한 사이트 모음\n"
					+          "4.상품 등록" + "\t" + "5.상품 삭제" + "\t" + "6.상품정보 수정\n"
					+          "-------------------------------------------------\n"
					+          "                                0.프로그램 종료");
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
