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
		var datagrid;
		$(function() {
			datagrid = $("#tt").datagrid({
				url : '/busi/ChapterManager.do',
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
					field : 'name',
					title : '章名称',
					width : 300,
					sortable : false
				}, {
					field : 'cdesc',
					title : '章节简介',
					width : 700,
					sortable : false
				}, {
					field : 'serno',
					title : '序号',
					width : 100,
					sortable : true
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
		function ChapterManagerAdd() {
			addobj(gb("ChapterManagerAdd").name, gb("ChapterManagerAdd").link, 700, 400);
		}

		function ChapterManagerUpd() {
			updateobj(gb("ChapterManagerUpd").name, gb("ChapterManagerUpd").link, 700, 400);
		}
		function ChapterManagerDel() {
			delobj("/busi/ChapterManagerDel.do");
		}
		function ChapterManagerSearch() {
			ChapterManagerSearch
		}
	</script>
</body>
</html>
