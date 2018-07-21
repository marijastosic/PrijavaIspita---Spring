<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="template/header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Import ceo za javu skript -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!---------------------------------------------------------------------------------------------------------------->
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1 style="font: 40px;">Prijava ispita</h1>

			<p class="lead">Molimo Vas pažljivo pristupite prijavi ispita!</p>
<hr>
<h3>Dostupni ispiti za prijavu</h3>
			<table class="table table-hover table-striped">
				<thead>
					<th>Predmet</th>
					<th>Datum</th>
					<th>Vreme</th>
					<th>Prijava</th>
				</thead>
				<tbody>
					<c:forEach items="${ispiti}" var="ispit">
						<tr>
							<td>${ispit.predmetId.naziv} - ${ispit.predmetId.espb} ESPB</td>
							<td>${ispit.datumString}</td>
							<td>${ispit.vreme}</td>
							<td><a href="<c:url value="/prijavaIspita/${ispit.id}"/>">Prijavi ispit</a></td>
							
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<hr>
			<h3>Prijavljeni ispiti</h3>
			
			<table class="table table-hover table-striped">
				<thead>
					<th>Predmet</th>
					<th>Datum</th>
					<th>Vreme</th>
					<th>Odjava</th>
				</thead>
				<tbody>
					<c:forEach items="${prijavljeniIspiti}" var="prijavljenIspit">
						<tr>
							<td>${prijavljenIspit.terminIspitaId.predmetId.naziv} - ${prijavljenIspit.terminIspitaId.predmetId.espb} ESPB</td>
							<td>${prijavljenIspit.terminIspitaId.datumString}</td>
							<td>${prijavljenIspit.terminIspitaId.vreme}</td>
							<td><a href="<c:url value="/odjavaIspita/${prijavljenIspit.id}"/>">Odjavi ispit</a></td>
							
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
		<br />

	</div>
</div>

<br />
<br />
<script>
	function myFunction() {
		var txt;
		if (confirm("Pica je uspešno dodata u korpu")) {
			txt = "You pressed OK!";
		} else {
			txt = "You pressed Cancel!";
		}
		//document.getElementById("demo").innerHTML = txt;
	}
</script>
<%@include file="template/footer.jsp"%>