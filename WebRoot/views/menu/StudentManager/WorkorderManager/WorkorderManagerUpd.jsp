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
		valform("title", formdata[0].title, "");
		valform("atime", getLocalTime(formdata[0].atime), "");
		valform("content", formdata[0].content, "textarea");
		valform("answer", formdata[0].answer, "textarea");
	});

	function getLocalTime(x) {
		var now = new Date(x);
		var year = now.getYear() + 1900;
		var month = now.getMonth() + 1;
		var date = now.getDate();
		var hour = now.getHours();
		var minute = now.getMinutes();
		var second = now.getSeconds();
		return year + "-" + month + "-" + date + " " + hour + ":" + minute
				+ ":" + second;
	}
</script>
</head>
<body>
	<form class="formobj" method="post" action="/busi/WorkorderManagerUpd.do">
		<table class="vtb">
			<tr>
				<th>
					<span class="t_t">*</span>
					标题:
				</th>
				<td>
					<input type="text" name="title" readonly="readonly" style="width: 90%;">
				</td>
			</tr>
			<tr>
				<th>
					<span class="t_t">*</span>
					提问时间
				</th>
				<td>
					<input type="text" name="atime" readonly="readonly" style="width: 90%;">
				</td>
			</tr>
			<tr>
				<th>
					<span class="t_t">*</span>
					学生提问问题:
				</th>
				<td>
					<textarea name="content" readonly="readonly" cols="100" rows="15" style="width: 90%;"></textarea>
				</td>
			</tr>
			<tr>
				<th>
					<span class="t_t">*</span>
					回答:
				</th>
				<td>
					<textarea name="answer" cols="100" rows="15" style="width: 90%;"></textarea>
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