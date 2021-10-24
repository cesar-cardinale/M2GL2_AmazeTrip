const applicationPlace = {

    // Préparation des données
    data() {
        console.log("data");
        return {
            counter: 1,
            message: "Hello",
            list: [10, 20, 30],
            axios: null,
            places: [],
            nbCommentsPerPlace: {},
            placeToDisplay: null,
            comments: null,
            newPlace : null,
            newComment: null
        }
    },

    // Mise en place de l'application
    mounted() {
        console.log("Mounted ");
        this.axios = axios.create({
            baseURL: 'http://localhost:8081/amazetrip/api',
            timeout: 1000,
            headers: { 'Content-Type': 'application/json' },
        });
        this.axios.get('/places').then(r=>{
            this.places = r.data;
        }).catch(function(error){console.log(error);}).then(function(){console.log(this.places)});
        /*
        for (const place in this.places){
            this.axios.get('/place/'+ place['id'] +'/comments/number').then(r=>{
                this.nbCommentsPerPlace[place['id']] = r.data;
                console.log(this.nbCommentsPerPlace[place['id']]);
            })
        }/*/
    },

    methods: {
        displayDetails : function(idPlace){
            this.axios.get('/place/' + idPlace + '/comments').then(r=>{
                this.comments = r.data;
                });
            this.axios.get('/place/' + idPlace).then(r=>{
                this.placeToDisplay = r.data;
                });
        },

        submitPlace : function (){
            console.log(this.newPlace);
            this.axios.post('/places', this.newPlace).then(r=>{
                console.log("Ajout d'une place !");}
            ).catch(error=>{console.log(error)});
            window.location.replace("/app/places");
        }

        // Place pour les futures méthodes
    }
}

Vue.createApp(applicationPlace).mount('#applicationPlace');