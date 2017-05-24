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
					标题:
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
		var datagrid;
		$(function() {
			datagrid = $("#tt").datagrid({
				url : '/busi/MaterialTypeManager.do',
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
					title : '名称',
					width : 200,
					sortable : true
				}, {
					field : 'no',
					title : '编号',
					width : 150,
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
		function MaterialTypeManagerAdd() {
			addobj(gb("MaterialTypeManagerAdd").name,
					gb("MaterialTypeManagerAdd").link, 600, 400);
		}

		function MaterialTypeManagerUpd() {
			updateobj(gb("MaterialTypeManagerUpd").name,
					gb("MaterialTypeManagerUpd").link, 600, 400);
		}
		function MaterialTypeManagerDel() {
			delobj("/busi/MaterialTypeManagerDel.do");
		}
		function MaterialTypeManagerSearch() {
			MaterialTypeManagerSearch
		}
	</script>
</body>
</html>