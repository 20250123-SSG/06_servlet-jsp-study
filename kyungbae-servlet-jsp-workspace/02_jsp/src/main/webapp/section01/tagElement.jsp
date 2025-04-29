<%@ page import="com.kyungbae.jsp.dto.BookDto" %>
<%@ page import="com.kyungbae.jsp.dto.PersonDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <!-- HTML comment : 개발자 도구 탭 => Elements 통해 확인 가능, Java코드 및 JSP관련 구문 주석처리 못함 -->
  <%--  JSP comment : 노출이 되지 않음 (HTML문서에서 사용 안됨), Java코드 및 JSP관련 구문 주석처리 가능 --%>

  <%!
    // 선언식
    public int getRandom(){
        return (int)(Math.random()* 100 + 1);
    }
  %>

  <%
    // 스크립틀릿
    int sum = 0;
    int random = getRandom();
    for (int i = 1; i <= random; i++) {
        sum += i;
    }

    System.out.println("덧셈결과: " + sum);
  %>

  <!-- out 내강객체 : JSPWriter(화면) -->
  <b>덧셈결과 : <% out.println(sum); %></b> <%-- 스크립틀릿을 이용해서 특정값을 화면에 출력 가능 --%>
  <br>

  <% if (sum >= 3000) {%>
    <i>덧셈 결과가 3000보다 큽니다.</i>
  <% } else { %>
    <i>덧셈 결과가 3000보다 작습니다.</i>
  <% } %>

  <br><br>

  <!-- 표현식 -->
  <b>덧셈결과: <%= sum %></b>
  <br>
  <i>덧셈결과가 3000보다 <%= sum >= 3000? "큽니다" : "작습니다." %></i>

  <hr>

  <!-- JSP 내장 객체에 담은 Attribute 꺼내서 화면 구성하기 -->
  <%
    BookDto book = (BookDto)(request.getAttribute("book"));
    List<PersonDto> list = (List<PersonDto>)session.getAttribute("list");
    String academy = (String)application.getAttribute("academy");
  %>

  기관명 : <%= academy %> <br>
  도서정보 : <%= book.getTitle() %>, <%= book.getAuthor() %> <br>

  사람목록
  <table border="1">

    <% for(PersonDto p : list) { %> <%-- for문에 따라 <tr>요소가 반복적으로 만들어짐 --%>
    <tr>
      <td><%= p.getName() %></td>
      <td><%= p.getAge() %></td>
      <td><%= p.getGender() %></td>
    </tr>
    <% } %>

  </table>

  <%@ include file="common.jsp"%>

  <% "".charAt(10); %>

</body>
</html>
