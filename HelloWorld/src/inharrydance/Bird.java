package inharrydance;
/*
 * 부모클라스(Amimal)이 가진 추상메소드(sound)를 반드시 구현해야한다
 */

public class Bird extends Animal {
	void sound() {
		System.out.println("꽥꽥");
	}
}
