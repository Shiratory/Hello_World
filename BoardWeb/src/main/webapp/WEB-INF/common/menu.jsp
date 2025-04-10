<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
      String logId = (String) session.getAttribute("logId");
      String userName = (String) session.getAttribute("userName");
    %>
    <!-- menu.jsp -->
  <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">안녕하세요 <%=userName + " 님"%></div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글 목록</a>
                    <%if (logId == null) { %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
                    <%} else { %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addBoard.do">글쓰기</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃 (<%=userName + " 님"%>)</a>
                    <%} %>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="signForm.do">회원가입</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="javascript.do">JS연습</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="eventForm.do">캘린더</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="chart.do">차트</a>
                </div>
            </div>