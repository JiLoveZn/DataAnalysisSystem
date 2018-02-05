<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/login_main.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#heading{
	font-size:18px;
	font-family:微软雅黑;
	font-weight:bold;
	text-align:center;
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
    
<body>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;销项发票数据统计与分析<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/entrydata/SalesData_statistics.action">销项发票数据统计</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="heading">
		销项发票数据分析
	</div>
</div>
<div id="mainContainer">
<!-- 从session中获取数据集合 -->

<table class="default" width="100%">
	<col width="50%">
	<col width="50%">
	<tr class="title">
		<td>月份</td>
		<td>增长率（%）</td>
	</tr>
	
	<tr >
		<td>2</td>
		<td>0.089</td>
	</tr>	
		<td>3</td>
		<td>0.041</td>
	</tr>	
		<td>4</td>
		<td>0.235</td>
	</tr>	
		<td>5</td>
		<td>0.016</td>
	</tr>	
		<td>6</td>
		<td>-0.188</td>
	</tr>	
		<td>7</td>
		<td>0.077</td>
	</tr>	
		<td>8</td>
		<td>0.161</td>
	</tr>	
		<td>9</td>
		<td>-0.2</td>
	</tr>	
		<td>10</td>
		<td>0.385</td>
	</tr>	
		<td>11</td>
		<td>-0.083</td>
	</tr>	
		<td>12</td>
		<td>0.121</td>
	</tr>
</table>
</div>
</body>
</html>