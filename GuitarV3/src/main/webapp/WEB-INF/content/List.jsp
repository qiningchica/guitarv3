<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<title>Guitar List</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<h1>吉他列表</h1>
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
			<table class="table table-hover">
				<thead>
					<td>serialNumber</td>
					<td>price</td>
					<td>builder</td>
					<td>model</td>
					<td>type</td>
					<td>backWood</td>
					<td>topWood</td>
					<td>删除</td>
				</thead>
				<tbody>
					<s:iterator var="list" value="#request.List">
						<td><s:property value="#list.serialNumber" /></td>
						<td><s:property value="#list.price" /></td>
						<td><s:property value="#list.spec.builder" /></td>
						<td><s:property value="#list.spec.model" /></td>
						<td><s:property value="#list.spec.type" /></td>
						<td><s:property value="#list.spec.backWood" /></td>
						<td><s:property value="#list.spec.topWood" /></td>
						<form action="delete" method="post">
							<input type="hidden" name="id"
								value="<s:property value="#list.id"/>">
							<td class="operation"><span class="delete"><button
										type="submit" class="btn btn-default">删除</button></span></td>
						</form>
						</tr>
					</s:iterator>
				</tbody>
				<form action="AddGuitar">
					<td><button type="submit" class="btn btn-default">添加</button></td>
				</form>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
</html>