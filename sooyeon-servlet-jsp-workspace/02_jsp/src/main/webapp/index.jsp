<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <h1>JSP</h1>
    <!--contextpath (/jsp)의 경우는 정적이 아닌 동적으로 변경해야됨. -> 만약 변경될 시 일괄 수정 가능하도록-->

    <h2>1. Script Element, Directive, 내장객체 확인</h2>
    <a href="/jsp/tag-element?no=1">정보 조회</a>s

    <hr>

    <h2>2. Standard Action Tag(표준액션태그) 확인</h2>
    <a href="/jsp/standard-action-tag">표준액션태그 확인</a>

    <hr>

    <h2>3. EL(Expression language) 확인</h2>
    <a href="<%=request.getContextPath()%>/el">EL 확인</a>

    <hr>

    <h2>4. JSTL 확인</h2>
    <a href="${pageContext.request.contextPath}/jstl">EL 확인</a>
  
  </body>
</html>
