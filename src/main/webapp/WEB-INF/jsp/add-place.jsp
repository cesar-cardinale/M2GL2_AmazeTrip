<form id="app" method="post" novalidate="true">

    <div class="form-group">
        <label>Nom :</label>
        <input v-model="newPlace.name" class="form-control"
               v-bind:class="{'is-invalid':errors.name}" />
        <div v-if="(errors.name)" class="alert alert-warning">
            {{errors.name}}
        </div>
    </div>
    <div class="form-group">
        <button v-on:click.prevent="submitPlace()" class="btn btn-primary">
            Valider</button>
        <button v-on:click="listPlace()" class="btn btn-primary">
            Annuler</button>
    </div>
</form>