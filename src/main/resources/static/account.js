const accountApp = {
    data(){
        return{
            newAccount: {},
            errors: [],
        }
    },
    mounted(){
        console.log("AccountApp mounted ");
        this.axios = axios.create({
            baseURL: 'http://localhost:8081/amazetrip/api/',
            timeout: 1000,
            headers: { 'Content-Type': 'application/json' },
        });
    },
    methods: {
        submit: function(){
            let error = false
            if(!this.newAccount.firstname){
                this.errors.firstname = "Invalid firstname"
                error = true
            }
            if(!this.newAccount.lastname){
                this.errors.lastname = "Invalid lastname"
                error = true
            }
            if(!this.newAccount.email){
                this.errors.email = "Invalid email"
                error = true
            }
            if(!this.newAccount.password){
                this.errors.password = "Invalid password"
                error = true
            }
            if(error) return;
            this.axios.post('/users/create/', this.newAccount).then(r => {
                window.location.href = "/"
            });
        }
    }
}

Vue.createApp(accountApp).mount('#accountApp');