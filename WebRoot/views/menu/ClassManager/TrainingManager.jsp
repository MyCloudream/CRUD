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
	
		var sections;
		function getAllSections() {
			$.ajax({
				type : "POST",
				url : "/busi/SectionManager.do",
				data : {
					rows : 10000, // 所有小节
					page:1,
					sort:"id",
					order:"asc"
				},
				dataType : "json",
				success : function(data) {
					sections = data.rows;
				}
			});
		}
		
	
		var datagrid;
		$(function() {
			getAllChapters();
			getAllSections();
			datagrid = $("#tt").datagrid({
				url : '/busi/TrainingManager.do',
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
					field : 'type',
					title : '试题类型',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						if(value==1){
							return "单选题";
						}else if(value==2){
							return "多选题";
						}else if(value==3){
							return "判断题";
						}
					}
				}, {
					field : 'degree',
					title : '试题难度',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						if(value==1){
							return "简单";
						}else if(value==2){
							return "中等";
						}else if(value==3){
							return "困难";
						}
					}
				}, {
					field : 'question',
					title : '题干',
					width : 100,
					sortable : true
				},{
					field : 'optiona',
					title : '选项A',
					width : 100,
					sortable : true
				},  {
					field : 'optionb',
					title : '选项B',
					width : 100,
					sortable : true
				}, {
					field : 'optionc',
					title : '选项C',
					width : 100,
					sortable : true
				}, {
					field : 'optiond',
					title : '选项D',
					width : 100,
					sortable : true
				}, {
					field : 'answer',
					title : '试题答案',
					width : 100,
					sortable : true
				}, {
					field : 'explains',
					title : '解释说明',
					width : 200,
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
				}, {
					field : 'seid',
					title : '所属节',
					width : 250,
					sortable : true,
					formatter : function(value, row, index) {
						uid = value;
						for (var i = 0; i < sections.length; i++) {
							if (sections[i].id == value) {
								return sections[i].name;
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
		function TrainingManagerAdd() {
			addobj(gb("TrainingManagerAdd").name, gb("TrainingManagerAdd").link, 1000, 550);
		}

		function TrainingManagerUpd() {
			updateobj(gb("TrainingManagerUpd").name, gb("TrainingManagerUpd").link, 1000, 550);
		}
		function TrainingManagerDel() {
			delobj("/busi/TrainingManagerDel.do");
		}
		function TrainingManagerSearch() {
			TrainingManagerSearch
		}
	</script>
</body>
</html>
