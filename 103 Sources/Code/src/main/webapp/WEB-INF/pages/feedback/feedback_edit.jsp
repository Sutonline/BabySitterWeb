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
.coolbt2 {
  border-left: 2px solid #EFEFEF;
  border-top: 2px solid #EFEFEF;
  border-right: 2px solid #ACACAC;
  border-bottom: 2px solid #ACACAC;
  background-color: #F7FCDA
}
.nbline {border-bottom: 1px solid #d6d6d6; background-color:#FFFFFF; }
.bline2 {border-bottom: 1px solid #d6d6d6; background-color:#F9FCEF; }
</style>
</head>
<body> 
<div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
<script language="javascript">
$("#articles").addClass("current");$("#feedback_main").addClass("current");</script>				

	<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>评论管理</h3>
					
					<ul class="content-box-tabs">

					</ul>
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
<div class="tab-content  default-tab" id="tab1">				
<table width="98%"  border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#cfcfcf">

  <tr>
    <td height="187" colspan="2" align="center" bgcolor="#FFFFFF">
	<form name="form1" method="post" action="feedback_edit.php">
	<input type="hidden" name="dopost" value="edit" />
	<input type="hidden" name="id" value="<?php echo $row['id']; ?>" />
        <table width="100%" border="0" cellpadding="3" cellspacing="1" style="text-align:left;">
          <tr bgcolor="#FFFFFF"> 
            <td width="120" height="24">评论所属文章：</td>
            <td> 
              <?php echo $row['arctitle']; ?>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="24">评论人：</td>
            <td> 
              <input name="username" type="text" id="username" size="20" value="<?php echo $row['username']; ?>" /> 
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="24">评论发布时间：</td>
            <td> 
              <?php echo GetDateTimeMK($row['dtime']); ?>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="24">IP地址：</td>
            <td> 
              <?php echo $row['ip']; ?>
            </td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="24">评论内容：</td>
            <td>更改的评论内容HTML代码不会被屏蔽，可用HTML语法编辑。</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="62" align="center">&nbsp; </td>
            <td height="62"> 
              <textarea name="msg" cols="60" rows="5" id="msg"><?php echo cn_substr(Text2Html($row['msg']), 250); ?></textarea></td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="24">管理员回复：</td>
            <td>回复内容的HTML代码会被屏蔽。</td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="24" align="center">&nbsp; </td>
            <td height="24"> 
              <textarea name="adminmsg" cols="60" rows="5" id="adminmsg"></textarea></td>
          </tr>
          <tr bgcolor="#FFFFFF"> 
            <td height="40" width='600' colspan="2" align="center"> 
              <input class="button"name="Submit1" type="submit" value="保存更改" />

              &nbsp; 
                <input class="button" onclick="location='<?php echo $ENV_GOBACK_URL; ?>';" name="Submit2" type="button" value="不理返回" />

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
			
        <!--   <?php include(DEDEADMIN.'/templets/footer.htm'); ?>  -->
			
		</div> <!-- End #main-content -->	
	</div>
</body>
</html>
