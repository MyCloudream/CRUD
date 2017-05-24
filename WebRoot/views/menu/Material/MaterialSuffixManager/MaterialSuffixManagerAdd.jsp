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
			url : "/busi/MaterialTypeManager.do",
			data : {
				rows : 20, // 查询全部素材类型
				page : 1,
				sort : "id",
				order : "asc"
			},
			dataType : "json",
			success : function(data) {
				var str = "";
				for (var i = 0; i < data.rows.length; i++) {
					str += "<option value=\""+data.rows[i].id+"\">"
							+ data.rows[i].name + "</option>";
				}
				$("#type").append(str);
			}
		});
	});
</script>
</head>
<body>
	<form class="formobj" method="post" action="/busi/MaterialSuffixManagerAdd.do">
		<table class="vtb">
			<tr>
				<th>
					<span class="t_t">*</span>
					所属素材类型:
				</th>
				<td>
					<select id="type" name="tid" datatype="*">
						<option value="">请选择素材类型</option>
					</select>
					<span class="Validform_checktip"></span>
				</td>
			</tr>
			<tr>
				<th>
					<span class="t_t">*</span>
					名称:
				</th>
				<td>
					<input type="text" name="name" datatype="*2-10" errormsg="请输入正确的名称" nullmsg="请填写信息！">
					<span class="Validform_checktip">类型名称，如音频</span>
				</td>
			</tr>
			<tr>
				<th>
					<span class="t_t">*</span>
					编码:
				</th>
				<td>
					<input type="text" name="no" datatype="*1-1" errormsg="请输入正确的类型编码" nullmsg="请填写信息！">
					<span class="Validform_checktip">类型编码，如A</span>
				</td>
			</tr>
		</table>
		<span class="thidden">
			<input type="button" id="btn_sub">
		</span>
	</form>
</body>
</html>