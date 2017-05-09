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
		$.ajax({
			type : "POST",
			url : "/busi/ChapterManager.do",
			data : {
				rows : 20,
				page:1,
				sort:"id",
				order:"asc"
			},
			dataType : "json",
			success : function(data) {
				var str = "";
				for(var i=0;i<data.rows.length;i++){
					str += "<option value=\""+data.rows[i].id+"\">" + data.rows[i].name + "</option>";
				}
				$("#chapter").append(str);
			}
		});
	});
</script>
</head>
<body>
	<form class="formobj" method="post" action="/busi/SectionManagerUpd.do">
		<table class="vtb">
			<tr>
				<th><span class="t_t">*</span>所属章:</th>
				<td><select id="chapter" name="chid" datatype="*"><option value="">请选择章</option>
				</select><span class="Validform_checktip"></span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>小节名称:</th>
				<td><input type="text" name="name" datatype=s2-20
					errormsg="请输入正确的章节名称" nullmsg="请填写信息！"><span
					class="Validform_checktip">本章名称</span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>小节类型</th>
				<td>
					<select name="type">
						<option value="1">视频</option>
						<option value="2">练习</option>
						<option value="3">形式考试</option>
						<option value="4">项目考试</option>
					</select>
					<span class="Validform_checktip">小节类型</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>序号</th>
				<td><input type="text" name="serno" datatype=n1-2 errormsg="请输入正确的数字序号" nullmsg="请填写信息！">
					<span class="Validform_checktip">本小节在章中的顺序号码，非常重要！！</span>
				</td>
			</tr>
		</table>
		<span class="thidden">
			<input type="button" id="btn_sub">
		</span>
	</form>
</body>
</html>