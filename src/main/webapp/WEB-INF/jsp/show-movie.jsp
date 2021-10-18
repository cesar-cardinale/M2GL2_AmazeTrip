<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
	<h1>Détails d'un film</h1>

	<table class="table">
		<sec:authorize access="hasRole('ADMIN')">
			<tr>
				<th>ID :</th>
				<td>${movie.id}</td>
			</tr>
		</sec:authorize>
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
		</tr>
		<tr>
			<th>Image :</th>
			<td><img src="/image/${movie.file != null? movie.file.originalFilename : ''}"  alt="image"/></td>
		</tr>
	</table>

	<c:url var="editAction" value="/edit-movie" />
	<c:url var="moviesAction" value="/movies" />

	<p>
		<a class="btn btn-primary btn-sm" href="${editAction}/${movie.id}">Modifier</a>
		<a class="btn btn-primary btn-sm" href="${moviesAction}">Liste des films</a>
	</p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
