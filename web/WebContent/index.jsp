<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">

.generalClass{
 
 border: 1px dashed blue;
 margin: 10px 0px 10px 0px;
 border-radius:5px;
}
a{
display:inline-block;
margin:2px 0px 2px 0px;
width:70px;
height:20px;
border-radius:2px;
background-color:#0ae;
border-color: #0ae;
text-align: center;
color:white;
}
</style>
<script data-main="js/main" src="js/require.js"></script>
</head>
<body>
<div id="title"></div>
<a>转出</a>
<div id="main" class="generalClass">
爱好:
<input id="A1" type="radio" name="hobby" value="1"/><label for="A1">音乐</label>
<input id="A2" type="radio" name="hobby" value="2"/><label for="A2">体操</label>
<input id="A3" type="radio" name="hobby" value="3"/><label for="A3">跑步</label>
<br/><br/>
喜欢的书籍:
<input type="checkbox" name="book" value="水浒传"/>水浒传
<input type="checkbox" name="book" value="三国演义"/>三国演义
<input type="checkbox" name="book" value="红楼梦"/>红楼梦
<br/><br/>

<br/><br/>
说明:
<input type="text" value=""/>
<input id="btnSaveRaft" type="button" value="保 存 草稿 " />
<input id="btnShowCatage" type="button" value="显示类别" />
<input id="btnSave" type="button" value="保存数据"/>
<input id="btnBookReverse" type="button" value="反选书籍状态"/>
<div id="mainContent"></div>
</div>
<a href="json.jsp" target="_blank">go</a>
<input id="btnSaveStudentInfo" type="button" value="保 存 学生信息 " />
</body>
</html>
