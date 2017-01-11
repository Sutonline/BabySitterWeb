<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>更改文件</title>
<link rel="stylesheet" href="<s:url value='/ui/css/reset.css' />" type="text/css" media="screen" />
<link rel="stylesheet" href="<s:url value='/ui/css/style.css' />" type="text/css" media="screen" />
<link rel="stylesheet" href="<s:url value='/ui/css/main.css' />" type="text/css" media="screen" />
<script language="javascript" src="<s:url value='/ui/js/jquery.min.js' />" type="text/javascript"></script>	
<script type="text/javascript" src="<s:url value='/ui/js/facebox.js' />"></script>
<script type="text/javascript" src="<s:url value='/ui/js/admin.jquery.configuration.js' />"></script>
<script type="text/javascript" src="<s:url value='/ui/js/swfupload/swfupload.js' />"></script>
<script lang='javascript' src="<s:url value='/ui/js/tb-box.js' />"></script>
<script language='javascript' src="<s:url value='/ui/js/main.js' />"></script>
<script type="text/javascript" src="<s:url value='/ui/js/calendar.js' />"></script>
<script language="javascript" src="<s:url value='/ui/js/dedeajax2.js' />"></script>
<style>
.coolbg2 {
border: 1px solid #000000;
background-color: #F2F5E9;
height:18px
}
</style>
<script language='javascript'>
function CheckSubmit()
{
	if(document.form1.title.value==""){
		alert("请设定媒体标题！");
		document.form1.title.focus();
		return false;
	}
}
</script>
</head>
<body onLoad="ContextMenu.intializeContextMenu()">
<div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
<?php include(DEDEADMIN.'/templets/menu.htm'); ?>
<script language="javascript">
$("#media").addClass("current");$("#media_main").addClass("current");</script>				

	<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>更改文件</h3>
					
					<ul class="content-box-tabs">

					</ul>
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
<div class="tab-content  default-tab" id="tab1">				
<table width="99%" border="0" cellpadding="3" cellspacing="1" bgcolor="#D6D6D6">

<tr> 
<td height="19" bgcolor="#ffffff">
<img src="images/help.gif" border="0">
提示：图片类型仅支持jpg、png、gif、wbmp格式，flash为.swf格式，视音频和附件为限定扩展名的类型(可在系统参数中修改)。
</td>
</tr>
<tr> 
<td height="69" align="center" valign="top" bgcolor="#FFFFFF">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
<form enctype="multipart/form-data" name='form1' action="media_edit.php" method="POST" onSubmit="return CheckSubmit();">
<input type="hidden" name="dopost" value="save">
<input type="hidden" name="aid" value="<?php echo $aid?>"> 
<tr> 
<td width="15%" height="30" align="left" bgcolor="#FFFFFF"class='bline'>媒体类型：</td>
<td width="85%" height="25" align="left" bgcolor="#FFFFFF"class='bline'>
	<input type="radio" name="mediatype" class="np" value="1"<?php if($myrow['mediatype']==1) echo " checked"; ?>>
图片 
<input type="radio" name="mediatype" class="np" value="2"<?php if($myrow['mediatype']==2) echo " checked"; ?>>
FLASH 
<input type="radio" name="mediatype" class="np" value="3"<?php if($myrow['mediatype']==3) echo " checked"; ?>>
视频/音频 
<input type="radio" name="mediatype" class="np" value="4"<?php if($myrow['mediatype']==4) echo " checked"; ?>>
附件/其它
</td>
</tr>
<tr> 
<td height="30" align="center" bgcolor="#FFFFFF"class='bline'>说明标题：</td>
<td height="25" align="left" bgcolor="#FFFFFF"class='bline'>
	<input name="title" type="text" id="title" size="30" value="<?php echo $myrow['title']?>">
</td>
</tr>
<tr> 
<td height="30" align="center" bgcolor="#FFFFFF"class='bline'>参数说明：</td>
<td height="30" colspan='2' align="left" bgcolor="#FFFFFF"class='bline'>图片不需要指定"宽"、"高"，其它附加参数仅方便多媒体文件管理，没其它含义</td>
</tr>
<tr> 
<td height="30" align="center" bgcolor="#FFFFFF" class='bline'>附加参数：</td>
<td height="25" align="left" bgcolor="#FFFFFF" class='bline'>
	宽： 
<input name="mediawidth" type="text" id="mediawidth" size="5" value="<?php echo $myrow['width']?>">
(像素)　高： 
<input name="mediaheight" type="text" id="mediaheight" size="5" value="<?php echo $myrow['height']?>">
(像素)　播放时间： 
<input name="playtime" type="text" id="playtime" size="5" value="<?php echo $myrow['playtime']?>">
(分钟)
</td>
</tr>
<tr>
<td height="30" align="center" bgcolor="#FFFFFF"class='bline'>原文件：</td>
<td align="left" bgcolor="#FFFFFF"class='bline'>
<input name="filename" type="text" id="filename" style='width:350px' value="<?php echo $myrow['url']?>" >
<a href='<?php echo $myrow['url']?>' target='_blank'>[查看]</a>
</td>
</tr>
<?php
if($myrow['mediatype']==1)
{
 	$fullfilename = $cfg_basedir.$myrow['url'];
 	if(file_exists($fullfilename)){
 		$info = "";
 		$sizes = getimagesize($fullfilename,$info);
 		if(is_array($sizes)){
 			if($sizes[0]>200) $w=200;
 			else $w = $sizes[0];
?>
<tr>
<td height="30" align="center" bgcolor="#FFFFFF"class='bline'>预览：</td>
<td align="left" bgcolor="#FFFFFF"class='bline'>
<a href='<?php echo $myrow['url']?>' target='_blank'><img src='<?php echo $myrow['url']."?q=".time()?>' width='<?php echo $w?>' border='0' id='picview'></a>
</td>
</tr>
<?php } } } ?>
<tr> 
<td height="25" align="center" bgcolor="#FFFFFF"class='bline'>
	更改文件：
</td>
<td align="left" bgcolor="#FFFFFF"class='bline'>
<input name="upfile" type="file" id="upfile" style='width:300px'  size='30' >
</td>
</tr>
<tr> 
<td height="62" colspan="2" bgcolor="#FFFFFF"class='bline'>
<table width="60%" border="0" cellspacing="0" cellpadding="0">
<tr> 
<td align="center" height='48'>
<input class="button" name="imageField" type="submit" value="保存" />
<input class="button" type="reset" name="Submit" value=" 返回 " onClick="location.href='<?php echo $ENV_GOBACK_URL?>';" />
</td>
</tr>
</table>
</td>
</tr>
</form>
</table>
</td>

</tr>
</table>
							<div class="clear"></div><!-- End .clear -->
							
						
						
					</div> <!-- End #tab1 -->

					
				</div> <!-- End .content-box-content -->
				
			</div> <!-- End .content-box -->
			
			<div class="clear"></div>
			
           <?php include(DEDEADMIN.'/templets/footer.htm'); ?>
			
		</div> <!-- End #main-content -->	
	</div>
</body>
</html>
