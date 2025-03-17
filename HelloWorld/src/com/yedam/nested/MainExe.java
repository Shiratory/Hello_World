package com.yedam.nested;

public class MainExe {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method1();
		
		// Inner 클라스의 타입변수
		Outer.Inner inner = outer.new Inner();
		inner.innerMethod();
	}
}
