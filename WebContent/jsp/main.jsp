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
<!-- <script type="text/javascript" src="../resource/js/main.js"></script> -->
<!-- 通过document.write输出js解决加载速度慢的问题 -->
<script type="text/javascript">
document.write("<scr"+"ipt src=\"../resource/js/main.js\"></sc"+"ript>")
</script>
<script type="text/javascript" src="../resource/js/demo.js"></script>
<script type="text/javascript" src="../resource/js/menuManger.js"></script>
<script type="text/javascript" src="../resource/js/classManage.js"></script>
<script type="text/javascript" src="../resource/js/studentManage.js"></script>
</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 900px;">
		<div data-options="region:'north'" style="height: 100px"></div>
		<div data-options="region:'south',split:true" style="height: 80px;"></div>
		<div data-options="region:'west',split:true" title="菜单导航"
			style="width: 217px;">
			<div id="head"
				style="width: 200px; height: auto; background: #ffffff; padding: 5px;">
			</div>
		</div>
		<div class="easyui-tabs" data-options="region:'center'" id="dataTabs">
		
		</div>
	</div>

	<!-- <div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem">
				<label>用户编号:</label> <input name="id" class="easyui-validatebox"
					required="true">
			</div>
			<div class="fitem">
				<label>用户名：</label> <input name="userName"
					class="easyui-validatebox" required="true">
			</div>
			
			<div class="fitem">
				<label>年龄：</label> <input name="age" class="easyui-validatebox">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">Save</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div> -->

</body>
</html>



