<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>jsp:include</h2>
<p>다른 페이지를 포함하고자 할 때 사용되는 태그</p>
<h4> 기존 include 지시어 방식 (정적 include 방식)</h4>
<%@include file="common.jsp" %>
<br>

특징 : include 하는 jsp상에 선언된 변수를 현재 페이지에도 사용가능<br>
currentYear : <%=currentYear%>

벗, 현재 페이지에서 동일한 이름의 변수를 재선언 할 수 없음<br>
<%--  <% int currentYear = 2025; %>--%>
<h4> 표준 액션 태그 include 방식 (동적 include 방식) </h4>
<jsp:include page="common.jsp"/>
<br>

특징1: include 하는 jsp 상에 선언된 변수를 현재 페이지에서 사용 불가능 (따라서 재선언 가능) <br>

특징2: include 시 해당 jsp로 값을 전달해서 동적으로 표현할 수 있음
<jsp:include page="common.jsp">
  <jsp:param name="message" value="hello"/>
</jsp:include>
<br>
<jsp:include page="common.jsp">
  <jsp:param name="message" value="안녕"/>
</jsp:include>

<hr>

<h2>jsp:forward</h2>
<p>다른 페이지로 바로 포워딩 하고자 할 때</p>
<% int random = (int) (Math.random() * 10 + 1); %>
<% if (random >= 5) { %>
  <jsp:forward page="/section01/common.jsp"></jsp:forward>
<%} else { %>
<jsp:forward page="/section02/common.jsp">
  <jsp:param name="message" value="ㅇㅇㅇ"/>
</jsp:forward>
<% } %>

<!-- 포워딩된 페이지가 보여지나 url 에는 /jsp/standard-action-tag(매핑한 주소 페이지)가 찍혀있음 -->
</body>
</html>
