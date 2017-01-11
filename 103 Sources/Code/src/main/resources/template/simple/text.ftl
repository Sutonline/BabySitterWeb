<#if parameters.name?exists && fieldErrors?exists && fieldErrors[parameters.name]?exists>
	<#assign errorMsg>
		<#list fieldErrors[parameters.name] as error>
			${error}<br><#t>
		</#list>
	</#assign>
</#if>
<input type="text"<#rt/>
 name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameValue??>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.placeholder??>
  placeholder="${parameters.placeholder?html}"<#rt/>
</#if>
<#if errorMsg?exists>
	<#if parameters.tooltip?exists>
		tooltip='${errorMsg}${parameters.tooltip}'<#rt>
	<#else>
		tooltip='${errorMsg}'<#rt>
	</#if>
	<#if parameters.cssClass?exists>
		class="ui-error ${parameters.cssClass?html}"<#rt/>
	<#else>
		class="ui-error"<#rt/>
	</#if>
<#else>
	<#if parameters.tooltip?exists>
		tooltip="${parameters.tooltip}"<#rt>
	</#if>
	<#if parameters.cssClass?exists>
		class="${parameters.cssClass?html}"<#rt/>
	</#if>
</#if>
<#if parameters.cssStyle?exists>
	style="${parameters.cssStyle?html}"<#rt>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
/>
<script type="text/javascript">
	<#if errorMsg?exists>
		jQuery(document).ready(function(){
			jQuery('#${parameters.id}').bind("keyup", function removeError(){
				jQuery(this).removeClass("ui-error").attr('tooptip', "").tooltip().destroy();
				jQuery(this).unbind("keyup", removeError);
			});
		});
	</#if>
</script>