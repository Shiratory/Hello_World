package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	// 아이디와 비밀번호를 활용해서 단건조회
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	int insertMember(MemberVO member); // 입력
}
