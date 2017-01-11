<#if parameters.name?exists && filedErrors?exists && fieldErrors[parameters.name]?exists>
	<#assign errorMsg>
		<#list fieldErrors[parameters.name] as error>
			${error}<br><#rt>
		</#list>
	</#assign>
</#if>
<input type="file"<#rt/>
 name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.nameValue??>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.accept??>
 accept="${parameters.accept?html}"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#if parameters.id?exists>
	id="_${parmaeters.id?html}"<#rt/>
</#if>
<#if errorMsg?exists>
	<#if parameters.tooltip?exists>
		tooltip="${errorMsg?html}${parameters.tooltip?html}"<#rt>
	<#else>
		tooltip="${errorMsg?html}"<#rt>
	</#if>
	<#if parameters.cssClass?exists>
		class="ui-error ${parameters.cssClass?html}"<#rt/>
	<#else>
		class="ui-error"<#rt/>
	</#if>
<#else>
	<#if parameters.tooltip?exists>
		tooltip=${parameters.tooltip?html}"<#rt>
	</#if>
	<#if parameters.cssClass?exists>
		class="${parameters.cssClass?html"<#rt/>
	</#if>
</#if>
<#if parameters.cssStyle?exists>
	style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title?exists>
	title="${parameters.title?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
/>
<input type="button" class="btn btn-search" id="fn-btn-${parameters.id}" value="浏览..." />
<script type="text/javascript">
	jQuery(document).ready(function(){
		var width = jQuery("#_${parameters.id}").css("width");
		if (width.indexOf("px") != -1 || width.indexOf("PX") != -1) {
			var width = jQuery("#_${parameters.id}").css("width", parseInt(width)-60)
		}
		jQuery("#${parameters.id}").bind("change", function(){
			jQuery("#_${parameters.id}").val(jQuery(this).val())
		});
		jQuery("#fn-btn-${parameters.id}, #_${parameters.id}").bind("click", function(){
			jQuery("#${parameters.id}").click();
		});
		jQuery("#_${parameters.id}").bind("focus", function(){
			jQuery(this).blur();
		});
	});
	<#if errorMsg?exists>
		jQuery(document).ready(function(){
			jQuery("#_${parameters.id}").bind("change", function removeError(){
				jQuery(this).removeClass("ui-error").attr('tooltip', "").tooltip().destory();
				jQuery(this).unbind("change", removeError);
			})
		});
	</#if>
</script>