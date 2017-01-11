<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>附件数据管理</title>

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
.napisdiv {left:10;top:0;width:150px;height:100px;position:absolute;z-index:3}
</style>
<script>
function ChangeImage(surl){ document.getElementById('picview').src = surl; }
	//获得选中文件的文件名
function getCheckboxItem(){
	 var allSel="";
	 if(document.form1.aids.value) return document.form1.aids.value;
	 for(i=0;i<document.form1.aids.length;i++)
	 {
		 if(document.form1.aids[i].checked){
			 if(allSel=="")
				 allSel=document.form1.aids[i].value;
			 else
				 allSel=allSel+","+document.form1.aids[i].value;
		 }
	 }
	 return allSel;	
}

function AllSel(){
	for(i=0;i<document.form1.aids.length;i++){
		document.form1.aids[i].checked = true;
	}
}

function NoneSel(){
	for(i=0;i<document.form1.aids.length;i++){
		document.form1.aids[i].checked = false;
	}
}

function DelSel(){
	 var nid = getCheckboxItem();
	 if(nid==""){
		  alert("请选择项目!\r\n");
		  return ;
	 }
	 location.href = "media_edit.php?dopost=del&ids="+nid;
}
</script>
</head>
<body>
<div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
<?php include(DEDEADMIN.'/templets/menu.htm'); ?>
<script language="javascript">
$("#media").addClass("current");$("#media_main").addClass("current");</script>				

	<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>附件数据管理</h3>
					
					<ul class="content-box-tabs">

					</ul>
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
					
<div class="tab-content  default-tab" id="tab1">				
<div id="floater" class="napisdiv">
<a href="javascript:;" onClick="ChangeImage('../include/dialog/img/picviewnone.gif');">
	<img src='../include/dialog/img/picviewnone.gif' id='picview' name='picview' border='0' alt='单击关闭预览' style='z-index:10000'>
</a>
</div>
<SCRIPT language=JavaScript src="js/float.js"></SCRIPT>
<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#cfcfcf">

  <tr bgcolor="#ffffff" height="24"> 
    <td colspan="7">
	<table width="600" border="0" cellspacing="0" cellpadding="0">
        <form name='forms' method='post' action='media_main.php'>
        <tr> 
          <td width="10">&nbsp;</td>
          <td width="70" align="center">关键字：</td>
          <td width="100">
          	<input name="keyword" type="text" id="keyword" style="width:100" value="<?php echo $keyword?>" />
          </td>
          <td width="100" align="center">
		  <select name='mediatype' style='width:80'>
              <option value='0'>文件类型</option>
              <option value='1'<?php if($mediatype==1) echo " selected"?>>图片</option>
              <option value='2'<?php if($mediatype==2) echo " selected"?>>FLASH</option>
              <option value='3'<?php if($mediatype==3) echo " selected"?>>视频/音频</option>
              <option value='4'<?php if($mediatype==4) echo " selected"?>>其它附件</option>
            </select> </td>
          <td width="100" align="center">
		  <select name='membertype' style='width:80'>
              <option value='0'>用户组</option>
              <option value='1'<?php if($membertype==1) echo " selected"?>>管理员</option>
              <option value='2'<?php if($membertype==2) echo " selected"?>>外部会员</option>
		 </select>
		  </td>
          <td>
          <input class="button" name="imageField" type="submit" value="搜索" />

          </td>
        </tr>
      </form>
      </table>
    </td>
  </tr>
  <tr  bgcolor="#FBFCE2" height="24" align="center"> 
    <td width="8%">选择</td>      
    <td width="28%">文件标题</td>      
    <td width="10%">文件大小</td>      
    <td width="15%">上传会员</td>      
    <td width="15%">上传时间</td>      
    <td width="9%">文件类型</td>      
    <td width="15%">管理</td>
   </tr>
   <form name='form1'>
{dede:datalist}
  <tr align="center" bgcolor="#FFFFFF" height="24" 
  	onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';"> 
    <td>
    	<input type='checkbox' name='aids' id='aids{dede:field.aid/}' value='{dede:field.aid/}' class='np'/>
    </td>
    <td>
    	<a href='{dede:field.url/}' title='{dede:field.url/}' target='_blank'>
      <u>{dede:field.title/}</u>
    	</a>
    </td>
    <td>{dede:field.filesize function='GetFileSize(@me)'/}</td> 
    <td>{dede:field.adminname function="UploadAdmin(@me,$fields['membername'])"/}</td>
    <td>{dede:field.uptime function="MyDate('Y-m-d H:i',@me)"/}</td>
    <td>{dede:field.mediatype function="MediaType(@me,$fields['url'])"/}</td>
    <td>
    	<a href='media_edit.php?aid={dede:field.aid/}&dopost=edit'>更改</a> 
      |
      <a href='media_edit.php?aid={dede:field.aid/}&dopost=del'>删除</a> 
    </td>
     </tr>
{/dede:datalist}
  <tr bgcolor="#ffffff" height="28"> 
   <td colspan="7">
    &nbsp; <input class="button" name="b4" type="button" value="全选" onClick="AllSel();" />

    &nbsp; <input class="button" name="b5" type="button" value="取消" onClick="NoneSel();" />

    &nbsp; <input class="button" name="b6" type="button" value="删除所选" onClick="DelSel();" />

   </td>
  </tr>
  <tr bgcolor="#F9FCEF" height="36"> 
    <td colspan="7" align="center">
    	{dede:pagelist listsize=5/}
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
