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
				<span class="spanr">
					小节名称:
					<input type="text" name="name">
					&nbsp;&nbsp;
					<a id="btn" onclick="btn()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
					&nbsp;&nbsp;
					<a id="btn" onclick="reload()" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置 </a>
				</span>
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
					page : 1,
					sort : "id",
					order : "asc"
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
				url : '/busi/SectionManager.do',
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
					field : 'chid',
					title : '所属章名称',
					width : 300,
					sortable : true,
					formatter : function(value, row, index) {
						uid = value;
						for (var i = 0; i < chapters.length; i++) {
							if (chapters[i].id == value) {
								return chapters[i].name;
							}
						}
					}
				}, {
					field : 'name',
					title : '小节名称',
					width : 300,
					sortable : true
				}, {
					field : 'type',
					title : '小节类型',
					width : 300,
					sortable : true,
					formatter : function(value, row, index) {
						if (value == 1) {
							return "视频";
						} else if (value == 2) {
							return "练习";
						} else if (value == 3) {
							return "形式考试";
						} else if (value == 4) {
							return "项目考试";
						}
					}
				}, {
					field : 'serno',
					title : '小节序号',
					width : 200,
					sortable : true
				} ] ],
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
				name : ff.find('[name="name"]').val(),
			});
		}
		function reload() {
			ff[0].reset();
			btn();
		}
		function SectionManagerAdd() {
			addobj(gb("SectionManagerAdd").name, gb("SectionManagerAdd").link,
					700, 400);
		}

		function SectionManagerUpd() {
			updateobj(gb("SectionManagerUpd").name,
					gb("SectionManagerUpd").link, 700, 400);
		}
		function SectionManagerDel() {
			delobj("/busi/SectionManagerDel.do");
		}
		function SectionManagerSearch() {
			SectionManagerSearch
		}
	</script>
</body>
</html>
