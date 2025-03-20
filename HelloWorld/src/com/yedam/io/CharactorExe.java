package com.yedam.io;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CharactorExe {
	public static void main(String[] args) {
		Scanner scn = null;
		// 파일안에 내용을 읽음
		try {
			scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
			while(true) {
				String msg = scn.nextLine();
				String[] msgAry = msg.split(" ");
				System.out.println("코드 : " + msgAry[0] 
								 + ", 이름 : " + msgAry[1] 
								 + ", 가격 :" + msgAry[2]);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchElementException e) {
			
		}
		scn.close();
		System.out.println("end of prog");
	}
	
	
	static void write2() {
		Scanner scn = new Scanner(System.in);
		// 입력값을 파일로 출력
		try {
			Writer writer = new FileWriter("c:/temp/message.txt");
			while(true) {
				System.out.println("입력하시오");
				String msg = scn.nextLine();
				if(msg.equals("quit")) {
					break;
				}
				writer.write(msg+ "\n");
				writer.flush();
			}
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		scn.close();
		System.out.println("end of frog");
	}
		
	
	static void read() {	
		// 입력스트림(문자)
		try {
			Reader reader = new FileReader("D:\\DEV\\Git\\Hello_World\\Hello_World\\HelloWorld\\src\\com\\yedam\\io\\StreamExe.java");
			while(true) {
				int data = reader.read();
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
			reader.close();
		} catch(IOException e) {
				e.printStackTrace();
		}
		System.out.println("end of frog");
		}
	
	
	static void write() {
		try {
			Writer writer = new FileWriter("c:/temp/data.txt");
			writer.write('s');
			writer.write('e');
			writer.write('x');
			
			writer.flush();
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of frog");
	}
}
