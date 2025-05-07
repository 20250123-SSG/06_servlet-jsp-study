<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <h2>jsp:include</h2>
  <p>다른 페이지를 포함하고자 할 때 사용되는 태그</p>

  <%--
  <h4>기존 include 지시어 방식(정적 include 방식)</h4>
  <%@ include file="common.jsp" %>
  <br>

  특징 : include하는 jsp상에 선언된 변수를 현재 페이지에서도 사용 가능. 즉 standardActionTag에서 common에 선언된 변수 사용 가능
  currentYear : <%=currentYear%>

  단, 현재 페이지에서 동일한 이름의 변수를 재선언할 수 없음
  <% int currentYear = 2025; %>
  --%>

  <h4>표준액션 태그 include 방식(동적 include 방식)</h4>
  <!-- 액션태그 사용시 유의사항 : 반드시 종료태그까지 존재해야됨-->
  <jsp:include page="common.jsp"/>
  <br>

  특징1 : include 하는 jsp상에 선언된 변수를 현재 페이지에서 사용 불가능 (따라서 재선언 가능) <br>
<%--  currentYear : <%=currentYear%>--%>

  특징2 : include시 해당 jsp로 값을 전달해서 동적으로 표현할 수 있음 <br>
  <jsp:include page="common.jsp">
    <jsp:param name="message" value="hello"/>
  </jsp:include>

  <jsp:include page="common.jsp">
    <jsp:param name="message" value="incldue할때마다 특정 영역을 동적으로 사용할 수 있음"/>
  </jsp:include>


  <hr>

  <h2>jsp : forward</h2>
  <p>다른 페이지로 바로 포워딩하도자 할 때</p>

  <% int random = (int) (Math.random() * 10 + 1); %>
  <% if(random >= 5) { %>
    <jsp:forward page="/section01/common.jsp"/>
  <% }else { %>
    <jsp:forward page="/section02/common.jsp">
      <jsp:param name="message" value="url에서 파일 경로가 노출되지 않음 - index파일에 지정한 경로로 뜸 (index -> constroller -> 여기파일 -> common)"/>
    </jsp:forward>
  <% } %>




</body>
</html>
