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
		valform("nick", formdata[0].nick, "");
		valform("passwd", formdata[0].passwd, "");
		valform("mobile", formdata[0].mobile, "");
		valform("qq", formdata[0].qq, "");
		valform("roleid", formdata[0].roleid, "select");
		valform("status", formdata[0].status, "radio");
	});
</script>
</head>
<body>
	<form class="formobj" method="post" action="/busi/RegistrarManagerUpd.do">
		<table class="vtb">
			<tr>
				<th><span class="t_t">*</span>姓名:</th>
				<td>
					<input type="text" name="nick" datatype=*2-5	errormsg="请输入正确的姓名" nullmsg="请填写信息！" style="width:70%;">
					<span class="Validform_checktip">教务老师姓名或昵称</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>密码:</th>
				<td>
					<input type="password" name="passwd" datatype=*6-16	errormsg="请输入正确的密码" nullmsg="请填写信息！" style="width:70%;">
					<span class="Validform_checktip">6-16位密码</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>手机号码:</th>
				<td>
					<input type="text" name="mobile" datatype=m	errormsg="请输入正确的手机号码" nullmsg="请填写信息！" style="width:70%;">
					<span class="Validform_checktip">11位手机密码</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>QQ:</th>
				<td>
					<input type="text" name="qq" datatype=n8-13 errormsg="请输入正确的QQ号码" nullmsg="请填写信息！" style="width:70%;">
					<span class="Validform_checktip">QQ号码</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>用户类型:</th>
				<td>
					<select name="roleid">
						<option value="1">管理员</option>
						<option value="2">教务人员</option>
					</select>
					<span class="Validform_checktip">类型</span></td>
			</tr>
			<tr>
				<th>是否可用:</th>
				<td>
					<input type="radio" name="status" value="Y"	checked="checked">可用
					<input type="radio" name="status" value="N">禁用
				</td>
			</tr>
		</table>
		<span class="thidden">
			<input type="hidden" name="id" type="text">
			<input type="button" id="btn_sub">
		</span>
	</form>
</body>
</html>