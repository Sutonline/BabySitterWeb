<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About Us</title>
<script type="text/javascript">
$(function(){
	//将内容还原给div
	var content = jQuery('#\\_hiddenContent').text();
	jQuery('#pageContent').html(content);
});//这是jQuery()的结尾处

</script>
</head>
<body>
	<div id="_hiddenContent" class="disHide">
		<s:property value="article.content" />
	</div>
	<div id="pageContent">
		
	</div>
</body>
</html>