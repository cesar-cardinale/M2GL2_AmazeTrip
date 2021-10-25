<div class="row">
    <div class="col-12 gy-5">
        <h1>Liste des commentaires pour {{placeToDisplay['name']}} </h1>
        <button type="button" class="btn btn-primary" v-on:click="newComment = {}">Ajouter commentaire</button>
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
<div class="row" v-if="newComment!=null">
    <%@ include file="/WEB-INF/jsp/add-place-comment.jsp"%>
</div>
