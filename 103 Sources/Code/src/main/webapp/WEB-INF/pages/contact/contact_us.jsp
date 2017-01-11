<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<s:include value="../common/header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
<script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=494995e6776e52a5aa3801f487d15454" ></script>

<link type="text/css" href="<s:url value='/ui/css/base.min.css' />" rel="stylesheet" />
<link type="text/css" href="<s:url value='/ui/css/4002.min.css' />" rel="stylesheet" id="templateFrame"  class="templateFrameClass"/> 
<link type='text/css' href='<s:url value="/ui/css/pattern3.min.css" />' rel='stylesheet'>
<link type='text/css' href='<s:url value="/ui/css/searchBoxStyle1.min.css" />' rel='stylesheet'>
<link type="text/css" href="<s:url value='/ui/css/poshytipAndmCustomScrollbar.min.css' />" rel="stylesheet" />


<title>Contact us</title>
<script type="text/javascript">
$(function(){
	
	//console.log(map.getSize());
	//console.log(map.getSize().height);
	//console.log(topForms.offset().top);
	
	//topForms.css("top", curTop + map.getSize().height);
});
</script>
</head>
<body>
	<table id="webContainerTable" class="webContainerTable" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
          <div id="webContainer" class="webContainer">
            <div id="container" class="container">
  <table class="containerTop" cellpadding='0' cellspacing='0'>
    <tr valign='top'>
      <td class="left"></td>
      <td class="center"></td>
      <td class="right"></td>
    </tr>
  </table>

  <table class="containerMiddle" cellpadding='0' cellspacing='0'>
    <tr valign='top'>
      <td id="containerMiddleLeft" class="containerMiddleLeft">
          	
      </td>

      <td class="containerMiddleCenter">
        <div id="containerMiddleCenterTop" class="containerMiddleCenterTop">
          
        </div>
		
		<div id="mapcontainer" style="width:900px;height:300px;align:center">
		
			</div>
			
			<script>
				var map = new AMap.Map('mapcontainer', {
				    resizeEnable: false,
				    zoomEnable :false,
				    zoom:15,
				    center: [116.397428, 39.90923]       
				});
				console.log(map.getSize());
				
				// 自定义点标记内容
		        var markerContent = document.createElement("div");

		        // 点标记中的图标
		        var markerImg = document.createElement("img");
		        markerImg.className = "markerlnglat";
		        markerImg.src = "http://webapi.amap.com/theme/v1.3/markers/n/mark_r.png";
		        markerContent.appendChild(markerImg);

		        var markder = new AMap.Marker({
		            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_r.png",
		            position: [116.405467, 39.907761],
		            title : "北京联合公司"
		        });
		        
				markder.setMap(map);
			</script>
		
        <div id="containerForms" class="containerForms">
          <div id="topForms" class="column forms mainForms topForms" >
            <div id='module584' _indexClass='formIndex1' _modulestyle='56' _moduleid='584'  class='form  formIndex1 formStyle56' title='' style='' _side='0' _inTab='0' _inMulMCol='0' _inFullmeasure='0' _inpack='0' _autoHeight='1' _global='true' _independent='false' >
<table class='formTop formTop584' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class=' formMiddle formMiddle584' style='' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft584'></td>
<td class='formMiddleRight formMiddleRight584'></td>
</tr></table>
<table class='formBottom formBottom584' cellpadding='0' cellspacing='0'><tr><td class='left left584'></td><td class='center center584'></td><td class='right right584'></td></tr></table>
<div class='clearfloat clearfloat584'></div>
</div>

<div id='module564' _indexClass='formIndex2' _modulestyle='18' _moduleid='564'  class='form form564 formIndex2 formStyle18' title='' style='' _side='0' _inTab='0' _inMulMCol='0' _inFullmeasure='0' _inpack='0' _autoHeight='1' _global='false' _independent='false' >
<table class='formTop formTop564' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class=' formMiddle formMiddle564' style='' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft564'></td>
<td class='formMiddleCenter formMiddleCenter564 ' valign='top'>
<div class='formMiddleContent formMiddleContent564' tabStyle='0'>
<div id='mapframe564' name='mapframe' frameborder='0' scrolling='no' height='500' width='1200' src='about:blank'></div></div>
</td>
<td class='formMiddleRight formMiddleRight564'></td>
</tr></table>
<table class='formBottom formBottom564' cellpadding='0' cellspacing='0'><tr><td class='left left564'></td><td class='center center564'></td><td class='right right564'></td></tr></table>
<div class='clearfloat clearfloat564'></div>
</div>

