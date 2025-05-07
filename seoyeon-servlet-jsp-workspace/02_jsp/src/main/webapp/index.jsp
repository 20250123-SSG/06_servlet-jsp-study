<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>JSP</h1>

  <h2>1. Scripting Element, Directive, 내장객체 확인</h2>
  <a href="/jsp/tag-element?no=1">정보 조회</a>

  <hr>

  <h2>2. Standard Action Tag(표준액션태그) 확인</h2>
  <a href="/jsp/standard-action-tag">표준액션태그 확인</a>

  <hr>

  <h2>3. EL(Expression Language) 확인</h2>
  <a href="/jsp/el">EL 확인</a>

  <hr>

  <h2>4. JSTL 확인</h2>
  <a href="${pageContext.request.contextPath}/jsp/jstl">JSTL 확인</a>


</body>
</html>
