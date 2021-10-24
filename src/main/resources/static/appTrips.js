const appTrips = {

    // Préparation des données
    data() {
        console.log("data");
        return {
            counter: 1,
            message: "Hello",
            list: [10, 20, 30],
            axios: null,
            trips: [],
            searchPlace: "",
            placesOfNewTrip: [],
        }
    },

    // Mise en place de l'application
    mounted() {
        console.log("Mounted ");
        this.axios = axios.create({
            baseURL: 'http://localhost:8081/amazetrip/api',
            timeout: 1000,
            headers: {'Content-Type': 'application/json'},
        });
        this.axios.get('/trips').then(r => {
            this.trips = r.data;
        }).catch(function (error) {
            console.log(error);
        }).then(function () {
            console.log(this.trips)
        });
        /*
        for (const place in this.places){
            this.axios.get('/place/'+ place['id'] +'/comments/number').then(r=>{
                this.nbCommentsPerPlace[place['id']] = r.data;
                console.log(this.nbCommentsPerPlace[place['id']]);
            })
        }/*/
    },

    methods: {
        search: function () {
            if (this.searchPlace ==="")
                return
            this.axios.get('/searchtrips/' + this.searchPlace).then(r => {
                this.trips = r.data;
            });
        },
        auteur: function (trip) {
            if (trip.user === null)
                return "Anonyme";
            else
                return trip.user.firstname;
        },
        displayDetailsByName: function (namePlace) {
            this.axios.get('/placebyname/' + namePlace).then(r => {
                this.placeToDisplay = r.data;
            });

            // Place pour les futures méthodes
        },
        showDetails: function (trip) {
            var trajet = trip.places.at(0).name;
            for (let i = 1; i < trip.places.length; i++) {
                trajet= trajet+ " - " +trip.places.at(i).name
            }
            return trajet
            // Place pour les futures méthodes
        },
        addNewTrip: function (){
            console.log("pouloulou")

           /* this.axios.put('/newTrip/',this.newTrip.depart).then(r => {
                //this.trips = r.data;
            });*/
        }
    }
}
Vue.createApp(appTrips).mount('#appTrips');