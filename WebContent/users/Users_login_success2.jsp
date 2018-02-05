<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>企业增值税发票数据分析系统</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/login_success.css" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"><img src="../images/logo1.png" alt=""></div>
		<div id="title">财务及运营人员端</div>
		<div id="heading">
			<div id="heading_container">
				<div id="heading_text">企业增值税发票数据分析系统</div>
			</div>
		</div>
		<div id="user_info">
			<div id="welcome">欢迎${sessionScope.loginUid}使用本系统</div>
			<div id="logout"><a href="<%=path%>/users/Users_logout.action">安全退出</a></div>
		</div>
	</div>
	<div id="navigator">
		<iframe src="../tree2.jsp"></iframe>
        </div>
	<div id="main">
		<iframe name="MainFrame" src="Users_login_main.jsp"></iframe>
	</div>
	<div id="footer">Powered By 陈吉 赵珍</div>
</div>
</body>
<script type="text/javascript">
function screenAdapter(){
	document.getElementById('footer').style.top=document.documentElement.scrollTop+document.documentElement.clientHeight- document.getElementById('footer').offsetHeight+"px";
		document.getElementById('navigator').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.width=window.screen.width-230+"px";
}

window.onscroll=function(){screenAdapter();};
window.onresize=function(){screenAdapter();};
window.onload=function(){screenAdapter();};
</script>
</html>