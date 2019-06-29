<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme()+"://"
        +request.getServerName()+":"+request.getServerPort()+
        request.getContextPath()+"/";		
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>添加成功</title>
</head>
<body>
    <div style="text-align:center;margin-top:200px;">
       ${message}点击<a href="BookServlet?method=goAdd">此处</a>继续增加，点击<a href="BookServlet?method=list">此处</a>返回首页
    </div>
</body>
</html>