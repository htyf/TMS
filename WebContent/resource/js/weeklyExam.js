$(document).ready(function() {
	var url = getRootPath() + '/weeklyExam/showAllDataNearest';
	// 当进入页面的时候默认加载导航菜单的第一行数据
	getPageData(url);
});

function goback(){
	//window.location.href = getRootPath()+"/jsp/weeklyExam.jsp";
	location.reload();
}

function getPageData(url){
	$("#weeklyExamTable").datagrid({	
		url : url + '.do',
		fitColumns : true,
		pagination : true,
		singleSelect : true,
		loadMsg: '数据加载中请稍后……',
		queryParams:{
			weeklyyear:$("#year").combobox('getValue'),
		  	weeklymonth:$("#month").combobox('getValue'),
		  	weeklyday:$("#week").combobox('getValue')},
		rownumbers : true,
		onSelect : function(rowIndex,rowData){
			$("#goback").css("display","inline");
			$("#weeklyExamTable").datagrid({
				url : getRootPath()+'/weeklyExam/showClassStudentScore.do',
				fitColumns : true,
				pagination : true,
				singleSelect : true,
				queryParams:{
					classname:rowData.classname,
					weeklyyear:rowData.weeklyyear,
					weeklymonth:rowData.weeklymonth,
					weeklyday:rowData.weeklyday},
				rownumbers : true,
				columns:[ [ {
						field : 'className',
						title : '班级名称',
						width : 150,
						align : 'center'
					}, {
						field : 'stuName',
						title : '学员姓名',
						width : 78,
						align : 'center'
					}, {
						field : 'weeklyyear',
						title : '考试年份',
						width : 150,
						align : 'center'
					},{
						field : 'weeklymonth',
						title : '考试月份',
						width : 150,
						align : 'center'
					},{
						field : 'weeklyday',
						title : '考试为第几周',
						width : 150,
						align : 'center'
					},{
						field : 'weeklyExamDay',
						title : '考试时间',
						width : 150,
						align : 'center'
					},{
						field : 'weeklyExamScore',
						title : '考试成绩',
						width : 150,
						align : 'center'
					}] ]
			});
		},
		columns : [ [ {
			field : 'classname',
			title : '班级名称',
			width : 150,
			align : 'center'
		}, {
			field : 'classStuNum',
			title : '班级人数',
			width : 78,
			align : 'center'
		}, {
			field : 'examStuNum',
			title : '考试人数',
			width : 78,
			align : 'center'
		}, {
			field : 'rateScore',
			title : '班级平均分',
			width : 78,
			align : 'center'
		}, {
			field : 'tname',
			title : '授课老师',
			width : 100,
			align : 'center'
		}, {
			field : 'highRate',
			title : '高分率',
			width : 78,
			align : 'center',
			formatter: function(value,row,index){
				return value+'%';
			}
		}, {
			field : 'lowRate',
			title : '低分率',
			width : 78,
			align : 'center',
			formatter: function(value,row,index){
				return value+'%';
			}
		}, {
			field : 'mediumRate',
			title : '中等学生占比',
			width : 100,
			align : 'center',
			formatter: function(value,row,index){
					return value+'%';
			}
		}, {
			field : 'weeklyyear',
			title : '考试年份',
			width : 150,
			align : 'center',
			hidden : true
		},{
			field : 'weeklymonth',
			title : '考试月份',
			width : 150,
			align : 'center',
			hidden : true
		},{
			field : 'weeklyday',
			title : '考试为第几周',
			width : 150,
			align : 'center',
			hidden : true
		},{
			field : 'weeklyExamDay',
			title : '考试时间',
			width : 150,
			align : 'center'
		},{
			field : 'classDesc',
			title : '班级描述',
			width : 150,
			align : 'center'
		} ] ]
	});
}

function search(){
	var url = getRootPath() + '/weeklyExam/showAllDataByWeek';
	getPageData(url);
}

//获取路径方法
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