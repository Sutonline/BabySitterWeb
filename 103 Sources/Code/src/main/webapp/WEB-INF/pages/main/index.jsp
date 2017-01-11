<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<s:url value='/ui/css/main.css' />" rel="stylesheet" type="text/css">
<link href="<s:url value="/ui/css/public.css" />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<s:url value="/ui/js/global.js" />"></script>
<script src="<s:url value="/ui/js/frame.js" />" language="javascript" type="text/javascript"></script>
<title>Manage Index Page</title>
<script type="text/javascript">
//顶部下拉菜单
$(document).ready(function(){
  $('.M').hover(
    function(){
      $(this).addClass('active');
    },
    function(){
      $(this).removeClass('active');
    });
});

function change(id, choose)
{
  document.getElementById(id).value = choose.options[choose.selectedIndex].title;
}

function resizeIframe(obj) {
    obj.style.height = (obj.contentWindow.document.body.scrollHeight + 0) + 'px';
  }

</script>
</head>
<body>

<div id="dcWrap"> <div id="dcHead">
<!-- 更多更能 -->
<div class="allmenu">
  <div class="allmenu-box">
    <?php
	echo $mapstring;
?>
    <br style='clear:both' />
  </div>
</div>


 <div id="head">
  <%-- <div class="logo"><img src="<s:url value="/ui/images/style1/admin_top_logo.gif" />" width="200" height="37" alt="DedeCms Logo" title="Welcome use DedeCms" id="topdedelogo" /></div> --%>
  <div class="nav">
   <ul>
    <li><a href="../index.php" target="_blank">查看站点</a></li>
    <li><a href="sys_cache_up.php" target='main'>清除缓存</a></li>
    <li> 
    	<a href="#" id="allmenu">功能地图</a>
	</li>
   </ul>
   <ul class="navRight">
    <li class="M noLeft"><a href="JavaScript:void(0);">您好，admin</a>
     <div class="drop mUser"> <a href="../member" target="_blank">会员中心</a></div>
    </li>
    <li class="noRight"><a href="exit.php" target="_top">注销</a></li>
   </ul>
  </div>
 </div>
</div>
<!-- dcHead 结束 --> <div id="dcLeft"><!-- 后台菜单 -->
<div id="menu">

<!--  <ul class="top">
  <li><a href="index.php" ><i class="home"></i><em>管理首页</em></a></li>
 </ul> -->
 
 <ul>
  <li><a href="<s:url value='/article/listByCategory.html' />"  target='main'><i class="article"></i><em>文章列表</em></a></li>
  <li><a href="content_list.php?channelid=6"  target='main'><i class="product"></i><em>商品列表</em></a></li>
    <li><a href="catalog_main.php"  target='main'><i class="articleCat"></i><em>栏目管理</em></a></li>
   <li><a href="<s:url value='/feedback/listAll.html' />"  target='main'><i class="page"></i><em>评论管理</em></a></li>
 </ul>
 
 <ul>

  <li><a href="sys_info.php"  target='main'><i class="system"></i><em>系统设置</em></a></li>
  <li><a href="templets_main.php"  target='main'><i class="nav"></i><em>模板管理</em></a></li>
  <li><a href="co_main.php"  target='main'><i class="show"></i><em>采集管理</em></a></li>
 
 </ul>
 
 
 <ul>
  <li><a href="sys_admin_user.php"  target='main'><i class="manager"></i><em>网站管理员</em></a></li>
  <li><a href="log_list.php" target='main'><i class="managerLog"></i><em>操作记录</em></a></li>
 </ul>
 <ul class="bot">
  <li><a href="makehtml_all.php"  target='main'><i class="mobile"></i><em>更新网站</em></a></li>
  <li><a href="sys_cache_up.php"  target='main'><i class="guestbook"></i><em>更新缓存</em></a></li>
  <li><a href="sys_data.php"  target='main'><i class="backup"></i><em>数据备份</em></a></li>
  <li><a href="friendlink_main.php"  target='main'><i class="link"></i><em>友情链接</em></a></li>
 </ul>
</div></div>
 <div class="ui-waitting"></div>
 <div class="page-content">
 <div id="dcMain"> <!-- 当前位置 -->
	<iframe id="main" name="main"  src="<s:url value="/admin/indexBody.html" />"  frameborder="0" onload="resizeIframe(this)" ></iframe>
 </div>
 </div>
 <div class="clear"></div>
<div id="dcFooter">
 <div id="footer">
  <div class="line"></div>
  <ul>
   版权所有 © 2013-2014 雷霆策动文化传播有限公司，并保留所有权利。
  </ul>
 </div>
</div><!-- dcFooter 结束 -->
<div class="clear">

</div> </div>

</body>
</html>