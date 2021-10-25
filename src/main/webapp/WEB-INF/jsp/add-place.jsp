<div class="row">
    <div class="col-12 gy-1">
        <form id="app" method="post" novalidate="true">

            <div class="form-group">
                <label>Nom :</label>
                <input v-model="newPlace.name" class="form-control"/>
            </div>
            <div class="form-group">
                <button v-on:click.prevent="submitPlace()" class="btn btn-primary">Valider</button>
                <button v-on:click="newPlace = null" class="btn btn-primary">Annuler</button>
            </div>
        </form>
    </div>
</div>