package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class DeleteFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		// 삭제화면(deleteForm.jsp)
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int boardNo = Integer.parseInt(req.getParameter("bno"));
		String page = req.getParameter("page");
		BoardVO board = mapper.selectOne(boardNo);
		sqlSession.close();
		
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/WEB-INF/views/deleteBoard.jsp").forward(req, resp);
	}

}
