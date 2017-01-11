/**
 * 
 */
jQuery(document).ready(function(){
	$(".ui-waitting").fadeOut("fast", function(){
		$(".page-content").fadeIn();
	});

	//提示信息关闭
	$(document).on("mouseover", ".callout", function(){
		$(this).stop(true);
		$(this).show();
	});
	$(document).on("mouseout", ".callout", function(){
		$(this).slideUp(function(){
			$(this).off("mouseover mouseout");
		})
	});
});