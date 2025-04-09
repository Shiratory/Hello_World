package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EventListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");

		SqlSessionFactory factory = DataSource.getInstance();
		try (SqlSession session = factory.openSession()) {
			EventMapper mapper = session.getMapper(EventMapper.class);
			List<EventVO> list = mapper.selectEvent(); // DB에서 일정 가져오기

			// Gson으로 JSON 변환 후 출력
			Gson gson = new Gson();
			String json = gson.toJson(list);
			resp.getWriter().print(json);
		}
	}
}
