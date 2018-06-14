<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     
  </head>
  
  <body>
  
  <form action="testconsever" method="POST">
           <input type="text" name="employee" > 
           <input type="submit" value="submit">
  </form>
  
  
  
       
     <form:form action="${pageContext.request.contextPath }/empss" method="POST" 
		modelAttribute="employee">
	<c:if test="${employee.id == null }">
                LastName: <form:input path="lastName"/>
         </c:if>  

		<c:if test="${employee.id != null }">
	             <form:hidden path="id"/>
                <input type="hidden" name="_method" value="PUT">
         </c:if>          
         
		<br>
		Email: <form:input path="email"/>
		<br>
		<% 
			Map<String, String> genders = new HashMap();
			genders.put("1", "Male");
			genders.put("0", "Female");			
			request.setAttribute("genders", genders);
		%>
                Gender:<form:radiobuttons path="gender" items="${genders}"/>
                 </br>
               Department: <form:select path="department.id" 	items="${deparment }" itemLabel="departmentName" itemValue="id"></form:select>
                 </br>
                Birth:<form:input path="birth"/>
                 </br> 
                 Slary:<form:input path="salary"/>
                 </br> 
                 <input type="submit" value="Submit"/>
         </form:form>
    
    

  </body>
</html>
