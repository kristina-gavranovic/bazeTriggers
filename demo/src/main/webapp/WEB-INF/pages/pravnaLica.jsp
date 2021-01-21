<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
</head>
<body style="background-color:#ebc8dc;">
<div align="center" class="container">
	<br>
<h1>Pravna lica</h1>


	<br>
	<br>

	<br />
	<table  align="center"   width: 80%;  cellpadding="5" class="table table-bordered">
		<tr>
			<th class="table-info">PIB</th>
			<th class="table-info">Naziv</th>
			<th class="table-info">Adresa</th>

		</tr>
		<c:forEach items="${list}" var="lice">
			<tr>
				<td  class="table-light">${lice.pib}</td>
				<td  class="table-light">${lice.naziv}</td>
				<td  class="table-light">${lice.adresa}</td>
			</tr>
		</c:forEach>
		




		<!-- 			<td align="center"> -->
		<%-- 				<button onclick="window.location.href='editAutor?id=${autor.autorID}'" type="button" class="btn btn-secondary btn-sm">Izmeni</button> --%>
		<%-- 				<button onclick="window.location.href='deleteAutor?id=${autor.autorID}'" type="button" class="btn btn-secondary btn-sm">Obriši</button> --%>		<!-- 			</td> -->
		<!-- 		</tr> -->


	</table>
</div>	
</body>
</html>