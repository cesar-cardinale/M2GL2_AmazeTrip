<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="appPlace" value="/appPlace.js" />

<div id="applicationPlace">
    <div class="container">
        <div v-if="(comments == null)">
        <div class="row">
            <div class="col-12 gy-5">
                <h1>Liste des lieux </h1>
            </div>
        </div>
        <button type="button"  v-on:click="newPlace = {}" class="btn btn-primary">Ajouter lieu</button>
        <div class="row">
            <div class="col-12 gy-1">
                <table class="table">
                    <tr>
                        <th>Nom lieu</th>
                        <th>Nb commentaires</th>
                        <th>Action</th>
                    </tr>
                    <tr v-for="place in places">
                        <td>{{place['name']}}</td>
                        <td>1</td>
                        <td><a href="#" v-on:click="displayDetails(place['id'])">Voir</a></td>
                    </tr>
                </table>
            </div>
        </div>
        </div>
        <div class="row"  v-if="(comments != null)">
            <%@ include file="/WEB-INF/jsp/place-comments.jsp"%>
        </div>
        <div v-if="(newPlace != null)">
            <%@ include file="/WEB-INF/jsp/add-place.jsp"%>
        </div>
    </div>
</div>
<script src="${appPlace}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
