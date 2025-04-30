<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

  <div style="border: 1px solid gray; padding: 10px;">
    <% String currentYear = new SimpleDateFormat("yyyy").format(new Date()); %>
    Copyright (C) 2000-<%=currentYear%> sotogito Academy. All right reserved. <br>

    <% String msg = request.getParameter("message"); %>
    <% if(msg != null) { %>
      해당 페이지로 전달되는 파라미터 : <%=msg%>
    <% } %>


<%--    해당 페이지로 전달되는 파라미터 : <%= request.getParameter("message")%>--%>
  </div>

</body>
</html>
