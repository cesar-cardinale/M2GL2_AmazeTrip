<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="movies" value="/movies" />

<div class="container">
	<h1>Supprimer un film</h1>

	<form:form method="post" modelAttribute="movie">
		<table>
			<tr>
				<th>Nom :</th>
				<td>${movie.name}</td>
			</tr>
			<tr>
				<th>Année :</th>
				<td>${movie.year}</td>
			</tr>
			<tr>
				<th>Description :</th>
				<td>${movie.description}</td>
				<td></td>
			</tr>
		</table>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Supprimer définitivement ce film</button>
			<a class="btn btn-primary" href="${movies}">Annuler</a>
		</div>
	</form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
