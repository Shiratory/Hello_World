package com.yedam.interfaces;
/*
 * 1차 프로젝트
 * 등록(insert), 수정(modify), 삭제(remove)
 */
public class MysqlDao implements Dao{
	@Override
	public void insert() {
		System.out.println("mysql용 등록");
	}
	@Override
	public void modify() {
		System.out.println("mysql용 수정");
	}
	@Override
	public void remove() {
		System.out.println("mysql용 삭제");
	}
}
