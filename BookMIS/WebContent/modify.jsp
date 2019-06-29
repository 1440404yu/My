<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme()+"://"
        +request.getServerName()+":"+request.getServerPort()+
        request.getContextPath()+"/";		
%>
   <%@ include file="common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>编辑图书</title>
</head>
<body style="text-align:center;">
    <div >
        <div style="color:red;">${error}</div>
    <form action="BookServlet?method=modify" method="post">
     <input type="hidden" name="bid" value="${currBook.bid}" />
    <table width="400" align="center" border="1" cellspacing="0" cellpadding="10"style="margin-top:100px" >
    <tr><th colspan="2">编辑图书</th>
    </tr>
    <tr><td>书名:</td>
    <td ><input type="text" name="bname" style="margin-left:-50px" value="${currBook.bname}"/></td>
   
    </tr>
    <tr><td>作者:</td>
     <td><input type="text" name="author" style="margin-left:-50px" value="${currBook.author}"/></td>
     </tr>
   <tr><td >出版社:</td>
      <td>
                <select name="companyId">
                   <option value="">---请选择---</option>
                   <c:forEach items="${sessionScope.companyList}" var="item">
                       <option value="${item.cId}" <c:if test="${item.cId == currBook.companyId}">selected</c:if>>${item.cName}</option>
                   </c:forEach>
                </select>
             </td>
  <tr><td >出版日期:</td>
    <td ><input type="text" name="publication" style="margin-left:-50px"value="${currBook.publication}"/></td>
   <tr><td >页数:</td>
    <td ><input type="text" name="page" style="margin-left:-50px" value="${currBook.page}"/></td>
   <tr><td>价格:</td>
    <td ><input type="text" name="price" style="margin-left:-50px"value="${currBook.price}"/></td>
   <tr><td>内容摘要:</td>
    <td ><textarea style="margin-left:-50px" name="content" ></textarea></td>
   <tr><td colspan="2"> <input type="submit" value="提交" /> <input type="submit" value="返回" /></td>
  
    </table>
    </form>
    </div>
</body>
</html>