<#if (actionMessages?? && actionMessages?size > 0 && !parameters.isEmptyList)>
<#assign errorMsg>
	<#list actionMessages as message>
	   ${message}<br><#rt>
	</#list>
</#assign>
<div class="box-body">
<div class="callout callout-success">
	<button type="button" data-dismiss="alert" class="close">x</button>
	<p>${errorMsg}<#rt/></p>
</div>
</div>
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery(".box-body .callout-success").fadeOut(50000);
	});
</script>
</#if>