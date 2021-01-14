<%--
  Created by IntelliJ IDEA.
  User: CDLX
  Date: 2021/1/11
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<script>
    /*创建引擎对象*/
    var xmlHttpRequest = new XMLHttpRequest();
    /*绑定监听  */
    xmlHttpRequest.onreadystatechange = function () {
        /*接受响应数据*/
        if(xmlHttpRequest.readyState ==4 && xmlHttpRequest.status == 200){
            var re = xmlHttpRequest.responseText;
            alert(re);
        }
    }
    /*绑定地址*/
    xmlHttpRequest.open("GET","${pageContext.request.contextPath}/index.jsp",true)
    /*发送请求*/
    xmlHttpRequest.send()

</script>

</body>
</html>
