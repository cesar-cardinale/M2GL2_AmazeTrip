<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="appPlace" value="/appPlace.js" />

<div id="applicationPlace">
    <div class="container">
        <div class="row">
            <div class="col-12 gy-5">
                <h1>Liste des lieux {{message}}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-12 gy-1">
                <table class="table">
                    <tr>
                        <th>Nom lieu</th>
                        <th>Nb commentaires</th>
                        <th>Action</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="${appPlace}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
