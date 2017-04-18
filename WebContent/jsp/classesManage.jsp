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
<script type="text/javascript" src="../resource/js/classManage.js"></script>
<!-- <script type="text/javascript" src="/locale/easyui-lang-zh_CN.js"></script>    -->
 <script type="text/javascript" src="../resource/easyUi/locale/easyui-lang-zh_CN.js"></script> 
</head>
<body>
<table id="classManageTable">
<div style="margin-bottom:5px">
		<a href="javaScript:mainBut_add()"  class="easyui-linkbutton" iconCls="icon-add" plain="true" text="增加" ></a>
		<a href="javaScript:mainBut_edit()" class="easyui-linkbutton" iconCls="icon-edit" plain="true" text="修改" ></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"  text="保存" ></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"  text="剪切" ></a>
		<a href="javaScript:mainBut_delete()" class="easyui-linkbutton" iconCls="icon-remove" plain="true"  text="删除" ></a>
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
    <option value="1">5</option>
    <option value="2">6</option>
    <option value="3">7</option>
    <option value="4">8</option>
    <option value="2">9</option>
    <option value="3">10</option>
    <option value="4">11</option>
    <option value="4">12</option>
</select>
月&nbsp;&nbsp;&nbsp;&nbsp;第
<select id="week" class="easyui-combobox" name="week" style="width:50px; text-align: center;">
    <option value="1">一</option>
    <option value="2">二</option>
    <option value="3">三</option>
    <option value="4">四</option>
    <option value="5">五</option>
</select>&nbsp;&nbsp;周&nbsp;&nbsp;
		<a href="javaScript:search()" class="easyui-linkbutton" iconCls="icon-search">搜索</a>&nbsp;&nbsp;&nbsp;&nbsp;
	</div>	
		
	</div>	
</table>
<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem">
				<label>班级id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="classid" class="easyui-validatebox"
					required="true" missingMessage='班级序号不能为空'>
			</div>
			<div class="fitem">
				<label>班级名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="classname" class="easyui-validatebox"
					required="true" missingMessage='班级名称不能为空'>
			</div>
			<div class="fitem">
				<label>班级创建时间：&nbsp;</label> <input name="classopentime" class="easyui-validatebox" required="true" missingMessage='创建时间不能为空'>
			</div>
			<div class="fitem">
				<b>时间格式如：2000-10-10</b>
			</div>
			<div class="fitem">
				<label>班级学生人数：&nbsp;</label> <input name="classstunum" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>班主任：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="classmanagername">
			</div>
			<div class="fitem">
				<label>班级类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="classcategoryid">
			</div>
			<div class="fitem">
				<label>班级描述：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="classdesc">
			</div>
			<div class="fitem">
				<label>班级质量：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="classquality">
				<label>优 /良 /差</label> 
			</div>
			<div class="fitem">
				<label>就业指导老师：&nbsp;</label> <input name="jobteaname">
			</div>
			<div class="fitem">
				<label>班长： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="stuName">
			</div>
			<div class="fitem">
				<label>授课老师：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="tname">
			</div>
			<div class="fitem">
				<label>班级授课等级：&nbsp;</label> <input name="coursecontent">
			</div>
			<div class="fitem">
				<label>是否面授：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="teachmethods">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveClass()">Save</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>
</body>
</html>