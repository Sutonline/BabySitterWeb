<#if parameters.required?default(false)>
	<span class="required">*</span><#rt/>
</#if>
<label<#rt/>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.cssClass??>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#if parameters.for??>
 for="${parameters.for?html}"<#rt/>
</#if>
<#if parameters.lable?exists>
	${stack.findValue("getText('"+parameters.label+"')")} : <#rt/>
</#if>
</label><#rt/>