window.onload=function (){
	var trs=document.getElementsByTagName("tr");;
	for(var i=0;i<trs.length;i++){
		if(i%2==0){
			trs[i].style.backgroundColor="pink";
			trs[0].style.backgroundColor="white";
		}
	}
}
