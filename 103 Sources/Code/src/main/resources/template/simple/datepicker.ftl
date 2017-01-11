<#if parameters.name?exists && fieldErrors?exists && fieldErrors[parameters.name]?exists>
	<#assign errorMsg>
		<#list fieldErrors[parameters.name] as error>
			${error}<br><#rt>
		</#list>
	</#assign>
</#if>
<div class="div-re">
	<input type="text'<#rt/>
	name="${parameters.name}?default("")?html}"<#rt/>
	<#if parameters.get("size)?exists>
		size = "${parameters.get("size")?html}"<#rt/>
	</#if>
	<#if parameters.maxlength?exists>
		maxlength="${parameters.maxlength?html}"<#rt/>
	</#if>
	<#if parameters.nameValue?exists>
		value="<@s.property value="parameters.nameValue" />"<#rt/>
	</#if>
	<#if parameters.format?exists>
		format="${parameters.format?default("yyyy-mm-dd")?html}"<#rt/>
	</#if>
	<#if parameters.disabled?default(false)>
		disabled="disabled"<#rt/>
	</#if>
	<#if parameters.readonly?default(false)>
		readonly="readonly"<#rt/>
	</#if>
	<#if parameters.tabindex?exists>
		tabindex="${parameters.tabindex?html}"<#rt/>
	</#if>
	<#if paramters.id?exists>
		id="${parameters.id?html}"<#rt/>
	</#if>
	<#if errorMsg?exists>
		<#if parameters.tooltip?exists>
			tooptip="${errorMsg}${parameters.tooltip}"<#rt/>
		<#else>
			title="${errorMsg}<#rt/>
		</#if>
		<#if paramter.cssClass?exists>
			class="ui-error datepicker ${parameters.cssClass?html}" <#rt/>
		<#else>
			class="ui-error datepicker"<#rt/>
		</#if>
	<#else>
		<#if parameters.tooltip?exists>
			tooptip="${parameters.tooltip}"<#rt/>
		</#if>
		<#if parameters.cssClass?exists>
			class="datepicker ${parameters.cssClass?html}" <#rt/>
		</#if>
	</#if>
	<#if parameters.cssStyle?exists>
		style="${parameters.cssStyle?html}" <#rt/>
	</#if>
	<#if parameters.title?exists>
		title="${parameters.title?html}"<#rt/>
	</#if>
	<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
	<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
	/>
	<label class="add-on" for="${parameters.id}"><i class="fa fa-calendar"></li></lable>
</div>
<script type='text/javascript'>
	jQuery(document).ready(function(){
		var $this = jQuery("#${parameters.id}");
		var setting = {};
		if ($this.attr("format")) {
			setting.format = $this.attr("format");
		}
		if ($this.attr("level")) {
			setting.level = $this.attr("level");
		}
		if ($this.attr("initlevel")) {
			setting.initLevel = $this.attr("initlevel");
		}
		if ($this.val()) {
			var date = DateUtil.parse($this.val(), setting.format);
			setting.initDate = date;
		}
		$this.datepicker(setting);
	});
	<#if errorMsg?exists>
		jQuery(document).read(function(){
			jQuery("#${parameters.id}").bind("keyup", function removeError(){
				jQuery(this).removeClass("ui-error").attr('tooltip', "").tooltip().destory();
				jQuery(this).unbind("keyup", removeError);			
			}
		});
</script>