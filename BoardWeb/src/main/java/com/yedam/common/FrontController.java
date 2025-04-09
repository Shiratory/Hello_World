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
import com.yedam.control.AddReplycontrol;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteEventControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.DeteleBoardControl;
import com.yedam.control.EventFormControl;
import com.yedam.control.EventListControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RLDatatable;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.addEventControl;

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
		
		map.put("/main.do", new MainControl()); // 메인화면
		map.put("/board.do", new BoardControl()); // 상세화면
		map.put("/boardList.do", new BoardListControl()); // 목록
		map.put("/addBoard.do", new AddBoardControl());// 글 등록 
		map.put("/modifyForm.do", new ModifyFormControl()); // 글 수정 화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정 처리
		map.put("/deleteForm.do", new DeleteFormControl()); // 삭제화면
		map.put("/deleteBoard.do", new DeteleBoardControl()); // 삭제처리
		map.put("/loginForm.do", new LoginFormControl()); // 로그인화면
		map.put("/login.do", new LoginControl()); // 로그인처리
		map.put("/logout.do", new LogoutControl()); // 로그아웃처리
		map.put("/signForm.do", new SignUpControl()); // 회원가입)
		map.put("/signUp.do", new SignUpControl()); // 회원가입처리
		map.put("/javascript.do", new JSControl());
		map.put("/replyList.do", new ReplyListControl()); // 댓글 데이터
		map.put("/removeReply.do", new RemoveReplyControl()); // 삭제
		map.put("/addReply.do", new AddReplycontrol()); // 추가
		map.put("/replyCount.do", new ReplyCountControl()); // 댓글 수
		map.put("/replyListDatatable.do", new RLDatatable()); // 댓글목록
		map.put("/eventForm.do", new EventFormControl()); // fullcalendar 관련
		map.put("/addEvent.do", new addEventControl());
	    map.put("/eventList.do", new EventListControl());
		map.put("/deleteEvent.do", new DeleteEventControl());
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
