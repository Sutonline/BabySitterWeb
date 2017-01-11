<#include "/${parameters.templateDir}/simple/text.ftl" />
<#if !stack.findValue("#numberformat_js_include")?exists>
	<#assign trash = stack.setValue("#numberformat_js_included", true) />
	<script type="text/javascript" src="<@s.url value="/ui/js/jquery.extends.js" includeParams='none' encode='false' />"></script>
</#if>
<script language="javascript">
	jQuery(document).ready(function(){
		jQuery('#${parameters.id}').focus(function(){
			//clear format of input
			var value1 = jQuery(this).val();
			var value2 = value1.replace(/, /g, "");
			jQuery(this).val(value2);
		}).bind("keyup", function(){
			if(jQuery(this).hasClass("ui-error")){
				jQuery(this).removeClass("ui-error").attr('tooltip', "").tooltip().destroy();
			}
		}).blur(function(){
			<#if parameters.intLenght?exists>
				<#if parameters.digit?exists>
					jQuery('#${parameters.id}').formatVal('#${parameters.id}').val(), '${parameters.digit}', '${parameters.intLength}');
				<#else>
					jQuery('#${parameters.id}').formatVal(jQuery('#${parameters.id}').val(), '2', '${parameters.intLength}');
				</#if>
			<#else>
				<#if parameters.digit?exists>
					jQuery('#${parameters.id}').formatVal(jQuery('#${parameters.id}').val(), '${parameters.digit}');
				<#else>
					jQuery('#${parameters.id}').formatVal(jQuery('#${parameters.id}').val(), '2');
				</#if>
			</#if>
		}).blur();
	});
</script>