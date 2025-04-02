<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
    
<jsp:include page="includes/header.jsp"/>
  <!-- webapp/WEB-INF/views/board.jsp -->
 
  <h3>게시글 상세(board.jsp)</h3>
  <form action="modifyForm.do">
  <input type = "hidden" name = "bno" value = "${board.boardNo }">
  <input type = "hidden" name = "page" value = "${page }">
  <table class = "table">
    
     <tr>
       <th>글 번호</th><td><c:out value = "${board.boardNo }" /></td>
       <th>작성자</th><td><c:out value = "${board.writer }" /></td>
     </tr>
  	 <tr>
  	   <th>제 목</th><td colspan = "3"><c:out value = "${board.title }" /></td>
  	 </tr>
	 <tr>
	   <th>내 용</th>
	   <td colspan = "3"><textarea class = "form-control" cols = "30" rows = "3" readonly><c:out value = "${board.content }" /></textarea></td>
	 </tr> 
	 <tr>
  	   <th>작성일자</th><td colspan = "3"><fmt:formatDate value = "${board.writeDate }" pattern = "yyyy-MM-dd HH:mm:ss" /></td>
  	 </tr>
  	   <c:if test = "${msg != null }">
  	     <tr><td align="center" style="color: crimson" colspan="4">${msg }</td></tr>
  	   </c:if>
  	 <tr>
  	  <td colspan="4" align = "center">
  	     <input type = "submit" value = "수정" class = "btn btn-warning">
  	     <c:choose>
  	       <c:when test="${logId != null && logId == board.writer}">
  	         <button type = "button" class = "btn btn-danger">삭제</button>
  	       </c:when>
  	       <c:otherwise>
  	         <button type = "button" class = "btn btn-danger" disabled>삭제</button>
  	       </c:otherwise>
  	     </c:choose>
       </td>
      </tr>
  </table>
  </form>
  <p><a href='boardList.do'>목록이동</a></p>
  <script>
    // 삭제버튼에 이벤트등록
    document.querySelector('button.btn.btn-danger').addEventListener('click', deleteFnc);
    // 삭제함수
    function deleteFnc() {
		location.href = 'deleteForm.do?page=${page}&bno=${board.boardNo}'; // 삭쩨화면 -> 삭제처리
    }
  </script>
<jsp:include page="includes/footer.jsp"/>