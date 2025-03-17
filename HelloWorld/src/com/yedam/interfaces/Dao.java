package com.yedam.interfaces;

/*
 * Data Access Object
 * 인터베이스 내의 메소드는 추상메소드다
 * 
 */
public interface Dao {
	void insert();
	void update();
	void delete();
	void modify();
	void remove();
}
