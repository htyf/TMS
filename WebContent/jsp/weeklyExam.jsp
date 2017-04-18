<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../resource/easyUi/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../resource/easyUi/themes/icon.css">
<script type="text/javascript" src="../resource/easyUi/jquery.min.js"></script>
<script type="text/javascript"
	src="../resource/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../resource/js/weeklyExam.js"></script>
</head>
<body>
<table id="weeklyExamTable">
<div style="margin-bottom:5px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" text="增加" ></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" text="修改" ></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"  text="保存" ></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"  text="剪切" ></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"  text="删除" ></a>
		<a href="javascript:goback();" class="easyui-linkbutton" iconCls="icon-back" plain="true" style="display:none;" text="返回" id = "goback"></a>
	<div style="float: right;">
<select id="year" class="easyui-combobox" name="year" style="width:70px; text-align: center;">
    <option value="2016">2016</option>
    <option value="2017">2017</option>
    <option value="2018">2018</option>
    <option value="2019">2019</option>
</select>
年&nbsp;&nbsp;&nbsp;&nbsp;
		
<select id="month" class="easyui-combobox" name="month" style="width:50px; text-align: center;" >
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    <option value="11">11</option>
    <option value="12">12</option>
</select>
月&nbsp;&nbsp;&nbsp;&nbsp;第
<select id="week" class="easyui-combobox" name="week" style="width:50px; text-align: center;">
    <option value="一">一</option>
    <option value="二">二</option>
    <option value="三">三</option>
    <option value="四">四</option>
    <option value="五">五</option>
</select>&nbsp;&nbsp;周&nbsp;&nbsp;
<a href="javaScript:search()" class="easyui-linkbutton" iconCls="icon-search">搜索</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>	
		
	</div>
	
</table>
</body>
</html>