<%--
  Created by IntelliJ IDEA.
  User: CDLX
  Date: 2021/1/6
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/uploadServlet">
        文件上传:<<input type="file" name="file" id="">
        <p><input type="submit"></p>
    </form>
</body>
</html>
