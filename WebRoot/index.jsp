<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	
	<script type="text/javascript" src="/SSHFrameWork/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function() {

			$("#asubmit").click(function() {
		    	//提交的参数，name和inch是和struts action中对应的接收变量
		        var params = {
		           name : $("#loginName").val(),
		           inch : $("#password").val()
		        };
		        alert("此功能还没有实现哦");
		        return false;
		        $.ajax({
				    type: "POST",
				    url: "jsonAjax.action",
				    data: params,
				    dataType:"text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
				    success: function(json){  
					    var obj = $.parseJSON(json);  //使用这个方法解析json
					    var state_value = obj.result;  //result是和action中定义的result变量的get方法对应的
					    alert(state_value);
						window.document.location.href('/jsp/welcome.jsp');
				    },
				    error: function(json){
				    	alert("json=" + json);
				     	return false;
				    }
				});
		    });
		
		});
	</script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table.tableCss {
			font-size: 13px;
		}
		
		.tableMini{
			font-size: 12px;
		}
	</style>

  </head>
  
  <body>
    This is my JSP page. <br>
    <form name="form" method="post" action="login_login.action">
		  <table align="center" width="60%" class="tableCss">
			  <tr><td>用户名：</td><td><input type="text" id="loginName" name="user.loginName"></td></tr>
			  <tr><td>密 码：</td><td><input type="password" id="password" name="user.passWord"></td></tr>
			  <tr>
			  <td align="center">
				  <table>
					  <tr>
					  	<td><input type="submit" value="submit提交"></td>
					  	<td><input type="button" id="asubmit" value="ajax提交"></td>
					  </tr>
				  </table>
			  </td>
			  </tr>
		  </table>
	  </form>
  </body>
</html>
