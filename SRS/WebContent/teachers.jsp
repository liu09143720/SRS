<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >
<link rel="stylesheet" type="text/css" href="css/superfish.css" >

<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
</head>

<body>

 <div id="top-line"></div>
 
 
 <div id="menu-bar">
	<div class="center-block clearfix">
	  
    	
		<div id="menu" class="fix-fish-menu">
			<div class="white-fix-left"></div>
			<ul id="nav" class="sf-menu">

			 		<li > <a href="index.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;&nbsp;</a>

			    </li>
		 		<li class=""> <a href="enrollCourse.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

				    </li>
			 	<li class=""> <a href="SearchTranscript">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成绩查询&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

				</li>
		 		<li class=""> <a href="SearchCourses">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所有课程&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

			    </li>
                <li class=""><a href="SearchTeachers" class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所有教师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
               		 
	            </li>

	            <li class=""><a href="StudentofSection">&nbsp;&nbsp;&nbsp;已选学生&nbsp;&nbsp;&nbsp;</a>
	   				
	            </li>
	            
	            <li class=""><a href="SignOut">&nbsp;&nbsp;&nbsp;退出&nbsp;&nbsp;&nbsp;</a>
	   				
	            </li>

		 	</ul>  
	 	</div>	
	</div>
</div>
<!-- END MENU SECTION -->
 

<!-- START WRAPPER SECTION -->
<div id="wrapper">

	<div id="separator">
		<div class="center-block">
			<h3>${sessionScope.userName }</h3>
			<span>: ${sessionScope.ssn }</span>
		</div>
	</div>

	<!-- START CONTENT -->
	<div class="center-block-page clearfix">
	<p><font size="3" color="brown"><strong>添加教师</strong></font></p><br><br>
	 <form action="AddTeacher">
		<table>
			
			<tr >
		   				<td >教师编号：<input type="text" name="addNo" ></td>
		   				 <td >教师名称：<input type="text" name="addName" ></td> 
		   				<td >教师部门：<input type="text" name="addDepartment" ></td>
		   		</tr>
		   		
		</table>
		
		<p align="center"><input class="submit" type="submit" value="招聘" ></p>
		</form>
		<br><br>
		<p><font size="3" color="brown"><strong>修改教师</strong></font></p><br><br>
		<form action="UpdateTeachers">
	  	<table>
	  		
	  		<tr>
	  					<td>修改&nbsp;&nbsp;</td>
		   				<td >教师编号</td>
		   				 <td >教师名称</td> 
		   				<td >教师部门</td>
		   				
		   		</tr>
	  		<c:forEach var="oneResult" items="${requestScope.result }">
		   			
		   			<tr >
		   				<td><input type="radio" name="change" value='${oneResult.ssn}'>&nbsp;&nbsp;</td>
		   				<td ><input type="text" name="changeNo" value='${oneResult.ssn}' readonly="readonly"></td>
		   				 <td ><input type="text" name="changeName" value='${oneResult.name}'></td> 
		   				<td ><input type="text" name="changeDepartment" value='${oneResult.department}'></td>
		   			</tr>
		   		</c:forEach>
		   </table>
		   
		   <p align="center"><input class="submit" type="submit" value="修改" ></p>
		   </form>
		   <br><br>
		   <p><font size="3" color="brown"><strong>删除教师</strong></font></p><br><br>
		   <form action="DeleteTeachers">
		   <table align="center">
	  		
	  		<tr>
	  					<td>删除&nbsp;&nbsp;</td>
		   				<td >教师编号&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   				 <td >教师名称&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		   				<td >教师部门</td>
		   				
		   		</tr>
	  		<c:forEach var="oneResult" items="${requestScope.result }">
		   			
		   			<tr >
		   				<td><input type="checkbox" name="delete" value='${oneResult.ssn}'>&nbsp;&nbsp;</td>
		   				<td >${oneResult.ssn}&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   				 <td >${oneResult.name}&nbsp;&nbsp;&nbsp;&nbsp;</td> 
		   				<td >${oneResult.department}&nbsp;&nbsp;&nbsp;&nbsp;</td>
		   			</tr>
		   		</c:forEach>
		   </table>
		   
		   <p align="center"><input class="submit" type="submit" value="解雇" ></p>
		   </form>
		   
	</div>
	
</div><!--   width="120px"  #wrapper -->

<!-- END WRAPPER -->	    

<!-- START FOOTER -->
<div class="divider-100-2px"></div>

<!-- START FOOTER MENU  -->
<div id="footer-menu">
	<div class="center-block clearfix">
		<div class="copyright">&copy; Copyright &copy; Electronic Commerce 2013-2.</div>
	</div><!-- .center-block -->
</div><!-- #footer-menu -->
<!-- END FOOTER MENU  -->

</body>

</html>