<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common/taglib.jsp" %>
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
<title>增加图书</title>
</head>
<body style="text-align:center;">
    <div >
      <div style="color:red;">${error}</div>
      <hr/>
    <form action="BookServlet?method=add" method="post">
    <table width="400" align="center" border="1" cellspacing="0" cellpadding="10"style="margin-top:100px" >
    <tr><th colspan="2">增加图书</th>
    </tr>
    <tr><td>书名:</td>
    <td ><input type="text" name="bname" style="margin-left:-50px"/></td>
   
    </tr>
    <tr><td>作者:</td>
     <td><input type="text" name="author" style="margin-left:-50px"/></td>
     </tr>
   <tr><td >出版社:</td>
         <td>
             <select name="companyId" style="width:120px;margin-left:-50px;">
                <option value="">------请选择------</option>
                   <c:forEach items="${sessionScope.companyList}" var="item">
                       <option value="${item.cId}">${item.cName}</option>
                   </c:forEach>
             </select>
        </td>
  <tr><td >出版日期:</td>
    <td ><input type="text" name="publication" style="margin-left:-50px"/></td>
   <tr><td >页数:</td>
    <td ><input type="text" name="page" style="margin-left:-50px"/></td>
   <tr><td>价格:</td>
    <td ><input type="text" name="price" style="margin-left:-50px"/></td>
   <tr><td>内容摘要:</td>
    <td ><textarea style="margin-left:-60px" name="content"></textarea></td>
   <tr><td colspan="2"> <input type="submit" value="提交" /> <input type="button" value="返回"  onclick="location.href='BookServlet?method=list'"/></td>
  
    </table>
    </form>
    </div>
</body>
</html>