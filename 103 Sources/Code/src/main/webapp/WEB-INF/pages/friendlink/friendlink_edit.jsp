<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>评论管理</title>
<link rel="stylesheet" href="<s:url value='/ui/css/reset.css' />" type="text/css" media="screen" />
<link rel="stylesheet" href="<s:url value='/ui/css/style.css' />" type="text/css" media="screen" />
<script language="javascript" src="<s:url value='/ui/js/jquery.min.js' />" type="text/javascript"></script>	
<script type="text/javascript" src="<s:url value='/ui/js/admin.jquery.configuration.js' />"></script>
<script type="text/javascript" src="<s:url value='/ui/js/swfupload/swfupload.js' />"></script>
<script lang='javascript' src="<s:url value='/ui/js/tb-box.js' />"></script>
<script language='javascript' src="<s:url value='/ui/js/main.js' />"></script>
<script type="text/javascript" src="<s:url value='/ui/js/calendar.js' />"></script>
<script language="javascript" src="<s:url value='/ui/js/dedeajax2.js' />"></script>

</head>
<body>
<div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
<?php include(DEDEADMIN.'/templets/menu.htm'); ?>
<script language="javascript">
$("#plus").addClass("current");$("#friendlink_main").addClass("current");</script>				

	<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>友情链接更改</h3>
					
					<ul class="content-box-tabs">

					</ul>
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
<div class="tab-content  default-tab" id="tab1">				
<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#D6D6D6">

<tr>
    <td height="200" bgcolor="#FFFFFF" valign="top">
	<form action="friendlink_edit.php" method="post" enctype="multipart/form-data" name="form1">
	<input type="hidden" name="id" value="<?php echo $myLink['id']?>">
	<input type="hidden" name="dopost" value="saveedit">
	<table width="80%"  border="0" cellspacing="1" cellpadding="3">
	  <tr>
        <td width="19%" height="25">网址：</td>
        <td width="81%">
        <input name="url" type="text" id="url" value="<?php echo $myLink['url']?>" size="30" class='pubinputs' />
        </td>
      </tr>
      <tr>
        <td width="19%" height="25">排列位置：</td>
        <td width="81%">
        <input name="sortrank" type="text" id="sortrank" value="<?php echo $myLink['sortrank']?>" size="10"  class='pubinputs' style="width:60px" />
        (由小到大排列)
        </td>
      </tr>
      <tr>
        <td height="25">网站名称：</td>
        <td><input name="webname" type="text" id="webname" size="30" value="<?php echo $myLink['webname']?>" class='pubinputs' /></td>
      </tr>
      <tr>
        <td height="25">网站Logo：</td>
        <td>
        	<input name="logo" type="text" id="logo" size="40" value="<?php echo $myLink['logo']?>" class='pubinputs'/>
          (88*31 gif或jpg)
         </td>
      </tr>
      <tr>
        <td height="25">上传Logo：</td>
        <td><input name="logoimg" type="file" id="logoimg" size="30" class='pubinputs' /></td>
      </tr>
      <tr>
        <td height="25">网站简况：</td>
        <td><textarea name="msg" cols="50" rows="4" id="msg"><?php echo htmlspecialchars($myLink['msg'])?></textarea></td>
      </tr>
      <tr>
        <td height="25">站长Email：</td>
        <td><input name="email" type="text" id="email" size="30" value="<?php echo $myLink['email']?>" class='pubinputs' /></td>
      </tr>
      <tr>
        <td height="25">链接位置：</td>
        <td>
        	<input type='radio' name='ischeck' value="0" <?php if($myLink['ischeck']==0) echo " checked='1' "?>/> 未审核
        	<input type='radio' name='ischeck' value="1" <?php if($myLink['ischeck']==1) echo " checked='1' "?>/> 内页
        	<input type='radio' name='ischeck' value="2" <?php if($myLink['ischeck']==2) echo " checked='1' "?>/> 首页
        </td>
      </tr>
      <tr>
        <td height="25">网站类型：</td>
        <td>
        <select name="typeid" id="typeid">
        <?php
        echo "	<option value='".$myLink['typeid']."'>".$myLink['typename']."</option>\r\n";
        $dsql->SetQuery("select * from #@__flinktype where id<>'".$myLink['typeid']."'");
        $dsql->Execute();
        while($row=$dsql->GetObject()){
        	echo "	<option value='".$row->id."'>".$row->typename."</option>\r\n";
        }
        ?>
        </select>
        </td>
      </tr>
      <tr>
        <td height="51">&nbsp;</td>
        <td>
        <input class="button" name="Submit" type="submit" value="提 交" />
         　<input class="button" type="reset" name="Submit" value=" 返 回 " onClick="location.href='<?php echo $ENV_GOBACK_URL?>';" />
         </td>
      </tr>
    </table>
	</form>
 </td>
</tr>
</table>
							<div class="clear"></div><!-- End .clear -->
							
						
						
					</div> <!-- End #tab1 -->

					
				</div> <!-- End .content-box-content -->
				
			</div> <!-- End .content-box -->
			
			<div class="clear"></div>
			
			
		</div> <!-- End #main-content -->	
	</div>
</body>
</html>
