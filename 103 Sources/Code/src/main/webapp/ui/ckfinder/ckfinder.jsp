<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/pages/common/taglibs.jsp" %>    
<s:include value="../../WEB-INF/pages/common/header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<title>CKFinder</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="robots" content="noindex, nofollow" />
	<script type="text/javascript" src="<s:url value='/ui/ckfinder/ckfinder.js' />"></script>
	<style type="text/css">
		body, html, iframe, #ckfinder {
			margin: 0;
			padding: 0;
			border: 0;
			width: 100%;
			height: 100%;
			overflow: hidden;
		}
	</style>
</head>
<body class="CKFinderFrameWindow">
	<div id="ckfinder"></div>
	<script type="text/javascript">
//<![CDATA[
(function()
{
		var config = {};
		//这里要改成从action中获取参数
		var get = CKFinder.tools.getUrlParam;
		//getBool在这里
		/* var getBool = function( v )
		{
			var t = get( v );

			if ( t === null )
				return null;

			return t == '0' ? false : true;
		}; */

		var tmp;
		if ( tmp = '<s:property value="configId" />' )
		{
			var win = window.opener || window;
			try
			{
				while ( ( !win.CKFinder || !win.CKFinder._.instanceConfig[ tmp ] ) && win != window.top )
					win = win.parent;

				if ( win.CKFinder._.instanceConfig[ tmp ] )
					config = CKFINDER.tools.extend( {}, win.CKFinder._.instanceConfig[ tmp ] );
			}
			catch(e) {}
		}

		if ( tmp = '<s:property value="startupPath" />' || '<s:property value="start" />'  )
			config.startupPath = decodeURIComponent( tmp );

		config.id = '<s:property value="id" />'  || '';

		//TODO 这个怎么处理?看起来只要出来一个boolean的值就可以了
		/* if ( ( tmp = getBool( 'rlf' ) ) !== null )
			config.rememberLastFolder = tmp;

		if ( ( tmp = getBool( 'dts' ) ) !== null )
			config.disableThumbnailSelection = tmp; */

		if ( tmp = '<s:property value="data" />' )
			config.selectActionData = tmp;

		if ( tmp = '<s:property value="tdata" />' )
			config.selectThumbnailActionData = tmp;

		if ( tmp = '<s:property value="type" />' )
			config.resourceType = tmp;

		if ( tmp = '<s:property value="langCode" />' )
			config.language = tmp;

		if ( typeof( config.selectActionFunction ) == 'undefined' )
		{
			// Try to get desired "File Select" action from the URL.
			var action;
			if ( tmp = '<s:property value="CKEditor" />' )
			{
				if ( tmp.length )
					action = 'ckeditor';
			}
			if ( !action )
				action = '<s:property value="selectActionFunction" />';

			var parentWindow = ( window.parent == window ) ? window.opener : window.parent;
			switch ( action )
			{
				case 'js':
					var actionFunction = '<s:property value="func" />';
					if ( actionFunction && actionFunction.length > 0 )
						config.selectActionFunction = parentWindow[ actionFunction ];

					actionFunction = '<s:property value="thumbFunc" />';
					if ( actionFunction && actionFunction.length > 0 )
						config.selectThumbnailActionFunction = parentWindow[ actionFunction ];
					break ;

				case 'ckeditor':
					var funcNum = '<s:property value="CKEditorFuncNum" />';
					if ( parentWindow['CKEDITOR'] )
					{
						config.selectActionFunction = function( fileUrl, data )
						{
							parentWindow['CKEDITOR'].tools.callFunction( funcNum, fileUrl, data );
						};

						config.selectThumbnailActionFunction = config.selectActionFunction;
					}
					break;

				default:
					if ( parentWindow && parentWindow['FCK'] && parentWindow['SetUrl'] )
					{
						action = 'fckeditor' ;
						config.selectActionFunction = parentWindow['SetUrl'];

						if ( !config.disableThumbnailSelection )
							config.selectThumbnailActionFunction = parentWindow['SetUrl'];
					}
					else
						action = null ;
			}
			config.action = action;
		}

		// Always use 100% width and height when nested using this middle page.
		config.width = config.height = '100%';

		var ckfinder = new CKFinder( config );
		ckfinder.replace( 'ckfinder', config );
})();
//]]>
	</script>
</body>
</html>
