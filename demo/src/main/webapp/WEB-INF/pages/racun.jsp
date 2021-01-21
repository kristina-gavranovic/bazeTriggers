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
		<h1>Unos proizvoda</h1>


		<br> <br>


		<form:form action="saveRacun" method="post"
			modelAttribute="racun">
			<table border="0" cellpadding="5">

				<tr>
					<td>Dostava:</td>
	
							<td><form:input path="dostava" class="form-control-sm" /></td>
						</tr>
						<tr>
							<td>odgovornaOsoba:</td>
							<td><form:input path="odgovornaOsoba" class="form-control-sm" required = "true"/></td>
						</tr>
						
											<tr>
							<td>mestoFakture:</td>
							<td><form:input path="mestoFakture" class="form-control-sm" required = "true"/></td>
						</tr>
						
											<tr>
							<td>Kupac:</td>
							
								<td><select name="kupac.pib" path="kupac.pib">
							<c:forEach items="${pravnaLica}" var="p">
								<option value="${p.pib}">${p.naziv}</option>
							</c:forEach>
					</select></td>
						</tr>
											<tr>
							<td>Primalac</td>
							<td><select name="primalac.pib" path="primalac.pib">
							<c:forEach items="${pravnaLica}" var="p">
								<option value="${p.pib}">${p.naziv}</option>
							</c:forEach>
					</select></td>
						</tr>
				
		
			
					<td colspan="3" align="center"><input type="submit"
						value="Sacuvaj" class="btn btn-primary">&nbsp;&nbsp;</td>

				</tr>
			</table>
		</form:form>
<!-- 		<br /> -->
<!-- 		<table align="center" width: 80%;  cellpadding="5" -->
<!-- 			class="table table-bordered"> -->
<!-- 			<tr> -->
<!-- 				<th class="table-info">PIB</th> -->
<!-- 				<th class="table-info">Naziv</th> -->
<!-- 				<th class="table-info">Adresa</th> -->

<!-- 			</tr> -->
<%-- 			<c:forEach items="${list}" var="lice"> --%>
<!-- 				<tr> -->
<%-- 					<td class="table-light">${lice.pib}</td> --%>
<%-- 					<td class="table-light">${lice.naziv}</td> --%>
<%-- 					<td class="table-light">${lice.adresa}</td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>





			<!-- 			<td align="center"> -->
			<%-- 				<button onclick="window.location.href='editAutor?id=${autor.autorID}'" type="button" class="btn btn-secondary btn-sm">Izmeni</button> --%>
			<%-- 				<button onclick="window.location.href='deleteAutor?id=${autor.autorID}'" type="button" class="btn btn-secondary btn-sm">Obriši</button> --%>
			<!-- 			</td> -->
			<!-- 		</tr> -->


<!-- 		</table> -->
	</div>
	
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
	<div align="left" class="container">
	<h1>Izmena naziva jedinice mere</h1>
	
<%-- 	<form:form action="saveAutor" method="post" modelAttribute="j"> --%>
		<table  align="center"   width: 80%;  cellpadding="5" class="table table-bordered">
		<tr>
			<th class="table-info">ID</th>
			<th class="table-info">Naziv JM</th>

		</tr>
		<c:forEach items="${jediniceMere}" var="j">
			<tr>
				<td  class="table-light">${j.id}</td>
				
				<td id="nazivjm"  class="table-light">${j.naziv} </td>

<%-- 					<td id="nazivjm"  class="table-light"><form:input path="naziv" class="form-control-sm" /></td> --%>
				
			<td align="center">
			
	
				<button onclick="window.location.href='updateNazivJM?id=${j.id}&naziv=${j.naziv}'" type="button" class="btn btn-info">Izmeni</button>
<!-- 				<input type="submit" value="Zapamti izmene" class="btn btn-primary">&nbsp; -->
			</td>
			</tr>
		</c:forEach>
		

	</table>
<%-- 	</form:form> --%>
	
	
	
	
	
	
	
	
	</div>
		
</body>
</html>