<div id='module566' _indexClass='formIndex3' _modulestyle='35' _moduleid='566'  class='form form566 formIndex3 formStyle35 layoutModule  formStyle35_2  fk-formCol ' title='' style='' _side='0' _inTab='0' _inMulMCol='0' _inFullmeasure='0' _inpack='0' _autoHeight='1' _global='false' _independent='false' >
<table class='formTop formTop566' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class=' formMiddle formMiddle566' style='' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft566'></td>
<td class='formMiddleCenter formMiddleCenter566  f-colFormMiddleCenter ' valign='top'>
<div class='formMiddleContent formMiddleContent566 multiColFormMiddleContent f-colFormMiddleContent ' tabStyle='0'>
<div class='mulMColContent' id='mulMColContent566'><table width="100%" border="0" cellspacing="0" class="mulMColContentTable" cellpadding="0"><tbody><tr><td class=" mulColLayout mulColPadding" style="width:590px;"><div id="mulMCol566_cid_1" class="mulMColList"><div id='module567' _indexClass='' _modulestyle='1' _moduleid='567'  class='form form567 formStyle1 formInMulMCol ' title='' style='' _side='0' _inTab='0' _inMulMCol='566' _inFullmeasure='0' _inpack='0' _autoHeight='1' _global='false' _independent='false' >
<table class='formTop formTop567' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class=' formMiddle formMiddle567' style='' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft567'></td>
<td class='formMiddleCenter formMiddleCenter567 ' valign='top'>
<div class='formMiddleContent formMiddleContent567' tabStyle='0'>
<div class='richContent richContent0'><p><img src="http://9231013.s21i-9.faiusr.com/4/ABUIABAEGAAg56fmuAUo1IOhpgMwgwE4eA!60x60.png" alt=" " style="width:40px;height:40px;" /><span style="font-size:18px;"> 2497324831</span></p><p><span style="font-size:18px;"><br /></span></p><p><span style="font-size:18px;"><img src="http://9231013.s21i-9.faiusr.com/4/ABUIABAEGAAgwqjmuAUotPeRvgMwgwE4eA!60x60.png" alt=" " style="width:40px;height:40px;" /> 021-55600811</span></p><p><span style="font-size:18px;"><br /></span></p><p><span style="font-size:18px;"><img src="http://9231013.s21i-9.faiusr.com/4/ABUIABAEGAAgn6nmuAUogL3JhwIwejh_!60x60.png" alt=" " style="width:40px;height:40px;" /> 13764057282/陈老师</span></p><p><span style="font-size:18px;"><br /></span></p><p><span style="font-size:18px;"><img src="http://9231013.s21i-9.faiusr.com/4/ABUIABAEGAAg6anmuAUonoCphQcwhQE4igE!60x60.png" alt=" " style="width:40px;height:40px;" /> beibeiyuesao@126.com</span></p><p><span style="font-size:18px;"><br /></span></p><p><span style="font-size:18px;"><img src="http://9231013.s21i-9.faiusr.com/4/ABUIABAEGAAgk6rmuAUo-sKd4QMwezh3!60x60.png" alt=" " style="width:40px;height:40px;" /> 上海市静安区共和新路938号2107室</span></p><div><span style="font-size:18px;"><br /></span></div><p><br /></p></div></div>
</td>
<td class='formMiddleRight formMiddleRight567'></td>
</tr></table>
<table class='formBottom formBottom567' cellpadding='0' cellspacing='0'><tr><td class='left left567'></td><td class='center center567'></td><td class='right right567'></td></tr></table>
<div class='clearfloat clearfloat567'></div>
</div>
</div><div class="mulModuleColStyleLine" style=""></div></td><td class="mulColLayout" style=""><div id="mulMCol566_cid_2" class="mulMColList"><div id='module568' _indexClass='' _modulestyle='1' _moduleid='568'  class='form form568 formStyle1 formInMulMCol ' title='' style='' _side='0' _inTab='0' _inMulMCol='566' _inFullmeasure='0' _inpack='0' _autoHeight='1' _global='false' _independent='false' >
<table class='formTop formTop568' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class=' formMiddle formMiddle568' style='' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft568'></td>
<td class='formMiddleCenter formMiddleCenter568 ' valign='top'>
<div class='formMiddleContent formMiddleContent568' tabStyle='0'>
<div class='richContent richContent6'><p><span style="font-size:18px;">地铁1号线中山北路地铁站1号口出</span></p><p><span style="font-size:18px;"><br /></span></p><p><span style="font-size:18px;">地铁8号线西藏北路地铁站3号口出</span></p><p><span style="font-size:18px;"><br /></span></p><p><span style="font-size:18px;">附近公交：46/47/95/98/210/216/743/829/840/ 849/869/933/966/974/1208路、北安线等</span></p><p><span style="font-size:18px;"><br /></span></p><p><span style="font-size:18px;">可以扫码添加我们的微信公众号：<span style="color:#222222;font-family:&#39;Helvetica Neue&#39;, &#39;Hiragino Sans GB&#39;, &#39;Microsoft YaHei&#39;, 黑体, Arial, sans-serif;font-size:14px;line-height:22.4px;background-color:#FFFFFF;">蓓贝母婴上海专业月嫂育儿嫂护理</span></span></p><p><br /></p><p><br /></p></div><div class='richModuleSlaveImgContainer textImg6'><img  imgid='ABUIABACGAAgtdTmuAUo_Lqc1gUwggI4ggI' imgurl='' imglinktype='1' imgcolId='2' imgpath='http://9231013.s21i-9.faiusr.com/2/ABUIABACGAAgtdTmuAUo_Lqc1gUwggI4ggI.jpg' class='richModuleSlaveImg' alt='' title='' src='http://9231013.s21i-9.faiusr.com/2/ABUIABACGAAgtdTmuAUo_Lqc1gUwggI4ggI!160x160.jpg'  style='width:112px;height:112px;'><div class='richEditPic' _onMouseIn='0' onclick='Site.changeRichPic(568);return false;'><a class='edit' id='uploadButton' title='编辑图片'></a></div></div></div>
</td>
<td class='formMiddleRight formMiddleRight568'></td>
</tr></table>
<table class='formBottom formBottom568' cellpadding='0' cellspacing='0'><tr><td class='left left568'></td><td class='center center568'></td><td class='right right568'></td></tr></table>
<div class='clearfloat clearfloat568'></div>
</div>
</div></td></tr></tbody></table></div></div>
</td>
<td class='formMiddleRight formMiddleRight566'></td>
</tr></table>
<table class='formBottom formBottom566' cellpadding='0' cellspacing='0'><tr><td class='left left566'></td><td class='center center566'></td><td class='right right566'></td></tr></table>
<div class='clearfloat clearfloat566'></div>
</div>


          </div>

          <table class="containerFormsMiddle" cellpadding='0' cellspacing='0'>
            <tr>
              <td valign="top" id="containerFormsLeft" class="containerFormsLeft" style='display:none'>
                <div class="containerFormsLeftTop">
                </div>
                <div id="leftForms" class="column forms sideForms leftForms">
                  
                </div>
                <div class="containerFormsLeftBottom">
                </div>
              </td>

              <td valign="top" id="containerFormsCenter" class="containerFormsCenter">
          
                <div id="centerTopForms" class="column forms mainForms centerTopForms" style='display:none'>
                  
                </div>
                <div class="containerFormsCenterMiddle J_containerFormsCenterMiddle">
                  <div id="middleLeftForms" class="column forms mainForms middleLeftForms" style='display:none'
                    
                  >
                  
                  </div>
                  <div id="middleRightForms" class="column forms mainForms middleRightForms" style='display:none'
                    
                  >
                  
                  </div>  
                  <div class="clearfloat"></div>
                </div>
                <div id="centerBottomForms" class="column forms mainForms centerBottomForms" style='display:none'>
                  
                </div>
              </td>

              <td valign="top" id="containerFormsRight" class="containerFormsRight" style='display:none'>
                <div class="containerFormsRightTop">
                </div>
                <div id="rightForms" class="column forms sideForms rightForms">
                  
                </div>
                <div class="containerFormsRightBottom">
                </div>
              </td>
            </tr>
          </table>

          <div id="bottomForms" class="column forms mainForms bottomForms" style='display:none'>
            
          </div>

          <div id="containerPlaceholder" class="containerPlaceholder" ></div>
          
        </div>

        <div id="containerMiddleCenterBottom" class="containerMiddleCenterBottom">
        </div>

      </td>

      <td id="containerMiddleRight" class="containerMiddleRight"></td>
    </tr>
  </table>
  
  <table class="containerBottom" cellpadding='0' cellspacing='0'>
    <tr valign='top'>
      <td class="left"></td>
      <td class="center"></td>
      <td class="right"></td>
    </tr>
  </table>
</div>

          </div>
        </td>
      </tr>
    </table>
    
	
</body>
</html>