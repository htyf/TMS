//方法的名字一定要和数据库中的sys_titlemenu表中的tnameEng字段的值一样
function menuManger(address){
	var url = getRootPath() + address;
	addTab('菜单管理','menuManger');  // 增加标签的方法
	
	//作用是向该方法增加的tab中写入数据
	$("#mainTable_menuManger").datagrid({
		toolbar : [{
			iconCls: 'icon-edit',   //修改
			handler: function(){menu_edit()}    //回调函数
		},'-',{
			iconCls: 'icon-add',    //增加
			handler: function(){menu_add()}
		},'-',{
			iconCls: 'icon-remove',    //删除
			handler: function(){ menu_remove()}
		},'-',{
			iconCls: 'icon-help',      //帮助
			handler: function(){alert('help')}
		}],
		url : url + '.do',   // 需要url
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
		} ] ]
	});
}

//删除子级菜单
function menu_remove() {
	var row = $("#mainTable_menuManger").datagrid('getSelected');
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

//修改子级菜单
function menu_edit(){
	var row = $('#mainTable_menuManger').datagrid('getSelected');
	if (row) {
		$('#fm').form('clear');
//		$('#dlg').dialog('open').dialog('setTitle', '用户修改');
		$('#fm').form('load', row);
		url = getRootPath() + '/menu/UpdateForMenu.do';
		
	} else {
		alert("请选择一行操作");
	}
}





//增加子级菜单
function menu_add() {
	alert('add');
	$('#dlg').dialog('open').dialog('setTitle', '添加用户');
	$('#fm').form('clear');
	url = getRootPath() + '/menu/addOneMenu.do';
}

