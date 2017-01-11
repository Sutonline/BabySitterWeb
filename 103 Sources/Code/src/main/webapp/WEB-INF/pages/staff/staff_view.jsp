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
<style type="text/css">
.litpic_span{width:77px;overflow:hidden;height:21px;*vertical-align:3px;margin-left:-60px;*margin-left:-75px;cursor:pointer;}#litpic{width:85px;height:20px;margin-left:-20px;filter:alpha(opacity=00);-moz-opacity:.0;opacity:0.0;cursor:pointer;}
</style>
<script type="text/javascript">

$(function(){
	//submit Button添加事件
	$('#save').on('click', function(){
		$('#addForm').submit();
	});
	
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
				
				<div class="content-box-content">
					<input type="hidden" name="channelid" value="这里填写类别" />
					<input type="hidden" name="dopost" value="save" />
					<div class="tab-content  default-tab" id="tab1">
						<div>
							<img class="bigImage" src="<s:property value='staff.imgPath' />"
								alt="<s:property value='staff.staffName' />"></img>
						</div>
						<table class="registerForm">
							<tr>
								<th>
									<label>姓名</label>
								</th>
								<td>
									<s:property value="staff.staffName" />
								</td>
							</tr>
							<tr>
								<th>
									<label>服务类别</label> 
								</th>
								<td>
									<s:property value="staff.serviceType.displayText" />
								</td>
								<th>
									<label>级别</label>
								</th>
								<td>
									<s:property value="staff.staffLevel.displayText" />
								</td>
							</tr>
							<tr>
								<th>
									<label>出生日期</label>
								</th>
								<td>
									<s:property value="staff.birthDate" />
								</td>
								<th>
									<label>地区</label>
								</th>
								<td>
									<s:property value="staff.address" />
								</td>
							</tr>
							<tr>
								<th>
								<label>健康状况</label>
								</th>
								<td>
									<s:property value="staff.healthyStatus.displayText" />
								</td>
								<th>
									<label>教育程度</label>
								</th>
								<td>
									<s:property value="staff.educationLevel.displayText" />
								</td>
							</tr>
							<tr>
								<th>
									<label>工作年限</label>
								</th>
								<td>
									<s:property value="staff.workYears" />
								</td>
								<th>
									<label>证书</label>
								</th>
								<td>
									<s:property value="staff.cert" />
								</td>
							</tr>
							<tr>
								<th>
									<label>手机号</label>
								</th>
								<td>
									<s:property value="staff.mobile" />
								</td>	
								<th>
									<label>微信号</label>
								</th>
								<td>
									<s:property value="staff.webchatNumber" />
								</td>
							</tr>
							<tr>
								<th>
									<label>自我介绍</label>
								</th>
								<td colspan="3">
									<s:property value="staff.selfIntroduction" />
								</td>	
							</tr>
						</table>
						<s:form id="addForm" action="addReview.html" namespace="/staff" method="post" >
							<table style="margin-top:100px" class="registerForm">
								<tr>
									<s:hidden name="review.staffId" value="%{staff.id}" />
									<th><s:label required="true">姓名</s:label> </th>
									<td><s:textfield name="review.nickName" cssClass="text-input input"/></td>
									<th><s:label required="true">联系类型</s:label></th>
									<td>
										<s:select name="review.contactType" cssClass="select" list="%{@com.sut.util.meta.ContactTypeEnum@getAll()}" listKey="stringValue" 
											listValue="displayText" value="%{}" />
									</td>
								</tr>
								<tr>
									<th><s:label required="true">联系方式</s:label></th>
									<td>
										<s:textfield name="review.contactNumber" cssClass="text-input input"/>
									</td>
								</tr>
								<tr>
									<th style="text-align: center"><s:label required="true">评论</s:label></th>
									<td colspan="3"><s:textarea name="review.comment" rows="5" cols="80" maxlength="300" /> </td>
								</tr>
								<tr>
								<th> 
									<input id="save" class="button" name="imageField" 
									type="button" value="提交" />
								</th>
							</tr>	
							</table>
						</s:form>
						<div class="clear"></div>
						<!-- End .clear -->
					</div>
					<!-- End #tab1 -->

			</div> <!-- End .content-box-content -->
				
			</div> <!-- End .content-box -->
			
			<!-- <div class="clear"></div> -->
			<s:actionerror />
			<s:fielderror></s:fielderror>
		</div> <!-- End #main-content -->	
	</div>
</body>
</html>

