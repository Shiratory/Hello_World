<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!-- deleteBoard.jsp -->

<h3>파괴화면(deleteBoard.jsp)</h3>

<form action="deleteBoard.do">
 <input type = "hidden" name = "bno" value = "${board.boardNo }">
 <input type = "hidden" name = "page" value = "${page }">
  <table class = "table">
    
     <tr>
       <th>글 번호</th><td>${board.boardNo }</td>
       <th>작성자</th><td>${board.title }</td>
     </tr>
  	 <tr>
  	   <th>제 목</th><td colspan = "3">${board.title }</td>
  	 </tr>
	 <tr>
	   <th>내 용</th>
	   <td colspan = "3"><textarea class = "form-control" name = "content" cols = "30" rows = "3" readonly>${board.content }</textarea></td>
	 </tr> 
	 <tr>
  	   <th>작성일자</th><td colspan = "3">${board.writedate }</td>
  	 </tr>
  	 <tr>
  	   <td colspan = "3">
  	     <input type = "submit" value = "삭제" class = "btn btn-danger">
       </td>
  </table>
  </form>
