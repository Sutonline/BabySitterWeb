<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传新文件</title>
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
<body onLoad="ContextMenu.intializeContextMenu()">
<div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
<?php include(DEDEADMIN.'/templets/menu.htm'); ?>
<script language="javascript">
$("#media").addClass("current");$("#media_add").addClass("current");</script>				

	<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>上传新文件</h3>
					
					<ul class="content-box-tabs">

					</ul>
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
<div class="tab-content  default-tab" id="tab1">				
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#D6D6D6">

  <tr> 
    <td height="19" bgcolor="#ffffff">
    	 <img src="images/help.gif" border="0" />
    	提示：图片类型仅支持jpg、png、gif、wbmp格式，flash为.swf格式，视音频和附件为限定扩展名的类型(可在系统参数中修改)。
    </td>
  </tr>
  <tr> 
    <td height="69" align="center" valign="top" bgcolor="#FFFFFF">
    	<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <form enctype="multipart/form-data" name='form1' action="media_add.php" method="POST" onSubmit="return CheckSubmit();">
          <input type="hidden" name="dopost" value="upload" />
          <tr> 
            <td width="15%" height="30" align="center" bgcolor="#FFFFFF"  class='bline'>媒体类型：</td>
            <td width="85%" height="25" bgcolor="#FFFFFF"  class='bline' style="text-align:left;">
            	<input name="mediatype" type="radio" class="np" value="1" checked='1' />
              图片 
              <input type="radio" name="mediatype" class="np" value="2" />
              FLASH 
              <input type="radio" name="mediatype" class="np" value="3" />
              视频/音频 
              <input type="radio" name="mediatype" class="np" value="4" />
              附件/其它
            </td>
          </tr>
          <tr> 
            <td height="30" align="center" bgcolor="#FFFFFF"  class='bline'>说明标题：</td>
            <td height="25" bgcolor="#FFFFFF"  class='bline' style="text-align:left;">
            	<input name="title" type="text" id="title" size="30" style="width:300px" />
            </td>
          </tr>
          <tr> 
            <td height="30" align="center" bgcolor="#FFFFFF"  class='bline'>参数说明：</td>
            <td height="30" bgcolor="#FFFFFF"  class='bline' colspan='2' style="text-align:left;">
            	图片不需要指定"宽"、"高"，其它附加参数仅方便多媒体文件管理，没其它含义
            </td>
          </tr>
          <tr> 
            <td height="30" align="center" bgcolor="#FFFFFF" class='bline'>附加参数：</td>
            <td height="25" bgcolor="#FFFFFF" class='bline' style="text-align:left;">宽： 
              <input name="mediawidth" type="text" id="mediawidth" size="5" />
              (像素)　高： 
              <input name="mediaheight" type="text" id="mediaheight" size="5" />
              (像素)　播放时间： 
              <input name="playtime" type="text" id="mediawidth3" size="5" />
              (分钟)</td>
          </tr>
          <tr>
            <td height="30" align="center" bgcolor="#FFFFFF"  class='bline'>上传文件：</td>
            <td bgcolor="#FFFFFF"  class='bline'  style="text-align:left;">数量：
              <input name="picnum" type="text" id="picnum" value="5" size="6" />
              <input class="button" type="button" name="Submit" value="增加" onClick="MakeUpload()" />
            
			       &nbsp;
               <input class="button"  type="button" name="Submit" value="恢复" onClick="ResetUpload()"  />    
			      </td>
          </tr>
          <tr> 
            <td align="center" bgcolor="#FFFFFF">&nbsp;</td>
            <td bgcolor="#FFFFFF"  style="text-align:left;">
			<input name="upfile1" type="file" id="upfile1" style='width:300px' size='30' class='pubinputs' /><br/>
			<input name="upfile2" type="file" id="upfile2" style='width:300px' size='30' class='pubinputs' /><br/>
			<input name="upfile3" type="file" id="upfile3" style='width:300px' size='30' class='pubinputs' /><br/>
			<input name="upfile4" type="file" id="upfile4" style='width:300px' size='30' class='pubinputs' /><br/>
			<input name="upfile5" type="file" id="upfile5" style='width:300px' size='30' class='pubinputs' /><br/>
            <span id='uploadfield'></span>

			 </td>
          </tr>
          <tr> 
            <td height="50" colspan="2" bgcolor="#FFFFFF">
            	<table width="60%" border="0" cellspacing="0" cellpadding="0">
                <tr> 
                  <td align="center">
                  <input class="button" name="imageField" type="submit" value="保存" />
				   
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
