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
<script src="js/main.js"></script>
<script src="js/color.js"></script>
<title>图书管理</title>
</head>
<body style="text-align:center;">
    <h1>图书管理</h1>
    <div style="text-align:right;">当前用户：${sessionScope.currentUser.username}</div>
    <hr /> 
    
 <div style="width:900px;margin:0px auto;text-align:left;line-height:2.2;margin-bottom:20px;">   
 <form method="post" style="width:900px;margin:0px auto;text-align:left;line-height:1.8;margin-bottom:20px;">
 <div style="margin-left:150px;float:left">书号：<input type="text" name="isbn" value="${sessionScope.query.isbn}" /></div>
 <div style="margin-left:150px;float:left">书名：<input type="text" name="bname" value="${sessionScope.query.bname}"/></div>
 <div style="margin-left:150px;float:left">作者：<input type="text" name="author" value="${sessionScope.query.author}"/></div>
 <br/>
 <div style="margin-left:150px;float:left">
 出版社： <select name="companyId">
              <option value="">---请选择---</option>
              <c:forEach items="${sessionScope.companyList}" var="item">
                  <option value="${item.cId}" <c:if test="${item.cId == sessionScope.query.companyId}">selected</c:if>>${item.cName}</option>
              </c:forEach>
      </select> 
 </div>  
   <br/>
   <div style="width:100px;margin:0px auto;text-align:left;line-height:2.2;margin-bottom:20px;">   
      <input type="submit" value="重置" formaction="BookServlet?method=find&reset=true"/>
      <input type="submit" value="搜索" formaction="BookServlet?method=find"/>  
   </div>                         
 </form>   
  
 </div>   
    <div>
       <div style="margin-bottom:10px;">
        
       </div>
       <table width="900" border="1" align="center" cellspacing="0" cellpadding="5">
          <tr>
             <th colspan="9" ">图书信息管理</th>
          </tr>
          <tr>       
               <th>书名</th>
               <th>作者</th>
               <th>出版社</th>
               <th>出版时间</th>
               <th>页数</th>
               <th>价格</th>
               <th>内容摘要</th>
               <th>操作 </th>
         </tr>
          <c:forEach items="${sessionScope.bookList}" var="item">
             <tr>         
                <td>${item.bname}</td>
                <td>${item.author}</td>
                 <td>${item.C_NAME}</td>
                <td>${item.publication}</td>
                <td>${item.page}</td>
                <td>${item.price}</td>
                <td>${item.content}</td>
                <td>
                    <input type="button" value="修 改" onclick="location.href='BookServlet?method=goModify&bid=${item.bid}';"/>
                    <input type="button" value="删除" onclick="deleteRow('${item.bid}')"/>
                </td>
             </tr>
          </c:forEach>
       </table>
    </div>
    <div>
    <jsp:include page="common/page.jsp">
         <jsp:param value="BookServlet?method=list" name="url"/>
    </jsp:include>
</div>
</body>
</html>