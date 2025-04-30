<%@ page import="com.ibe6.jsp.dto.BookDto" %>
<%@ page import="com.ibe6.jsp.dto.PersonDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" errorPage="errorPage500.jsp" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <!-- HTML comment : 개발자 도구탭(f12) > Elements 통해 확인 가능(노출o), , java코드 및 jsp관련 구문 주석처리 못함  -->
  <%-- JSP  comment : 개발자 도쿠탭(f12) > Elements 통해 확인 불가능(노출x), java코드 및 jsp관련 구문 주석처리 가능--%>

<%!
  // 선언식
  public int getRandom(){
      return (int)(Math.random() * 100 + 1);
  }
%>


<%
  // 스크립틀릿
  int sum = 0;
  int random = getRandom();
  for(int i=1; i<=random; i++){
      sum += i;
  }

  System.out.println("덧셈결과: " + sum); // 콘솔(System.out==PrintStream)에출력
%>
  <!-- out 내장객체 : JSPWriter(화면) -->
<b>덧셈결과 : <% out.println(sum); %></b> <!-- 스크립틀릿을 이용해서 특정값을 화면에 출력 가능 -->
  <br>

<% if(sum >= 3000) { %>
  <i>덧셈 결과가 3000보다 큽니다.</i>
<% }else {%>
  <i>덧셈 결과가 3000보다 작습니다.</i>
<% } %>

<br><br>

<b>덧셈결과 : <%= sum %></b>
<br>
<i>덧셈 결과가 3000보다 <%= sum >= 3000 ? "큽니다" : "작습니다" %></i>

  <hr>

<!-- JSP 내장객체에 담은 Attribute 꺼내서 화면 구성하기 -->
<%
  BookDto bk = (BookDto)request.getAttribute("book");
  List<PersonDto> list = (List<PersonDto>)session.getAttribute("list");
  String academy = (String)application.getAttribute("academy");
%>

기관명 : <%= academy %> <br>
도서정보 : <%= bk.getTitle() %>, <%=bk.getAuthor()%> <br>
사람목록 
<table border="1">
  <% for(PersonDto p : list) {%>
  <tr>
    <td><%=p.getName()%></td>
    <td><%=p.getAge()%></td>
    <td><%=p.getGender()%></td>
  </tr>
  <% } %>
  
</table>

  <%@ include file="common.jsp"%>

  <% "".charAt(10); %>
</body>
</html>
