<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo</title>
</head>
<body>
    <%
        java.util.List<demo.Message> messageList = (java.util.List<demo.Message>) request.getAttribute("messageList");
        for (demo.Message message : messageList) {

            out.print("<div>");
            out.print(message.getMessage());
            out.print("</div>");
            out.print("<div>");
            out.print("(");
            out.print(message.getLatitude());
            out.print(",");
            out.print(message.getLongitude());
            out.print(")");
            out.print("</div>");

        }
    %>
</body>
</html>
