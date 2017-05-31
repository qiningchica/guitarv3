<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<title>查询吉他</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-2">
			<h1>search</h1>
		</div>
		<div class="col-md-8"></div>
	</div>

	<form role="form" action="searchguitar" method="post">
	
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<h3>builder</h3>
			</div>
			<div class="col-md-2">
				<select class="form-control" name="builder">
					<option value="empty"></option>
					<option value="COLLINGS">Collings</option>
					<option value="FENDER">Fender</option>					
					<option value="GIBSON">Gibson</option>
					<option value="MARTIN">Martin</option>
					<option value="OLSON">Olson</option>
					<option value="PRS">PRS</option>
					<option value="RYAN">Ryan</option>					
				</select>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<h3>type</h3>
			</div>
			<div class="col-md-2">
				<select class="form-control" name="type">
					<option value="empty"></option>
					<option value="ACOUSTIC">Acoustic</option>
					<option value="ELECTRIC">Electric</option>
				</select>
			</div>
			<div class="col-md-2"></div>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<h3>backWood</h3>
			</div>
			<div class="col-md-2">
				<select class="form-control" name="backWood">
					<option value="empty"></option>
					<option value="ADIRONDACK">Adirondack</option>
					<option value="ALDER">Alder</option>
					<option value="BRAZILIAN_ROSEWOOD">Brazilian_Rosewood</option>
					<option value="CEDAR">Cedar</option>
					<option value="COCOBOLO">Cocobolo</option>
					<option value="INDIAN_ROSEWOOD">Indian_Rosewood</option>					
					<option value="MAHOGANY">Mahogany</option>
					<option value="MAPLE">Maple</option>				
					<option value="SITKA">Sitka</option>
				</select>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<h3>topWood</h3>
			</div>
			<div class="col-md-2">
				<select class="form-control" name="topWood">
					<option value="empty"></option>
					<option value="ADIRONDACK">Adirondack</option>
					<option value="ALDER">Alder</option>
					<option value="BRAZILIAN_ROSEWOOD">Brazilian_Rosewood</option>
					<option value="CEDAR">Cedar</option>
					<option value="COCOBOLO">Cocobolo</option>
					<option value="INDIAN_ROSEWOOD">Indian_Rosewood</option>					
					<option value="MAHOGANY">Mahogany</option>
					<option value="MAPLE">Maple</option>				
					<option value="SITKA">Sitka</option>
				</select>
			</div>
			<div class="col-md-2"></div>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<h3>numString</h3>
			</div>
			<div class="col-md-2">
				<select class="form-control" name="numStrings">
					<option value="empty"></option>
					<option value="6">6</option>
					<option value="12">12</option>
				</select>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<h3>model</h3>
			</div>
			<div class="col-md-2">
				<div class="input-group input-group-lg">
					<input type="text" class="form-control" placeholder="Username"
						aria-describedby="sizing-addon1" name="model">
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
		
		<div class="row">
			<br>
		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<button type="submit">SEARCH</button>
			</div>
			<div class="col-md-8"></div>
		</div>

	</form>
</body>