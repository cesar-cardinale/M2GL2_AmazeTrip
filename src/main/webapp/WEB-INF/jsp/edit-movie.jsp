<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="movies" value="/movies" />

<div class="container">
	<h1>Modifier un film</h1>

	<form:form method="post" modelAttribute="movie" enctype="multipart/form-data">

		<div class="form-group">
			<label>Nom :</label>
			<form:input path="name" cssClass="form-control"
				cssErrorClass="form-control is-invalid" />
			<form:errors path="name" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group">
			<label>Ann�e :</label>
			<form:input path="year" cssClass="form-control"
				cssErrorClass="form-control is-invalid" />
			<form:errors path="year" cssClass="alert alert-warning" element="div" />
		</div>
		<div class="form-group">
			<label>Description :</label>
			<form:textarea path="description" rows="10" cols="50"
				cssClass="form-control" cssErrorClass="form-control is-invalid" />
			<form:errors path="description" cssClass="alert alert-warning"
				element="div" />
		</div>
		<div class="form-group">
			<label>Image :</label>
			<form:input path="file" type="file" rows="10" cols="50"
						   cssClass="form-control" cssErrorClass="form-control is-invalid" />
			<form:errors path="file" cssClass="alert alert-warning"
						 element="div" />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Enregistrer</button>
			<a class="btn btn-primary" href="${movies}">Annuler</a>
		</div>
	</form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
