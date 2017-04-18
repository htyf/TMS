$(document).ready(function() {
	var url = getRootPath() + '/studentManage/showAllStudent';
	// 当进入页面的时候默认加载导航菜单的第一行数据
	getPageData(url);
	
});

function getPageData(url){
	$("#studentManageTable").datagrid({
		url : url + '.do',
		pagination : true,
		columns : [ [ {
			field : 'stuid',
			title : '学生id',
			width : 150,
			align : 'center'
		}, {
			field : 'stuname',
			title : '学生名称',
			width : 78,
			align : 'center'
		}, {
			field : 'stuage',
			title : '学生年龄',
			width : 200,
			align : 'center'
		}, {
			field : 'stusex',
			title : '学生性别',
			width : 78,
			align : 'center'
		}, {
			field : 'borthdate',
			title : '出生日期',
			width : 100,
			align : 'center'
		}, {
			field : 'idnum',
			title : '身份证号码',
			width : 78,
			align : 'center'
		}, {
			field : 'phone',
			title : '手机号码',
			width : 78,
			align : 'center'
		}, {
			field : 'addr',
			title : '家庭住址',
			width : 100,
			align : 'center'
			
		},{
			field : 'classid',
			title : '班级id',
			width : 150,
			align : 'center'
		}, {
			field : 'createdate',
			title : '创建日期',
			width : 100,
			align : 'center'
		},{
			field : 'emerconperson',
			title : '紧急联系人',
			width : 100,
			align : 'center'
		},{
			field : 'emerconphone',
			title : '紧急联系电话',
			width : 100,
			align : 'center'
		},{
			field : 'password',
			title : '登录密码',
			width : 100,
			align : 'center'
		},{
			field : 'stunum',
			title : '学号',
			width : 100,
			align : 'center'
		},{
			field : 'status',
			title : '删除状态 1 表示删除',
			width : 150,
			align : 'center'
		},{
			field : 'entrancedate',
			title : '入学时间',
			width : 100,
			align : 'center'
		},{
			field : 'graduationdate',
			title : '毕业时间',
			width : 100,
			align : 'center'
		},{
			field : 'nativeplace',
			title : '籍贯',
			width : 100,
			align : 'center'
		},{
			field : 'email',
			title : '邮箱',
			width : 100,
			align : 'center'
		},{
			field : 'communityid',
			title : '籍贯id',
			width : 100,
			align : 'center'
		},{
			field : 'createusername',
			title : '创建人姓名',
			width : 100,
			align : 'center'
		},{
			field : 'createuserid',
			title : '创建人Id',
			width : 100,
			align : 'center'
		},{
			field : 'deleteuserid',
			title : '删除人id',
			width : 100,
			align : 'center'
		}] ]
	});
}
function mainBut_add() {
	$('#dlg').dialog('open').dialog('setTitle', '添加班级');
	$('#fm').form('clear');
	url = getRootPath() + '/studentManage/addOneStudent.do';
}

function mainBut_edit() {
	var row = $('#studentManageTable').datagrid('getSelected');
	if (row) {
		$('#fm').form('clear');
		$('#dlg').dialog('open').dialog('setTitle', '学生信息修改');
		$('#fm').form('load', row);
		url = getRootPath() + '/studentManage/UpdateForStudent.do';
	} else {
		alert("请选择一行操作");
	}
}

function mainBut_delete() {
	var row = $('#studentManageTable').datagrid('getSelected');
	if (row) {
		/*
		 * easyUi1.40的写法 $.messager.defaults={ok :"切换用户",cancel: "退出"};
		 * 
		 * 下面是easyUi1.4.2的写法
		 */
		$.messager.defaults.ok = "确定";
		$.messager.defaults.cancel = "退出";
		$.messager.confirm('确定删除', '您确定要删除这个学生吗?', function(r) {
			if (r) {
				$.post(getRootPath() + '/studentManage/deleteForStudent.do', {
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
							msg : '删除失败！',
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
	$('#studentManageTable').datagrid('reload'); // reload the user data
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
