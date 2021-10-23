<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="accountApp" value="/account.js" />

<div class="container">
    <h1>Sign Up</h1>

    <div>
        <form id="accountApp" method="post" novalidate="true">

            <div class="form-group">
                <label>Firstname :</label>
                <input v-model="newAccount.firstname" class="form-control"
                       v-bind:class="{'is-invalid':errors.firstname}" />
                <div v-if="(errors.firstname)" class="alert alert-warning">
                    {{errors.firstname}}
                </div>
            </div>
            <div class="form-group">
                <label>Lastname :</label>
                <input v-model="newAccount.lastname" class="form-control"
                       v-bind:class="{'is-invalid':errors.lastname}" />
                <div v-if="(errors.lastname)" class="alert alert-warning">
                    {{errors.lastname}}
                </div>
            </div>
            <div class="form-group">
                <label>Email :</label>
                <input v-model="newAccount.email" class="form-control"
                       v-bind:class="{'is-invalid':errors.email}" />
                <div v-if="(errors.email)" class="alert alert-warning">
                    {{errors.email}}
                </div>
            </div>
            <div class="form-group">
                <label>Email :</label>
                <input v-model="newAccount.password" class="form-control"
                       v-bind:class="{'is-invalid':errors.password}" type="password" />
                <div v-if="(errors.password)" class="alert alert-warning">
                    {{errors.password}}
                </div>
            </div>
            <div class="form-group">
                <button v-on:click.prevent="submit()" class="btn btn-primary">
                    Signup</button>
            </div>
        </form>
    </div>
</div>

<script src="${accountApp}"></script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
