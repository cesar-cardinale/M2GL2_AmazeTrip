<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
    <div class="container">
        <h1>Profil de l'utilisateur</h1>
        <img src="/images/avatar.jpg" width="160" height="160"/>
        <table class="table">
            <tr>
                <th>Nom :</th>
                <td>${profil.lastname}</td>
            </tr>
            <tr>
                <th>Prénom :</th>
                <td>${profil.firstname}</td>
            </tr>
            <tr>
                <th>Email :</th>
                <td>${profil.email}</td>
                <td></td>
            </tr>
        </table>
    </div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
