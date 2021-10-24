<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v-on" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="appTrips" value="/AppTrips.js" />



<div v-if="editable">
    <form id="app">

        <div class="form-group">
            <label>Lieu de depart :</label>
            <input v-model="placesOfNewTrip[0]" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Lieu d'arivee :</label>
            <input v-model="placesOfNewTrip[1]" class="form-control"/>
        </div>
        <div class="form-group">
            <button v-on:click="addNewTrip()" class="btn btn-primary">
                Save</button>
        </div>
    </form>
</div>
<script src="${appTrips}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
