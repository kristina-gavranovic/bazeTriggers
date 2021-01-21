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
<h1>Izmena JM</h1>
		<div align="center">
		
				<form:form action="izmeniJM" method="post"
			modelAttribute="jm">
			<table border="0" cellpadding="5">

				<tr>
					<td>ID:</td>
					<td>
					<form:input path="id" class="form-control-sm" readonly="true" /></td>
					
					</td>
					
				</tr>
				<tr>
					<td>Jedinica mere naziv:</td>
					
					<td>
						<form:input path="naziv" class="form-control-sm" /></td>
					</td>
					
				
		
			
					<td colspan="3" align="center"><input type="submit"
						value="Sacuvaj" class="btn btn-primary">&nbsp;&nbsp;</td>

				</tr>
			</table>
		</form:form>
		
		
		</div>
</body>
</html>