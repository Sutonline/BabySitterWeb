<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<s:url value="/ui/css/Css.css" />" rel="stylesheet" type="text/css" />
<link href="<s:url value="/ui/css/bbCss.css" />" rel="stylesheet" type="text/css" />
<link href="<s:url value="/ui/css/page.css" />" rel="stylesheet" type="text/css" />
<link href="<s:url value="/ui/css/main.css" />" ref="stylesheet" type="text/css" />
<script type="text/javascript" src="<s:url value="/ui/js/png.js" />" ></script>
<script type="text/javascript" src="<s:url value="/ui/js/jquery/jquery-1.7.2.min.js" />" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
<script type="text/javascript">
$(function(){
	var $headerFrame = $('#header');
	var $centerFrame = $('#center');
	var $footerFrame = $('#footer');
	
	//加载头部
	$headerFrame.attr("src", "<s:url value="/index/header.html" />");
	
	//加载尾部
	$footerFrame.attr("src", "<s:url value="/index/footer.html" />");
	
	//加载主页
	$centerFrame.attr("src", "<s:url value="/index/mainport.html" />")

}); //这是$()的结尾处
</script>
</head>
<body>
<!-- header iframe -->
<iframe id="header" src="" frameborder="0" class="maxWidth" scrolling="no" style="width:100%;height:246px;"></iframe>
	
<!-- center iframe -->
<iframe id="center" src="" frameborder="0" class="maxWidth" scrolling="no" style="width:100%;height:1200px;">
</iframe>

<!-- footer iframe -->
<iframe id="footer" src="" frameborder="0" class="maxWidth" scrolling="no" style="width:100%;height:164px;"></iframe>
</body>
</html>