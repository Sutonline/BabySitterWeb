<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Captcha</title>
</head>
<body>
	<img src="/captcha/captcha.html" />
	<s:form action="/captcha/verify.html" method="post">
		<input name="captchaAnswer" />
		<s:if test="%{verifyResult == true}">
			<b>Correct!</b>
		</s:if>
	</s:form>
</body>
</html>