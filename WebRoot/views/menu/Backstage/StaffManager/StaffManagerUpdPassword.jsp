<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../formBase.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.vtb {
	width: 100%;
}

.vtb tr td {
	width: 80%;
}

.vtb tr th {
	width: 20%;
}
</style>
<script type="text/javascript">
	$(function() {
		valform("id", formdata[0].id, "");
	});
</script>
</head>
<body>
	<form class="formobj" method="post" action="<%=path%>/busi/StaffManagerUpdPassword.do">
		<table class="vtb">
			<tr>
				<th><span class="t_t">*</span>请输入新密码:</th>
				<td><input type="password" name="password" plugin="passwordStrength" datatype="*6-28" errormsg="密码至少6个字符,最多28个符！" /> <span class="passwordStrength"> <span>弱</span><span>中</span><span class="last">强</span>
				</span><span class="Validform_checktip">密码长度在6-28位字符</span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>确认密码:</th>
				<td><input type="password" name="repassword" recheck="password" datatype="*6-28" errormsg="两次输入的密码不一致！" /><span class="Validform_checktip"> 重复密码</span></td>
			</tr>
		</table>
		<span class="thidden"><input type="hidden" name="id" type="text"><input type="button" id="btn_sub"></span>
	</form>
</body>
</html>