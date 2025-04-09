<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
    
    
<link rel = "stylesheet" href = "https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css">
<script src = "https://code.jquery.com/jquery-3.7.1.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src = "https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>

  <!-- webapp/WEB-INF/views/board.jsp -->
 
  <h3>게시글 상세(board2.jsp)</h3>
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
  <!-- 댓글관련 -->
 <input id = "addContent" class = "col-sm-6">
 <button class="btn btn-primary" id="addRow">댓글 등록</button>
 <button class="btn btn-danger" id="delRow">댓글 삭제</button>
 <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일자</th>
 	         </tr>
        </thead>
        <tfoot>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일자</th>
            </tr>
        </tfoot>
    </table>
  <script>
  const bno = "${board.boardNo}";
  const replyer = "${logId}";
    // 삭제버튼에 이벤트등록
    document.querySelector('button.btn.btn-danger').addEventListener('click', deleteFnc);
    // 삭제함수
    function deleteFnc() {
		location.href = 'deleteForm.do?page=${page}&bno=${board.boardNo}'; // 삭쩨화면 -> 삭제처리
    }
  </script>
  <!--  
  <script src = "js/boardService.js"></script>
  <script src = "js/board1.js"></script>
  -->
  <script src = "js/board2.js"></script>