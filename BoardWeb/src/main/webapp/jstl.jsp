<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
    request.setAttribute("name", "Hong");
  	List<String> list = new ArrayList<String>();
  	list.add("Hello");
  	list.add("Bitch");
  	list.add("Good");
  	request.setAttribute("list", list);
  	request.setAttribute("today", new Date());
  %>
  <!-- jstl 변수초기화 Expression Language (EL)-->
  <c:set var = "msg" value = "Hello"/>
  <p><c:out value="${msg }"></c:out></p>
  <p>request 객체의 name Attribute의 값은 ${name }</p>
  <p>session 객체의 logId Attribute의 값은 ${logId }</p>
  
  <c:if test = "${msg == 'Hello' }">
    <c:out value = "msg의 값이 Hello입니다."></c:out>
  </c:if>
  
  <c:set var = "age" value = "3"></c:set>
  <c:choose>
    <c:when test ="${age >= 30 }">
     <p>성인입니다.</p>
     </c:when>
    <c:otherwise>
     <p>응애입니다.</p>
    </c:otherwise>
  </c:choose>
  
  <!-- 반복문 -->
  <% for(int i=1; i<=10; i++) {} %>
  <c:forEach var = "i" begin = "1" end = "10" step = "1">
    <p>2 * ${i} = ${2 * i}</p>
  </c:forEach>
  
  <ul>
  <c:forEach var = "str" items = "${list }">
  <li><c:out value = "${str }"></c:out></li>
  </c:forEach>
  </ul>
  
  <!-- fmt -->
  <fmt:formatDate value = "${today }" pattern = "yyyy-MM-dd HH:mm:ss" />
  <c:set var = "cnt" value = "1000000000000" ></c:set>
  <fmt:formatNumber value = "${cnt }" pattern = "##,### 딸라"></fmt:formatNumber>
    <script>
    let msg = 'Hello';
    console.log(`${msg}`);
  </script>
</body>
</html>