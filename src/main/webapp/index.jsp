<%--
  Created by IntelliJ IDEA.
  User: moritz
  Date: 9/20/13
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello JEE7</title>
    <script type="text/javascript">
        var ws = new WebSocket("ws://localhost:8080/websocket");
        ws.onmessage = function(message) {
            console.log(message.data);
        };
    </script>
</head>

<body>

</body>
</html>