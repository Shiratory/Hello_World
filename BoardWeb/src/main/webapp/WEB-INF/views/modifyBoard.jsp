<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- modifyBoard.jsp -->

<h3>수정화면(modifyForm.jsp)</h3>
<%
  BoardVO board = (BoardVO) request.getAttribute("board");
  String paging = (String) request.getAttribute("page");
%>
 <form action="modifyBoard.do">
 <input type = "hidden" name = "bno" value = "${board.boardNo }">
 <input type = "hidden" name = "page" value = "${page }">
  <table class = "table">
    
     <tr>
       <th>글 번호</th><td>${board.boardNo }</td>
       <th>작성자</th><td>${board.writer }</td>
     </tr>
  	 <tr>
  	   <th>제 목</th><td><input type = "text" name = "title" class="form-control" value=${board.title }></td>
  	 </tr>
	 <tr>
	   <th>내 용</th>
	   <td colspan = "3"><textarea class = "form-control" name = "content" cols = "30" rows = "3" >${board.content }</textarea></td>
	 </tr> 
	 <tr>
  	   <th>작성일자</th><td colspan = "3">${board.writeDate }</td>
  	 </tr>
  	 <tr>
  	   <td colspan = "3">
  	     <input type = "submit" value = "수정" class = "btn btn-warning">
       </td>
  </table>
  </form>
