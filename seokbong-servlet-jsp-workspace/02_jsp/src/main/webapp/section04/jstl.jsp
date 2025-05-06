<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>JSTL Core Library</h2>

  <h3>1. 변수 (== JSP내장객체의 attribute)</h3>
  <c:set var="num1">10</c:set>        <!-- pageContext.setAttribute("num1", "10"); -->
  <c:set var="num2" value="20" scope="request"/> <!-- request.setAttribute("num2", "20") -->

  num1값 : ${num1}, ${pageScope.num1} <br>
  num2값 : ${num2}, ${requestScope.num2} <br>

  <c:set var="result" value="${num1 + num2}" scope="session"/>
  result값 : ${result}, ${sessionScope.result} <br>

  <!-- 자주 사용되는 c:set -->
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  contextPath값 : ${contextPath} <br>

  <a href="${contextPath}/el">el 확인</a> <br>

  <c:remove var="result" scope="session"/> <!--session.removeAttribute("result)-->
  삭제 후 result값 : ${result} <br>

  result값 : <c:out value="${result}" default="없음"/> <br>

  <c:set var="outTest" value="<b>출력테스트</b>"/>
  outTest값 : <c:out value="${outTest}"/> <br>
  outTest값 : <c:out value="${outTest}" escapeXml="false"/>

  <h3>2. 조건문</h3>

  <!--num1이 num2보다 작거나 같을 경우 특정 요소가 보여지도록-->
  <%--
    <%if(num1 <= num2) { %>

    <% } %>
  --%>

  <c:if test="${num1 le num2}">
    <b>num1이 num2보다 작거나 같습니다.</b>
  </c:if>
  <br>

  <c:set var="str" value="안녕"/>
  <%--
    <% if(str.equals("안녕")) { %>

    <% } %>
  --%>
  <c:if test="${str eq '안녕'}">
    <b>Hello World</b>
  </c:if>

  <c:if test='${str ne "안녕"}'>
    <b>Bye World</b>
  </c:if>
  <br>

  <%--
    <% if(num1 > 20( { %>

    <% }else if(num1 >=10) { %>

    <% }else { %>

    <% } %>
  --%>

  <c:choose>
    <c:when test="${num1 gt 20}">
      <b>반갑습니다</b>
    </c:when>
    <c:when test="${num1 ge 10}">
      <b>안녕하세요</b>
    </c:when>
    <c:otherwise>
      <b>어서오세요</b>
    </c:otherwise>
  </c:choose>

  <h3>3. 반복문</h3>
  <%--
  <% for(int i=1; i<=10; i+=2){ %>

  <% } %>
  --%>
  <c:forEach var="i" begin="1" end="10" step="2">
    <i>반복확인 : ${i}</i> <br>
  </c:forEach>

  <c:forEach var="i" begin="1" end="6">
    <h${i}>태그 안에도 적용 가능</h${i}>
  </c:forEach>

  <ul>
    <c:forEach var="color" items="${colors}">
      <li style="color:${color};">${color}</li>
    </c:forEach>
  </ul>

  <table border="1">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>나이</th>
        <th>성별</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="p" items="${list}" varStatus="sta">
        <tr>
          <td>인덱스: ${sta.index}, 순번: ${sta.count}</td>
          <td>${p.name}</td>
          <td>${p.age}</td>
          <td>${p.gender}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <ol>
    <c:forTokens var="d" items="${device}" delims=",./">
      <li>${d}</li>
    </c:forTokens>
  </ol>

  <h3>4. url 제작</h3>

  <a href="${contextPath}/test?name=홍길동&age=10">기존방식(url 직접 작성)</a><br>

  <!-- c:url은 자동으로 앞에 contextPath를 붙여줌 -->
  <a href="<c:url value="/test?name=홍길동&age=10"/>">c:url 바로 사용하는 방식</a>

  <c:url var="mkurl" value="/test">
    <c:param name="name" value="홍길동"/>
    <c:param name="age" value="10"/>
  </c:url>
  <!-- /test?name=홍길동&age=10 -->

  <a href="${mkurl}">c:url로 만들어둔 걸 사용하는 방식</a>

</body>
</html>
