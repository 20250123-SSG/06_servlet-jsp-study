<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>JSTL core Library</h2>

  <h3>1. 변수 (== jsp내장객체의 attribute)</h3>
  <c:set var="num1">10</c:set> <%-- pageScope 에 담아짐 --%>
  <c:set var="num2" value="20" scope="request"/> <%-- requestScope에 담아짐 --%>

  num1값 : ${num1}, ${pageScope.num1} <br>
  num2값 : ${num2}, ${requestScope.num2} <br>

  <c:set var="result" value="${num1 + num2}" scope="session"/>
  + : ${result}, ${sessionScope.result} <br>
  <hr>
  <%-- 자주 사용되는 c:set --%>
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  contextPth 값 : ${contextPath} <br>

  <a href="${contextPath}//el">el 확인</a> <br>

  <c:remove var="result" scope="session"/>
  삭제 후 result값 : ${result} <br>

  <hr>

  result값 : <c:out value="${result}" default="없음"/> <br>

  <c:set var="outTest" value="<b>출력테스트</b>"/>
  outTest값 : <c:out value="${outTest}"/> <br>
  outTest값 : <c:out value="${outTest}" escapeXml="false"/> <br>

  <hr>

  <h3>2. 조건문</h3>

  <!-- num1이 num2보다 작거나 같을 경우 특정 요소가 보여지도록 -->
  <%--
  <% if(num1 <= num2) {%>
  <% } %>
  --%>
  <h4>IF문 사용</h4>
  <c:if test="${num1 le num2}">
    <b>num1이 num2보다 작거나 같습니다.</b>
  </c:if>
  <br>

  <c:set var="str" value="안녕"/>

  <c:if test="${str == '안녕'}">
    <b>Hello World</b>
  </c:if>
  <c:if test='${str ne "안녕"}'>
    <b>Goodbye World</b>
  </c:if>
  <hr>

  <h4>ELSE IF문 사용</h4>
  <c:choose>
    <c:when test="${num1 gt 20}">
      <b>20보다 큰 수</b>
    </c:when>
    <c:when test="${num1 ge 10}">
      <b>10과 같거나 큰 수</b>
    </c:when>
    <c:otherwise>
      <b>10보다 작은 수</b>
    </c:otherwise>
  </c:choose>

  <h3>3. 반복문</h3>

  <c:forEach var="i" begin="1" end="10" step="2">
    <i>반복확인 : ${i}</i>
  </c:forEach>

  <c:forEach var="i" begin="1" end="6">
    <h${i}>태그 안에도 적용 가능</h${i}>
  </c:forEach>

  <hr>

  <ul>
    <c:forEach var="color" items="${colors}">
    <li style="color: ${color}">색상명 : ${color}</li>
    </c:forEach>
  </ul>

  <table border="1">
    <thead>
      <th>나이</th>
      <th colspan="3">성별</th>
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
  <hr>
  <ol>
    <c:forTokens var="d" items="${device}" delims=",./">
      <li>${d}</li>
    </c:forTokens>
  </ol>

  <h3>4. url 제작</h3>

  <a href="${contextPath}/test?name=길동&age=10">기존방식 (url 직접 작성)</a> <br>

  <!-- c:url은 자동으로 contextPath를 입력해줌 -->
  <a href="<c:url value="/test?name=동길&age=20"/>">c:url 바로 사용하는 방식</a> <br>

  <c:url var="mkurl" value="/test">
    <c:param name="name" value="깅돌"/>
    <c:param name="age" value="10"/>
  </c:url>

  <a href="${mkurl}">c:url로 만들어둔 걸 사용하는 방식</a>


</body>
</html>
