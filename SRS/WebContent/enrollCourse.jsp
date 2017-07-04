<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课</title>
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
		 		<li class=""> <a href="enrollCourse.jsp" class="active">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

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
	
	<p align="center"><font size="3" color="brown"><strong>学期选课</strong></font></p><br><br>
	
	<form action="enrollCourseServlet">
		<p align="center"><input class="submit" type="submit" value="保存" ></p><br><br>
	
		
	  	<table id="01" width="45%" align="left">
		<tr>
			<td width="20px">&nbsp;</td>
			
			<td width="200px">可选课程</td>
		</tr>
	</table>
	  	
	  	<table id="02" width="45%" align="right">
		<tr>
			<td width="20px">&nbsp;</td>
			
			<td width="200px">已选课程(选中可退选)</td>
		</tr>
	</table>
	  
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

<script type="text/javascript">
   
	$(document).ready(
			$.getJSON("scheduleOfClassServlet",function(jsonData){
	 			var html = "";
	 			var html2 = "";
	 			for(var i=0;i<jsonData.length;i++){
	 				//alert(jsonData[i].id+","+jsonData[i].studentId+","+jsonData[i].studentName+","+jsonData[i].age);
	 			//}    $("table tr:gt(0)").remove();
	 			  if(jsonData[i].sid!=null){
	 				html += "<tr><td><input type='checkbox' name='select' value="+jsonData[i].sid+"></td>";
	 				html += "<td>" +jsonData[i].option+ "</td></tr>";
	 			  }else{
	 				html2 += "<tr><td><input type='checkbox' name='drop' value="+jsonData[i].tid+"></td>";
	 				html2 += "<td>" +jsonData[i].enrolled+ "</td></tr>";
	 			}}
	 			$("#01").append(html);
	 			$("#02").append(html2);
	 		})
	) ;
   
    
    
</script>

</html>