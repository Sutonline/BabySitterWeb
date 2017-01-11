<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<s:url value="/ui/css/Css.css" />" rel="stylesheet" type="text/css" />
<link href="<s:url value="/ui/css/bbCss.css" />" rel="stylesheet" type="text/css" />
<link href="<s:url value="/ui/css/page.css" />" rel="stylesheet" type="text/css" />
<link href="<s:url value="/ui/css/main.css" />" ref="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.clearfix:after{content: ".";display: block;height: 0;clear: both;visibility: hidden;}  
/*
.clearfix{zoom:1;}
*/
img{border:0;}  
.wrapper{
	width:300px;
	margin:0 auto;
	padding-bottom:50px;
	height:130px;
}  
/* h1{height:50px;line-height:50px;font-size:22px;font-weight:normal;font-family:"Microsoft YaHei",SimHei;margin-bottom:20px;}  
*/
/* focus */  
#focus{
	width:300px;
	height:200px;
	overflow:hidden;
	position:relative;
	margin-top:-205px;
	margin-left:0;
}  
#focus ul{height:185px;position:absolute;margin-left:-40px}  
#focus ul li{:300px;height:185px;overflow:hidden;position:relative;background:#000;}  
#focus ul li div{position:absolute;overflow:hidden;}  
#focus .btnBg{position:absolute;width:300px;height:20px;left:0;bottom:0;background:#000;}  
#focus .btn{position:absolute;width:780px;height:10px;padding:5px 10px;right:0;bottom:0;text-align:right;}  
#focus .btn span{display:inline-block;_display:inline;_zoom:1;width:25px;height:10px;_font-size:0;margin-left:5px;cursor:pointer;background:#fff;}  
#focus .btn span.on{background:#fff;}  
#focus .preNext{
	width:25px;
	height:40px;
	position:absolute;
	top:90px;
	-webkit-background-size:contain;
	background:url(<s:url value="/ui/images/sprite.png" />) no-repeat 0 0;cursor:pointer;
}  
#focus .pre{left:0;}  
#focus .next{right:0;background-position:right top;}  
#focus .image{
	width:300px;
}
	width:300px;
}
</style>
<script type="text/javascript">
$(function() {  
    var sWidth = $("#focus").width(); //获取焦点图的宽度（显示面积）  
    var len = $("#focus ul li").length; //获取焦点图个数  
    var index = 0;  
    var picTimer;  
      
    //以下代码添加数字按钮和按钮后的半透明条，还有上一页、下一页两个按钮  
    var btn = "<div class='btnBg'></div><div class='btn'>";  
    for(var i=0; i < len; i++) {  
        btn += "<span></span>";  
    }  
    btn += "</div><div class='preNext pre'></div><div class='preNext next'></div>";  
    $("#focus").append(btn);  
    $("#focus .btnBg").css("opacity",0.5);  
  
    //为小按钮添加鼠标滑入事件，以显示相应的内容  
    $("#focus .btn span").css("opacity",0.4).mouseover(function() {  
        index = $("#focus .btn span").index(this);  
        showPics(index);  
    }).eq(0).trigger("mouseover");  
  
    //上一页、下一页按钮透明度处理  
    $("#focus .preNext").css("opacity",0.2).hover(function() {  
        $(this).stop(true,false).animate({"opacity":"0.5"},300);  
    },function() {  
        $(this).stop(true,false).animate({"opacity":"0.2"},300);  
    });  
  
    //上一页按钮  
    $("#focus .pre").click(function() {  
        index -= 1;  
        if(index == -1) {index = len - 1;}  
        showPics(index);  
    });  
  
    //下一页按钮  
    $("#focus .next").click(function() {  
        index += 1;  
        if(index == len) {index = 0;}  
        showPics(index);  
    });  
  
    //本例为左右滚动，即所有li元素都是在同一排向左浮动，所以这里需要计算出外围ul元素的宽度  
    $("#focus ul").css("width",sWidth * (len));  
      
    //鼠标滑上焦点图时停止自动播放，滑出时开始自动播放  
    $("#focus").hover(function() {  
        clearInterval(picTimer);  
    },function() {  
        picTimer = setInterval(function() {  
            showPics(index);  
            index++;  
            if(index == len) {index = 0;}  
        },4000); //此4000代表自动播放的间隔，单位：毫秒  
    }).trigger("mouseleave");  
      
    //显示图片函数，根据接收的index值显示相应的内容  
    function showPics(index) { //普通切换  
        var nowLeft = -index*sWidth; //根据index值计算ul元素的left值  
        $("#focus ul").stop(true,false).animate({"left":nowLeft},300); //通过animate()调整ul元素滚动到计算出的position  
          
        $("#focus .btn span").stop(true,false).animate({"opacity":"0.4"},300).eq(index).stop(true,false).animate({"opacity":"1"},300); //为当前的按钮切换到选中的效果  
    }  
});  //这是$()的结尾处});  //这是$()的结尾处
</script>
</head>
<body>
	<table width="994" style="margin-top: 22px;" align="center" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td width="280" valign="top">
				<table width="264" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="32"><img
							src="<s:url value="/ui/images/t1.jpg" />" border="0"
							usemap="#Map25" /></td>
					</tr>
					<tr>
						<td background="<s:url value="/ui/images/c1.jpg" />" height="144"
							valign="top" style="padding-top: 17px; padding-bottom: 17px;">
							<table width="240" align="center" height="30" border="0"
								cellspacing="0" cellpadding="0">
								<s:iterator value="newsList">
									<tr>
										<td width="40" align="center"><img
											src="<s:url value="/ui/images/dian.jpg" />" /></td>
										<td><a
											href="/BabySitterWeb/article/getDetail.html?article.id=<s:property value='id' />"
											target="_blank" title="<s:property value='title' />"> <span>
													<s:property
														value='%{@com.sut.util.StringUtil@utf8Truncate(title, 15)}' />
											</span>
										</a></td>
									</tr>
								</s:iterator>
							</table>

						</td>
					</tr>
					<tr>
						<td height="11"><img
							src="<s:url value="/ui/images/b1.jpg" />" /></td>
					</tr>
				</table> <map name="Map25" id="Map25">
					<area shape="rect" coords="212,8,252,26" href="#" />
				</map>
				<table width="264" style="margin-top: 18px;" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td height="32"><img
							src="<s:url value="/ui/images/t2.jpg" />" border="0"
							usemap="#Map" /></td>
					</tr>
					<tr>
						<!-- 这里是护理常识 -->
						<td background="<s:url value="/ui/images/c1.jpg" />" height="182"
							valign="top" style="padding-top: 17px; padding-bottom: 17px;">
						</td>
					</tr>
					<tr>
						<td height="11"><img
							src="<s:url value="/ui/images/b1.jpg" />" />
							<table width="264" style="margin-top: 18px;" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td height="32"><img
										src="<s:url value="/ui/images/t3.jpg" />" border="0" /></td>
								</tr>
								<tr>
									<td background="<s:url value="/ui/images/c1.jpg" />"
										height="156" valign="top"
										style="line-height: 20px; padding-left: 23px; padding-right: 23px; padding-top: 4px;"><img
										src="<s:url value="/ui/images/tel.jpg" />" /><br />
										地址：上海市闸北区共和新路999号<br /> （共和大厦）5178室<br /> 电话：021-xxxxxxxx<br />
										手机：138xxxxxxxx<br /> 在线QQ：xxxxxxx<br /> 培训部网站：<a
										href="http://jpsjw.net/">www.jpsjw.net</a></td>
								</tr>
								<tr>
									<td height="11"><img
										src="<s:url value="/ui/images/b1.jpg" />" /></td>
								</tr>
							</table></td>
					</tr>
				</table> <map name="Map" id="Map">
					<area shape="rect" coords="214,7,251,26" href="#" />
				</map>
			</td>
			<td valign="top">
				<table width="714" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="415" valign="top">
							<table width="401" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="32"><img src="<s:url value='/ui/images/t5.jpg' />"
										border="0" usemap="#Map2" /></td>
								</tr>
								<tr>
									<td background="<s:url value='/ui/images/c2.jpg' />" height="144"
										valign="top" style="padding-top: 17px; padding-bottom: 17px;">
										<table width="364" align="center" border="0" cellspacing="0"
											cellpadding="0">
											<tr>
												<!-- 这里是公司简介 -->
												<td align="left" valign="top">
													<p><span style="line-height:1.8;">上海蓓贝家庭服务有限公司是一家集月嫂、育婴师、催乳师、母婴培训于一体的综合母婴护理体验站。成立于2011年，已有6年多的经营经验，服务江浙沪，海内外客户......</span></p>
												</td> 
											</tr>
										</table>
									</td>
								</tr>
								<td height="11"><img src="<s:url value='/ui/images/b2.jpg' />" /></td>
								</tr>
							</table>
						</td>


						<td align="center" bgcolor="#FF42B6">
						<!-- 这里是图片滚动 -->
							<div class="wrapper">
								<div id="focus">
									<ul>
										<li>
											<a href="http://www.875.cn/" target="_blank">
											<img class="image" src="<s:url value='/ui/images/1.jpg' />"
													alt="QQ商城焦点图效果下载" />
											</a>
										</li>
										<li>
											<a href="http://www.875.cn/" target="_blank">
												<img class="image" src="<s:url value='/ui/images/2.jpg' />"
													alt="QQ商城焦点图效果教程" />
											</a>
										</li>
										<li><a href="http://www.875.cn/" target="_blank">
											<img class="image" src="<s:url value='/ui/images/3.jpg' />"
												 alt="jquery商城焦点图效果" /></a></li>
										<li><a href="http://www.875.cn/" target="_blank">
											<img class="image" src="<s:url value='/ui/images/4.jpg' />"
												alt="jquery商城焦点图代码" />
										</a></li>
										<li><a href="http://www.875.cn/" target="_blank"><img
												class="image"
												src="<s:url value='/ui/images/5.jpg' />"
												alt="jquery商城焦点图源码" />
										</a></li>
									</ul>
								</div>
								<!--focus end-->

							</div>
							<!-- wrapper end -->
						</td>
					</tr>
				</table> <map name="Map2" id="Map2">
					<area shape="rect" coords="344,7,384,26" href="#" />
				</map>
				<table width="714" style="margin-top: 18px;" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td valign="top">
							<table width="714" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="32"><img src="<s:url value='/ui/images/t6.jpg' />"
										border="0" usemap="#Map3" />
									</td>
								</tr>
								<tr>
									<td background="<s:url value='/ui/images/c3.jpg' />" height="215">
										<DIV id=demo
											style="OVERFLOW: hidden; WIDTH: 600px; margin: 0 auto; COLOR: #ffffff; margin-top: 4px;">
											<TABLE cellSpacing=0 cellPadding=0 align=left border=0
												cellspace="0">
												<TBODY>
													<TR>
														<TD id=demo1 vAlign=top><table border="0"
																cellpadding="0" cellspacing="0">
																<tr>
																	<!-- 员工风采 -->
																	<td width="106"
																		style="padding-left: 7px; padding-right: 7px;">
																		<table width="106" height="164" border="0"
																			cellspacing="0" cellpadding="0">
																			<tr>
																				<td>
																				<a href="[field:arcurl/]" target=_blank
																					title="[field:title/]">
																					<img height=128
																						src="<s:url value='/upload/images/staff/20161224031146399.jpg' />" width=100
																						style="border: 3px solid #FFFFFF" />
																				</a>
																				</td>
																			</tr>
																			<tr>
																				<td height="22" align="center"><A
																					href="[field:arcurl/]" target=_blank
																					style="color: #F94987">[field:title/]</A></td>
																			</tr>
																		</table>
																	</td> 
																	
																	<td width="106"
																		style="padding-left: 7px; padding-right: 7px;">
																		<table width="106" height="164" border="0"
																			cellspacing="0" cellpadding="0">
																			<tr>
																				<td>
																				<a href="[field:arcurl/]" target=_blank
																					title="[field:title/]">
																					<img height=128
																						src="<s:url value='/upload/images/staff/20161224031146399.jpg' />" width=100
																						style="border: 3px solid #FFFFFF" />
																				</a>
																				</td>
																			</tr>
																			<tr>
																				<td height="22" align="center"><A
																					href="[field:arcurl/]" target=_blank
																					style="color: #F94987">[field:title/]</A></td>
																			</tr>
																		</table>
																	</td> 

																</tr>
															</table></TD>
														<TD id=demo2 vAlign=top></TD>
													</TR>
												</TBODY>
											</TABLE>
										</DIV> 
									</td>
								</tr>
								<tr>
									<td height="11"><img src="<s:url value='/ui/images/b3.jpg' />" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table> <map name="Map3" id="Map3">
					<area shape="rect" coords="658,7,698,26" href="#" />
				</map>
				<table width="714" style="margin-top: 18px;" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td valign="top">
							<table width="714" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="32"><img src="<s:url value='/ui/images/t7.jpg' />"
										border="0" usemap="#Map4" /></td>
								</tr>
								<tr>
									<td background="<s:url value='/ui/images/c3.jpg' />" height="187"
										valign="top">
										<table style="margin-top: 24px;" class="item" width="690"
											align="center" height="118" border="0" cellspacing="0"
											cellpadding="0">
											<tr>
												<td width="114" height="30">&nbsp;<a href="#">月嫂服务</a></td>
												<td width="116"></td>
												<td width="114">&nbsp;<a href="#">育婴师/育儿嫂服务</a></td>
												<td width="116"></td>
												<td width="114">&nbsp;<a href="#">培训服务</a></td>
												<td width="116"></td>
											</tr>
											<tr>
												<td width="114" valign="top" align="center"><img
													src="<s:url value='/ui/images/img2.jpg' />" /></td>
												<td width="116" valign="top">产后指导，膳食调配，乳房护理，心理调节，形体恢复；新生儿喂养，抚触等。</td>
												<td width="114" valign="top" align="center"><img
													src="<s:url value='/ui/images/img3.jpg' />" /></td>
												<td width="116" valign="top">生活护理，行为教养，开发智力，体能锻炼，保健护理。
												</td>
												<td width="114" valign="top" align="center"><img
													src="<s:url value='/ui/images/img4.jpg' />" /></td>
												<td width="116" valign="top">上海专业的月嫂培训服务。</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td height="11"><img src="<s:url value='/ui/images/b3.jpg' />" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table> <map name="Map4" id="Map4">
					<area shape="rect" coords="658,7,698,26" href="#" />
				</map>
			</td>
		</tr>
	</table>
	<table align="center" width="994" style="margin-top: 18px;" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td height="32"><img src="<s:url value='/ui/images/t110.jpg' />"
				border="0" /></td>
		</tr>
		<tr>
			<td background="<s:url value='/ui/images/c10.jpg' />" valign="top"
				style="line-height: 20px; padding-left: 23px; padding-right: 23px; padding-top: 10px; padding-bottom: 10px;">

				{dede:arclist row=12 typeid='11' orderby=pubdate titlelen=20
				type='image.' imgwidth='158' imgheight='118'}
				<div class="list3">
					<table width="128" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="30" background="<s:url value='/ui/images/titbg.jpg' />"
								style="background-position: center; background-repeat: no-repeat; font-size: 13px;"
								align="center"><A href="about.asp?ID=29" target=_blank>[field:title/]</A></td>
						</tr>
						<tr>
							<td height="110" align="center"><A href="[field:arcurl/]"
								target=_blank><img src="[field:litpic/]" width="99"
									height="99" /></A></td>
						</tr>
						<tr>
							<td height="68" valign="top">
								<table width="99" align="center" border="0" cellspacing="0"
									cellpadding="0">
									<tr>
										<td class="pmin"><A href="[field:arcurl/]" target=_blank>[field:description
												function="cn_substr(@me,404)"/]</A></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div> {/dede:arclist}
			</td>
		</tr>
		<tr>
			<td height="11"><img src="<s:url value='/ui/images/b10.jpg' />" /></td>
		</tr>
	</table>
	<table align="center" width="994" style="margin-top: 12px;" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td height="32"><img src="<s:url value='/ui/images/t10.jpg' />"
				border="0" /></td>
		</tr>
		<tr>
			<td background="<s:url value='/ui/images/c10.jpg' />" valign="top"
				style="line-height: 20px; padding-left: 23px; padding-right: 23px; padding-top: 10px; padding-bottom: 10px;">
				{dede:flink linktype='2' row='10'} [field:link /]&nbsp;&nbsp;
				{/dede:flink}</td>
		</tr>
		<tr>
			<td height="11"><img src="<s:url value='/ui/images/b10.jpg' />" /></td>
		</tr>
	</table>
</body>
</html>