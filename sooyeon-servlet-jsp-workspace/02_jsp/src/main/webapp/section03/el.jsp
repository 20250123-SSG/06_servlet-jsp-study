<%@ page import="com.sotogito.jsp.dto.PersonDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
  <body>

    <h3>기존 방식 (JSP 표현식 활용)</h3>

    <%--
    <%
      String classRoom = (String) request.getAttribute("classRoom");
      PersonDto student = (PersonDto) request.getAttribute("student");

      PersonDto teacher = (PersonDto) session.getAttribute("teacher");

      String academy = (String) application.getAttribute("academy");
    %>

    강의장 : <%=classRoom%><br>
    학생 : <%=student.getName()%> <%=student.getAge()%> <%=student.getGender()%><br>
    선생님 : <%=teacher.getName()%> <%=teacher.getAge()%> <%=teacher.getGender()%><br>
    소속 : <%=academy%><br>
    --%>

    <h1>EL 방식</h1>
    <p>
      학원명 : ${academy} <br>
      강의장 : ${classRoom} <br>
      학생 :  ${student.name}  ${student.age} ${student.gender} <br>
      선생님 :  ${teacher.name}  ${teacher.age} ${teacher.gender}
    </p>

    <hr>

    <h3>EL 특징</h3>
    중복된 attribute : ${scope} <br>                <!--중복된 attribute : request에 담긴 데이터-->
    pageScope에 접근 : ${pageScope.scope} <br>
    request에 접근 : ${requestScope.scope} <br>     <!--pageScope에 접근 : request에 담긴 데이터-->
    session에 접근 : ${sessionScope.scope} <br>     <!--session에 접근 : session에 담긴 데이터-->
    application에 접근 : ${applicationScope.scope}  <!--application에 접근 : application에 담긴 데이터-->

    <h3>EL 연산자</h3>
    <h4>1. 산술 연산</h4>
    기존 JSP 표현식 + : <%= (int)request.getAttribute("big") + (int)request.getAttribute("small") %>

    <h5>EL 방식</h5>
    + : ${big + small} <br>
    - : ${big - small} <br>
    * : ${big * small} <br>
    / : ${big / small}, ${big div small} <br>
    % : ${big % small}, ${big mod small} <br>

    <h5>유의사항 : 문자열을 연이어주고 할 때 + 연사자 사용 불가</h5>
  <%--  ${str1 + str2} => NumberformatException--%>
    ${str}${str}

    <h4>2. 대소비교연산</h4>
    &lt; : ${big < small}, ${big lt small} <br>
    &lt; : ${big > small}, ${big gt small} <br>
    &lt;= : ${big <= small}, ${big le small} <br>
    &lt;= : ${big >= small}, ${big ge small} <br>

    <h4>3. 동등 비교 연산</h4>
    ${big == 10}, ${big eq 10} <br>
    ${str2 == str2}, ${str2 eq str2} <br>
    ${str3 == "잘가"}, ${str3 eq '잘가'} <br>

  <h4>4. 객체가 null인지 또는 리스트가 비어있는지 비교</h4>
  ${book1 == null}, ${empty book1} <br>
  ${book2 == null}, ${empty book2} <br>

  ${empty list1} <br>
  ${empty list2} <br>

  ${not empty list1}, ${! empty list1}

  <h4>5. 논리 연산자</h4>
  && : ${true && true}, ${true and true} <br>
  && : ${true || true}, ${true or true} <br>



</body>
</html>
