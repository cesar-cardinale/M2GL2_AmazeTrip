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
            <div class="row">
                <div class="col-12 gy-5">
                    <h1>Liste des commentaires pour {{placeToDisplay['name']}} </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12 gy-1">
                    <table class="table">
                        <tr>
                            <th>Nom utilisateur</th>
                            <th>Commentaire</th>
                            <th>Date creation</th>
                        </tr>
                        <tr v-for="com in comments">
                            <td>{{com['user']['firstname']}}</td>
                            <td>{{com['commentText']}}</td>
                            <td>{{com['creationDate']}}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div v-if="(newPlace != null)">

            <form id="app" method="post" novalidate="true">

                <div class="form-group">
                    <label>Nom :</label>
                    <input v-model="newPlace.name" class="form-control"/>
                </div>
                <div class="form-group">
                    <button v-on:click.prevent="submitPlace()" class="btn btn-primary">
                        Valider</button>
                    <button v-on:click="newPlace = null" class="btn btn-primary">
                        Annuler</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script src="${appPlace}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
