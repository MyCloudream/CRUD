<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../formBase.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="<%=path%>/plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/plug-in/ueditor1_4_3_3-utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/plug-in/ueditor1_4_3_3-utf8-jsp/ueditor.all.min.js"></script>
<%-- <script type="text/javascript" charset="utf-8" src="<%=path%>/plug-in/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/plug-in/ueditor/ueditor.all.min.js"></script> --%>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=path%>/plug-in/ueditor1_4_3_3-utf8-jsp/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}

.vtb {
	width: 100%;
}

.vtb tr td {
	width: 300px;
}

.vtb tr td input[type="text"] {
	width: 280px;
}

.vtb tr th {
	width: 100px;
}
</style>
<script type="text/javascript">
	/* $(function() {
		$.ajax({
			type : "POST",
			url : "/busi/MaterialTypeManager.do",
			data : {
				rows : 20, // 获取所有的素材类型
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
	}); */

	// 下拉列表选中事件  二级联动
	function typeChange(osel) {
		$("#suffix").empty();// 先清空，防止堆积
		var tid = osel.options[osel.selectedIndex].value;
		$.ajax({
			type : "POST",
			url : "/busi/MaterialSuffixManager.do",
			data : {
				rows : 200, // 获取所有的素材规格
				page : 1,
				sort : "id",
				order : "asc",
				tid : tid
			},
			dataType : "json",
			success : function(data) {
				var str = "";
				for (var i = 0; i < data.rows.length; i++) {
					str += "<option value=\""+data.rows[i].id+"\">"
							+ data.rows[i].name + "</option>";
				}
				$("#suffix").append(str);
			}
		});
	}
</script>
</head>
<body>
	<table class="vtb">
		<tr>
			<th>
				<span class="t_t">*</span>
				资源名称:
			</th>
			<td>
				<input type="text" name="name" id="name">
			</td>
			<th>
				<span class="t_t">*</span>
				编号:
			</th>
			<td>
				<input type="text" name="no" id="no">
			</td>
		</tr>
		<tr>
			<th>
				<span class="t_t">*</span>
				类型:
			</th>
			<td>
				<select id="type" name="type" onchange="typeChange(this)">
					<option value="">请选择类型</option>
				</select>
			</td>
			<th>
				<span class="t_t">*</span>
				所属格式:
			</th>
			<td>
				<select id="suffix" name="suffix">
					<option value="">请选择格式</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>
				<span class="t_t">*</span>
				动作动画:
			</th>
			<td>
				<select id="animation" name="animation">
					<option value="1">是</option>
					<option value="0">否</option>
				</select>
			</td>
			<th>
				<span class="t_t">*</span>
				资源容量(M):
			</th>
			<td>
				<input type="text" name="size" id="size">
			</td>
		</tr>
		<tr>
			<th>
				<span class="t_t">*</span>
				资源定价:
			</th>
			<td>
				<input type="text" name="price" id="price">
			</td>
			<th>
				<span class="t_t">*</span>
				金豆（颗）:
			</th>
			<td>
				<input type="text" name="bean" id="bean">
			</td>
		</tr>
		<tr>
			<th>
				<span class="t_t">*</span>
				云盘地址:
			</th>
			<td>
				<input type="text" name="url" id="url">
			</td>
			<th>
				<span class="t_t">*</span>
				云盘密码:
			</th>
			<td>
				<input type="text" name="passwd" id="passwd">
			</td>
		</tr>

	</table>
	<table class="vtb">
		<tr>
			<th>
				<span class="t_t">*</span>
				备注说明:
			</th>
			<td>
				<textarea id="mdesc" name="mdesc" cols="120" rows="3"></textarea>
				<span>200字以内</span>
			</td>
		</tr>
	</table>
	<div>
		<!-- <div style="width: 100%; height: 40%; line-height: 30px"></div> -->
		<div style="width: 100%; height: 40%;">
			素材详情:
			<script id="editor" type="text/plain" style="width:980px;;height:450px;"></script>
		</div>
	</div>
	<span class="thidden">
		<input type="button" id="btn_sub">
	</span>
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');
		var win = frameElement.api.opener;
		var formdata = win.datagrids;
		$(function() {
			$("#name").val(formdata[0].name);
			$("#no").val(formdata[0].no);
			// 设置素材类型
			$.ajax({
				type : "POST",
				url : "/busi/MaterialTypeManager.do",
				data : {
					rows : 20, // 获取所有的素材类型
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
					$(
							"select[name='type'] option[value='"
									+ formdata[0].type + "']").attr("selected",
							true);
				}
			});

			// 设置素材规格
			var tid = formdata[0].type;
			$.ajax({
				type : "POST",
				url : "/busi/MaterialSuffixManager.do",
				data : {
					rows : 200, // 获取所有的素材规格
					page : 1,
					sort : "id",
					order : "asc",
					tid : tid
				},
				dataType : "json",
				success : function(data) {
					var str = "";
					for (var i = 0; i < data.rows.length; i++) {
						str += "<option value=\""+data.rows[i].id+"\">"
								+ data.rows[i].name + "</option>";
					}
					$("#suffix").append(str);
					$(
							"select[name='suffix'] option[value='"
									+ formdata[0].suffix + "']").attr(
							"selected", true);
				}
			});

			$(
					"select[name='animation'] option[value='"
							+ formdata[0].animation + "']").attr("selected",
					true);
			$("#size").val(formdata[0].size);
			$("#price").val(formdata[0].price);
			$("#bean").val(formdata[0].bean);
			$("#url").val(formdata[0].url);
			$("#passwd").val(formdata[0].passwd);
			$("#mdesc").val(formdata[0].mdesc);
			//判断ueditor 编辑器是否创建成功
			ue.addListener("ready", function() {
				// editor准备好之后才可以使用
				ue.setContent(formdata[0].content);
			});
			$("#btn_sub").click(
					function() {
						var name = $("#name").val();
						var no = $("#no").val();
						var type = $("#type").val();
						var suffix = $("#suffix").val();
						var animation = $("#animation").val();
						var size = $("#size").val();
						var price = $("#price").val();
						var bean = $("#bean").val();
						var url = $("#url").val();
						var passwd = $("#passwd").val();
						var mdesc = $("#mdesc").val();
						var hasContents = ue.hasContents();
						if (name == '' || name == undefined) {
							alert("标题不能为空");
							return;
						}
						// 这里后续添加其他项的验证
						if (hasContents != true) {
							alert("内容不能为空");
							return;
						}
						$.ajax({
							type : "POST",
							url : "/busi/MaterialManagerUpd.do",
							data : {
								id : formdata[0].id,
								name : name,
								no : no,
								type : type,
								suffix : suffix,
								animation : animation,
								size : size,
								price : price,
								bean : bean,
								url : url,
								passwd : passwd,
								mdesc : mdesc,
								content : ue.getContent()
							},
							dataType : "json",
							success : function(data) {
								var win = frameElement.api.opener;
								if (data.success == true) {
									frameElement.api.close();
									win.tip(data.msg);
								} else {
									if (data.responseText == ''
											|| data.responseText == undefined) {
										alert(data.msg);
									} else {
										alert(data.responseText);
									}
									frameElement.api.close();
									return false;
								}
								win.reloadTable();
							}
						});
					});
		});
	</script>
</body>
</html>