<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<style type="text/css" >
    .pager{
        width:100%;
	    height:100%;
	    margin:5px;
	    font-family: "宋体", "Arial", "Helvetica", "sans-serif";
	    font-size: 14px;
	    text-align:center;
	    color:blue;
    }
    .pager a{
	    color:blue;
	    text-decoration:none;
    }
</style>
<div class="pager">
<input type="button" value="新增图书" onclick="location.href='BookServlet?method=goAdd'"/>
          每页大小
    <select id="currSize" onchange ="turnOverPage(1);">
       <option value="5"  <c:if test="${pager.pageSize == 5}">selected</c:if>>5</option>
       <option value="10" <c:if test="${pager.pageSize == 10}">selected</c:if>>10</option>
       <option value="15" <c:if test="${pager.pageSize == 15}">selected</c:if>>15</option>
       <option value="20" <c:if test="${pager.pageSize == 20}">selected</c:if>>20</option>
    </select>
    &nbsp;
         共${pager.rowCount}条记录&nbsp;
         当前第${pager.pageNo}页&nbsp;
         共${pager.pageCount}页&nbsp;
	<c:choose>
        <c:when test="${pager.pageNo==1}">
                       　首页&nbsp;上一页
        </c:when>
	    <c:otherwise>
           <a href='javascript:void(0);' onclick='turnOverPage(1)'>首页&nbsp;</a>
           <a href='javascript:void(0);' onclick='turnOverPage("${pager.pageNo-1}")'>上一页&nbsp;</a>
        </c:otherwise>  
     </c:choose>
     <c:choose>
        <c:when test="${pager.pageNo==pager.pageCount}"> 
                          下一页&nbsp;尾页
        </c:when>
        <c:otherwise>  
           <a href='javascript:void(0);' onclick='turnOverPage("${pager.pageNo+1}")'>下一页&nbsp;</a>
           <a href='javascript:void(0);' onclick='turnOverPage("${pager.pageCount}")'>尾页&nbsp;</a>
        </c:otherwise> 
     </c:choose>   
     &nbsp;
           转到第<input type='text' size='2' id='jump' />页&nbsp;        
	<input type='button' value='GO' onclick='turnOverPage(parseInt(document.getElementById("jump").value))' />       
    
    <form name='pageForm' id='pageForm' action='${param.url}' method='post'>
		 <input type='hidden' id='pageNo' name='pageNo' value="${pager.pageNo}" />
		 <input type='hidden' id='pageSize' name='pageSize' value="${pager.pageSize}" />
    </form>
            
</div>           
<script type='text/javascript'>
    function turnOverPage(pageNo){
    	if(isNaN(pageNo)){
    		alert("页码为空或输入错误！");
    		return;
    	}
    	var pageCount = parseInt("${pager.pageCount}");
    	if(pageNo > pageCount){
    		pageNo = pageCount;
    	}else if(pageNo < 1){
    		pageNo = 1;
    	}
        var form = document.getElementById('pageForm');
        document.getElementById("pageNo").value=pageNo;
        document.getElementById("pageSize").value=document.getElementById("currSize").value;
        form.submit();
    }
</script>                      