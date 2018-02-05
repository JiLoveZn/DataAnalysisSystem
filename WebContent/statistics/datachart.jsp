<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 这是一个html5 doctype声明 -->
<!DOCTYPE html>
<html>

 <!-- <body>  
    <img alt="JfreeChartAction" src="/jfreechart/JfreeChartAction.action"/>  
</body>  -->  

<body>  
   <img alt="" src="EntryDataChartAction" id="chart" style="cursor: pointer;">
   <img alt="" src="SalesDataChartAction" id="chart" style="cursor: pointer;">  
     
    <script>  
  $("#chart").click(function(){  
//alert("ddd");  
$(this).attr("src","testChartAction?time="+new Date());     
  });  
  </script>
 </body>  


</html>