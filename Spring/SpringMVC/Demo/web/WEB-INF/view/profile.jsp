<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
    <h1>Your Profile</h1>
    <%
        demo.User user = (demo.User) request.getAttribute("user");
        out.print(user.getUsername());
        out.print("<br>");
        out.print(user.getFirstName());
        out.print(" ");
        out.print(user.getLastName());
        out.print("<br>");
        out.print(user.getEmail());
    %>
</body>
</html>
