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
		// 获取全部章
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
				// 选中指定章
				$("select[name='chid'] option[value='" + formdata[0].chid + "']").attr("selected",true);
			}
		});
		
		// 获取该章的全部小节
		var chid = formdata[0].chid;
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
				// 选中指定小节
				$("select[name='seid'] option[value='" + formdata[0].seid + "']").attr("selected",true);
			}
		});
		// 获取
		valform("id", formdata[0].id, "");
		valform("Qanda", formdata[0].Qanda, "textarea");
	});
	
	// 下拉列表选中事件  二级联动
	function chapterChange(opt){
		$("#section").empty();// 先清空，防止堆积
		var chid = opt.options[opt.selectedIndex].value;
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
	<form class="formobj" method="post" action="/busi/QandaManagerUpd.do">
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
				<th><span class="t_t">*</span>课程问答:</th>
				<td><textarea name="qanda" cols="100" rows="25" datatype=*2-50000 errormsg="请输入正确的课程笔记内容" nullmsg="请填写信息！"></textarea>
				<br/><span class="Validform_checktip">本小节课程问答题</span></td>
			</tr>
		</table>
		<span class="thidden">
			<input type="button" id="btn_sub">
			<input type="hidden" name="id" type="text">
		</span>
	</form>
</body>
</html>