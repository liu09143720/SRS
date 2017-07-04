<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出错了</title>
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
                <li class=""><a href="SearchTeachers">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所有教师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
               		 
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
	<p align="center"><font size="3" color="brown"><strong>${requestScope.falseResult }</strong></font></p><br>
	  	<table>
	  		<c:forEach var="oneResult" items="${requestScope.result }">
		   			
		   			<tr >
		   				 <td >${oneResult.value}</td> 
		   				
		   			</tr>
		   		</c:forEach>
		   </table>
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