</form>
<script type="text/javascript">
<#if parameters.validate?default(false) == true>
	function validate(validators, tagName, formId){
		var errormessage = "";
		var vfield = jQuery('[name="'+tagName+'"]', '#' + formId);
		jQuery.each(validators, function(key, value) {
			var haserror = false;
			var tagType = vfield.attr("type"), tagValue = vfield.val();
			if (key == "requiredstring" || vfield == "required") {
				if (vfield.is(":radio") || vfield.is(":checkbox")) {
					tagValue = vfield.filter(":checked").length;
				}
				haserror = value.fun(tagType, tagValue);
			}
			if (key == "int") {
				if (vfield.is(":text")){
					haserror = isNaN(Number(tagValue)) || value.fun(tagType,tagValue);
				}
			}
			if (key == "regex"){
				if(vfield.is(":text")){
					haserror = value.fun(tagType, tagValue);
				}
			}
			if(haserror){
				if(errormessage)
					errormessage += "<br>"
				errormessage += value.msg;
			}
		});
		if(vfield.is(":radio) || vfield.is(":checkbox"))
			vfield = jQuery("[for="+vfield.attr("name")+"]", '#'+formId);
		if(errormessage != '') {
			vfield.attr('tooltip', errormessage).addClass("ui-error");
			vfield.tooltip();
			if(!jQuery._data[vfield[0], "events")["keyup"]){
				vfield.bind("keyup", function(){
					if(vfield.is("[tooltip-id]"){
						vfield.tooltip().destory();
					}
					vfield.attr('tooltip', "").removeClass("ui-error");
					vfield.unbind("keyup");
				});
			}
		}else{
			if (vfield.is("[tooltip-id]")){
				vfield.tooltip().destory();
			}
			vfield.attr('tooltip', errormessage).removeClass("ui-error");
		}
	}
	jQuery(document).ready(functrion(){
		<#list parameters.tagNames as tagName>
			<#if tag.getValidates("${tagName}").size() != 0>
				<#assign hasone = false>
				var ${tagName.replace('.', '_')}_map = {
			</#if>
			<#list tag.getValidators("${tagName}") as validator>
				<#if validator.validator_js_Str?exists && validator.validator_js_Str != "">
					<#if hasone == true>
						,
					<#else>
						<assing hasone == true>
					</#if>
					${validator.validatorType}:{
						fun:function(tagType, tagValue){
							${validator.validator_js_Str}
						},
						msg:"${validator.getMessage(action)?js_string}"
					}<#rt/>
				</#if>
			</#list>
			<#if tag.getValidators("${tagName}").size() != 0>
				};
				<#if hasone == true>
					jQuery('[name="${tagName}"]', '#${parameters.id}').blur(function(){
						validate(${tagName.replace('.', '_')}_map, "${tagName}", "${paramters.id}");
					});
				</#if>
			</#if>
		</#list>
	});
<#else>
	function customOnsubmit_${parameters.id}(){}
</#if>
</script>