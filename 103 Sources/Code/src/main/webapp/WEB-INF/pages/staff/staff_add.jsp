<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>add staff</title>
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
<script language="javascript" src="<s:url value='/ui/js/tooltip.js' />" ></script>
<!-- 引入ckeditor 开始-->
<script type="text/javascript" src="<s:url value='/ui/ckeditor/ckeditor.js' />"></script>
<script type="text/javascript" src="<s:url value='/ui/ckeditor/adapters/jquery.js' />" ></script>
<!-- 引入ckeditor 结束-->
<!-- 引入ckfinder -->
<script type="text/javascript" src="<s:url value='/ui/ckfinder/ckfinder.js' />"></script>
<style type="text/css">
.litpic_span{width:77px;overflow:hidden;height:21px;*vertical-align:3px;margin-left:-60px;*margin-left:-75px;cursor:pointer;}#litpic{width:85px;height:20px;margin-left:-20px;filter:alpha(opacity=00);-moz-opacity:.0;opacity:0.0;cursor:pointer;}
</style>
<script type="text/javascript">

$(function(){
	//submit Button添加事件
	$('#save').on('click', function(){
		$('#form1').submit();
	});
	
	//绑定缩略图上传按钮事件
	$('input[name="thumbnail\.button"]').on('click', function(){
		console.log('clicked!');
		uploadImage();
	});
	
	function uploadImage() {
		CKFinder.popup({
			chooseFiles : true,
			selectMultiple : false,
			resourceType: 'Images',
			selectActionFunction : function(fileUrl) {
				$('#avatar').val(fileUrl);
			}
		});
	}
	
}); //这是jQuery的结尾处
</script>
</head>
<body>
<div id="body-wrapper"> <!-- Wrapper for the radial gradient background -->
<script language="javascript">
	$("#articles").addClass("current");
	$("#article_add").addClass("current");
