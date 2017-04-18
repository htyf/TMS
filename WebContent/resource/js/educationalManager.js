$(document).ready(function() {
	var url = getRootPath() + '/educational/showAllDataNearest';
	getPageData(url);
});


function getPageData(url){
	$("#educationalManager").datagrid({
		url : url + '.do',
		fitColumns:true,
		pagination : true,
		singleSelect : true,
		rownumbers : true,
		onSelect : function(rowIndex,rowData){
			alert(rowData.classname);
		},
		columns : [ [ {
			field : 'classname',
			title : '班级名称',
			width : 200,
			align : 'center'
		}, {
			field : 'classStuNum',
			title : '班级人数',
			width : 78,
			align : 'center'
		}, {
			field : 'stuLeaveNum',
			title : '请假人数',
			width : 78,
			align : 'center'
		}, {
			field : 'stuTruant',
			title : '旷课人数',
			width : 78,
			align : 'center'
		}, {
			field : 'stuAbnormal',
			title : '异动人数',
			width : 78,
			align : 'center'
		}, {
			field : 'classActivity',
			title : '当前进行的活动',
			width : 200,
			align : 'center'
		}, {
			field : 'eduTime',
			title : '统计时间',
			width : 200,
			align : 'center'
		}, {
			field : 'eduDesciption',
			title : '班级描述',
			width : 400,
			align : 'center',
			formatter: function(value,row,index){  
				   return '<span title='+value+'>'+value+'</span>'  
				} 
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