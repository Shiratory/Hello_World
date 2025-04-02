package com.yedam.service;

import com.yedam.vo.MemberVO;

// 업무 프로셋스(service)
public interface MemberService {
	// 로긴
	MemberVO login(String id, String pw);
}
