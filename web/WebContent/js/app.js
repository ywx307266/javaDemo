
define(['jquery','i18n!nls/basicResource'],function($,basicResource){
	
	function create(){
		var arr=new Array();
		$("input[name='book']:checked").each(function(i,item){			
			arr.push($(item).val());
		});
		$("#mainContent").html(arr.join(' '));
	}
	
	function add(){		
		var $select=$("<select id='Birdtype'></select><br/><br/>");
		$("#main").prepend($select);
		
		$("#main").prepend($("<span>类别：</span>"));
	}
	
	function save(){
		
		var param={};
		param.hobby=$("input[name='hobby']:checked").next('Label').text();
		var arr=new Array();
		$("input[name='book']:checked").each(function(i,item){
			
			arr.push($(item).val());
		});
		param.books=arr.join(',');
		
		window.location.href='ShowInfo.jsp?'+$.param(param);
	}
	
	function getWeeksDesc(indexs){
		var weeks=basicResource.WEEKS;
		weeks=weeks.split(',');
		var params=indexs.split(',');
		var res="";
		for(var i=0;i<params.length;i++){
			res+=weeks[params[i]-1]+",";
		}
		
		return res.length>0?res.substring(0,res.length-1):'';
	}
	
	function showInfo(){
		alert(CKM.CommonInfo.title);
	}
	return {
		create:create,
		add:add,
		save:save,
		getWeeksDesc:getWeeksDesc,
		showInfo:showInfo
		};
});