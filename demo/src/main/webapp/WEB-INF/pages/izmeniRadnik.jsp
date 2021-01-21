<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body style="background-color: #ebc8dc;">
<h1>Izmena proizvoda</h1>
		<div align="center">
		
				<form:form action="izmeniRadnik" method="post"
			modelAttribute="r">
			<table border="0" cellpadding="5">

				<tr>
					<td>ID:</td>
					<td>
					<form:input path="id" class="form-control-sm" readonly = "true"/></td>
					
					</td>
					
				</tr>
				<tr>
					<td>Ime:</td>
					
					<td>
						<form:input  path="imePrezime.ime" class="form-control-sm" />	
					</td>
					
				</tr>
					<tr>
					<td>Prezime:</td>
					
					<td>
						<form:input path="imePrezime.prezime" class="form-control-sm" /></td>
					</td>
					
				</tr>
						<td>JMBG :</td>
							<td><form:input path="jmbg" class="form-control-sm" readonly = "true"/></td>
						</tr>
						
				
		
			
					<td colspan="3" align="center"><input type="submit"
						value="Izmeni ime/prezime radnika" class="btn btn-primary">&nbsp;&nbsp;</td>

				</tr>
			</table>
		</form:form>
		
		
		</div>
</body>
</html>