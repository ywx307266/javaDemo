<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试文件上传路径处理</title>
<script type="text/javascript" src="js/pulign/jquery.js"></script>
<script type="text/javascript" language="javascript">
	$(function(){
		$("#btnSave").bind("click",function(){
			var filePath=$("#fileUploadInput").val();
			var txt=['<p>',filePath.substr(filePath.lastIndexOf('\\')+1),'</p>'].join("");
			alert(location.search.substring(1));
			
		});
	});
</script>
</head>
<body>
<div style="nnnnn">
<div style=" width:80%;margin: 0 auto; border: 1px solid #ccc;border-radius: 10px; ">
<p><input type="file" id="fileUploadInput" /></p>
<p><input id="btnSave" type="button" value="截取文件名"/></p>
</div>
</div>
<%
	Cookie cookie=new Cookie("userid","ywx307266");
	response.addCookie(cookie);
%>
</body>
</html>