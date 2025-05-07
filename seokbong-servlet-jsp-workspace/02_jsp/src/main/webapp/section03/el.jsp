<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <%--
  <h3>기존 방식 (JSP 표현식 활용)</h3>
  <%@ page import="com.jjanggu.jsp.dto.PersonDto" %>
  <%
    String cRoom = (String)request.getAttribute("classRoom");
    PersonDto stu = (PersonDto)request.getAttribute("student");
    PersonDto tea = (PersonDto)session.getAttribute("teacher");
    String aca = (String)application.getAttribute("academy");
  %>
  <p>
    학원명 : <%=aca%> <br>
    강의장 : <%=cRoom%> <br>
    강사정보 : <%=tea.getName()%>, <%=tea.getAge()%>, <%=tea.getGender()%> <br>
    학생정보 : <%=stu.getName()%>, <%=stu.getAge()%>, <%=stu.getGender()%> <br>
  </p>
  --%>

  <h3>EL 방식</h3>
  <p>
    학원명 : ${ academy } <br>
    강의장 : ${ classRoom } <br>
    강사정보 : ${ teacher.name }, ${ teacher.age }, ${ teacher.gender } <br>
    학생정보 : ${ student.name }, ${ student.age }, ${ student.gender }
  </p>

  <hr>

  <h3>EL 특징</h3>
  중복된 attribute : ${ scope } <br>

  pageScope에 접근 : ${pageScope.scope} <br>
  requestScope에 접근 : ${requestScope.scope} <br>
  sessionScope에 접근 : ${sessionScope.scope} <br>
  applicationScope에 접근 : ${applicationScope.scope} <br>

  존재하지 않는 attribute : ${test}, ${test.sdf}

  <hr>

  <h3>EL 연산자</h3>
  <h4>1. 산술 연산</h4>

  기존 JSP 표현식 + : <%= (int)request.getAttribute("big") + (int)request.getAttribute("small") %>

  <h5>EL 방식</h5>
  + : ${big + small} <br>
  - : ${big - small} <br>
  * : ${big * small} <br>
  / : ${big / small}, ${big div small} <br>
  % : ${big % small}, ${big mod small} <br><br>
  <!-- el내에서 산수연산자 작성시 피연산자들을 무조건 숫자형으로 형변환해서 처리함 -->

  <h5>*유의사항 : 문자열을 연이어주고자 할 때 + 연산 사용 불가!</h5>
<%--  ${str1 + str2 => NumberFormatException 발생 --%>
  해결방법 : ${str1}${str3}

  <h4>2. 대소 비교 연산</h4>
  &lt; : ${big < small}, ${big lt small} <br>
  &gt; : ${big > small}, ${big gt small} <br>
  &lt;= : ${big <= small}, ${big le small} <br>
  &gt;= : ${big >= small}, ${big ge small} <br>

  <h4>3. 동등 비교 연산</h4>
  ${big == 10}, ${big eq 10} <br>
  ${str1 == str2}, ${str1 eq str2} <br>
  ${str1 == str3}, ${str1 eq str3} <br> <!-- EL에서의 ==은 자바의 equals와 동일하게 동작 -->
  ${str3 == "잘가"}, ${str3 eq '잘가'} <br> <!-- EL내에서 문자열 제시시 ''|"" 구분없음 -->
  <br>
  ${big != 10}, ${big ne 10} <br>

  <h4>4. 객체가 null인지 또는 리스트가 비어있는지 비교</h4>
  ${book1 == null}, ${empty book1} <br>
  ${book2 == null}, ${empty book2} <br>

  ${empty list1} <br>
  ${empty list2} <br>

  ${not empty list1}, ${!empty list1} <br>
  ${not empty list2} <br>

  <h4>5. 논리 연산자</h4>
  && : ${true && true}, ${true and true} <br>
  || : ${true || true}, ${true or true} <br>

  big이 small보다 크고 list2가 비어있냐 : ${(big gt small) and empty list2}


</body>
</html>
