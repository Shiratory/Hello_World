<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.mapper.BoardMapper"%>
<%@page import="com.yedam.common.DataSource"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="ch.qos.logback.core.net.SyslogOutputStream"%>
<%@page import="java.util.List" %>
<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- webapp/views/test.jsp -->
	<%
	// 자바영역
	String msg = "Hell World";
	System.out.println(msg);
	int age = 200;
	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	SearchDTO search = new SearchDTO();
	search.setPage(1);
	List<BoardVO> list = mapper.selectBoard(search);
	%>
	<h3>글 목록</h3>
	<ul>
	<%
	for(BoardVO board : list) {
	%>
	  <li>글 번호(<%=board.getBoardNo() %>)/ 글 제목(<%=board.getTitle() %>)</li>
	<%
	}
	%>
	</ul>
	<p>저장정보</p>
	<p>age에 저장된 값은 <%=age %></p>
	<%
	if (age > 20){
	%>
	<p>성인입니다.</p>
	<%
	} else {
	%>
	<p>미성년자입니다</p>
	<%
	}
	%>
</body>
</html>