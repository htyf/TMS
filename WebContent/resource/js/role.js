$(document).ready(function() {
	init();
	
	
	
	
});


function getPageData(){
	$('#mainTable').datagrid({
		url : getRootPath()+'/role/showAllRole.do',
		pagination:true,
		columns : [ [ {
			field : 'role_id',
			title : '角色编号',
			width : 100
		}, {
			field : 'role_position',
			title : '用户名',
			width : 100
		}] ]
	});
}
function init(){
	
	$("#mainBut_add").unbind();
	$("#mainBut_add").bind("click",function(){
		mainBut_add();
	});
	$("#mainBut_edit").unbind();
	$("#mainBut_edit").bind("click",function(){
		mainBut_edit();
	});
	
	$("#mainBut_delete").unbind();
	$("#mainBut_delete").bind("click",function(){
		mainBut_delete();
	});
	
	$("#role").click(function(){
		
	});
	getPageData();
	getPrivilege();
	selectPrivilege();
}




function getPrivilege(){
	
	
/**
 * 备用：权限存到了title数组里
 * 
 * */
//	 var title=new Array();
//	$.post(getRootPath() + "/menuAndTitle/initTitle.do",
//				function(result) {
//					alert(result);
//					// var json= Jquery.parseJSON(result);
//					// var json = JSON.parse(result);
//					title=eval(result);				
//		});
	 
/**
 * 
 * 从数据库获取权限 动态的添加到jsp页面里
 * 
 * */	 
	$.post(getRootPath() + "/menuAndTitle/initTitle.do",
			function(result) {
			alert(result);
		var json = JSON.parse(result);				
			$.each(json,function(i, obj) {$("#choosePri").append(
						"<input type='checkbox' name='checkBoxSub' id='"+obj.tid+"'/>"+obj.tname+" &nbsp; &nbsp;"
				);
			});
	});
	/**
	 * 全选功能
	 * */
	$("#checkAll").click(function(){
		
			if($('#checkAll').is(':checked')) {
				$("[name=checkBoxSub]:checkbox").prop("checked", true);
			}else{
				$("[name=checkBoxSub]:checkbox").prop("checked", false);
			}
			
		});
	
	
}



/**
 * 
 * 备用：
 * 添加角色时选择权限功能
 * 
 */
//function selectPrivilege(){
//	// 教学管理全选功能
//	$("#tec").click(function(){
//		
//		// 判断全选框是否被选中，如果被选中遍历所有checkbox将属性设置为true
//		if($('#tec').is(':checked')) {
//			
//			$("[name=checkboxTec]:checkbox").prop("checked", true);
//		// 如果没被选中将属性设置为false
//		}else{
//			$("[name=checkboxTec]:checkbox").prop("checked", false);
//		}
//	});
//	// 教务管理全选功能
//	$("#jw").click(function(){
//		
//		if($('#jw').is(':checked')) {
//			
//			$("[name=checkboxJw]:checkbox").prop("checked", true);
//		}else{
//			$("[name=checkboxJw]:checkbox").prop("checked", false);
//		}
//	});
//	// 结业管理全选功能
//	$("#jy").click(function(){
//		
//		if($('#jy').is(':checked')) {
//			
//			$("[name=checkboxJy]:checkbox").prop("checked", true);
//		}else{
//			$("[name=checkboxJy]:checkbox").prop("checked", false);
//		}
//	});
//	// 系统管理全选功能
//	$("#sys").click(function(){
//		
//		if($('#sys').is(':checked')) {
//			
//			$("[name=checkboxSys]:checkbox").prop("checked", true);
//		}else{
//			$("[name=checkboxSys]:checkbox").prop("checked", false);
//		}
//	});
//	// 公司管理全选功能
//	$("#company").click(function(){
//		
//		if($('#company').is(':checked')) {
//			
//			$("[name=checkboxCp]:checkbox").prop("checked", true);
//		}else{
//			$("[name=checkboxCp]:checkbox").prop("checked", false);
//		}
//	});
//}

function mainBut_add(){
	
	$('#dlg').dialog('open').dialog('setTitle','添加用户');
	$('#fm').form('clear');
	url = getRootPath()+'/role/addOneRole.do';
}

function mainBut_edit(){
	var row = $('#mainTable').datagrid('getSelected');
	if (row){
		$('#fm').form('clear');
		$('#dlg').dialog('open').dialog('setTitle','用户修改');
		$('#fm').form('load',row);
		url = getRootPath()+'/role/UpdateForRole.do';
	}else{
		alert("请选择一行操作");
	}
}

function mainBut_delete(){
	var row = $('#mainTable').datagrid('getSelected');
	if (row){
		/*
		 * easyUi1.40的写法 $.messager.defaults={ok :"切换用户",cancel: "退出"};
		 * 
		 * 下面是easyUi1.4.2的写法
		 */
		$.messager.defaults.ok = "确定";  
	    $.messager.defaults.cancel = "退出"; 
		$.messager.confirm('确定删除','您确定要删除这个用户吗?',function(r){
			if (r){
				$.post(getRootPath()+'/role/deleteForRole.do',{id:row.role_id},function(result){
					if (result == 0){
						$.messager.show({
							title:'提示消息',
							msg:'恭喜您删除成功',
							timeout:3000,
							showType:'slide'
						});
						closeAndreLoad();
					} else if(result == 1){
						$.messager.show({
							title:'提示消息',
							msg:'删除失败，请重新再试',
							timeout:3000,
							showType:'slide'
						});
						closeAndreLoad();
					}
				},'json');
			}
		});
	}else{
		alert("请选择一行操作");
	}
}


function saveUser(){
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
	var id_array=new Array();
	$("input[type='checkbox'][name='checkboxSub']:checked").each(function(){
		alert($(this).id);//向数组中添加元素
	});
	var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串  
	alert(idstr);
}





function getRootPath(){
    // 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    // 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    // 获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    // 获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

function closeAndreLoad(){
	$('#dlg').dialog('close');		// close the dialog
	$('#mainTable').datagrid('reload');	// reload the user data
}