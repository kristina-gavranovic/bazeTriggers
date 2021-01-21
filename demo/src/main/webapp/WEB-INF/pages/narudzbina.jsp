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
<script type="text/javascript">
var idZaUpdate=document.getElementById("idUpdate").value;
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body style="background-color: #ebc8dc;">
<!-- 	<div  align="center" class="container"> -->
<!-- 		<br> -->
<!-- 		<h1>Unos proizvoda</h1> -->


<!-- 		<br> <br> -->


<%-- 		<form:form action="saveProizvod" method="post" --%>
<%-- 			modelAttribute="proizvod"> --%>
<!-- 			<table border="0" cellpadding="5"> -->

<!-- 				<tr> -->
<!-- 					<td>Vrsta proizvoda:</td> -->
<!-- 					<td><select name="vrstaProizvoda.ident" path="vrstaProizvoda.ident"> -->
<%-- 							<c:forEach items="${vrsteProizvoda}" var="vp"> --%>
<%-- 								<option value="${vp.ident}">${vp.naziv}</option> --%>
<%-- 							</c:forEach> --%>
<!-- 					</select></td> -->
					
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>Jedinica mere:</td> -->
<!-- 					<td><select name="jedinicaMere.id" path="jedinicaMere.id" > -->
<%-- 							<c:forEach items="${jediniceMere}" var="jm"> --%>
<%-- 								<option value="${jm.id}">${jm.naziv}</option> --%>
<%-- 							</c:forEach> --%>
<!-- 					</select></td> -->
					
<!-- 				</tr> -->
<!-- 						<td>Stanje zaliha :</td> -->
<%-- 							<td><form:input path="stanjeZalihe" class="form-control-sm" /></td> --%>
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Kupovna cena:</td> -->
<%-- 							<td><form:input path="cenaKupovna" class="form-control-sm" required = "true"/></td> --%>
<!-- 						</tr> -->
				
		
			
<!-- 					<td colspan="3" align="center"><input type="submit" -->
<!-- 						value="Sacuvaj" class="btn btn-primary">&nbsp;&nbsp;</td> -->

<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 		</form:form> --%>

<!-- 	</div> -->
	
	<div align="left" class="container">
	<h1>Narudzbine</h1>

		<c:if test="${not empty message}">
						<div class="alert alert-warning ">${message}</div>
					</c:if>
	
	<table  align="center"   width: 80%;  cellpadding="5" class="table table-bordered">
		<tr>
			<th class="table-info">ID</th>
			<th class="table-info">Datum</th>
			<th class="table-info">Dostava</th>
			<th class="table-info">Rok isporuke</th>
			<th class="table-info">Napomena</th>
			<th class="table-info">PIB Dobavljac</th>
			<th class="table-info">PIB Prevoznik</th>
			<th class="table-info">ID Radnik</th>
			<th class="table-info">Ime radnika</th>
			<th class="table-info">Prezime radnika</th>
			

		</tr>
		<c:forEach items="${narudzbine}" var="n">
			<tr>
				<td  class="table-light">${n.id}</td>
				<td   class="table-light">${n.datum}</td>
				<td   class="table-light">${n.dostava}</td>
				<td class="table-light">${n.rokIsporuke}</td>
				<td  class="table-light">${n.napomena}</td>
				<td  class="table-light">${n.dobavljac.pib}</td>
				<td  class="table-light">${n.prevoznik.pib}</td>
				<td  class="table-light">${n.radnik.id}</td>
				<td  class="table-light">${n.imePrezime.ime}</td>
				<td  class="table-light">${n.imePrezime.prezime}</td>
			 

			<td align="center">
			
		<button onclick="window.location.href='updateNar?id=${n.id}'" type="button" class="btn btn-info">Izmeni  </button>
		
<!-- 			<input name="idZaUpdate" type="text" id="idZaUpdate" /> -->
			
			
								
			
			
			
			
			</td>
			</tr>
		</c:forEach>
		

	</table>
	</div>
	<div align="left" class="container">
	<h1>Radnici</h1>
	
<%-- 	<form:form action="saveAutor" method="post" modelAttribute="j"> --%>
		<table  align="center"   width: 80%;  cellpadding="5" class="table table-bordered">
		<tr>
			<th class="table-info">ID:</th>
			<th class="table-info">Ime:</th>
			<th class="table-info">Prezime:</th>
			<th class="table-info">JMBG:</th>

		</tr>
		<c:forEach items="${radnici}" var="r">
			<tr>
				<td  class="table-light">${r.id}</td>
				
				<td   class="table-light">${r.imePrezime.ime} </td>
				<td   class="table-light">${r.imePrezime.prezime} </td>
				<td   class="table-light">${r.jmbg} </td>

				
			<td align="center">
			
	
				<button onclick="window.location.href='updateRadnik?id=${r.id}'" type="button" class="btn btn-info">Izmeni</button>
<!-- 				<input type="submit" value="Zapamti izmene" class="btn btn-primary">&nbsp; -->
			</td>
			</tr>
		</c:forEach>
		

	</table>
<%-- 	</form:form> --%>
	
	
	
	
	
	
	
	
	</div>
		
</body>
</html>