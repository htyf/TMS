$(document).ready(function() {
	init();
	getPageData();
});


function getPageData(){
	$('#mainTable').datagrid({
		url : getRootPath()+'/sys_user/sys_showAllUser.do',
		pagination:true,
		columns : [ [ {
			field : 'id',
			title : '用户编号',
			width : 100
		}, {
			field : 'name',
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
			
		} , {
			field : 'gender',
			title : '性别',
			width : 100,
			
		}, {
			field : 'position',
			title : '职位',
			width : 100,
		
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
}


function popUpBox(){
	
}
function mainBut_add(){
	
	$('#dlg').dialog('open').dialog('setTitle','添加用户');
	$('#fm').form('clear');
	url = getRootPath()+'/sys_user/sys_addOneUser.do';
}

function mainBut_edit(){
	var row = $('#mainTable').datagrid('getSelected');
	if (row){
		$('#fm').form('clear');
		$('#dlg').dialog('open').dialog('setTitle','用户修改');
		$('#fm').form('load',row);
		url = getRootPath()+'/sys_user/sys_UpdateForUser.do';
	}else{
		alert("请选择一行操作");
	}
}

function mainBut_delete(){
	var row = $('#mainTable').datagrid('getSelected');
	if (row){
		/*easyUi1.40的写法
		 * $.messager.defaults={ok :"切换用户",cancel: "退出"}; 
		 * 
		 * 下面是easyUi1.4.2的写法
		 */
		$.messager.defaults.ok = "确定";  
	    $.messager.defaults.cancel = "退出"; 
		$.messager.confirm('确定删除','您确定要删除这个用户吗?',function(r){
			if (r){
				$.post(getRootPath()+'/sys_user/sys_deleteForUser.do',{id:row.id},function(result){
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
}





function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

function closeAndreLoad(){
	$('#dlg').dialog('close');		// close the dialog
	$('#mainTable').datagrid('reload');	// reload the user data
}