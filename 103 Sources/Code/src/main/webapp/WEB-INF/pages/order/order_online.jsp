<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<s:url value='/ui/css/reset.css' />" type="text/css" media="screen" />
<link rel="stylesheet" href="<s:url value='/ui/css/style.css' />" type="text/css" media="screen" />
<link rel="stylesheet" href="<s:url value='/ui/css/main.css' />" type="text/css" media="screen" />
<link rel="stylesheet" href="<s:url value='/ui/css/staff_style.css' />" type="text/css" media="screen" />
<script language="javascript" src="<s:url value='/ui/js/jquery.min.js' />" type="text/javascript"></script>	
<script language='javascript' src="<s:url value='/ui/js/main.js' />"></script>
<script language="javascript" src="<s:url value='/ui/js/tooltip.js' />" ></script>
<title>order online</title>
</head>
<body>

	<table width="1002" border="0" cellspacing="0" cellpadding="0"
		align="center" class="tab_items_cont">

		<tr>

			<td width="730" valign="top" align="center" class="bookingtd">
				<!--right start--> <script type="text/javascript">
				<!--
					menu_selected('formguide');
				//-->
				</script> <script type="text/javascript">
	function QueryString() {
		var name, value, i;
		var str = location.href;
		var num = str.indexOf("?")
		str = str.substr(num + 1);
		var arrtmp = str.split("&");
		for (i = 0; i < arrtmp.length; i++) {
			num = arrtmp[i].indexOf("=");
			if (num > 0) {
				name = arrtmp[i].substring(0, num);
				value = arrtmp[i].substr(num + 1);
				this[name] = value;
			}
		}
	}
	var Request = new QueryString();
	var ysname = "";
	ysname = Request["ysname"];
</script>
				<div class="bookingtitle">
					<img src="<s:url value='/ui/images/booking.gif' />"
						align="center" />
				</div>
				<div class="tip">

					声明：<br /> (1)* 号字段必填！<br />
					(2)在外派月嫂时，我们尽量安排您所意向的月嫂，但由于产妇产期不定，您所指定的月嫂不一定能如期进驻您家，我们会按相应的月嫂等级给您调整。尽请谅解！<br />
					(3)我们公司默认建行转帐，<br /> 帐号：6217-0018-2000-1058-571<br /> 帐户名：杨燕飞<br />
					开户行：建设银行三坊七巷支行<br /> 麻烦您汇完款后，回个短信到手机号：13107607856 ，以便财务对帐，谢谢！
				</div>

				<form name="myform" action="formguide/index.php" method="post"
					enctype="multipart/form-data">
					<table width="600" border="0" cellspacing="1" cellpadding="3"
						align="center" bgcolor="#d7d7d7">

						<tr>
							<td width="120" height="26" bgcolor="#FFFFFF">预订月嫂等级：</td>
							<td width="180" bgcolor="#FFFFFF"><select
								name="info[ys_grade]" id="ys_grade" size="1"><option
										value="初级月嫂">初级月嫂</option>
									<option value="中级月嫂">中级月嫂</option>
									<option value="高级月嫂" selected>高级月嫂</option>
									<option value="特级月嫂">特级月嫂</option>
									<option value="明星月嫂">明星月嫂</option>
									<option value="金牌月嫂">金牌月嫂</option>
							</select></td>
							<td width="110" bgcolor="#FFFFFF">意向月嫂：</td>
							<td width="190" bgcolor="#FFFFFF"><input type="text"
								name="info[ys_ysname]" id="ys_ysname" value="" size="20"
								class="" /></td>
							<script>
								document.myform.ys_ysname.value = ysname;
								if (document.myform.ys_ysname.value == "undefined") {
									document.myform.ys_ysname.value = "";

								}
							</script>
						</tr>
						<tr>
							<td height="26" bgcolor="#FFFFFF"><span class="xin">*</span>客户姓名：</td>
							<td bgcolor="#FFFFFF"><input type="text"
								name="info[ys_username]" id="ys_username" value="" size="20"
								class="" /></td>
							<td bgcolor="#FFFFFF"><span class="xin">×</span>预产期：</td>
							<td bgcolor="#FFFFFF"><input type="text"
								name="info[ys_birthdate]" id="ys_birthdate" value="" size="20"
								class="" /></td>
						</tr>
						<tr>
							<td height="26" bgcolor="#FFFFFF"><span class="xin">*</span>联系电话：</td>
							<td bgcolor="#FFFFFF"><input type="text"
								name="info[ys_usertel]" id="ys_usertel" value="" size="20"
								class="" require="false" regexp="^[0-9.-]+$" datatype="custom"
								msg='×' /></td>
							<td bgcolor="#FFFFFF"><span class="xin">*</span>身份证号 ：</td>
							<td bgcolor="#FFFFFF"><input type="text"
								name="info[ys_cardid]" id="ys_cardid" value="" size="20"
								class="" require="false" regexp="^[0-9-]+$" datatype="custom"
								msg='×' /></td>
						</tr>
						<tr>
							<td height="26" bgcolor="#FFFFFF">Email邮箱:</td>
							<td bgcolor="#FFFFFF"><input type="text"
								name="info[ys_email]" id="ys_email" value="" size="20" class=""
								require="false" regexp="^[\w\-\.]+@[\w\-\.]+(\.\w+)+$"
								datatype="custom" msg='×' /></td>
							<td bgcolor="#FFFFFF">客户QQ：</td>
							<td bgcolor="#FFFFFF"><input type="text" name="info[ys_qq]"
								id="ys_qq" value="" size="20" class="" require="false"
								regexp="^[0-9]{5,20}$" datatype="custom" msg='×' /></td>
						</tr>
						<tr>
							<td height="26" bgcolor="#FFFFFF">支付方式：</td>
							<td bgcolor="#FFFFFF"><select name="info[ys_pay]"
								id="ys_pay" size="1"><option value="建行转帐" selected>建行转帐</option>
							</select></td>
							<td bgcolor="#FFFFFF">预订金：</td>
							<td bgcolor="#FFFFFF"><input type="text"
								name="info[ys_deposit]" id="ys_deposit" value="1000元"
								disabled="disabled" size="20" class="" /></td>
						</tr>
						<tr>
							<td height="26" bgcolor="#FFFFFF"><span class="xin">*</span>家庭地址：
							</td>
							<td colspan="3" bgcolor="#FFFFFF"><input type="text"
								name="info[ys_address]" id="ys_address" value="" size="40"
								class="" /></td>
						</tr>
						<tr>
							<td bgcolor="#FFFFFF">留言备注：</td>
							<td colspan="3" bgcolor="#FFFFFF"><textarea
									name="info[ys_demo]" id="ys_demo" rows="6" cols="50" class=""></textarea></td>
						</tr>
						<tr>
							<td bgcolor="#FFFFFF" height="26" colspan="4" align="center"
								class="bookingbtn"><input type="hidden" name="dataid"
								value="" /> <input type="hidden" name="formid" value="1" /> <input
								type="submit" name="dosubmit" value="确定" /> <input type="reset"
								name="reset" value="取消" /></td>
						</tr>
					</table>
				</form> <!--right end -->



			</td>

		</tr>

	</table>




	<script language="JavaScript" src="count.php?specialid=1"></script>
	<script LANGUAGE="javascript">

<!--

$().ready(function() {

  $('form').checkForm(1);

});


</body>
</html>