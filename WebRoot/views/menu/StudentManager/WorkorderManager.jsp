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
					回复内容(输入null查询未回复):
					<input type="text" name="answer">
					&nbsp;&nbsp;
					<a id="btn" onclick="btn()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
					&nbsp;&nbsp;
					<a id="btn" onclick="reload()" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">重置</a>
				</span>
			</p>
		</form>
	</div>
	<table id="tt">
	</table>
	<script type="text/javascript">
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

		var vtype = [ "是", "否" ];
		var datagrid;
		$(function() {
			datagrid = $("#tt").datagrid({
				url : '/busi/WorkorderManager.do',
				/* 	fitColumns : true,//设置为true将自动使列适应表格宽度以防止出现水平滚动 */
				pagination : true,// 分页控件
				pageSize : 20,//默认显示大小
				fit : true,// 自动大小
				rownumbers : true,// 行号
				singleSelect : true,//只能选中一行
				pageList : [ 10, 20, 50 ],
				sortName : 'id',//排序
				sortOrder : 'asc',// asc desc
				idField : 'id',
				columns : [ [ {
					field : 'title',
					title : '标题',
					width : 200,
					sortable : true
				}, {
					field : 'content',
					title : '学生问题',
					width : 220,
					sortable : true
				}, {
					field : 'atime',
					title : '学生提问时间',
					width : 220,
					sortable : true,
					formatter : function(value, row, index) {
						return getLocalTime(value);
					}
				}, {
					field : 'answer',
					title : '老师回复',
					width : 150,
					sortable : true,
					formatter : function(value, row, index) {
						if(value==null){
							return "未回复，请及时回复";
						}else{
							return value;
						}
					}
				}, {
					field : 'qtime',
					title : '回复时间',
					width : 220,
					sortable : true,
					formatter : function(value, row, index) {
						return getLocalTime(value);
					}
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
				answer : ff.find('[name="answer"]').val()
			});
		}
		function reload() {
			ff[0].reset();
			btn();
		}
		function WorkorderManagerUpd() {
			updateobj(gb("WorkorderManagerUpd").name,
					gb("WorkorderManagerUpd").link, "1000", "600");
		}
	</script>
</body>
</html>
