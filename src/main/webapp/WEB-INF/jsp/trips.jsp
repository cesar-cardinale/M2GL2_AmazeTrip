<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v-on" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="appTrips" value="/AppTrips.js" />

<div id="applicationTrips">
        <div class="container">
            <div>
                <div class="row">
                    <div class="col-12 gy-5">
                        <h1>Liste des Trajets </h1>
                    </div>
                </div>
                <br>
                <br>
                <label  for="name">Recherche</label><input v-model="searchPlace" type="text" id="name" name="name" required minlength="0" maxlength="20" size="15" placeholder="Lieu">
                <br>
                <button v-on:click="search()">search</button>
                <br>
                <br>
                <div class="row">
                    <div class="col-12 gy-1">
                        <table class="table">
                            <tr>
                                <th>Lieu depart</th>
                                <th>Parcours</th>
                                <th>Lieu arrivee</th>
                                <th>Date de publication</th>
                                <th>Auteur</th>
                            </tr>
                            <tr v-for="trip in trips">

                                <td>{{trip.places[0].name}}</td>
                                <td><div>{{showDetails(trip)}}</div></td>
                                <td>{{trip.places.at(-1).name}}</td>
                                <td>{{trip.creationDate}}</td>
                                <td>{{auteur(trip)}}</td>
                            </tr>
                        </table>
                    </div>
                </div>
        </div>
    </div>
</div>
<script src="${appTrips}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
