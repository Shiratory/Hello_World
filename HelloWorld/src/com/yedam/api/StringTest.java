package com.yedam.api;

public class StringTest {
	public static void main(String[] args) {
	// 성별반환	
		String[] ssn = { "9503061234567",
						"990603 2345678",
						"030502-3456789"};
		for(int i=0; i<ssn.length; i++) {
		String gender = StringUtil.getGender(ssn[i]);
		System.out.println(gender);
		}
	
		String[] files = { "c:/temp/orange.jpg",
						"d:/storage/test/grape.jpeg",
						"c:/img/melon.gif"};
		for(int i=0; i<files.length; i++) {
		System.out.println("파일이름은 " + StringUtil.getFileName1(files[i]));
		System.out.println("파일의 확장자는 " + StringUtil.getExtName(files[i]));
		}
	}
}
