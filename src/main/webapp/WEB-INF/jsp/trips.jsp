<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-12 gy-5">
			<h1>Liste des trajets</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-12 gy-1">
			<table class="table">
				<thead>
				<tr>
					<th>Ville de départ</th>
					<th>Ville d'arrivée</th>
					<th>Date de publication</th>
					<th>Auteur</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="trip" items="${trips}">
					<c:url var="tripView" value="/trip/${trip.id}" />
					<tr>
						<td><c:out value="${trip.places[0].name}"/></td>
						<td><c:out value="${trip.places[trip.places.size()-1].name}"/></td>
						<td><c:out value="${trip.creationDate}"/></td>
						<td><c:out value="${trip.user == null?'Anonyme':trip.user.firstname}"/></td>
						<td>
							<a class="btn btn-primary btn-sm" href="${tripView}">Voir</a>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${trips.size() == 0}"><tr><td colspan="5">Aucun trajet n'est disponnible.</td></tr></c:if>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
