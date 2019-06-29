function deleteRow(bid){
	if(window.confirm("确定删除本条记录吗?")){
		location.href="BookServlet?method=remove&bid="+bid;
	}
}


