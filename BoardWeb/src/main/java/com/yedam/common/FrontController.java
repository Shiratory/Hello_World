package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.DeteleBoardControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;

// *.do 요청에 실행
public class FrontController extends HttpServlet {
	// 요청 URL <=> 실행컨트롤
	Map<String, Control> map;
	// 셍성자
	public FrontController() {
		map = new HashMap<String, Control>();
		
	}
	// init
	@Override
	public void init(ServletConfig config) throws ServletException{
		map.put("/board.do", new BoardControl()); // 상세화면
		map.put("/boardList.do", new BoardListControl()); // 목록
		map.put("/addBoard.do", new AddBoardControl());// 글 등록 AddBoardControl
		map.put("/modifyForm.do", new ModifyFormControl()); // 글 수정 화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정 처리
		map.put("/deleteForm.do", new DeleteFormControl());
		map.put("/deleteBoard.do", new DeteleBoardControl());
	}
	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url vs. uri
		// http://localhost:8080/BoardWeb/board.do/
		String uri  = req.getRequestURI();
//		System.out.println("요청 URI: " + uri); // /BoardWeb/board.do
		String context = req.getContextPath();
		String page = uri.substring(context.length()); // "/board.do"
		System.out.println(page);
		
		Control sub = map.get(page); // 키(url) -> control 반환
		sub.exec(req, resp);
	}
}
