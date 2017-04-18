$(document).ready(function() {
	var url = getRootPath() + '/menu/showAllMenu';
	// 当进入页面的时候默认加载导航菜单的第一行数据
	getPageData(url);
	init();
});


function init(){
	$("#judgeDivSelect").hide();
	$("#subAddress").hide();
	$("input[name='radioName']").unbind();
	$("input[name='radioName']").bind("click",function(){
		judgeIsChecked();
	});
	
	$("#bqid").unbind();
	$("#bqid").bind("blur",function(){
		var bqid = $("#bqid").val();
		//做非空判断
		var judgeVal = $("input[name='radioName']:checked").val();
		if(judgeVal == 'no'){
			$.post(getRootPath() + "/menuAndTitle/findTitleMenu.do",{'tid':bqid},function(data){
				
			});
		}else{
			$.post(getRootPath() + "/menuAndTitle/findHeadMenu.do",{'hid':bqid},function(data){
				
			});
		}
	});
}
function judgeIsChecked(){
	var judgeVal = $("input[name='radioName']:checked").val();
	if(judgeVal == 'ok'){
		$("#judgeDivSelect").hide();
		$("#subAddress").hide();
		$("#judgeDivSelect option").remove();
	}else if(judgeVal == 'no'){
		$.ajax({ 
			type: "POST",
			url: getRootPath() + "/menuAndTitle/initMenu.do", 
			dataType: "json",
			async : false,
			success: function(data){
				$.each(data,function(i, o) {
					$("#judgeSelect").append("<option name='judgeOption' value='"+o.hid+"'>"+o.hname+"</option>");
				});
	      }});
		$("#judgeDivSelect").show();
		$("#subAddress").show();
	}else{
		$.messager.show({
			title : '提示消息',
			msg : '系统错误，请稍后再试',
			timeout : 3000,
			showType : 'slide'
		});
		closeAndreLoad();
	}
}
function getPageData(url){
	$("#menuTable").datagrid({
//		toolbar : [ 
//		    { text: '增加', iconCls: 'icon-add', handler: function () { } },
//		    { text: '修改', iconCls: 'icon-edit', handler: function () {  } },
//		    { text: '删除', iconCls: 'icon-remove', handler: function () { menu_remove() } },
//		    { text: '查看', handler: function () { } }, '-',
//		    { text: '刷新', iconCls: 'icon-reload', handler: function () {  } },
//		    { text: '导出', iconCls: 'icon-save', handler: function () {  } }, '-'
//		],
		url : url + '.do',
		pagination : true,
		columns : [ [ {
			field : 'hname',
			title : '父级菜单名',
			width : 100
		}, {
			field : 'tname',
			title : '子级菜单名',
			width : 100
		},{
			field : 'tid',
			title : '子级菜单id',
			width : 100,
			hidden: true   //隐藏此列
		}] ]
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

//删除子级菜单
function menu_remove() {
	var row = $("#menuTable").datagrid('getSelected');
	if (row) {
		/*
		 * easyUi1.40的写法 $.messager.defaults={ok :"切换用户",cancel: "退出"};
		 * 
		 * 下面是easyUi1.4.2的写法
		 */
		$.messager.defaults.ok = "确定";
		$.messager.defaults.cancel = "退出";
		$.messager.confirm('确定删除', '您确定要删除这个菜单吗?', function(r) {   //r：回调函数传来的内容
			if (r) {
				$.post(getRootPath() + '/menu/deleteForMenu.do', {id : row.tid}, function(result) {
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

//修改子级菜单（子级菜单名、子级菜单所属的父级菜单、子级菜单的地址）
function mainBut_edit(){
	var row = $('#menuTable').datagrid('getSelected');
	if (row){
		$('#fm').form('clear');
		$('#dlg').dialog('open').dialog('setTitle','菜单修改');
		$('#fm').form('load',row);
		url = getRootPath()+'/sys_user/sys_UpdateForUser.do';
	}else{
		alert("请选择一行操作");
	}
}

function menu_add(){
	$('#dlg').dialog('open').dialog('setTitle','添加菜单');
	$('#fm').form('clear');
	$("#judgeDivSelect").hide();
	$("#subAddress").hide();
	url = getRootPath()+'/menu/addOneMenu.do';
}





function saveUser(){
	var judgeVal = $("input[name='radioName']:checked").val();
	var juOption;
	if(judgeVal == 'ok'){
		$("#judgeDivSelect").remove();
	}else if(judgeVal == 'no'){
	 juOption = $("#judgeDivSelect option:selected").val();
	}
	$('#fm').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			var result = eval('('+result+')');
			if (result.errorMsg){
				$.messager.show({
					title: 'Error',
					msg: result.errorMsg
				});
			}else if(result == 0){
				$.messager.show({
					title:'提示消息',
					msg:'恭喜您操作成功',
					timeout:3000,
					showType:'slide'
				});
				closeAndreLoad();
			}
			else if(result == 1){
				$.messager.show({
					title:'提示消息',
					msg:'操作失败，请稍后再试',
					timeout:3000,
					showType:'slide'
				});
				closeAndreLoad();
			} else {
				closeAndreLoad();
			}
		}
	});
}




function closeAndreLoad(){
	$('#dlg').dialog('close');		// close the dialog
	$('#mainTable').datagrid('reload');	// reload the user data
}
