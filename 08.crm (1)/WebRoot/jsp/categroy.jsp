<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link id="themeLink" rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function (){
		emp();
	})
	function emp(){
		$('#dg').datagrid({    
		    url:'../findAllEmp.action',
		    toolbar:'#tb',
		    pagination:true,
		    singleSelect:true
		});  
	}
</script>
</head>
<body>
	<div id="tb">
	
	</div>
	<table id="dg" class="easyui-datagrid"
        data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">   
    <thead>   
        <tr>   
            <th data-options="field:'emp_id',width:100">编码</th>   
            <th data-options="field:'emp_name',width:100">名称</th>   
            <th data-options="field:'emp_sex',width:100">价格</th>   
        </tr>   
    </thead>   
</table> 
	
	
</body>
</html>