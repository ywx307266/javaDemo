
define(function(){
	//定义全局变量
	var CKM={};
	
		CKM.CommonInfo={
			title:"中国必将屹立于世界民族之林,华夏儿女怒吼吧!",
			isOpen:false
		};
		CKM.FuncUtil={
			showTipInfo: function(message){
				alert(message);
			},
			getCurrentDatetime:function(fmt){				
				var date=new Date();
				var o = {   
						 "M+" : date.getMonth()+1,                 //月份   
						 "d+" : date.getDate(),                    //日   
						 "h+" : date.getHours(),                   //小时   
						 "m+" : date.getMinutes(),                 //分   
						 "s+" : date.getSeconds(),                 //秒   
						 "q+" : Math.floor((date.getMonth()+3)/3), //季度   
						 "S"  : date.getMilliseconds()             //毫秒   
						};   
				if(/(y+)/.test(fmt))   
				 fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
				for(var k in o)   
				 if(new RegExp("("+ k +")").test(fmt))   
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
				return fmt; 
			}
		}
	return CKM;
});