<#if (actionErrors?? && actionErrors?size > 0)>
<#assign errorMsg>
	<#list actionErrors as error>
	    <#assign i = error?index_of("_jsonString_")/>
	    <#if (i > -1)||false>
	    	${error}<br><#rt>
	    <#else>
	    	${error}<br><#t>
	    </#if>
	</#list>
</#assign>
<div class="box-body">
<div class="callout callout-danger">
	<button type="button" data-dismiss="alert" class="close">x</button>
	<p>${errorMsg}<#rt/></p>
</div>
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery(".box-body .callout-danger").fadeOut(50000);
	});
</script>
</#if>