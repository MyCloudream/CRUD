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
		valform("name", formdata[0].name, "");
		valform("serno", formdata[0].serno, "");
		valform("cdesc", formdata[0].cdesc, "textarea");
	});
</script>
</head>
<body>
	<form class="formobj" method="post" action="/busi/ChapterManagerUpd.do">
		<table class="vtb">
			<tr>
				<th><span class="t_t">*</span>本章名称:</th>
				<td><input type="text" name="name" datatype=s2-20
					errormsg="请输入正确的章节名称" nullmsg="请填写信息！"><span
					class="Validform_checktip">本章名称</span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>本章简介:</th>
				<td><textarea name="cdesc" cols="70" rows="15" datatype=*2-500 errormsg="请输入正确的章节名称" nullmsg="请填写信息！"></textarea>
				<br/><span class="Validform_checktip">本章简介，500字以内</span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>序号</th>
				<td><input type="text" name="serno" datatype=n1-2 errormsg="请输入正确的数字序号" nullmsg="请填写信息！">
					<span class="Validform_checktip">本章的序号，非常重要！！第一章请填写1，第二章请填写2，以此类推。</span>
				</td>
			</tr>
		</table>
		<span class="thidden">
			<input type="button" id="btn_sub">
			<input type="hidden" name="id" type="text">
		</span>
	</form>
</body>
</html>