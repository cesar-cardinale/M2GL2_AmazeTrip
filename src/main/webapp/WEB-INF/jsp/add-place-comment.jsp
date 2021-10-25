<div class="row">
    <div class="col-12 gy-1">
        <form id="app" method="post" novalidate="true">

            <div class="form-group">
                <label>Commentaire :</label>
                <textarea v-model="newComment.commentText" class="form-control">Votre commentaire</textarea>
            </div>
            <div class="form-group">
                <button v-on:click.prevent="submitPlaceComment()" class="btn btn-primary">
                    Valider</button>
                <button v-on:click="newComment = null" class="btn btn-primary">
                    Annuler</button>
            </div>
        </form>
    </div>
</div>