(function($) {
	var tooltipids = {};
	var genid = function(){
		var result = "tooltip-" + parseInt(Math.random() * Math.pow(10,14), 10);
		if (tooltipids[result]) {
			result = genid();
		} else {
			tooltipids[result] = result;
		}
		return result;
	}
	
	/**
	 * 创建一个Tooltip对象，参数如下:
	 * {
	 * 	content : "提示内容"
	 *  className : "样式类名称"
	 *  show : "是否显示, true | false"
	 * }
	 */
	var Tooltip = function(setting) {
		this.setting = {};
		$.extend(this.setting, {content: "content is empty."
			,className:"tooltip-view"
			,show:false
			,zIndex:20000
			,width:null
			,height:null
			,status:null //状态，可用的状态包括success,warning, info, error
			,position:{
				at:"top"
				,aligh:"center"
				,offset:4
			}}, setting);
		this.setting.position = $.extend({at:"top", align:"center", offset:4}, this.setting.position)
		if (this.setting.target && !(this.setting.target instanceof $)) {
			this.setting.target = $(this.setting.target);
		}
			
		//事件堆栈
		this.event_stack = {destory:[], show:[], hide:[], create:[]};
		this.create();
		
		if (this.setting.show) {
			this.show();
		}
	};
	
	var fn = Tooltip.prototype;
	
	fn.getview = function() {
		return this.$tooltip;
	}
	
	fn.show = function(callback) {
		if(callback){
			this.event_stack.show[this.event_stack.show.length] = callback;
			return;
		}
		
		this.resetPosition();
		this.$tooltip.show();
		
		for(var i=0; i < this.event_stack.show.length;i++){
			if(this.event_stack.show[i] && typeof(this.event_stack.show[i]) == 'function'){
				this.event_stack.show[i]();
			}
		}
	};
	
	fn.hide = function(callback){
		if(callback){
			this.event_stack.show[this.event_stack.show.length] = callback;
			return;
		}
		
		this.$tooltip.hide();
		
		for(var i=0;i<this.event_stack.show.length;i++){
			if(this.event_stack.show[i] && typeof(this.event_stack.show[i]) == 'function') {
				this.event_stack.show[i]();
			}
		}
	};
	
	fn.resetPosition = function() {
		var $target = this.setting.target;
		var $tooltip = this.$tooltip;
		
		var _height = $target.outerHeight();
		var _width = $target.outerWidth();
		
		var _theight = $tooltip.outerHeight(true);
		var _twidth = $tooltip.outerWidth(true);
		
		var offset = $target.offset();
		var position = this.setting.position;
		
		switch(position.at) {
			case "top" :
				offset.top -= (_theight + position.offset);
				break;
			case "bottom" :
				offset.top += _height+position.offset;
				break;
			case "left":
				offset.left -= _twidth+position.offset;
				break;
			case "right":
				offset.left += _width+position.offset;
				break;
		}
		
		switch(position.align){
		case "center":
			offset.left += (_width - _twidth)/2;
			break;
		case "right":
			offset.left += (_width - _twidth);
		case "middle":
			offset.top += (_height - _theight)/2;
			break;
		case "bottom":
			offset.top += (_height - _theight );
		}
		$tooltip.css({
			visibility : "visible",
			display:"none",
			left:offset.left,
			top:offset.top
		});
		
	}
	//创建
	fn.create = function(callback){
		if(callback){
			this.event_stack.show[this.event_stack.show.length] = callback;
			return;
		}
		var id = genid();
		var $tooltip = $("<div class='" + this.setting.className+"-"+(this.setting.status?this.setting.status:"normal") + "'>" + this.setting.content + "</div>");
		$tooltip.css({visibility:"hidden", top:0, left:0, zIndex:this.setting.zIndex})
			.appendTo($(document.body))
			.attr("id", id);
		//检查是否有指定高度和宽度
		if(this.setting.width) {
			$tooltip.css({width:this.setting.width});
		}
		
		if (this.setting.height) {
			$tooltip.css({height:this.setting.height});
		}
		
		var $target = this.setting.target;
		$target.attr("tooltip-id", id);
		
		var $this = this;
		this.$tooltip = $tooltip;
		
		$target.mouseover((this.mouseover = function(){
			$this.show();
		}));
		
		$target.mouseout((this.mouseout = function(){
			$this.hide();
		}));
		
		for(var i=0;i<this.event_stack.show.length;i++){
			if(this.event_stack.show[i] && typeof(this.event_stack.show[i]) == 'function'){
				this.event_stack.show[i]();
			}
		}
		
	};
	
	fn.destory = function(callback) {
		if(callback){
			this.event_stack.show[this.event_stack.show.length] = callback;
			return;
		}
		
		this.setting.target.removeAttr("tooltip");
		this.setting.target.removeAttr("tooltip-id");
		this.setting.target.unbind('mouseout', this.mouseout);
		this.setting.target.unbind('mouseover', this.mouseover);
		this.$tooltip.remove();
		
		for(var i=0;i < this.event_stack.show.length;i++) {
			if(this.event_stack.show[i] && typeof(this.event_stack.show[i]) == 'function') {
				this.event_stack.show[i]();
			}
		}
	};
	
	//解绑事件
	fn.unbind = function(evName, callback) {
		for(var i=0;i<this.event_stack[evName].length;i++){
			if(ths.event_stack[evName][i] == callback){
				delete this.event_stack[evName][i];
			}
		}
	}
	
	var tooltips = {};
	$.fn.tooltip = function(s){
		if(!this.length) return;
		
		var id = this.attr("tooltip-id");
		if(id && tooltips[id]) {
			$('#' + id).html(this.attr("tooltip"));
			return tooltips[id];
		}else{
			var setting = {content:this.attr("tooltip"), position:{at:"right", aligh:"left"}};
			$.extend(setting, {target:this}, s);
			setting.target = this;
			
			if (!setting.status) {
				var className = this.attr("class");
				if(className){
					var matchs = className.match(/(success|info|warning|error)/i);
					if (matchs && matchs[0]) {
						setting.status = matchs[0];
					}
				}
			}
			
			var result = new Tooltip(setting);
			tooltips[this.attr("tooltip-id")] = result;
		}
	}
	
	$(function(){
		$("[tooltip]").each(function(){
			var $this = $(this);
			var status = null;
			var className = $this.attr("class");
			if(className){
				var matchs = className.match(/(Success|info|warning|error)/i);
				if(matchs && matchs[0]) {
					status = matchs[0];
				}
			}
			
			var setting = {status : status};
			$this.tooltip(setting);
		});		
		
	});
})(jQuery);