<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<s:url value="/ui/css/login.css" />" rel="stylesheet"	type="text/css" />
<link href="<s:url value='/ui/css/main.css' />" rel="stylesheet" type="text/css" />
<script type="text/javascript"	src="<s:url value='/ui/js/jquery/jquery-1.7.2.min.js' />"></script>
<script type="text/javascript" src="<s:url value='/ui/js/jquery-easyui-1.3.2/jquery.easyui.min.js' />"></script>

<script type="text/javascript">
$(function(){
	
	$('#subbtn').on('click', function(){
		checkVerifyCode();
	});
	
	
	//check验证码 captchaAnswer
	function checkVerifyCode() {
		var $verifyCode = $('input[name="verifycode"]');
		var code = $('input[name="verifycode"]').val();
		if (code) {
			$.ajax({
				url : '/BabySitterWeb/captcha/verify.html',
				async : false,
				data : {captchaAnswer : code},
				success : function(data) {
					var obj = $.parseJSON(data);
					if (obj.verifyResult == true) {
						//这里来提交form
						var $form = $('#form1');
						$form.submit();
					} else {
						alert('请填写正确的验证码!');
						if (! $verifyCode.hasClass('ui-error')) {
							$verifyCode.addClass('ui-error');
						}
						$verifyCode.attr('title', '请输入正确的验证码');
					}
				},
				error : function(msg) {
					alert('服务器通讯失败');
				}
			});
		} else {
			if (! $verifyCode.hasClass('ui-error')) {
				$verifyCode.addClass('ui-error');
			}
			$verifyCode.attr('title', '请输入正确的验证码');
		}
	}
	
	
	/* $("input[name='verifycode']").on('blur', function(){
		checkVerifyCode();
	}); */
	
}); //这是$()的结尾


if (window.parent !== window.self) {
	document.write = '';
	window.parent.location.href = window.self.location.href;
	setTimeout(function () {
		document.body.innerHTML = '';
	}, 0);
}

function reloadImage(imgurl){
    var getimagecode=document.getElementById("codeimg");
    getimagecode.src= imgurl + "?id=" + Math.random();
}

</script>
</head>
<body>
	<div class="wrap">
		<div class="inner">
			<div class="header">
				<h1>
				</h1>
			</div>
			<div class="qzone_login clearfix">
				<div class="qzone_cont" id="_pt">
					<li><img src="<s:url value="/ui/images/login_bg.jpg" />"
						alt="生活以快乐为基准，爱情以互惠为原则！"></li>
				</div>
				<!-- end qzone_cont -->
				<div class="login_main">
					<p class="wrong_notice" id="err_m" style="display: none;"></p>
					<s:form name='form1' id="form1" method="post" action="/admin/loginSubmit.html">
						<input type="hidden" name="gotopage"
							value="<?php if(!empty($gotopage)) echo RemoveXSS($gotopage);?>" />
						<input type="hidden" name="dopost" value="login" /> <input
							name='adminstyle' type='hidden' value='newdedecms' />
						<ul class="login_list" id="web_login">
							<li class="login_input">
								<s:textfield id="u" name="username" cssClass="input_txt" tabindex="1" value="%{username}" placeholder="账号名" title="账号名" />
							<!-- <input value="" id="u"
								name="username" class="input_txt" tabindex="1" type="text"
								value="" placeholder="帐号名" title="帐号名" /> -->
							</li>
							<li class="login_input">
								<s:password maxlength="16" id="p" name="password" tabindex="2" cssClass="input_txt" value="" placeholder="密码" title="密码" />
							<!-- <input maxlength=16 type="password"
								id="p" name="pwd" tabindex="2" class="input_txt" type="text"
								value="" placeholder="密码" title="密码" /> -->
							</li>

							<li class="yanzhengma clearfix" id="verifytip"><span
								id="verifyinput"> <input id="verifycode"
									name="verifycode" maxlength=5 tabindex="3" class="input_txt"
									type="text" value="" placeholder="请输入验证码" />
							</span> <img id="codeimg" name="codeimg" align="absmiddle" border=0
								onClick="this.src=this.src+'?'" style="cursor: pointer;"
								alt="看不清？点击更换" src="<s:url value="/captcha/captcha.html" />"<%-- <a href="javascript:reloadImage('<s:url value="/captcha/captcha.html" />')">看不清</a><br/> --%>
            </li>

							<li>
								<button class="login_btn" tabindex="4" id="subbtn" type="button"
									name="sm1" >登录</button>
							</li>
						</ul>
					</s:form>
					<div class="quick_login" id="qlogin"></div>
				</div>
			</div>
			<div class="platform_box"></div>
		</div>
	</div>
	<div class="footer">
		<div class="inner">
			<div class="copyright clearfix">
				<p class="copyright_en">Copyright &copy; 2012 - 2014 , LTCDPR
					All Rights Reserved.</p>
				<p class="copyright_ch">
					<a href="http://www.ltcdpr.com" target="_blank">http://www.ltcdpr.com</a>
				</p>
			</div>
		</div>
	</div>


</body>
</html>