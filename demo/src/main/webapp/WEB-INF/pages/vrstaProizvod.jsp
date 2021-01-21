<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body style="background-color: #ebc8dc;">
	<div  align="center" class="container">
		<br>
		<h1>Unos vrste proizvoda</h1>


		<br> <br>


		<form:form action="saveVrstaProizvod" method="post"
			modelAttribute="vp">
			<table border="0" cellpadding="5">

				<tr>
					<td>Vrsta proizvoda:</td>
					<td><select name="vrstaProizvoda.ident" path="vrstaProizvoda.ident">
							<c:forEach items="${vrsteProizvoda}" var="vp">
								<option value="${vp.ident}">${vp.naziv}</option>
							</c:forEach>
					</select></td>
					
				</tr>
				<tr>
					<td>Jedinica mere:</td>
					<td><select name="jedinicaMere.id" path="jedinicaMere.id" >
							<c:forEach items="${jediniceMere}" var="jm">
								<option value="${jm.id}">${jm.naziv}</option>
							</c:forEach>
					</select></td>
					
				</tr>
						<td>Stanje zaliha :</td>
							<td><form:input path="stanjeZalihe" class="form-control-sm" /></td>
						</tr>
						<tr>
							<td>Kupovna cena:</td>
							<td><form:input path="cenaKupovna" class="form-control-sm" required = "true"/></td>
						</tr>
				
		
			
					<td colspan="3" align="center"><input type="submit"
						value="Sacuvaj" class="btn btn-primary">&nbsp;&nbsp;</td>

				</tr>
			</table>
		</form:form>

	
	<div align="left" class="container">
	<h1>Svi proizvodi</h1>
		<c:if test="${not empty message}">
						<div class="alert alert-warning ">${message}</div>
					</c:if>
	
	<table  align="center"   width: 80%;  cellpadding="5" class="table table-bordered">
		<tr>
			<th class="table-info">Ident</th>
			<th class="table-info">Idjm</th>
			<th class="table-info">NazivJM</th>
			<th class="table-info">cenakupovna</th>
			<th class="table-info">stanjezaliha</th>

		</tr>
		<c:forEach items="${proizvodi}" var="p">
			<tr>
				<td  class="table-light">${p.vrstaProizvoda.ident}</td>
				<td  id="newidjm" contenteditable='true' class="table-light">${p.jedinicaMere.id}</td>
				<td contenteditable='true' class="table-light">${p.nazivJM}</td>
				<td  class="table-light">${p.cenaKupovna}</td>
				<td  class="table-light">${p.stanjeZalihe}</td>
			<td align="center">
<%-- 			<button onclick="window.location.href='izmeniProizvod?idjm=${ <script> document.getElementById("newidjm").value}</script>&ident=${p.vrstaProizvoda.ident}'" type="button" class="btn btn-info">Izmeni </button> --%>
				<button onclick="window.location.href='updateProizvod?ident=${p.vrstaProizvoda.ident}&idjm=${p.jedinicaMere.id}'" type="button" class="btn btn-info">Izmeni </button>
<%-- 				<button onclick="window.location.href='updateProizvod?ident=${p.vrstaProizvoda.ident}&idjm=${p.jedinicaMere.id}&nazivJM=${p.nazivJM}'" type="button" class="btn btn-info">Izmeni nazivJM</button> --%>
				
			</td>
			</tr>
		</c:forEach>
		

	</table>
	</div>

		
</body>
</html>