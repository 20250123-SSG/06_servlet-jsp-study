<%@ page import="com.kyungbae.jsp.dto.PersonDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <h3>기존 방식 (jsp 표현식 활용)</h3>
  <%--
  <%
    String classRoom = (String) request.getAttribute("classRoom");
    PersonDto student = (PersonDto) request.getAttribute("student");
    PersonDto teacher = (PersonDto) session.getAttribute("teacher");
    String academy = (String) application.getAttribute("academy");
  %>


  <p>
    학원명 : <%=academy%> <br>
    강의장 : <%=classRoom%> <br>
    강사정보 : <%=teacher.getName()%>, <%=teacher.getAge()%>, <%=teacher.getGender()%> <br>
    학생 : <%=student.getName()%>, <%=student.getAge()%>, <%=student.getGender()%>
  </p>
  --%>

  <h3>EL 방식</h3>
  <p>
    학원명 : ${ academy } <br>
    강의장 : ${ classRoom } <br>
    강사정보 : ${ teacher.name }, ${ teacher.age }, ${teacher.gender} <br>
    학생정보 : ${student.name}, ${student.age}, ${student.gender}
  </p>

  <hr>

  <h3>EL 특징</h3>
  중복된 attribute : ${scope} <br>

  pageScope 접근 : ${pageScope.scope} <br>
  requestScope 접근 : ${requestScope.scope} <br>
  sessionScope 접근 : ${sessionScope.scope} <br>
  applicationScope 접근 : ${applicationScope.scope}

  <hr>

  <h3>EL 연산자</h3>
  <h4>1. 산술 연산</h4>

  기존 JSP 표현식 + : <%= (int)request.getAttribute("big") + (int)request.getAttribute("small") %>

  <h5>EL 방식</h5>
  + : ${big + small} <br>
  - : ${big - small} <br>
  * : ${big * small} <br>
  / : ${big / small} <br>
  % : ${big % small} <br> <br>

  <h5>유의사항 : 문자열을 연이어주고자 할때 + 연산 사용 불가</h5>
<%--  ${str1 + str2} 에러 발생 : NumberFormatException--%>
  해결방법 : ${str1}${str3}

  <h4>2. 대소비교 연산</h4>
  less then &lt; : ${big < small}, ${big lt small} <br>
  greater then &gt; : ${big > small}, ${big gt small} <br>
  &le; : ${big <= small}, ${big le small} <br>
  &ge; : ${big >= small}, ${big ge small} <br>

  <h4>3. 동등 비교 연산</h4>
  ${big == 10}, ${big eq 10} <br>
  ${str1 == str2}, ${str1 eq str2} <br>
  ${str1 == str2}
  ${str1 == str3}
  ${str3 == "잘가"}, ${str3 eq '잘가'} <br>
  <br>
  ${big != 10}, ${big ne 10} <br>

  <h4>4. 객체가 null인지 또는 리스트가 비어있는지 비교</h4>
  ${book1 == null}, ${empty book1} <br>
  ${book2 == null}, ${empty book2} <br>

  ${empty list1} <br>
  ${empty list2} <br>



</body>
</html>
