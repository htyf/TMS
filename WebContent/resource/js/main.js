$(document).ready(function() {
	$('#dataTable').attr("data-options", "region:'center',title:'表格数据2'");
	init();
	var url = getRootPath() + '/user/showAllUser';
	// 当进入页面的时候默认加载导航菜单的第一行数据
	// getPageData(url);
	initMenu();
});

function getPageData(url) {
	$('#mainTable').datagrid({
		url : url + '.do',
		pagination : true,
		columns : [ [ {
			field : 'id',
			title : '用户id',
			width : 100
		}, {
			field : 'userName',
			title : '用户名',
			width : 100
		}, {
			field : 'password',
			title : '密码',
			width : 100
		}, {
			field : 'age',
			title : '年龄',
			width : 100,
			align : 'right'
		} ] ]
	});
}
function init() {
	$("#mainBut_add").unbind();
	$("#mainBut_add").bind("click", function() {
		mainBut_add();
	});
	$("#mainBut_edit").unbind();
	$("#mainBut_edit").bind("click", function() {
		mainBut_edit();
	});

	$("#mainBut_delete").unbind();
	$("#mainBut_delete").bind("click", function() {
		mainBut_delete();
	});

}

function popUpBox() {

}
function mainBut_add() {

	$('#dlg').dialog('open').dialog('setTitle', '添加用户');
	$('#fm').form('clear');
	url = getRootPath() + '/user/addOneUser.do';
}

function mainBut_edit() {
	var row = $('#mainTable').datagrid('getSelected');
	if (row) {
		$('#fm').form('clear');
		$('#dlg').dialog('open').dialog('setTitle', '用户修改');
		$('#fm').form('load', row);
		url = getRootPath() + '/user/UpdateForUser.do';
	} else {
		alert("请选择一行操作");
	}
}

function mainBut_delete() {
	var row = $('#mainTable').datagrid('getSelected');
	if (row) {
		/*
		 * easyUi1.40的写法 $.messager.defaults={ok :"切换用户",cancel: "退出"};
		 * 
		 * 下面是easyUi1.4.2的写法
		 */
		$.messager.defaults.ok = "确定";
		$.messager.defaults.cancel = "退出";
		$.messager.confirm('确定删除', '您确定要删除这个用户吗?', function(r) {
			if (r) {
				$.post(getRootPath() + '/user/deleteForUser.do', {
					id : row.id
				}, function(result) {
					if (result == 0) {
						$.messager.show({
							title : '提示消息',
							msg : '恭喜您删除成功',
							timeout : 3000,
							showType : 'slide'
						});
						closeAndreLoad();
					} else if (result == 1) {
						$.messager.show({
							title : '提示消息',
							msg : '删除失败，请重新再试',
							timeout : 3000,
							showType : 'slide'
						});
						closeAndreLoad();
					}
				}, 'json');
			}
		});
	} else {
		alert("请选择一行操作");
	}
}

function saveUser() {
	$('#fm').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else if (result == 0) {
				$.messager.show({
					title : '提示消息',
					msg : '恭喜您操作成功',
					timeout : 3000,
					showType : 'slide'
				});
				closeAndreLoad();
			} else if (result == 1) {
				$.messager.show({
					title : '提示消息',
					msg : '操作失败，请稍后再试',
					timeout : 3000,
					showType : 'slide'
				});
				closeAndreLoad();
			} else {
				closeAndreLoad();
			}
		}
	});
}

function getRootPath() {
	// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}

function closeAndreLoad() {
	$('#dlg').dialog('close'); // close the dialog
	$('#mainTable').datagrid('reload'); // reload the user data
}
/**
 * 添加菜单栏里的大标题和小标题
 */
function initMenu() {
	// 大标题
	$.post(getRootPath() + "/menuAndTitle/initMenu.do",
					function(result) {
						// var json= Jquery.parseJSON(result);
						var json = JSON.parse(result);
						$.each(json,function(i, o) {
											$("#head")
													.append(
															"<div id='title"
																	+ o.hid
																	+ "' class='easyui-panel' title='"
																	+ o.hname
																	+ "' data-options='collapsible:true,collapsed:true' "
																	+ "style='width: 200px; height: auto; padding: 10px;'></div><br />");
										});
//						$.parser.parse(); // 渲染界面
						// 小标题
						$.post(getRootPath()+ "/menuAndTitle/initTitle.do",
										function(result) {
							var json = JSON.parse(result);
											$.each(json,function(i, obj) {
																if (obj.hid) {
																	$("#title"+ obj.hid).append(
																					"<a href='#' id='t"
																							+ obj.tid
																							+ "' onclick='addTab"+"(\""+obj.tname+"\",\""+obj.address+"\") ' style='text-decoration: none;'  value='"
																							+ obj.address
																							+ "'>"
																							+ obj.tname
																							+ "</a><br /><br/>");
																}
															});

										});
						$.parser.parse();
					});
}




// 增加标签的方法
function addTab(title,url) {
	// 我们使用 'exists' 方法来判断 tab 是否已经存在，如果已存在则激活 tab。如果不存在则调用 'add' 方法来添加一个新的 tab
	// 面板
	if ($('#dataTabs').tabs('exists', title)) {
		$('#dataTabs').tabs('select', title);
	} 
	/*else {
		$('#dataTabs').tabs('add', {
			title : title,
			tools : [ {
				iconCls : 'icon-mini-refresh',
				handler : function() {
					alert('刷新');
				}
			} ],
			closable : true
		});
	}*/
	else{
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		$('#dataTabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
	//得到当前选中的tabs
//	var currentTabPanel = $("#dataTabs").tabs('getSelected');
//	var dynamicTable = $('<table id=\"mainTable_'+teng+'\"></table>');
//	// 这里一定要先添加到currentTabPanel中，因为dynamicTable.datagrid()函数需要调用到parent函数
//	currentTabPanel.html(dynamicTable);

}


