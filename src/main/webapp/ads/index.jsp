<%--
  Created by IntelliJ IDEA.
  User: stuart
  Date: 12/11/18
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>These are the ads</h2>
    <c:forEach items="${ads}" var="ad">
        <div class="ad">
            <h2>Title: ${ad.title}</h2>
            <p>Description: ${ad.description}</p>
        </div>
    </c:forEach>
</body>
</html>
