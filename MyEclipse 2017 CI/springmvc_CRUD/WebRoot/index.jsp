<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#testjson").click(function(){
			var url = this.href;
			var args = {};
			$.post(url,args,function(data){
			    alert(data);
			    alert(typeof(data));
			    for(var i=0;i<data.length;i++){
			        var id = data[i].id;
			        var LastName = data[i].lastName
			        alert(id+":"+LastName);
			    }
			})

			return false;
		});
	})
</script>
  </head>
  
  <body>
   
     </br></be>
     
     <a href = "emp">show emplyee with list</a>
     </br></br>
     <a href = "testjson" id ="testjson">test json</a>
     </br></br>
     <form action="testhttpmessageconver">
           文件：<input type="file" name="file">
           名字：<input type="text" name="name">
           <input type="submit" value="sumit">
     </form>


</br></br>
    
    <a href="i18n"> i18n</a>
    
    </br></br>
    <a href="testexceptionHandler?i=10"> test exceptionHandler</a>
  </body>
</html>
