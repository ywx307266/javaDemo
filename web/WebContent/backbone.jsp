<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>练习backbone</title>
<script type="text/javascript" language="javascript" src="js/pulign/jquery.js"></script>
<script type="text/javascript" language="javascript" src="js/pulign/underscore.js"></script>
<script type="text/javascript" language="javascript" src="js/pulign/backbone.js"></script>

</head>
<body>
<div id="msg">测试区域</div>
</body>

<script type="text/javascript" language="javascript">

	var Sidebar = Backbone.Model.extend({
		  promptColor: function() {
		    var name_ = prompt("Please enter your name:");
		    this.set({name: name_,age:23});
		  }
	});
	_.templateSettings = {interpolate: /\{(.+?)\}/g	};
	var DocumentRow = Backbone.View.extend({
		  template: _.template("{name} 欢迎你！你的考试分数:<s>{age}</s>"),
		  initialize: function() {
		    this.listenTo(this.model, "change", this.render);
		  },
		  
		  render: function() {
			  $("#"+this.id).html(this.template(this.model.attributes));
			 
			  return this;
		  }

	 });
	
	
	var sidebar = new Sidebar();
	
	var view_div=new DocumentRow({model:sidebar,id: "msg"});
	
	sidebar.promptColor();
</script>
</html>
