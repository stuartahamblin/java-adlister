<%--
  Created by IntelliJ IDEA.
  User: stuart
  Date: 12/10/18
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--MUST BE INCLUDED IF GOING TO HAVE <c:choose>ECT</c:choose> EXPRESSION--%>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Success</h1>

        <%--MY SOLUTION--%>
        <%--<form method="POST">--%>
            <%--<p>Username</p>--%>
            <%--<input id="username" name="username" type="text" placeholder="Enter your username">--%>
            <%--<p>Password</p>--%>
            <%--<input id="password" name="password" type="password" placeholder="Enter your password">--%>
            <%--<br>--%>
            <%--<button type="submit">Submit</button>--%>
        <%--</form>--%>


        <%--CLASS SOLUTION--%>
        <%
            if (request.getMethod().equalsIgnoreCase("POST")){
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                if(username != null && password != null){
                    if(username.equals("admin") && password.equals("password")){
                        response.sendRedirect("profile.jsp");
                    }
                }
            }
        %>
        <form action="login.jsp" method="POST">
            <label for="username">User Name:</label><input type="text" name="username" id="username">
            <label for="password">Password:</label><input type="password" name="password" id="password">
            <button>Login</button>
        </form>

        <%--MARIA SOLUTION--%>
    <%--<c:if test="${param.username.equals(\"admin\") && param.username.equals(\"password\")}">--%>
        <%--<jsp:forward page="profile.jsp"/>--%>
        <%--&lt;%&ndash;<c:redirect url="/profile.jsp"/>&ndash;%&gt;    altername way--%>
    <%--</c:if>--%>
    </body>
</html>
