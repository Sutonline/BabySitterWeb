<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../css/Css.css" rel="stylesheet" type="text/css" />
<link href="../../css/bbCss.css" rel="stylesheet" type="text/css" />
<link href="../../css/page.css" rel="stylesheet" type="text/css" />
<link href="../../css/main.css" ref="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/png.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table width="994" style="margin-top: 22px;" align="center" border="0"
		cellspacing="0" cellpadding="0">
		<tr>
			<td width="280" valign="top">
				<table width="264" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="32"><img src="../../images/t8.jpg"
							border="0" usemap="#Map5" /></td>
					</tr>
					<tr>
						<td background="../../images/c1.jpg" height="144"
							valign="top"
							style="padding-left: 23px; padding-right: 23px; padding-top: 17px; padding-bottom: 17px;">
							<table width="164" class="severs" border="0" cellspacing="0"
								cellpadding="0">
								{dede:arclist titlelen='24' row='3' typeid='3'}
								<tr>
									<td width="50" height="44" align="center"><img
										src="../../images/dian.jpg" /></td>
									<td><a href="[field:arcurl /]" target=_blank>[field:title
											/]</a></td>
								</tr>
								{/dede:arclist}
							</table>
						</td>
					</tr>
					<tr>
						<td height="11"><img src="../../images/b1.jpg" /></td>
					</tr>
				</table> <map name="Map5" id="Map5">
					<area shape="rect" coords="211,7,252,25" href="ezuk.net" />
				</map>
				<table width="264" style="margin-top: 18px;" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td height="32"><img src="../../images/t2.jpg"
							border="0" usemap="#Map" /></td>
					</tr>
					<tr>
						<td background="../../images/c1.jpg" height="182"
							valign="top" style="padding-top: 17px; padding-bottom: 17px;">
							{dede:arclist titlelen='28' row='6' typeid='5'}
							<table width="240" align="center" height="30" border="0"
								cellspacing="0" cellpadding="0">
								<tr>
									<td width="40" align="center"><img
										src="../../images/dian.jpg" /></td>
									<td><a href="[field:arcurl /]" target="_blank"
										title="[field:title /]">[field:title /]</a></td>
								</tr>
							</table> {/dede:arclist}
						</td>
					</tr>
					<tr>
						<td height="11"><img src="../../images/b1.jpg" /></td>
					</tr>
				</table> <map name="Map" id="Map">
					<area shape="rect" coords="214,7,251,26" href="ezuk.net" />
				</map>
				<table width="264" style="margin-top: 18px;" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td height="32"><img src="../../images/t3.jpg"
							border="0" /></td>
					</tr>
					<tr>
						<td background="../../images/c1.jpg" height="156"
							valign="top"
							style="line-height: 20px; padding-left: 23px; padding-right: 23px; padding-top: 4px;">
							<img src="../../images/tel.jpg" /><br />
							地址：上海市闸北区共和新路999号<BR> （共和大厦）5178室<BR> 电话：021-xxxxxxxx<BR>
							手机：138xxxxxxxx<BR> 在线QQ：xxxxxxx<BR> 培训部网站：<A
							href="http://jpsjw.net/">www.jpsjw.net</A>
						</td>
					</tr>
					<tr>
						<td height="11"><img src="../../images/b1.jpg" /></td>
					</tr>
				</table>
			</td>
			<td valign="top">
				<table width="714" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td valign="top">
							<table width="714" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="32" background="../../images/tbg.jpg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前位置：{dede:field
										name='position'/}</td>
								</tr>
								<tr>
									<td background="../../images/c3.jpg" height="730"
										valign="top">
										<table width="90%"
											style="margin-top: 30px; margin-bottom: 30px;" align="center"
											border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>{dede:list pagesize='20' titlelen='40'}
													<table width="100%" height="24" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td width="36" align="center"><img
																src="../../images/dian.jpg" /></td>
															<td><a href="[field:arcurl /]" target="_blank"
																title="[field:title /]">[field:title /]</a></td>
														</tr>
													</table> {/dede:list}

													<table width="100%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td height="80">
																<div class="dede_pages">
																	<ul class="pagelist">{dede:pagelist
																		listitem="info,index,end,pre,next,pageno,option"
																		listsize="5"/}
																	</ul>
																</div>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td height="11"><img src="../../images/b3.jpg" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>