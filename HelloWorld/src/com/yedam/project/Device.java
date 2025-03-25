package com.yedam.project;

public class Device {

	private String DeviceCode;
	private String DeviceName;
	private int Unpack;
	private String Stock;
	
	public Device() {}
	public Device(String DeviceCode, String DeviceName, int Unpack, String Stock) {
		this.DeviceCode = DeviceCode;
		this.DeviceName = DeviceName;
		this.Unpack = Unpack;
		this.Stock = Stock;
	}
	
	public String showList() {
		return DeviceCode + "\t" + DeviceName + "\t" + Unpack + "\t" + Stock;
	}
	public String showListInfo() {
		String msg = "기기코드: " + DeviceCode + "\t" + "|| 기기명: " + DeviceName + "\t" + "|| 출시년도: " + Unpack + " || 재고량: " + Stock;
		return msg;
	}
	
	// 3번항목 선택지 출력문구
	// 1번
	public static String num_one() {
		String num_one = "-------------------------------------------------"
				       + "\n아래의 사이트를 추천합니다. (주소를 드래그 후 복사하세요)"
				       + "\n-------------------------------------------------"
				       + "\n 세티즌 : https://m.cetizen.com/ "
				       + "\n 당근마켓 : https://www.daangn.com/kr/"
				       + "\n 중고나라 : https://web.joongna.com/";
		return num_one;
	}
	// 2번
	public static String num_two() {
		String num_two = "-------------------------------------------------"
				       + "\n아래의 사이트를 추천합니다. (주소를 드래그 후 복사하세요)"
				       + "\n-------------------------------------------------" 
				       + "\n ITWorld : https://www.itworld.co.kr/"
				       + "\n 지디넷코리아 : https://zdnet.co.kr/"
				       + "\n 더 테크 : https://www.the-tech.co.kr/";
		return num_two;
	}
	// 3번
	public static String num_thr() {
		String num_thr = "-------------------------------------------------"
				       + "\n아래의 사이트를 추천합니다. (주소를 드래그 후 복사하세요)"
				       + "\n-------------------------------------------------"
					   + "\n GSMArena (제원비교) : https://www.gsmarena.com/compare.php3"
					   + "\n PhoneArena (크기비교) : https://www.phonearena.com/phones/size"
					   + "\n NanoReview (성능비교) : https://nanoreview.net/en/phone-compare";
		return num_thr;
	}
				
				
	public String getDeviceCode() {
		return DeviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		DeviceCode = deviceCode;
	}
	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}
	public int getUnpack() {
		return Unpack;
	}
	public void setUnpack(int unpack) {
		Unpack = unpack;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	
}
