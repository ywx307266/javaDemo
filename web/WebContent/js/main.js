/**
 * 主函数入口
 */
require.config({	
	paths:{
		 jquery: 'pulign/jquery'
	},
	waitSeconds:30,
	config: {
        i18n: {
            locale: 'en-us'
        }
    }
});
require(['jquery','app','global','i18n!nls/basicResource'],
	function($,app,global,basicResource){
	window.CKM=global;
	$("#btnSaveRaft").on("click",			
			function(){				
				$.ajax({
					url: "ShowInfo.jsp",
					type: "post",
					dataType:"text",
					data: {name:"闫永超",id:"123"},
					success:function(data){
						alert(data);
					}
				});
			}
	);
	
	$("#btnSaveStudentInfo").on("click",			
		function(){				
			$.ajax({
				type:"POST",
				url:"rest/sg/saveData",
				contentType:"application/json",
				dataType:"text",
				cache:false,
				data:JSON.stringify({id:"111",name:"王宁宁",address:"日本东京",login:new Date()}),
				success:function(result){
					alert(result);
				}
			
			});
		}
	);	
	
	$("#btnShowCatage").on("click",			
			function(){				
				app.add();
			}
	);	
	
	$("#btnBookReverse").click(function(){
		$("input[name='book']").each(function(){			
			$(this).attr("checked",this.checked?false:true);			
		});		
	});
	$("#main").css({color:"red",fontSize:"20px"});
	$("#title").html(basicResource.WEB_TITLE_NAME).css({"backgroundColor":"yellow"});
	$("#title").attr("align","center");
	$("#title").click(function(){		
		$(this).animate({
		    width: "80%",
		    opacity: 0.8,
		    fontSize: "3em",
		    border: "10px",
		    borderRadius:"10px"
		  }, 1500 );
		$("#title").css({"margin":"0 auto"});
	});
});