<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="<%=path%>/plug-in/easyui/themes/bootstrap/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="<%=path%>/plug-in/easyui/themes/icon.css" type="text/css">
<script type="text/javascript" src="<%=path%>/plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/plug-in/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
/*    var ff; */
	$(function() {
/* 		ff = $("#ff").form(); */
		$("#ff #mobile").val("");
		$("#ff #passwd").val("");
		$('#submit').bind('click', function() {
			var mobile = $("#ff #mobile").val();
			var passwd = $("#ff #passwd").val();
			var code = $("#ff #code").val();
			if (code == "" || code == null) {
				$("#error_msg").html("验证码不能为空");
				return;
			}
			if (mobile == "" || mobile == null) {
				$("#error_msg").html("账户不能为空");
				return;
			}
			if (passwd == "" || passwd == null) {
				$("#error_msg").html("密码不能为空");
				return;
			}
			$.ajax({
				url : '<%=path%>/common/login.do',
				type : "POST",
				dataType : "json",
				data : {
					method : 'alogin',
					mobile : mobile,
					passwd : passwd,
					code : code
				},
				success : function(data) {
					if (data.success == true) {
						window.location = "home.jsp";
					} else {
						if (data != "") {
							$("#error_msg").html(data.msg);
						} else {
							$("#error_msg").html("出现严重错误");
						}
						flushImage();
					}
				}
			});
		});
		$('#reset').bind('click', function() {
			$('#ff')[0].reset();
		});
	});
	function flushImage() {
		$("#imagecodeid").attr("src", "<%=path%>/common/imagecode.do?timestamp=" + new Date().getTime());
	}
</script>
<style type="text/css">
form {
	padding: 0px;
}

body {
	margin: 0px;
	padding: 0px;
}

img {
	vertical-align: middle;
}

#code {
	width: 60px;
	height: 30px;
}

#mobile {
	height: 30px;
	width: 160px;
}

#passwd {
	height: 30px;
	width: 160px;
}

#ff {
	text-align: center;
	margin-top: 60px;
}
</style>
</head>
<body style="background: url('<%=path%>/images/login/body.jpg');">
	<div class="easyui-window easyui-layout" title="用户登录" style="width:600px;height:400px" data-options="iconCls:'icon-man',modal:true,minimizable:false,closable:false,maximizable:false,collapsible:false,draggable:false,shadow:false">
		<div data-options="region:'north',split:true" style="height:100px;background:#eee;">
			<img alt="" src="<%=path%>/images/home/logo.png" height="100" width="100" style="margin-left:10px ">
			<span style="font-size:40">幽梦平台后台管理系统</span>
		</div>
		<div data-options="region:'center'" style="background:#eee;">
			<form id="ff" method="post">
				<center>
					<table>
						<tr>
							<th>用户名:</th>
							<td><input type="text" name="mobile" id="mobile"></td>
						</tr>
						<tr>
							<th>密码:</th>
							<td><input type="password" name="passwd" id="passwd"></td>
						</tr>
						<tr>
							<th>验证码:</th>
							<td><input type="text" name="code" id="code">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img alt="" src="<%=path%>/common/imagecode.do" id="imagecodeid" onclick="flushImage()" style="width: 60px;height: 30px;"></td>
						</tr>
						<tr align="center">
							<td colspan="2"><a id="submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确 认</a>&nbsp;&nbsp;<a id="reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重 置</a></td>
						</tr>
						<tr align="center">
							<td colspan="2"><font color="red" id="error_msg"></font></td>
						</tr>
					</table>
				</center>
			</form>
		</div>
	</div>
</body>
</html>
