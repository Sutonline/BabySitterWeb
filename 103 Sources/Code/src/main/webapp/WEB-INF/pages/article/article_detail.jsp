<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type='text/css' href="<s:url value='/ui/css/searchBoxStyle1.min.css' />" rel='stylesheet'>
<link type="text/css" href="<s:url value='/ui/css/base.min.css' />" rel="stylesheet" />
<link type="text/css" href="<s:url value='/ui/css/poshytipAndmCustomScrollbar.min.css' />" rel="stylesheet" />
<link type="text/css" href="<s:url value='/ui/css/4002.min.css'  />" rel="stylesheet" id="templateFrame"  class="templateFrameClass"/>
<link type='text/css' href="<s:url value='/ui/css/pattern3.min.css' />" rel='stylesheet'>
<link type='text/css' href="<s:url value='/ui/css/fontsIco.min.css' />" rel='stylesheet'>
<link type='text/css' href="<s:url value='/ui/css/bannerAnimation.min.css' />" rel="stylesheet">

<!-- 增加share js的引用，本质是应用提供的服务类似webservice -->
<link type="text/css" href="<s:url value='/ui/css/share.min.css' />" rel="stylesheet">
<script type="text/javascript" src="<s:url value='/ui/js/jquery.share.min.js' />" ></script>
<title>ArticleDetail</title>
<script type="text/javascript" charset="utf-8">
	$(function(){
		var $config = {
			title : '<s:property value="article.title" escape='false' />',
			sites : ['qq', 'weibo','wechat', 'douban'],	
			disabled : ['google', 'facebook', 'twitter']
		};
		$(".social-sharex").share($config);
	}); //这是$()的结尾处
</script>
</head>
<body>
<!-- 文章详情开始 -->
	<table class=" formMiddle formMiddle12" style="" cellpadding="0"
		cellspacing="0">
		<tbody>
			<tr>
				<td class="formMiddleLeft formMiddleLeft12"></td>
				<td class="formMiddleCenter formMiddleCenter12 " valign="top">
					<div class="formMiddleContent formMiddleContent12" tabstyle="0">
						<div class="newsDetail" newsid="40">
							<div class="title">
								<s:property value="article.title" escape="false" />
							</div>
							<div class="sourceInfo"></div>
							<div class="shareInfo">
								<div class="social-sharex"></div>
							</div>
							<div class="clearfloat" style="height: 5px;"></div>
							<div class="g_border line"></div>
							<div class="richContent  richContent3">
								<s:property value="article.content" escape="false"/>
							</div>
						</div>
						<!-- 上一篇 下一篇 -->
						<!-- <div id="prevAndNextDiv">
							<table style="width: 100%; height: 100%;">
								<tbody>
									<tr>
										<td colspan="2" align="center" valign="middle"><div
												id="singleNewspagenation12" style="margin: 0px;"
												class="pagenation">
												<div class="pagePrev">
													<a hidefocus="true" class="g_border"
														href="nd.jsp?id=41&amp;groupId=-1#module12"><span>上一篇</span></a>
												</div>
												<div class="pageNext">
													<a hidefocus="true" class="g_border"
														href="nd.jsp?id=39&amp;groupId=-1#module12"><span>下一篇</span></a>
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div> -->
						<div id="newsCommentDiv">
							<table class="pdCommentSwitchTable fk-pdcomment-switch-table"
								style="width: 100%" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</td>
				<td class="formMiddleRight formMiddleRight12"></td>
			</tr>
		</tbody>
	</table>
	<!-- 文章详情结束 -->
</body>
</html>