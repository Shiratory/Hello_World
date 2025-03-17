package inharrydance;
/*
 * 추상클라스
 * 추상메소드 : 선언부분만 존재
 */

public abstract class Animal {
	abstract void sound(); // 자식클라스에 규칙을 지정
	void eat() {
		System.out.println("먹는다");
	}
}
