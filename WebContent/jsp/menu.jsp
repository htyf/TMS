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
<!-- 载入menu.js文件 -->
<script type="text/javascript" src="../resource/js/menu.js"></script>
</head>
<body>
<table id="menuTable">
<div style="margin-bottom:5px">
		<a href="javaScript:menu_add()" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	</div>
	<div>
		Date From: <input class="easyui-datebox" style="width:80px">
		To: <input class="easyui-datebox" style="width:80px">
		Language: 
		<input class="easyui-combobox" style="width:100px"
				url=""
				valueField="id" textField="text">
		<a href="#" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
	</div>
</table>

<div id="dlg" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px" 
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem">
				<label>标签编号 :</label> <input name="id" 
					 id="bqid" value="" />
			</div>
			<div class="fitem">
				<label>标签名称 :</label> <input name="userName"
				value="" />
			</div>
			<div class="fitem" id="judgeDivRadio">
				<label>是否父标签 :</label> 是<input type="radio" name="radioName" value="ok" checked="checked" />
				                                                                        否<input type="radio" name="radioName" value="no"/>
			</div>
			<div class="fitem" id="judgeDivSelect">选择父级标签: <select id="judgeSelect"></select></div>
			<div class="fitem" id= "subAddress">
				<label>标签路径 :</label> <input name="address" class="easyui-validatebox">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>

</body>
</html>