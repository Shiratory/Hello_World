package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello, World";
		str = new String("Hello, World");
		byte[] byteArray = str.getBytes();
		for(int i=0; i<byteArray.length; i++) {
			System.out.println(byteArray[i]);
		}
		
		byte[] bstr = {72,101,108,108,111,44,32,87,111,114,108,100};
		String msg = new String(bstr, 7, 5);
		System.out.println(msg);
		char result = msg.charAt(0);
		System.out.println(result);
		
		// String: "", char: ''
		if(result == 'W') {
			// 비교구문
		}
		
		int idx = msg.indexOf("o");
		if(idx != -1) {
			// 처리	
		}
		
		String[] names = {"홍길동", "홍길순", "길민규", "길길길"};
		int cnt = 0;
		for(int i=0; i<names.length; i++) {
			if(names[i].indexOf("홍") == 0) {
				cnt++;
			}
		}
		System.out.println("\"홍\"을 성씨로 하는 이름의 갯수: " + cnt);
		
		System.out.println("Hello, World".substring(3, 7));
		
		
		
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		
	}
}