<%@ page import="java.awt.print.Book" %>
<%@ page import="com.younggalee.jsp.dto.BookDto" %>
<%@ page import="com.younggalee.jsp.dto.PersonDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="errorpage.jsp" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<!-- HTML comment : 개발자 도구탭(F12) > Elements 통해 확인 가능(노출O), java코드 및 jsp관련 구문은 주석처리 못함 -->
<%-- JSP comment : roqkfwk ehrnxoq(F12) > Elements 통해 확인 불가능 (노출X), java코드 및 jsp관련 구문은 주석처리 가능 --%>
<%!
  // 선언식
  public int getRandom(){
      return (int)(Math.random()*100 + 1);
  }
%>
<%
  //스크립틀릿 : java코드 작성시
  int sum = 0;
  int random = getRandom();
  for(int i=1; i<=random; i++){
      sum += i;
  }
  System.out.println("덧셈결과: " + sum);
%>
<!-- out 내장객체 : JSPWriter(화면) -->
<b>덧셈결과 : <% out.println(sum); %></b>


<br>

<% if(sum >= 3000) { %>
  <i>덧셈 결과가 3000보다 큽니다.</i>
<% } else { %>
  <i>덧셈 결과가 3000보다 작습니다.</i>
<% } %>

<br><br>

<b>덧셈결과 : <%= sum %></B>

<br>

<i>덧셈 결과가 3000보다 <%= sum >= 3000 ? "큽니다." : "작습니다." %></i>

<hr>

<!-- JSP 내장객체에 담은 Attribute 꺼내서 화면 구성하기 -->
<%
  BookDto bk = (BookDto) request.getAttribute("book"); // jsp 내장객체 request / 반환타입 object
  List<PersonDto> list = (List<PersonDto>) session.getAttribute("list");
  String academy = (String) application.getAttribute("academy");
%>

기관명 : <%= academy %> <br>
도서정보 : <%= bk.getTitle() %>, <%=bk.getAuthor() %> <br>
사람목록
<table border="1">
  <% for(PersonDto p : list) { %>
  <tr>
    <td> <%= p.getName()%> </td>
    <td>  <%= p.getAge()%> </td>
    <td>  <%= p.getGender()%>  </td>
  <% } %>

</table>

<%@ include file="common.jsp" %>



</body>
</html>