</script>	
			<div class="content-box"><!-- Start Content Box -->
				
				<div class="content-box-header">
					
					<h3>增加员工</h3>
					
					<!-- <ul class="content-box-tabs">
						<li><a href="#tab1" class="default-tab">基本信息</a></li> href must be unique and match the id of target div
						<li><a href="#tab2">扩展信息</a></li>
					</ul> -->
					
					<div class="clear"></div>
					
				</div> <!-- End .content-box-header -->
				
				<div class="content-box-content">
				<s:form id="form1" name="form1" action="/staff/saveStaff.html"
					enctype="multipart/form-data" method="post">
					<input type="hidden" name="channelid" value="这里填写类别" />
					<input type="hidden" name="dopost" value="save" />
					<div class="tab-content  default-tab" id="tab1">
						<table class="registerForm">
							<tr>
								<th>
									<label>姓名</label>
								</th>
								<td>
									<s:textfield name="staff.staffName"
										cssClass="text-input input" id="name" value="" />
								</td>
								<th>
									<label>选择照片</label>
								</th>
								<td>
									<s:textfield name="staff.imgPath" id="avatar" cssClass="text-input input" style="width:238px"/>
									<input type="button" name="thumbnail.button" class="button" value="上传">
								</td>
							</tr>
							<tr>
								<th>
									<label>服务类别</label> 
								</th>
								<td>
									<span id='typeidct'> 
                               	    	<s:select name="staff.serviceType" cssClass="select" list="%{@com.sut.util.meta.ServiceTypeEnum@getAll()}" listKey="stringValue" listValue="displayText">
                               	    	</s:select> 
									</span>
								</td>
								<th>
									<label>级别</label>
								</th>
								<td>
									<span>
										<s:select name="staff.staffLevel" cssClass="select" list="%{@com.sut.util.meta.StaffLevelEnum@getAll()}" 
											listKey="stringValue" listValue="displayText" />
									</span>
								</td>
							</tr>
							<tr>
								<th>
									<label>出生日期</label>
								</th>
								<td>
									<s:textfield name="staff.birthDate" value="" cssClass="text-input input"
										placeholder="请填写yyyy-MM-dd格式的日期"/>
								</td>
								<th>
									<label>地区</label>
								</th>
								<td>
									<s:textfield name="staff.address" value="" cssClass="text-input input"/>
								</td>
							</tr>
							<tr>
								<th>
								<label>健康状况</label>
								</th>
								<td>
									<span>
										<s:select name="staff.healthyStatus" cssClass="select" list="%{@com.sut.util.meta.HealthyStatusEnum@getAll()}"
											listKey="stringValue" listValue="displayText" />
									</span>
								</td>
								<th>
									<label>教育程度</label>
								</th>
								<td>
									<span>
										<s:select name="staff.educationLevel" cssClass="select" list="%{@com.sut.util.meta.EducationLevelEnum@getAll()}"
											listKey="stringValue" listValue="displayText" />
									</span>
								</td>
							</tr>
							<tr>
								<th>
									<label>工作年限</label>
								</th>
								<td>
									<s:textfield name="staff.workYears" cssClass="text-input input"  />
								</td>
								<th>
									<label>证书</label>
								</th>
								<td>
									<s:textfield name="staff.cert" cssClass="text-input input" />
								</td>
							</tr>
							<tr>
								<th>
									<label>手机号</label>
								</th>
								<td>
									<s:textfield name="staff.mobile" cssClass="text-input input" />
								</td>	
								<th>
									<label>微信号</label>
								</th>
								<td>
									<s:textfield name="staff.webchatNumber" cssClass="text-input input" />
								</td>
							</tr>
							<tr>
								<th>
									<label>自我介绍</label>
								</th>
								<td colspan="3">
									<s:textarea name="staff.selfIntroduction" rows="5" cols="80" maxlength="600" />
								</td>	
							</tr>
							<tr>
								<th> 
									<input id="save" class="button" name="imageField"
									type="button" value="编辑" />
								</th>
							</tr>
						</table>
						<div class="clear"></div>
						<!-- End .clear -->
					</div>
					<!-- End #tab1 -->
					<%-- <div class="tab-content" id="tab2">
						<fieldset>
							<p>
								<label>发布时间</label>
							</p>
							<input name="pubdate" value="$nowtime" type="text" id="pubdate"
								style="width: 220px"> <script language="javascript"
									type="text/javascript">
					Calendar.setup({
						inputField     :    "pubdate",
						ifFormat       :    "%Y-%m-%d %H:%M:%S",
						showsTime      :    true,
						timeFormat     :    "24"
					});
				 </script>
							<p>
								<label>作者</label> <input class="text-input small-input"
									type="text" id="writer" name="writer" value="作者" />
							</p>
							<p>
								<label>来源</label> <input class="text-input small-input"
									type="text" id="source" name="source" value="来源" />
							</p>
							<p>
								<label>TAG标签</label> <input class="text-input small-input"
									name="tags" type="text" id="tags" value="" style="width: 300px"
									onChange="$Obj('keywords').value=this.value;" />(','号分开，单个标签小于12字节)
							</p>
							<!-- <p>
								<label>附加选项</label>
                                <input name="remote" type="checkbox" class="np" id="remote" value="1"<?php if($cfg_rm_remote=='Y') echo ' checked="1" '; ?> />
                                下载远程图片和资源
                                <input name="dellink" type="checkbox" class="np" id="dellink" value="1"<?php if($cfg_arc_dellink=='Y') echo ' checked="1" '; ?> />
                                删除非站内链接 <a href="javascript:OpenMyWin('article_allowurl_edit.php');">[设置]</a>
                                <input name="autolitpic" type="checkbox" class="np" id="autolitpic" value="1"<?php if($cfg_arc_autopic=='Y') echo ' checked="1" '; ?> />
                                提取第一个图片为缩略图
                                <input type='checkbox' name='needwatermark' value='1' class='np' <?php if($photo_markup=='1') echo "checked"; ?> />
                                图片是否加水印
							</p> -->
							<p>
								<label>seo关键词</label> <input class="text-input small-input"
									type='text' name="keywords" id="keywords"
									value="<?php echo $keywords; ?>" /> <input type="button"
									name="Submit" value="浏览..." style="width: 56; height: 20"
									onClick="SelectKeywords('form1.keywords');" /><input
									name="autokey" type="checkbox" onClick="ShowHide('keywords');"
									; class="np" id="autokey" value="1"<?php
									if($cfg_arc_autokeyword=='Y') echo ' checked="1" '; ?>/>
									自动获取，手动填写用","分开 
							</p>

							<p>
								<label>标题颜色</label> <input name="color" type="text" id="color"
									style="width: 120px" /> <input name="modcolor" type="button"
									id="modcolor" value="选取" onClick="ShowColor(event,this)" />
							</p>

							<p>
								<label>自定义文件名（可代替id为唯一标识，建议为小写字母，可以作为seo使用，例如标题拼音、英文翻译等）</label>
								<input class="text-input medium-input" type="text" id="filename"
									name="filename" value="" /> （不包括后缀名如.html等）
							</p>

							<p>
								<label>点击</label> <input class="text-input small-input"
									type='text' name='click' value='<?php echo ($cfg_arc_click=='-1' ? mt_rand(50, 200) : $cfg_arc_click); ?>'
									style='width:100px;' /> 
							</p>

							<p>
								<label>评论选项</label> <input type='radio' name='notpost'
									class='np' value='0'<?php
									if($cfg_feedback_forbid=='N') echo "checked='1' "; ?> />允许评论
									&nbsp; <input type='radio' name='notpost' class='np' value='1'<?php
										if($cfg_feedback_forbid=='Y') echo "checked='1' "; ?> />禁止评论 
							</p>

							<p>
								<label>文章排序</label> <select name="sortup" id="sortup"
									style="width: 150px">
									<option value="0" selected>默认排序</option>
									<option value="7">置顶一周</option>
									<option value="30">置顶一个月</option>
									<option value="90">置顶三个月</option>
									<option value="180">置顶半年</option>
									<option value="360">置顶一年</option>
								</select>
							</p>
							<p>
								<label>权重</label> <input name="weight" type="text" id="weight"
									style="width: 50px" value="<?php echo $maxWright['cc'];?>" />(越小越靠前)
							</p>
							<p>
								<label>阅读权限</label> <select name="arcrank" id="arcrank"
									style="width: 150px">
								</select>
							</p>

							<p>
								<label>消费金币</label> <input class="text-input small-input"
									name="money" type="text" id="money" value="0" size="10" />
							</p>


							<p>
								<label>发布选项</label> <input type="radio" name="ishtml" value="1"
									checked=checked />生成HTML <input type="radio" name="ishtml"
									value="0" />仅动态浏览
							</p>

							<p>
								<label>分页方式</label> <input name="sptype" type="radio" class="np"
									value="hand"<?php if($cfg_arcautosp=='N') echo "
									checked='1' "?>/> 手动 <input type="radio" name="sptype"
									value="auto" class="np"<?php if($cfg_arcautosp=='Y')
										echo " checked='1' "?>/> 自动 大小： <input name="spsize"
										type="text" id="spsize"
										value="<?php echo $cfg_arcautosp_size?>" size="6" /> K (分页符为：
										<font color="#FF0000">#p#分页标题#e# </font>) 
							</p>
							<p>
								<br />
								<input class="button" name="imageField" type="submit" value="编辑" />
							</p>
						</fieldset>
						<div class="clear"></div>
						<!-- End .clear -->
					</div> --%>
					<!-- End #tab2 -->
				</s:form>

			</div> <!-- End .content-box-content -->
				
			</div> <!-- End .content-box -->
			
			<!-- <div class="clear"></div> -->
			<s:actionerror />
			<s:fielderror></s:fielderror>
		</div> <!-- End #main-content -->	
	</div>
</body>
</html>

