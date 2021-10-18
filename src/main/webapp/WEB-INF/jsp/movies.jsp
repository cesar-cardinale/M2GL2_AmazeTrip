<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<h1>Liste des films ${sessionScope.isBefore2000?'avant 2000':''}</h1>

	<c:url var="movieAction" value="/movie" />
	<c:url var="movieActionDelete" value="/delete-movie" />
	<c:url var="addMovie" value="/add-movie" />
	<p>
		<a class="btn btn-primary btn-sm" href="${addMovie}">Ajouter un film</a>
	</p>
	<table class="table">
		<tr>
			<th>Nom</th>
			<th>Année</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="movie" items="${movies}">
			<tr>
				<td>${movie.name}</td>
				<td>${movie.year}</td>
				<td>
					<a class="btn btn-primary btn-sm" href="${movieAction}" onclick="<c:set var="movie" value="${movie}" scope="session"/>">Montrer</a>
					<a class="btn btn-primary btn-sm" href="${movieActionDelete}/${movie.id}">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<c:url var="before2000" value="${sessionScope.isBefore2000?'/movies':'/movies/before/2000'}" />
	<p>
		<a class="btn btn-primary btn-sm" href="${before2000}">${sessionScope.isBefore2000?'Tous les films':'Filtrer les films anciens (avant 2000)'}</a>
	</p>

	<c:url var="logout" value="/logout" />
	<p>
		<a class="btn btn-danger btn-sm" href="${logout}">Se déconnecter</a>
	</p>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
