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
<script type="text/javascript" src="../resource/js/studentManage.js"></script>
</head>
<body>
<table id="studentManageTable">
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
				<label>学生id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="stutid" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>学生姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="stuname" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>年龄：&nbsp;</label> <input name="stuage" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>性别：&nbsp;</label> <input name="stusex" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>出生日期：&nbsp;</label> <input name="borthdate" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>身份证号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="idnum">
			</div>
			<div class="fitem">
				<label>手机号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="phone">
			</div>
			<div class="fitem">
				<label>地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="addr">
			</div>
			<div class="fitem">
				<label>班级 id：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="classid">
			</div>
			<div class="fitem">
				<label>创建日期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="createdate">
			</div>
			<div class="fitem">
				<label>紧急联系人：&nbsp;</label> <input name="emerconperson">
			</div>
			<div class="fitem">
				<label>紧急联系电话： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="emerconphone">
			</div>
			<div class="fitem">
				<label>登陆密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="password">
			</div>
			<div class="fitem">
				<label>学号：&nbsp;</label> <input name="stunum">
			</div>
			<div class="fitem">
				<label>删除状态 1 表示删除：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="status">
			</div>
			<div class="fitem">
				<label>入学时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="entrancedate">
			</div>
			<div class="fitem">
				<label>毕业时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="graduationdate">
			</div>
			<div class="fitem">
				<label>籍贯：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="nativeplace">
			</div>
			<div class="fitem">
				<label>邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="email">
			</div>
			<div class="fitem">
				<label>籍贯id：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="communityid">
			</div>
			<div class="fitem">
				<label>创建人姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="createusername">
			</div>
			<div class="fitem">
				<label>创建人Id：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="createuserid">
			</div>
			<div class="fitem">
				<label>删除人id：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="deleteuserid">
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