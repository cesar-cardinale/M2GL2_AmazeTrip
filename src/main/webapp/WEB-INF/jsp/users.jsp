<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-12 gy-5">
            <h1>Liste des utilisateurs</h1>
        </div>
    </div>
    <c:url var="userProfil" value="/profil" />
    <div class="row">
        <div class="col-12 gy-1">
            <table class="table">
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Profil</th>
                </tr>
                <c:forEach var="profil" items="${users}">
                    <tr>
                        <td>${profil.lastname}</td>
                        <td>${profil.firstname}</td>
                        <td>
                            <a class="btn btn-primary btn-sm" href="${userProfil}/${profil.id}">Voir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>