<#assign hasFieldErrors = parameters.name?exists && filedErrors[parameters.name]?exists/>
<#if hasFieldErrors>
	<#assign errorMsg>
		<#list fieldErrors[parameters.name] as error>
			${error}<br><#rt>
		</#list>
	</#assign><#rt/>
	${tag.addParameter('title', '${errorMsg}')}<#rt/>
	<#if parameters.cssClass?exists>
		${tag.addParameter('cssClass', 'ui-error'+parameters.cssClass)}<#rt/>
	<#else>
		${tag.addParameter('cssClass', 'ui-error')}<#rt/>
	</#if>
<#else>
	${tag.addParameter('title', '')}<#rt/>
	<#if parameters.cssClass?exists>
		${tag.addParameter('cssClass', parameters.cssClass)}<#rt/>
	<#else>
		${tag.addParameter('cssClass','')}<#rt/>
	</#if>
</#if>
<#if !parameters.cssStyle?exists>
	${tag.addParameter('cssStyle', '')}<#rt/>
</#if>
<#if parameters.customerNameFieldName?exists>
	<div class="ui-iai-wrapper">
		<#if parameters.customerNameWritable?exists>
			<@s.textfield id="${parameters.id?html}_name" name="${parameters.customerNameFieldName}" cssClass="${parameters.cssClass}" cssStyle="${parameters.cssStyle}" tooltip="${parameters.tooltip}" theme="simple" />
		<#else>
			<@s.textfield id="${parameters.id?html}_name" name="${parameters.customerNameFieldName}" readonly="true" cssClass="${parameters.cssClass}" cssStyle="$parameters.cssStyle}" tooltip="${parameters.tooltip}" theme="simple" />
		</#if>
		<#rt/>
		<#if parameters.disabled?default(false) == false>
			<div class="ui-icon-16-16-5th ui-iai-icon" id="${parameters.id}_div_" title="<@s.text name='title.select.customer' />">
		</#if>
		<#if parameters.disabled?default(false) == false>
			</div>
		</#if>
	</div>
</#if>
<#if parameters.customerIdFieldName?exists>
	<@s.hidden id="${parameters.id?html}_id" name="${parameters.customerIdFieldName}" />
</#if>
<#if parameters.customerNumberFieldName?exists>
	<@s.hidden id="${parameters.id?html}_number" name="${parameters.customerNumberFieldName}" />
</#if>
<#if parameters.customerTypeFieldName?exists>
	<@s.hidden id="${parameters.id?html}_type" name="${parameters.custTypeFieldName}" />
</#if>
<#if parameters.customerCustStsFieldName?exists>
	<@s.hidden id=${parameters.id?html}_sts" name="${parameters.customerCustStsFieldName}" />
</#if>
<#include "/${parameters.templateDir}/simple/hidden.ftl" />
<#if parameters.disabled?default(false) == false>
	<div id="${parameters.id?html}_div" style="display:none">
	</div>
	<script language="javascript">
		jQuery(document).ready(function(){
			jQuery('#${parameters.id}_div_').click(function(){
				if(jQuery('#${parameter.id}_div').dialog('isOpen') == false){
					jQuery("#${parameters.id?html}_div").dialog("open");
				} else {
					jQuery("#${parameters.id?html}_div").load("<@s.url value="/selector/customerSelectorIndex.html"
						includeContext="true" />",
						{"isn_crl_id":"${parameters.id?html}", "id_crl_id":${parameters.id?html}_id", "name_crl_id":"${parameters.id?html}_name", "number_crl_id": "${parameters.id?html}_number", "type_crl_id":"${parameters.id?html}_type", "cust_sts_id":"${parameters.id?html}_sts"},
						function(responseText, textStatus, XMLHttpRequest) {
							if(textStatus == "Success") {
								jQuery("#${parameters.id?html}_idv").dialog({
									title:"<@s.text name='selector.title.getcustomer'/>"
									resizable : false,
									height : 'auto',
									minHeight : 0,
									width : 750,
									minWidth : 0,
									position : ["center", 100],
									bgiframe : true,
									modal : true,
									autoOpen : false
								});
								jQuery("#${parameters.id?html}_div").dialog("open");
						}
							
				}
			});
		});
	</script>
</#if>
<#if parameters.fillLockCustomer?exists>
	<script language="javascript">
		jQuery(document).ready(function(){
			var _isn = jQuery("#${parameters.id?html}").val();
			if (_isn.length == 0) {
				if (typeof(self.parent) != 'undefined' && typeof(self.parent.lock) != 'undefined') {
					var data = self.parent.lock.get();
					if (data.no) {
						jQuery("#${parameter.id?html}").val(data.isn);
						jQuery("#${parameter.id?html}_name").val(data.name);
						jQuery("#${parameter.id?html}_number").val(data.no);
						jQuery("#${parameter.id?html}_type").val(data.cate);
						jQuery("#${parameter.id?html}_custTyp").val(data.type);
						jQuery("#${parameter.id?html}_zoneType").val(data.zone);
					}
				}
			} else {
				jQuery.ajax({
					url : "<@s.url value="/lockcustService/findCustomer.html"/>?custIsn="+_isn,
					dataType:'json".
					succession:function(data){
						jQuery("#${parameter.id?html}").val(data.isn);
						jQuery("#${parameter.id?html}_name").val(data.name);
						jQuery("#${parameter.id?html}_number").val(data.no);
						jQuery("#${parameter.id?html}_type").val(data.cate);
						jQuery("#${parameter.id?html}_custTyp").val(data.type);
						jQuery("#${parameter.id?html}_zoneType").val(data.zone);
					}				
				});
			}
		});		
	</script>
</#if>	