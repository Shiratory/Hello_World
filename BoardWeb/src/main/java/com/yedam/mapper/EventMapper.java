package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;


public interface EventMapper {
	// 목록
	List<EventVO> selectEvent();
	// 등록
	int addEvent(EventVO event);
	// 삭제
	int deleteEvent(EventVO event);
	
	// 차트
	List<Map<String,Object>> selectWriter();
	// 로그
	int insertLogging(Map<String, String> map);
}

