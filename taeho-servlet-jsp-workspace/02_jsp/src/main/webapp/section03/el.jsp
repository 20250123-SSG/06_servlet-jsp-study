<%@ page import="com.johnth.jsp.dto.PersonDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%--  <h3> 기존방식 (JSP 표현식 활용)</h3>--%>
<%--<%--%>
<%--  String classRoom = (String)request.getAttribute("classRoom");--%>
<%--  PersonDto person = (PersonDto)request.getAttribute("person");--%>
<%--  PersonDto teacher = (PersonDto)session.getAttribute("teacher");--%>
<%--  String academy = (String)request.getAttribute("academy");--%>
<%--%>--%>
<%--  <h3>기존 방식 jsp 활용</h3>--%>
<%--<p>--%>
<%--  학원명 : <%=academy%>--%>
<%--  강의장 : <%=classRoom%>--%>
<%--  강사정보 : <%=teacher.getName()%>, <%=teacher.getAge()%>, <%=teacher.getGender()%>--%>
<%--  학생정보 : <%=teacher.getName()%>, <%=teacher.getAge()%>, <%=person.getGender()%>--%>
<%--</p>--%>

<h3>EL 방식</h3>
<p>
  학원명 : ${academy}<br>
  강의장 : ${classRoom}<br>
  강사정보 : ${ teacher.name }, ${ teacher.age }, ${ teacher.gender }
  학생정보 : ${ student.name }, ${ student.age }, ${ student.gender }
</p>

<h3>EL 특징</h3>
증복된 attribute : ${scope} <br>

pageScope에 접근: ${pageScope.scope} <br>
requestScope에 접근: ${requestScope.scope} <br>
sessionScope에 접근: ${sessionScope.scope} <br>
applicationScope에 접근: ${applicationScope.scope} <br>

존재하지 않는 attribute : ${test}, ${test.rwer}

<hr>

<h3>EL 연산자</h3>
<h4> 1.산술연산</h4>
기존 JSP표현식 + : <%=(int) request.getAttribute("big") + (int) request.getAttribute("small")%>

<h5> EL 방식</h5>
+ : ${big + small} <br>
- : ${big - small} <br>
* : ${big * small} <br>
/ : ${big / small}, ${big div small} <br>
% : ${big % small},${big mod small} <br>
<h5> 유의사항 : 문자열을 이어서 출력하고자할 때 + 연산 사용불가</h5>
${str1}${str3}

<h4>2. 대소 비교연산</h4>
&lt; : ${big < small}, ${big lt small}
&gt; : ${big > small}, ${big gt small}
&lt; = ${big <= small}, ${big le small}
&ge; : ${big >= small}, ${big ge small}

<h4>3. 동등 비교연산</h4>
${big == 10}, ${big eq 10} <br>
${str1 == str2},${str1 eq str2} <br>
${str1 == str3},${str1 eq str2} <br>
${str3 == "바이"},${str3 eq '잘가'} <br>

<br>
${big != 10}, ${big ne 10}
<h4>4. 객체가 null인지 또는 리스트가 비어있는지 비교</h4>
${book1 == null}, ${empty book1}
${book2 == null}, ${empty book2}

${empty list}
${empty list2}

${not empty list}, ${! empty list}


<h4> 5. 논리 연산자</h4>
&& : ${true && true}, ${true and true} <br>
|| : ${true || true}, ${true or true} <br>

big이 small보다 크고 list2가 비어있냐 : ${big gt small and empty list2}


</h4>
</body>
</html>
