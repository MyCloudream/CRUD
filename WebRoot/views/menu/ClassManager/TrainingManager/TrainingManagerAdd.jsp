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
	
	// 下拉列表选中事件  二级联动
	function chapterChange(osel){
		$("#section").empty();// 先清空，防止堆积
		var chid = osel.options[osel.selectedIndex].value;
		$.ajax({
			type : "POST",
			url : "/busi/SectionManager.do",
			data : {
				rows : 200,  // 获取所有小节
				page:1,
				sort:"id",
				order:"asc",
				chid:chid,
				type:1  // 表示查找所有的视频小节
			},
			dataType : "json",
			success : function(data) {
				var str = "";
				for(var i=0;i<data.rows.length;i++){
					str += "<option value=\""+data.rows[i].id+"\">" + data.rows[i].name + "</option>";
				}
				$("#section").append(str);
			}
		});
	}
</script>
</head>
<body>
	<form class="formobj" method="post" action="/busi/TrainingManagerAdd.do">
		<table class="vtb">
			<tr>
				<th><span class="t_t">*</span>所属章:</th>
				<td><select id="chapter" name="chid" datatype="*"  onchange="chapterChange(this)"><option value="">请选择章</option>
				</select><span class="Validform_checktip"></span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>所属节:</th>
				<td><select id="section" name="seid" datatype="*"><option value="">请选择小节</option>
				</select><span class="Validform_checktip"></span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>试题类型:</th>
				<td><select name="type">
						<option value="1">单选题</option>
						<option value="2">多选题</option>
						<option value="3">判断题</option>
				</select> <span class="Validform_checktip">选择需要的题目类型（单选、多选或判断）</span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>题干:</th>
				<td>
					<textarea name="question" cols="100" rows="10" datatype=*2-500 errormsg="请输入题干信息" nullmsg="请填写信息！"></textarea>
					<span class="Validform_checktip">题干</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>选项A:</th>
				<td>
					<input type="text" name="optiona" datatype=*2-100 errormsg="请输入选项A" nullmsg="请填写信息！" style="width:70%;"/>
					<span class="Validform_checktip">选项A</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>选项B:</th>
				<td>
					<input type="text" name="optionb" datatype=*2-100 errormsg="请输入选项B" nullmsg="请填写信息！" style="width:70%;"/>
					<span class="Validform_checktip">选项B</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>选项C:</th>
				<td>
					<input type="text" name="optionc" style="width:70%;"/>
					<span>选项C</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>选项D:</th>
				<td>
					<input type="text" name="optiond" style="width:70%;"/>
					<span>选项D</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>答案:</th>
				<td>
					<input type="text" name="answer" datatype=s1-4 errormsg="请输入本题正确答案" nullmsg="请填写信息！" style="width:70%;"/>
					<span class="Validform_checktip">多选题，则连着写就行，比如ABC</span>
				</td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>试题难度:</th>
				<td><select name="degree">
						<option value="1">简单</option>
						<option value="2">中等</option>
						<option value="3">困难</option>
				</select> <span class="Validform_checktip">选择题目难度（简单、中等或困难）</span></td>
			</tr>
			<tr>
				<th><span class="t_t">*</span>试题解释说明:</th>
				<td>
					<textarea name="explains" cols="100" rows="10" datatype=*2-500 errormsg="请输入题干信息" nullmsg="请填写信息！"></textarea>
					<span class="Validform_checktip">说明</span>
				</td>
			</tr>
		</table>
		<span class="thidden">
			<input type="button" id="btn_sub">
		</span>
	</form>
</body>
</html>