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
		<h1>Unos stavke</h1>


		<br> <br>


		<form:form action="saveStavka" method="post"
			modelAttribute="stavka"> 
			<table border="0" cellpadding="5">
			
			<tr>
				<td>ID NARUDZBINE :</td>
				<td><form:input  path="idNar" class="form-control-sm" readonly="true"/></td> </tr>
<%-- 				<td><form:input path="kolicina" class="form-control-sm" /></td> --%>
				<tr>
					<td>Vrsta proizvoda:</td>
					<td><select name="proizvod.vrstaProizvoda.ident" path="proizvod.vrstaProizvoda.ident">
							<c:forEach items="${vrsteProizvoda}" var="vp">
								<option value="${vp.ident}">${vp.naziv}</option>
							</c:forEach>
					</select></td>
					
				</tr>
<!-- 				<tr> -->
<!-- 					<td>Jedinica mere:</td> -->
<!-- 					<td><select name="jedinicaMere.id" path="jedinicaMere.id" > -->
<%-- 							<c:forEach items="${jediniceMere}" var="jm"> --%>
<%-- 								<option value="${jm.id}">${jm.naziv}</option> --%>
<%-- 							</c:forEach> --%>
<!-- 					</select></td> -->
					
<!-- 				</tr> -->
						<td>Kolicina :</td>
							<td><form:input path="kolicina" class="form-control-sm" /></td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td>Kupovna cena:</td> -->
<%-- 							<td><form:input path="cenaKupovna" class="form-control-sm" required = "true"/></td> --%>
<!-- 						</tr> -->
				
		
			
					<td colspan="3" align="center"><input type="submit"
						value="Dodaj" class="btn btn-primary">&nbsp;&nbsp;</td>

				</tr>
			</table>
		</form:form>

	</div>
	
	<div align="left" class="container">
	<h1>STavke narudzbine</h1>

		<c:if test="${not empty message}">
						<div class="alert alert-warning ">${message}</div>
					</c:if>
	
	<table  align="center"   width: 80%;  cellpadding="5" class="table table-bordered">
		<tr>
			
			<th class="table-info">ID Stavke</th>
			<th class="table-info">Kolicina</th>
			<th class="table-info">Proizvod</th>
			<th class="table-info">ID JM</th>
		
			

		</tr>
		<c:forEach items="${nar.stavke}" var="s">
			<tr>
				<td  class="table-light">${s.id}</td>
				<td   class="table-light">${s.kolicina}</td>
				<td   class="table-light">${s.proizvod.vrstaProizvoda.naziv}</td>
				<td class="table-light">${s.proizvod.jedinicaMere.id}</td>
				
			 

			<td align="center">
			
	<button onclick="window.location.href='deleteStavka?id=${s.id}'" type="button" class="btn btn-info">Obrisi stavku  </button> 
<%-- 	<button onclick="window.location.href='stavke?id=${n.id}'" type="button" class="btn btn-info">Stavke  </button>  --%>
		
<!-- 			<input name="idZaUpdate" type="text" id="idZaUpdate" />  -->
			
			
								
			
			
			
			
			</td>
			</tr>
		</c:forEach>
		

	</table>
	</div>
<!-- 	<div align="left" class="container"> -->
<!-- 	<h1>Radnici</h1> -->
	
<%-- <%-- 	<form:form action="saveAutor" method="post" modelAttribute="j"> --%> --%>
<!-- 		<table  align="center"   width: 80%;  cellpadding="5" class="table table-bordered"> -->
<!-- 		<tr> -->
<!-- 			<th class="table-info">ID:</th> -->
<!-- 			<th class="table-info">Ime:</th> -->
<!-- 			<th class="table-info">Prezime:</th> -->
<!-- 			<th class="table-info">JMBG:</th> -->

<!-- 		</tr> -->
<%-- 		<c:forEach items="${radnici}" var="r"> --%>
<!-- 			<tr> -->
<%-- 				<td  class="table-light">${r.id}</td> --%>
				
<%-- 				<td   class="table-light">${r.imePrezime.ime} </td> --%>
<%-- 				<td   class="table-light">${r.imePrezime.prezime} </td> --%>
<%-- 				<td   class="table-light">${r.jmbg} </td> --%>

				
<!-- 			<td align="center"> -->
			
	
<%-- 				<button onclick="window.location.href='updateRadnik?id=${r.id}'" type="button" class="btn btn-info">Izmeni</button> --%>
<!-- <!-- 				<input type="submit" value="Zapamti izmene" class="btn btn-primary">&nbsp; --> -->
<!-- 			</td> -->
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
		

<!-- 	</table> -->
<%-- 	</form:form> --%>
	
	
	
	
	
	
	
	
	</div>
		
</body>
</html>