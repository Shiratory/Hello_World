package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EventServiceImpl implements EventService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
		
	
	@Override
	public boolean addEvent(EventVO eve) {
		return mapper.addEvent(eve) > 0;
	}

	@Override
	public boolean deleteEvent(EventVO eve) {
		return mapper.deleteEvent(eve) > 0;
	}

	@Override
	public List<Map<String, Object>> getEvent() {
		return mapper.selectEvent();
	}

	@Override
	public List<Map<String, Object>> cntPerWriter() {
		return mapper.selectWriter();
	}

	@Override
	public void logCreate(Map<String, String> map) {
		mapper.insertLogging(map);
	}

}
