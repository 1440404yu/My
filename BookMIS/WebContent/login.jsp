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
<title>图书管理系统登录</title>
</head>
<body style="text-align:center;">
    <div >
    <form action="LoginServlet">
    <table width="400" align="center" border="1" cellspacing="0" cellpadding="10"style="margin-top:100px" >
    <tr><th colspan="2">欢迎登录图书管理系统</th>
    </tr>
    <tr><td style="background-color:gray;">用户名:</td>
    <td ><input type="text" name="username" style="margin-left:-65px"/></td>
   
    </tr>
    <tr><td style="background-color:gray;">密码:</td>
     <td><input type="password" name="password" style="margin-left:-65px"/></td>
     </tr>
    <tr> <td colspan="2"style="margin:0px auto"><input type="submit" value="登录"/></td></tr>
    <tr><td colspan="2">${error}</td></tr>
    </table>
    </form>
    </div>
</body>
</html>