<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="<s:url value='/ui/css/base.css' />" />
<link rel="stylesheet" type="text/css" href="<s:url value='/ui/css/indexbody.css' />" />
<!-- <link href="images/style<?php echo $cfg_admin_skin;?>/style.css"
	rel="stylesheet" type="text/css" /> -->
<script language="javascript" src="<s:url value="/uie/js/dedeajax2.js" />"></script>
<script language="javascript" src="<s:url value="/ui/include/js/jquery/ui.core.js" /> "></script>
<script language="javascript" src="<s:url value="/ui/include/js/jquery/ui.draggable.js" />"></script>
<script language="javascript" src="<s:url value="/ui/include/js/jquery/ui.sortable.js" />"></script>
<script language="javascript" src="<s:url value="/ui/js/jquery.json-2.2.min.js" />" ></script> 
<script language="javascript" src="<s:url value="/ui/js/indexbody.js" />"></script>
<script language="javascript" src="<s:url value="/ui/js/drag.js" />"></script>
<script type="text/javascript">
	function showMore() {
		$("#allInfo").toggle();
		$("#allInfoTD").toggle();
	}

	$(function() {
		$.get("index_testenv.php", function(data) {
			if (data !== '') {
				$("#__testEvn").html(data);
			}
		})
	})
</script>
</head>
<body leftmargin="8" topmargin='8' bgcolor="#FFFFFF">
	<div style="min-width: 780px">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<div style='float: left'>
						欢迎使用专业的PHP网站管理系统，轻松建站的首选利器 
					</div>
					<div id='' style='float: right; padding-right: 8px;'>
						<!--  //保留位置（顶右）  -->
					</div>
				</td>
			</tr>
			<tr>
				<td height="1" background="<s:url value="/ui/images/sp_bg.gif" />"
					style='padding: 0px'></td>
			</tr>
		</table>
		<div id="__testEvn"></div>
		<div id='mainmsg'>
			<div class="column" id="column1">
				<!--左侧开始-->
				<dl class="dbox" id="item1">
					<dt class='lside'>
						<span class='l'>
							<?php echo $cfg_soft_enname; ?> 更新消息
						</span>
					</dt>
					<dd>
						<div id='updatetest'>
							<div id='updateinfos'>
                            <div class='updatedvt'><b>您系统版本最后更新时间为：{$oktime} </b><br/>
                            <a href='javascript:LoadUpdateInfos();' class='np coolbg'>进行在线更新</a> &nbsp; <br/>
                            <a href='sys_repair.php' class='np coolbg'>系统错误修复</a></div> <br/>
                            <iframe name='stafrm' src='{$offUrl}&uptime={$oktime}' frameborder='0' id='stafrm' width='98%' height='50'></iframe>
							</div>
						</div>
					</dd>
				</dl>
				<!--更新消息结束-->
				<dl class='dbox' id="item3">
					<dt class='lside'>
						<div class='l'>快捷操作</div>
						<div class='r'>
							<a href='#' onClick="AddNew()"><b>【新增】</b></a><a href='#'
								onClick="ListAll()"><b>【管理】</b></a>
						</div>
					</dt>
					<dd>
						<div id='quickmenu'>
							这里列举快捷操作
						</div>
					</dd>

				</dl>
				<!--快捷操作结束-->
				<dl class="dbox" id="item4">
					<dt class='lside'>
						<div class='l'>系统基本信息</div>
					</dt>
					<dd class='intable'>
						<table width="98%" class="dboxtable">
							<tr>
								<td width="25%" class='nline' style="text-align: right">您的级别：</td>
								<td class='nline'>
									显示用户级别	
                         [<a href="javascript:showMore()">查看更多</a>]
								</td>
							</tr>
							<tr>
								<td colspan="2" class='nline' id="allInfoTD"
									style="display: none"><table width="100%" border="0"
										cellspacing="0" cellpadding="0" id="allInfo"
										style="display: none">
										<tr>
											<td rowspan="5" class='nline' style="text-align: right">PHP环境摘要：</td>
											<td class='nline' style="text-align: left">PHP版本：<?php echo @phpversion(); ?>&nbsp;GD版本：<?php echo @gdversion(); ?></td>
										</tr>
										<tr>
											<td class='nline' style="text-align: left">是否安全模式：<font
												color='red'>
												 	显示安全模式?	
											</td>
										</tr>
										<tr>
											<td class='nline' style="text-align: left">
												Register_Globals：<font color='red'>
													显示register globals	
											</font> &nbsp; Magic_Quotes_Gpc：<font color='red'>
												 显示Magic Qutoes	
											</font>
											</td>
										</tr>
										<tr>
											<td class='nline' style="text-align: left">支持上传的最大文件：这里参数post_max_size</td>
										</tr>
										<tr>
											<td class='nline' style="text-align: left">是否允许打开远程连接：allow_url_fopen?</td>
										</tr>
										<tr>
											<td class='nline' style="text-align: right">其它必须函数检测：</td>
											<td class='nline' style="text-align: left">
												符合要求	
											</td>
										</tr>
										<tr>
											<td class='nline' style="text-align: right">软件版本信息：</td>
											<td class='nline' style="text-align: left">版本名称：xxxxx &nbsp;版本号：版本</td>
										</tr>
									</table></td>
							</tr>
						</table>
					</dd>
				</dl>
				<!--系统基本信息结束-->
				<!--开发团队结束-->
			</div>
			<!--左侧结束-->
			<div class="column" id="column2">
				<!-- //右边的快捷消息开始 -->
				<!--赞助商链接结束-->
				<dl class='dbox' id="item6">
					<dt class='lside'>
						<div class='l'>信息统计</div>
					</dt>
					<dd id='listCount'>正在载入中...</dd>
				</dl>
				<!--信息统计结束-->
				<dl class='dbox' id="item7">
					<dt class='lside'>
						<div class='l'>最新文档</div>
					</dt>
					<dd id='listNews'>
						<table width="100%" class="dboxtable">
							<tr>
								<td class='nline' style="text-align: left">
								</td>
							</tr>
							<tr>
								<td class='nline' style="text-align: left">暂无新增内容</td>
							</tr>
						</table>
					</dd>
				</dl>
				<!--最新文档结束-->
			</div>
		</div>
		<br style='clear: both' />
		<!-- //底部 -->


		<!--  下面是隐藏的项目  -->
		<div id='loaddiv' style='display: none'>
			<p align='center' style='padding-top: 200px'>
				<img src='images/loadinglit.gif' /> 请稍后，正在下载更新文件列表...
			</p>
		</div>
		<div id="editTab">
			<span id='editTabBody'>请稍候，正在载入...</span>
		</div>
		<div id="addTab">
			<form name='addform' action='index_body.php'>
				<input type='hidden' name='dopost' value='addnew' />
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height='28' colspan='3' background="images/tbg.gif">
							<div style='float: left'>
								<b>增加快捷操作项</b>
							</div>
							<div style='float: right; padding: 3px 10px 0 0;'>
								<a href="javascript:CloseTab('addTab')"><img
									src="images/close.gif" width="12" height="12" border="0" /></a>
							</div>
						</td>
					</tr>
					<tr>
						<td
							style="height: 6px; font-size: 1px; border-top: 1px solid #8DA659"
							colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td width="20%" height="28" align="right">链接标题：</td>
						<td width="70%"><input name="title" type="text" id="title"
							class='pubinputs' style="width: 255px;" /></td>
					</tr>
					<tr>
						<td height="28" width="20%" align="right">ICO图片：</td>
						<td width="70%"><input name="ico" type="text" id="ico"
							class='pubinputs' style="width: 255px;" /></td>
					</tr>
					<tr>
						<td height="28" width="20%" align="right">链接网址：</td>
						<td width="70%"><input name="link" type="text" id="link"
							class='pubinputs' style="width: 255px;" /></td>
					</tr>
					<tr>
						<td height="45">&nbsp;</td>
						<td><input type="submit" name="Submit" value="保存项目"
							class="np coolbg" style="width: 80px; cursor: pointer" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>