const accountApp = {
    data(){
        return{
            newAccount: [],
            errors: [],
        }
    },
    mounted(){
        console.log("AccountApp mounted ");
        this.axios = axios.create({
            baseURL: 'http://localhost:8081/api/',
            timeout: 1000,
            headers: { 'Content-Type': 'application/json' },
        });
    },
    methods: {
        submit: function(){
            this.axios.get('/users/create', this.newAccount).then(r => {});
        }
    }
}

Vue.createApp(accountApp).mount('#accountApp');