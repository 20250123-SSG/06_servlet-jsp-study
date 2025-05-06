<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <div style="border: 1px solid gray; padding: 10px">
    <% String currentYear = new SimpleDateFormat("yyyy").format(new Date()); %>
    Copyright ⓒ 2000 - <%=currentYear%> TH wow. All rights served.<br>

    해당 페이지로 전달되는 파라미터 :
  </div>

</body>
</html>
