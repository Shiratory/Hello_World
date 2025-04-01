<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- deleteBoard.jsp -->
<jsp:include page = "includes/header.jsp"/>
<h3>파괴화면(deleteBoard.jsp)</h3>
<%
  BoardVO board = (BoardVO) request.getAttribute("board");
  String paging = (String) request.getAttribute("page");
%>
<form action="deleteBoard.do">
 <input type = "hidden" name = "bno" value = "<%= board.getBoardNo() %>">
 <input type = "hidden" name = "page" value = "<%= paging %>">
  <table class = "table">
    
     <tr>
       <th>글 번호</th><td><%=board.getBoardNo() %></td>
       <th>작성자</th><td><%=board.getWriter() %></td>
     </tr>
  	 <tr>
  	   <th>제 목</th><td colspan = "3"><%=board.getTitle() %></td>
  	 </tr>
	 <tr>
	   <th>내 용</th>
	   <td colspan = "3"><textarea class = "form-control" name = "content" cols = "30" rows = "3" readonly><%=board.getContent() %></textarea></td>
	 </tr> 
	 <tr>
  	   <th>작성일자</th><td colspan = "3"><%=board.getWriteDate() %></td>
  	 </tr>
  	 <tr>
  	   <td colspan = "3">
  	     <input type = "submit" value = "삭제" class = "btn btn-danger">
       </td>
  </table>
  </form>
<jsp:include page = "includes/footer.jsp"/>