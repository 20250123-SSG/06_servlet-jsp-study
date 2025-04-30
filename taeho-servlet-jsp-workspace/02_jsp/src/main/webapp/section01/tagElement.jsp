<%@ page import="com.johnth.jsp.dto.BookDto" %>
<%@ page import="com.johnth.jsp.dto.PersonDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<!-- HTML 주석 : 개발자 도구탭(F12) => Elemnets통해 확인 가능, Java 코드나 JSP 관련 구문 주석처리 불가  -->
<%-- JSP commnet :                                  확인 불가,                                    가능  --%>

<%! ///선언식
  public int getRandom() {
    return (int)(Math.random() * 100 +1);
  }
%>

<% /// 스크립틀릿
  int sum = 0;
  for(int i=1; i<100; i++){
    sum += i;
  }
  System.out.println("덧셈결과 : " + sum);
%>

<!-- out 내장 객체 : JSPWriter(화면)    (비권장)-->
<b>덧셈 결과 : <% out.println(sum); %></b> <%--스크립트를 이용해서 특정 값을 화면에 출력 가능--%>
<br>
<% if(sum >= 3000) { %>
<i>덧셈 결과가 3000보다 큽니다.</i>
<% }else {%>
<i>덧셈 결과가 3000보다 작습니다.</i>
<% } %>


<br><br>

<b>덧셈 결과 : <%= sum %></b> <%--표현식--%>
<br>
<i>덧셈 결과가 3000보다~~~ <%= sum >= 3000 ? "큽니다" : "작습니다" %></i>



<!--JSP 내장 객체에 담은 attirbute꺼내서 화면 구성-->
<%
  BookDto book = (BookDto) request.getAttribute("book"); /// request.getAttribute의 기본값 : Object
  List<PersonDto> personList = (List<PersonDto>) session.getAttribute("personList");
  String academy = (String) application.getAttribute("academy");
%>
기관명 : <%= academy %><br>
도서 정보 : <%= book.getTitle() %>, <%= book.getAuthor() %>
<%--  사람들 : <%= personList.forEach(p -> p.getName()) %> forEach 메서드는 void를 반환하기 때문에 500오류 --%>
사람들
<table border="50">
  <tr>
    <th>이름</th>
    <th>나이</th>
    <th>성별</th>
  </tr>
  <% for(PersonDto person : personList){ %>
  <tr>
    <td><%=person.getName()%></td>
    <td><%=person.getAge()%></td>
    <td><%=person.getGender()%></td>
  </tr>
  <% } %>
</table>


<%@ include file="common.jsp" %>

<% "".charAt(10); %> <!--HTTP 상태 500 – 내부 서버 오류-->


</body>
</html>