<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../menuBase.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title></title>
</head>
<body>
	<div class="p">
		<form id="ff" method="post">
			<p>
				<span class="spanr">标题:<input type="text" name="title">&nbsp;&nbsp;<a id="btn" onclick="btn()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>&nbsp;&nbsp;<a id="btn" onclick="reload()" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置 </a></span>
			</p>
		</form>
	</div>
	<table id="tt">
	</table>
	<script type="text/javascript">
		var chapters;
		function getAllChapters() {
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
					chapters = data.rows;
				}
			});
		}
	
		var datagrid;
		$(function() {
			getAllChapters();
			datagrid = $("#tt").datagrid({
				url : '/busi/ProjecttrainingManager.do',
				/* 	fitColumns : true,//设置为true将自动使列适应表格宽度以防止出现水平滚动 */
				pagination : true,// 分页控件
				pageSize : 10,//默认显示大小
				fit : true,// 自动大小
				rownumbers : true,// 行号
				singleSelect : true,//只能选中一行
				pageList : [ 5, 10, 20 ],
				sortName : 'id',//排序
				sortOrder : 'desc',// asc desc
				idField : 'id',
				columns : [ [ {
					field : 'content',
					title : '项目考题',
					width : 800,
					sortable : true
				}, {
					field : 'chid',
					title : '所属章',
					width : 250,
					sortable : true,
					formatter : function(value, row, index) {
						uid = value;
						for (var i = 0; i < chapters.length; i++) {
							if (chapters[i].id == value) {
								return chapters[i].name;
							}
						}
					}
				}] ],
				toolbar : ".p",
				onRowContextMenu : function(e, rowIndex, rowData) { // 右击事件
					e.preventDefault(); // 阻止浏览器自带的右键菜单弹出
					$('#menu').menu('show', {
						left : e.pageX, // 弹出窗口的方位坐标
						top : e.pageY
					});
				}
			});
		});
		function btn() {
			datagrid.datagrid("load", {
				title : ff.find('[name="title"]').val(),
			});
		}
		function reload() {
			ff[0].reset();
			btn();
		}
		function ProjecttrainingManagerAdd() {
			addobj(gb("ProjecttrainingManagerAdd").name, gb("ProjecttrainingManagerAdd").link, 1000, 600);
		}

		function ProjecttrainingManagerUpd() {
			updateobj(gb("ProjecttrainingManagerUpd").name, gb("ProjecttrainingManagerUpd").link, 1000, 600);
		}
		function ProjecttrainingManagerDel() {
			delobj("/busi/ProjecttrainingManagerDel.do");
		}
		function ProjecttrainingManagerSearch() {
			ProjecttrainingManagerSearch
		}
	</script>
</body>
</html>
