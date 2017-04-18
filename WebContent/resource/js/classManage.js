$(document).ready(function() {
	var url = getRootPath() + '/classManage/showAllClasses';
	// 当进入页面的时候默认加载导航菜单的第一行数据
	getPageData(url);
	
});

function getPageData(url){
	$("#classManageTable").datagrid({
		url : url + '.do',
		pagination : true,
		columns : [ [ {
			field : 'classid',
			title : '班级序号',
			width : 150,
			align : 'center'
		}, {
			field : 'classname',
			title : '班级名称',
			width : 78,
			align : 'center'
		}, {
			field : 'classopentime',
			title : '班级创建时间',
			width : 200,
			align : 'center'
		}, {
			field : 'classstunum',
			title : '班级学生人数',
			width : 78,
			align : 'center'
		}, {
			field : 'classmanagername',
			title : '班主任',
			width : 100,
			align : 'center'
		}, {
			field : 'classcategoryid',
			title : '班级类型',
			width : 78,
			align : 'center'
		}, {
			field : 'classdesc',
			title : '班级描述',
			width : 78,
			align : 'center'
		}, {
			field : 'classquality',
			title : '班级质量',
			width : 100,
			align : 'center'
			
		},{
			field : 'jobteaname',
			title : '就业指导老师',
			width : 150,
			align : 'center'
		}, {
			field : 'stuName',
			title : '班长',
			width : 100,
			align : 'center'
		},{
			field : 'tname',
			title : '授课教师',
			width : 100,
			align : 'center'
		},{
			field : 'coursecontent',
			title : '班级授课等级',
			width : 100,
			align : 'center'
		},{
			field : 'teachmethods',
			title : '是否面授',
			width : 100,
			align : 'center'
		}] ]
	});
}
function mainBut_add() {
	$('#dlg').dialog('open').dialog('setTitle', '添加班级');
	$('#fm').form('clear');
	url = getRootPath() + '/classManage/addOneClass.do';
}

function mainBut_edit() {
	var row = $('#classManageTable').datagrid('getSelected');
	if (row) {
		$('#fm').form('clear');
		$('#dlg').dialog('open').dialog('setTitle', '班级修改');
		$('#fm').form('load', row);
		url = getRootPath() + '/classManage/UpdateForClass.do';
	} else {
		alert("请选择一行操作");
	}
}

function mainBut_delete() {
	var row = $('#classManageTable').datagrid('getSelected');
	if (row) {
		/*
		 * easyUi1.40的写法 $.messager.defaults={ok :"切换用户",cancel: "退出"};
		 * 
		 * 下面是easyUi1.4.2的写法
		 */
		$.messager.defaults.ok = "确定";
		$.messager.defaults.cancel = "退出";
		$.messager.confirm('确定删除', '您确定要删除这个班级吗?', function(r) {
			if (r) {
				$.post(getRootPath() + '/classManage/deleteForClass.do', {
					id : row.classid
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
							msg : '删除失败，该班级还有学生信息存在！',
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

function saveClass() {
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
function closeAndreLoad() {
	$('#dlg').dialog('close'); // close the dialog
	$('#classManageTable').datagrid('reload'); // reload the user data
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


function search(){
	alert("sddd");
}