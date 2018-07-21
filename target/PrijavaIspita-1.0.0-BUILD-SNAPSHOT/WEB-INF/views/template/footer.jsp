<%-- 
    Document   : footer
    Created on : Jun 24, 2018, 10:30:47 AM
    Author     : Marija
--%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Footer -->
<footer class="page-footer font-small blue pt-4 mt-4"
	style="background-color: #a70532; color: white;">

	<div class="container-fluid text-center">

		<h5 class="text-uppercase">Univerzitet Metropolitan možete pratiti putem
			linkova:</h5>

		<ul class="list-unstyled">

			<a href="https://www.facebook.com/UniverzitetMetropolitan/"
				class="fa fa-facebook btn btn-rounded"></a>
			<a href="https://www.twitter.com"
				class="fa fa-twitter btn btn-rounded"></a>
			<a href="https://www.instagram.com"
				class="fa fa-instagram btn btn-rounded "></a>
			<a href="https://www.youtube.com"
				class="fa fa-youtube btn btn-rounded"></a>

		</ul>
	</div>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<ul class="list-unstyled list-inline text-center py-2">
			<li class="list-inline-item">
				<h5 class="mb-1">Registrujte se besplatno</h5>
			</li>
			<li class="list-inline-item"><a
				href="<c:url value="/registracija"/>"
				class="btn btn-info btn-rounded">Registracija!</a></li>
		</ul>
	</c:if>
	<hr>
	<div class="footer-copyright text-center py-3"
		style="background-color: #a70532; color: whitesmoke;">
		© 2018 Metropolitan: <a href="<c:url value="http://www.metropolitan.ac.rs/"/>"> Univerzitet Metropolitan</a>
	</div>

</footer>

<style>
.fa {
	padding: 10px;
	font-size: 30px;
	width: 50px;
	text-align: center;
	text-decoration: none;
}

.fa-facebook {
	background: #3B5998;
	color: white;
}

.fa-twitter {
	background: #55ACEE;
	color: white;
}

.fa-instagram {
	background: #125688;
	color: white;
}

.fa-youtube {
	background: #bb0000;
	color: white;
}
</style>

</body>
</html>