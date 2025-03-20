package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExe {
	public static void main(String[] args) {
		File file = new File("c:/temp/new.txt");
		File file1 = new File("c:/temp/images/img1/newfolder");
			try {
				if(!file.exists()) {
					file.createNewFile();
					System.out.println("생성완료");
				}
				if(!file1.exists()) {
					file1.mkdirs(); // 복수의 폴더 생성
					System.out.println("폴더 생성완료");
				}
				FileWriter fw = new FileWriter(file); // 입출력스트림 매개값
				fw.write("Hello\n");
				fw.write("World\n");
				fw.flush();
				fw.close();
				if(file.exists()) {
				   file.delete();
				   System.out.println("제거완료");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} // 파일생성

		System.out.println("end of frog");
	}
}
