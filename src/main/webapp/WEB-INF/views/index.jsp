<%--
  Created by IntelliJ IDEA.
  User: hungpv
  Date: 21/10/2019
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    SessionId: <%=request.getSession().getId()%>
    <br>
    <a href="sendRequest?id=<%=request.getSession().getId()%>">Send Request</a>
    source: <%=request.getAttribute("info")%>
</body>
</html>
