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
		
				<form:form action="izmeniProizvod" method="post"
			modelAttribute="p">
			<table border="0" cellpadding="5">

				<tr>
					<td>Vrsta proizvoda:</td>
					<td>
					<form:input path="vrstaProizvoda.ident" class="form-control-sm" readonly = "true"/></td>
					
					</td>
					
				</tr>
				<tr>
					<td>Jedinica mere id:</td>
					
					<td>
						<form:input id="idinput" path="jedinicaMere.id" class="form-control-sm" readonly = "true"/>	
					</td>
					
				</tr>
					<tr>
					<td>Naziv jedinice mere:</td>
					
					<td>
						<form:input path="nazivJM" class="form-control-sm" /></td>
					</td>
						<td colspan="3" align="center"><input type="submit"
						value="Izmeni naziv jedinice mere" class="btn btn-primary">&nbsp;&nbsp;</td>
					
					
				</tr>
						<td>Stanje zaliha :</td>
							<td><form:input path="stanjeZalihe" class="form-control-sm" readonly = "true"/></td>
						</tr>
						<tr>
							<td>Kupovna cena:</td>
							<td><form:input path="cenaKupovna" class="form-control-sm" readonly = "true"/></td>
						</tr>
				
		
			
				
				</tr>
			</table>
		</form:form>
		
		
		</div>
</body>
</html>