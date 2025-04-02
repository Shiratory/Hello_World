package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno=15 단건조회 modifyBoard.jsp
		
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int boardNo = Integer.parseInt(req.getParameter("bno"));
		BoardVO board = mapper.selectOne(Integer.parseInt(bno));
		sqlSession.close();
		
		// 권한체크
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		
		if(logId != null && logId.equals(board.getWriter())) {
			
			// board.jsp 전달
			req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", " 다른 사람의 글은 수정할 수 없습니다.");
			req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
		}
		
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);
		
		
	}

}
