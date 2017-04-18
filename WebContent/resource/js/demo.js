//方法的名字一定要和数据库中的sys_titlemenu表中的tnameEng字段的值一样
function tweekly(address){
	var url = getRootPath() + address;
	//第一个参数是显示在页面的tab的值，第二个参数是是当前函数的名字
	//该方法的作用是增加一个Tab
	addTab('教学周报','tweekly');

	//作用是向该方法增加的tab中写入数据
	$("#mainTable_tweekly").datagrid({
		toolbar : [{
			iconCls: 'icon-edit',
			handler: function(){alert('edit222222')}
		},'-',{
			iconCls: 'icon-help',
			handler: function(){alert('help1')}
		}],
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


function texam(){
	var url = getRootPath() + '/user/showAllUser';
	addTab('周考统计','texam');
	// 这里一定要先添加到currentTabPanel中，因为dynamicTable.datagrid()函数需要调用到parent函数
	$("#mainTable_texam").datagrid({
		toolbar : [{
			iconCls: 'icon-edit',
			handler: function(){alert('edit222222')}
		},'-',{
			iconCls: 'icon-help',
			handler: function(){alert('help1')}
		}],
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
/*
 * 

$.ajax({ 
url: "test.html", 
context: document.body, 
success: function(){
        $(this).addClass("done");
}});
 */

/**
 * $.post(URL,data,callback);
 */
function sentData(){
	$.post("/user/getAllUser",{'year':'2016','month':'11'},function(data){
		
	});
}



