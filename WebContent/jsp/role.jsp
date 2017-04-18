<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Basic Layout - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../resource/easyUi/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../resource/easyUi/themes/icon.css">
<script type="text/javascript" src="../resource/easyUi/jquery.min.js"></script>
<script type="text/javascript"
	src="../resource/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../resource/js/role.js"></script>
</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 700px;">
		<div data-options="region:'north'" style="height: 100px"></div>
		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<div data-options="region:'west',split:true" title="West"
			style="width: 217px;">
			<div
				style="width: 200px; height: auto; background: #ffffff; padding: 5px;">
				<div class="easyui-panel" title="Picture Tasks" collapsible="true"
					style="width: 200px; height: auto; padding: 10px;">
					View as a slide show<br /> Order prints online<br /> Print
					pictures
				</div>
				<br />
				<div class="easyui-panel" title="File and Folder Tasks"
					collapsible="true"
					style="width: 200px; height: auto; padding: 10px;">
					Make a new folder<br /> Publish this folder to the Web<br />
					Share this folder
				</div>
				<br />
				<div class="easyui-panel" title="Other Places" collapsible="true"
					collapsed="true" style="width: 200px; height: auto; padding: 10px;">
					New York<br /> My Pictures<br /> My Computer<br /> My Network
					Places
				</div>
				<br />
				<div class="easyui-panel" title="系统管理" collapsible="true"
					style="width: 200px; height: auto; padding: 10px;">
					<a href="user.jsp" style="text-decoration: none" id="main" >用户管理</a><br /><br />
					<a href="power.jsp" style="text-decoration: none" id="power" >权限管理</a><br /><br />
					<a href="role.jsp" style="text-decoration: none" id="role" >角色管理</a><br /><br />
					
				</div>
			</div>
		</div>
		<div
			data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div id="tb" style="padding: 5px; height: auto">
				<div style="margin-bottom: 5px">
					<button class="easyui-linkbutton" iconCls="icon-add" plain="true"
						id="mainBut_add">添加</button>
					<button id="mainBut_edit" class="easyui-linkbutton"
						iconCls="icon-edit" plain="true">修改</button>
					<button class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</button>
					<a href="#" class="easyui-linkbutton" iconCls="icon-cut"
						plain="true">剪贴</a>
					<button id="mainBut_delete" class="easyui-linkbutton"
						iconCls="icon-remove" plain="true">删除</button>
				</div>
				<div>
					开始日期: <input class="easyui-datebox" style="width: 80px">
					结束日期: <input class="easyui-datebox" style="width: 80px">
					关键字: <input class="easyui-combobox" style="width: 100px"
						valueField="id" textField="text"> <a href="#"
						class="easyui-linkbutton" iconCls="icon-search">搜索</a>
				</div>
			</div>
			<table id="mainTable">

			</table>

		</div>
	</div>




	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem">
				<label>角色编号:</label> <input name="role_id" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>角色：&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name="role_position" class="easyui-validatebox"
					required="true">
			</div>
			<br />
			
			<div id="choosePri">
			<input type="checkbox" name='checkAll' id="checkAll"/>全选<br />
               <!--  <input type="checkbox"  id="tec"/><b >教学管理</b><br />
                 &nbsp; &nbsp; &nbsp;<input type="checkbox" name='checkboxTec' id="tec_jxzb"/>教学周报
                 &nbsp; &nbsp;<input type="checkbox" name='checkboxTec' id="tec_zktj"/>周考统计<br />
                 <br />
                <input type="checkbox"  id="jw" /><b >教务管理</b><br />
                 &nbsp; &nbsp; &nbsp;<input type="checkbox" name='checkboxJw' id="jw_bjgl" />班级管理
                 &nbsp; &nbsp;<input type="checkbox"  name='checkboxJw' id="jw_stugl"/>学生管理
                 &nbsp; &nbsp;<input type="checkbox" name='checkboxJw' id="jw_jwzb"/>教务周报<br />
                 &nbsp; &nbsp; &nbsp;<input type="checkbox"  name='checkboxJw' id="jw_kbtj"/>口碑统计<br />
                 <br />
                <input type="checkbox" id="jy"/><b >结业管理</b><br />
                  &nbsp; &nbsp; &nbsp;<input type="checkbox"  name='checkboxJy' id="jy_ing"  />正在就业班级
                 &nbsp; &nbsp;<input type="checkbox" name='checkboxJy' id="jy_djy"  />待就业班级
                 &nbsp; &nbsp;<input type="checkbox" name='checkboxJy' id="jy_yjy"  />已就业班级<br />
                 <br />
                <input type="checkbox" id="sys" /><b >系统管理</b><br />
                  &nbsp; &nbsp; &nbsp;<input type="checkbox" name='checkboxSys' id="sys_role"  />角色管理
                 &nbsp; &nbsp;<input type="checkbox" name='checkboxSys' id="sys_pri" />权限管理
                 &nbsp; &nbsp;<input type="checkbox" name='checkboxSys' id="sys_user"  />用户管理  <br />
                 &nbsp; &nbsp; &nbsp;<input type="checkbox" name='checkboxSys' id="sys_menu"  />菜单管理 <br />
                 <br />
                <input type="checkbox" id="company" /><b >公司管理</b><br />
                &nbsp; &nbsp; &nbsp;<input type="checkbox" name='checkboxCp' id="cp_und" />undefined -->
                </div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">Save</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>

</body>
</html>


