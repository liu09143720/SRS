<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignIn</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" >
<link rel="stylesheet" type="text/css" href="css/style.css" >

</head>

<body>

<%  
    String name="";  
    String psw="";  
    String checked="";  
    Cookie[] cookies=request.getCookies();  
    if(cookies!=null&&cookies.length>0){   
        for(int i=0;i<cookies.length;i++){  
            Cookie cookie=cookies[i];  
             
            if("name".equals(cookie.getName())){  
                name=cookie.getValue();  
                //将"记住我"设置为勾选   
                checked="checked";  
            }  
            if("psw".equals(cookie.getName())){  
                psw=cookie.getValue();  
            }  
        }  
    }  
 %>

 <div id="top-line"></div>

<!-- START WRAPPER SECTION -->
<div id="wrapper">

	<div id="separator">
		<div class="center-block">
			<h3>您好</h3>
			<span>: 请登录</span>
		</div>
	</div>

	<!-- START CONTENT -->
	<div class="center-block-page clearfix">
	  	<form action="SignIn" method="post" >
	  	<table width="100%">
	  		<tr><td align="center" > 编号：<input type="text" name="userName" value=<%=name %>></td></tr>
	  		<tr><td align="center" > 密码：<input type="password" name="userPassword" value=<%=psw %>></td></tr>
	  		<tr><td align="center" > 
	  				记住我：<input type="checkbox" name="auto" value="auto" checked="<%=checked %>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  				学生：<input type="radio" name="kind" value="Student" checked="<%=checked %>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  				教师：<input type="radio" name="kind" value="Professor" >
	  			</td>
	  		</tr>
	  		<tr><td>&nbsp;</td></tr>
	  		<tr><td align="center" ><input class="submit" type="submit" value="登录" ></td></tr>
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
</html>