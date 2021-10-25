<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:url var="vue_js" value="/webjars/vue/3.2.19/dist/vue.global.js" />
<c:url var="axios_js" value="/webjars/axios/0.22.0/dist/axios.min.js" />
<c:url var="bootstrap_css"
	   value="/webjars/bootstrap/5.1.2/css/bootstrap.min.css" />
<c:url var="bootstrap_js"
	   value="/webjars/bootstrap/5.1.2/js/bootstrap.min.js" />
<c:url var="jquery_js" value="/webjars/jquery/3.5.1/jquery.min.js" />
<c:url var="css" value="/style.css" />
<c:url var="login" value="/login"/>
<c:url var="logout" value="/logout"/>
<c:url var="register" value="/app/users/create"/>

<html>
<head>
	<meta charset="UTF-8">
	<title>Amaze Trip Application</title>
	<link rel="stylesheet" href="${css}">
	<link rel="stylesheet" href="${bootstrap_css}">
	<script src="${jquery_js}"></script>
	<script src="${bootstrap_js}"></script>
	<script src="${vue_js}"></script>
	<script src="${axios_js}"></script>
</head>
<body>
<c:url var="main" value="/" />
<c:url var="places" value="/" />
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="${main}">
			<div class="logo"></div>
		</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link active" href="${main}">Trajets</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/app/places">Lieux</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/app/users">Users</a>
				</li>
        <sec:authorize access="isAuthenticated()">
				<li class="nav-item">
					<a class="nav-link" href="/app/newtrip">Nouveau Trajet</a>
        </li>

        </sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="nav-item">
						<a class="nav-link" href="/app/profil">Profil</a>
					</li>
				</sec:authorize>
				<li class="nav-item">
					<a class="nav-link" href="/app/users">Users</a>
				</li>
				<li>
					<sec:authorize access="!isAuthenticated()">
						<a class="btn btn-primary" href="${login}">Se connecter</a>
						<a class="btn btn-primary" href="${register}">Inscription</a>
					</sec:authorize>
				</li>
				<li>
					<sec:authorize access="isAuthenticated()">
						<a class="btn btn-primary" href="${logout}">Deconnexion</a>
					</sec:authorize>
        </li>


			</ul>
		</div>
	</div>
</nav>
<div class="container">
