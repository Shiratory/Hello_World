package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EventService {
	boolean addEvent(EventVO eve);
	boolean deleteEvent(EventVO eve);
	List<Map<String, Object>> getEvent();
	
	// 차트
	List<Map<String, Object>> cntPerWriter();
	
	// 로그생성
	void logCreate(Map<String, String> map);
	
}
