<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>JSTL Core Library</h2>

  <h3>1. 변수(==JSP 내장 객체의 attribute)</h3>
  <c:set var="num1">10</c:set>                                                        <!--pageContext.setAttribute("name1","10)-->
  <c:set var="num2" value="20" scope="request"/>                                      <!--pageContext.setAttribute("name1","20")-->

    num1값 : ${num1}, ${pageScope.num1} <br>                                          <!--num1값 : 10, 10-->
    num2값 : ${num2}, ${requestScope.num2} <br>                                       <!--num2값 : 20, 20-->

  <c:set var="result" value="${num1+num2}" scope="session"/>
  num1 + num2 : ${result} <br>


  <!-- 자주 사용되는 c:set -->
  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  contextPath 값 : ${contextPath} <br>                                                  <!--contextPath 값 : /jsp-->

  <a href="${contextPath}/el">el 확인</a> <br>

  <c:remove var="result" scope="session"/> <!--session.removeAttribute("result");-->
  result 삭제 : ${result} <br>                                                         <!--result 삭제 :-->
  result 기본값 설정 : <c:out value="${result}" default="없음"/> <br>                  <!--result 기본값 설정 : 없음-->

  <c:set var="outTest" value="<b>출력테스트</b>"/>
  outTest값 : <c:out value="${outTest}"/> <br>                                         <!--outTest값 : <b>출력테스트<b>-->
  outTest값 : <c:out value="${outTest}" escapeXml="false"/> <br>                       <!--outTest값 : 출력테스트-->





  <h3>2. 조건문</h3>
  <!--nul1이 num2보다 작거나 같을 경우 특정 요소가 보여지도록-->
  <c:if test="${num1 <= num2}">
    <b>num1 <= num2</b>
  </c:if>

  <c:set var="str" value="안녕"/>
  <c:if test="${str.equals('안녕')}">
    <b>같습니다.</b>
  </c:if>


  <br>
  <c:choose>
    <c:when test="${num1 > 20}">
    <b>num1 > 20</b>
    </c:when>
    <c:when test="${num1 >= 10}">
      <b>num1 >= 10</b>
    </c:when>
    <c:otherwise>
      num1 < 10
    </c:otherwise>
  </c:choose>

  <h3>3. 반복문</h3>
  <c:forEach var="i" begin="1" end="10" step="2">       <!-- 1 3 5 7 9 -->
    <b>${i}</b>
  </c:forEach>

  <c:forEach var="i" begin="1" end="6">
    <h${i}>h 태그안에도 사용할 수 있음</h${i}>
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
      <c:forEach var="person" items="${persons}" varStatus="sta">
        <tr>
  <%--        <td>${sta.index}</td> <!-- 0~ -->  --%>
          <td>${sta.count}</td>     <!-- 1~ -->
          <td>${person.name}</td>
          <td>${person.age}</td>
          <td>${person.gender}</td>
        </tr>
      </c:forEach>
    </thead>
  </table>

  <ol>
    <c:forTokens var="d" items="${device}" delims=",./">
      <li>${d}</li>
    </c:forTokens>
  </ol>
  <!--
  1. 컴퓨터
  2. 핸드폰
  3. TV
  4. 에어컨
  5. 냉장고
  6. 세탁기
  -->

  <h3>4. url 제작</h3>
  <a href="${contextPath}/test?name=홍길동&age=10">기존방식(url 직접 작성)</a> <br> <!--http://localhost:8080/jsp/test?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=10-->
  <!--자동으로 앞에 contextPath(/jsp)를 붙여줌-->
  <a href="<c:url value="/test?name=홍길동&age=10"/>">c:url을 바로 사용하는 방식</a> <br><!--http://localhost:8080/jsp/test?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=10-->

  <c:url var="mkurl" value="/test"> <!--mkurl = "test?name=홍길동&age=10"-->
    <c:param name="name" value="홍길동"/>
    <c:param name="age" value="10"/>
  </c:url>
  <a href="${mkurl}">c:url로 만들어두고 사용하는 방식</a>

</body>
</html>
