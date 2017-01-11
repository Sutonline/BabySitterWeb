function addDate(){
	//时间
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	var day = date.getDay();		
	var append;
	for(var i=year;i>1989;i--){
		$("#years").append("<option>"+i+"</option>");
	}
	for(var i=1;i<=12;i++){
		if(i<10){
			i="0"+i;
			append=	"<option>"+i+"</option>";
			$("#months").append(append);
		}else{
			append=	"<option>"+i+"</option>";
			$("#months").append(append);
		}
	}
	$("#years").bind("change",function(){
		if($("#years").val() == year){
			$("#months option:gt("+month+")").attr("disabled","");
		}
		else{
			$("#months option").removeAttr("disabled");
		}
	});	
	for(var j=year;j>1989;j--){
		$("#y").append("<option>"+j+"</option>");
	}
	for(var k=1;k<=12;k++){
		if(k<10){
			k="0"+k;
			append=	"<option>"+k+"</option>";
			$("#m").append(append);
		}else{
		append=	"<option>"+k+"</option>";
		$("#m").append(append);
		}
	}
	$("#y").bind("change",function(){
		if($("#y").val() == year){
			$("#m option:gt("+month+")").attr("disabled","");
		}
		else{
			$("#m option").removeAttr("disabled");
		}
	});	
	for(var l=year;l>1989;l--){
		$("#r").append("<option>"+l+"</option>");
	}
	for(var m=1;m<=12;m++){
		if(m<10){
           m="0"+m;
           append=	"<option>"+m+"</option>";
			   $("#h").append(append);
		}else{
		append=	"<option>"+m+"</option>";
		$("#h").append(append);
		}
	}
	$("#r").bind("change",function(){
		if($("#r").val() == year){
			$("#h option:gt("+month+")").attr("disabled","");
		}
		else{
			$("#h option").removeAttr("disabled");
		}
	});
	for(var n=year;n>1989;n--){
		$("#e").append("<option>"+n+"</option>");
	}
	for(var s=1;s<=12;s++){
		if(s<10){
            s="0"+s;
            append=	"<option>"+s+"</option>";
			$("#s").append(append);
		}else{
		append=	"<option>"+s+"</option>";
		$("#s").append(append);
		}
	}
	$("#e").bind("change",function(){
		if($("#e").val() == year){
			$("#s option:gt("+month+")").attr("disabled","");
		}
		else{
			$("#s option").removeAttr("disabled");
		}
	});	
}
