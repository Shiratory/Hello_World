package com.yedam.test;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class test {
	public static void main(String[] args) {
		MemberService svc = new MemberServiceImpl();
		
		MemberVO member = svc.login("user02", "2222");
		System.out.println(member.toString());
	}
}
