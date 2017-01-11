<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<s:url value='/ui/js/jquery.simplePagination.js' />"></script>
<link rel="stylesheet" type="text/css" href="<s:url value='/ui/css/simplePagination.css' />" >
<link rel="stylesheet" type="text/css" href="<s:url value='/ui/css/alternative.css' />">

<link type="text/css" href="<s:url value='/ui/css/base.min.css' />" rel="stylesheet" />
<link type="text/css" href="<s:url value='/ui/css/4002.min.css'  />" rel="stylesheet" id="templateFrame"  class="templateFrameClass"/>
<link type='text/css' href="<s:url value='/ui/css/pattern3.min.css' />" rel='stylesheet'>
<link type='text/css' href="<s:url value='/ui/css/searchBoxStyle1.min.css' />" rel='stylesheet'>
<link type="text/css" href="<s:url value='/ui/css/poshytipAndmCustomScrollbar.min.css' />" rel="stylesheet" />

<title>News Center</title>
<script type="text/javascript">
$(function(){
	var fullSize = <s:property value="#request['retList'].fullListSize" />;
	var objectsPerPage = <s:property value="#request['retList'].objectsPerPage" />;
	
	
	//gotoPage
	function gotoPage(pageNumber) {
		location.href='<s:url value="/article/getNews.html?page=" />' + pageNumber;
		console.log(pageNumber);
	}
	
	$('#paginationBar').pagination({
		items: fullSize, 
        itemsOnPage: objectsPerPage,
        cssStyle: 'light-theme',
        currentPage : <s:property value="#request['retList'].pageNumber" />,
        onPageClick : function(pageNumber, event){
        	gotoPage(pageNumber);
        }
        
	});
	
}); //这是$()的结尾

</script>
</head>
<body>
<table class="formMiddle formMiddle31" style='' cellpadding='0'
		cellspacing='0'>
		<tr>
			<td class='formMiddleLeft formMiddleLeft31'></td>
			<td class='formMiddleCenter formMiddleCenter31 ' valign='top'>
				<div class='formMiddleContent formMiddleContent31' tabStyle='0'>
					<div>
						<div class='newsList pic-mixNewsList' id='newsList31'
							_showSetting='1' useTitle='true'>
<!-- <th>标题内容</th> -->
<s:iterator value="%{#request['retList'].getList()}">
					<div topClassName='top1' topSwitch='on' newsId='41'
								newsName='<s:property value="title" />' //TODO 增加参数
								class='J_newsResultLine  line nline noHover  '
								style='padding: 0; height: auto; overflow: hidden;'>
								<table id='31lineBody41' class='J_lineBody lineBody'
									cellpadding='0' cellspacing='0'>
									<tr id='module31tr41'>
										<td class='newsTitle mixNewsTitle' valign='top'>
											<div class='J_articlePhotoBox articlePhotoBox' newid='41'
												newsFlag='8'>
												<a class='J_articlePicHref' href='getDetail.html?article.id=<s:property value="id" />'
													target='_self'
													style='display: block; width: 120px; height: 95px; overflow: hidden;'>
													<img class='J_newsResultPic' alt='文章附图' title=''
													src='<s:property value="thumbnail" />'
													style='width: 110px; height: 95px; float: left;' />
												</a>
											</div>
											<div class='mixNewsStyleTitleContainer'>
												<div class='J_newsResultTopFlag '
													style='margin: 0; position: relative;'>
													<a class='no-mixNewsStyleTitleTip'
														href='getDetail.html?article.id=<s:property value="id" />' target='_self'></a>
												</div>
												<span class='mixNewsStyleDate'><s:date name="publishTime" format="yyyy-MM-dd" /></span> <a
													hidefocus='true' href="getDetail.html?article.id=<s:property value='id' />"
													target=_self title="<s:property value='title' />"
													class='J_mixNewsStyleTitle mixNewsStyleTitle  pic-mixNewsStyleTitle '
													mix=1 style=''><s:property value="title" /></a>
											</div>
											<!-- TODO 这里要写摘要 -->
											<p class='mixNewsStyleSummary  pic-mixNewsStyleSummary '><s:property value="summary" /></p>
									</tr>
								</table>
							</div>
							<div class='separatorLine g_separator  pic-separatorLine '></div>
</s:iterator>
						</div>
					</div>
				</div>
				<!-- paginationBar -->
				<div id="paginationBar"></div>
			</td>
			<td class='formMiddleRight formMiddleRight31'></td>
		</tr>
</table>
</body>
</html>