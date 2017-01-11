function addTr(data){
	var date = new Date(data.strDt);
  	if(date.getMonth()< 9){
  		var strDt = date.getFullYear()+"-0";
  	}
  	else{
  		var strDt = date.getFullYear()+"-";
  	}
  	if(date.getDate() < 10){
  		strDt = strDt + (date.getMonth()+1) + "-0" + date.getDate();
  	}
  	else{
  		strDt = strDt + (date.getMonth()+1) + "-" + date.getDate();
  	}
  	strDt =strDt+ " " + date.toLocaleTimeString();
  	date = new Date(data.endDt);
  	if(date.getMonth()< 9){
  		var endDt = date.getFullYear()+"-0";
  	}
  	else{
  		var endDt = date.getFullYear()+"-";
  	}
  	if(date.getDate() < 10){
  		endDt = endDt + (date.getMonth()+1) + "-0" + date.getDate();
  	}
  	else{
  		endDt = endDt + (date.getMonth()+1) + "-" + date.getDate();
  	}
  	endDt = endDt+" "+date.toLocaleTimeString();
	var status;
	if(data.rptSts == '0'){
		status = "正在查询...";
		var lookUP = "<input disabled='disabled' class='ui-button' type='button' value='查看' onclick='fpubSeeReport("+data.sctSeq+")' />";
		var myUpload = "<input disabled='disabled' class='ui-button' type='button' value='下载' id='upload' onclick='fpubUpload("+data.sctSeq+")' />";	
		var myDelete = "<input disabled='disabled' class='ui-button' type='button' value='删除' id='delete' onclick='fpubDelete("+data.sctSeq+",this)' />";
	}else if(data.rptSts == '3'){
		status = "成功";
		var lookUP = "<input class='ui-button' type='button' value='查看' onclick='fpubSeeReport("+data.sctSeq+")' />";
		var myUpload = "<input class='ui-button' type='button' value='下载' id='upload' onclick='fpubUpload("+data.sctSeq+")' />";
		var myDelete = "<input class='ui-button' type='button' value='删除' id='delete' onclick='fpubDelete("+data.sctSeq+",this)' />";	
	}else if(data.rptSts == '4'){
		status ="失败";
		var lookUP = "<input disabled='disabled' class='ui-button' type='button' value='查看' onclick='fpubSeeReport("+data.sctSeq+")' />";
		var myUpload = "<input disabled='disabled' class='ui-button' type='button' value='下载' id='upload' onclick='fpubUpload("+data.sctSeq+")' />";
		var myDelete = "<input class='ui-button' type='button' value='删除' id='delete' onclick='fpubDelete("+data.sctSeq+",this)' />";
		
	}
	var tr=$("<tr align='center'></tr>");
	tr.append("<td>"+data.sctSeq+"</td>");
	tr.append("<td>"+data.usrId+"</td>");
	tr.append("<td>"+data.usrNm+"</td>");
	tr.append("<td>"+data.rptNm+"</td>");
	tr.append("<td>"+strDt+"</td>");
	if(data.endDt == null){
		tr.append("<td></td>");
	}else{
		tr.append("<td>"+endDt+"</td>");
	}
	if(data.rptPmt == null){
		tr.append("<td></td>");
	}else{
		tr.append("<td title="+data.rptPmt+">"+data.rptPmt+"</td>");
	}
	tr.append("<td>"+status+"</td>");

	var option = $("<td></td>");
	option.append(lookUP);
	option.append("&nbsp;");
	option.append(myUpload);
	option.append("&nbsp;");
	option.append(myDelete);
	tr.append(option);
	return tr;
}