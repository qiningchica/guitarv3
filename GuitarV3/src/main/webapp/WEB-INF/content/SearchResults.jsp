<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<title>查询结果</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<h1>查询结果</h1>
		</div>
		<div class="col-md-8"></div>
	</div>
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<br>
		</div>
		<div class="col-md-8"></div>
	</div>
	
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<table class="table">
				<thead>
					<tr>
						<td>serialNumber</td>						
						<td>builder</td>
						<td>model</td>
						<td>type</td>
						<td>backWood</td>
						<td>topWood</td>
						<td>price</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator var='List' value="#request.List">
						<tr>
							<td><s:property value="#List.serialNumber" /></td>							
							<td><s:property value="#List.spec.builder" /></td>
							<td><s:property value="#List.spec.model" /></td>
							<td><s:property value="#List.spec.type" /></td>
							<td><s:property value="#List.spec.backWood" /></td>
							<td><s:property value="#List.spec.topWood" /></td>
							<td><s:property value="#List.price" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

		</div>
		<div class="col-md-2"></div>
	</div>
</body>