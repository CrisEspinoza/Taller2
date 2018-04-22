<template>

    <div class="center">
        <h2>Actor:</h2>
        <select v-model="aux">
            <option v-for="r,j in users">
                {{ r.firstName }}
            </option>
        </select>
        <h2> Asociar a la pelicula: </h2>
        <select>
            <option v-for="m , i in movies">
                {{m.firstName}}
            </option>
        </select>
        <h1></h1>

        <button class="button" @click=sendData(j,i)>+</button>

    </div>


</template>

<script>

    export default {
        data() {
            return {
                users: [],
                film: [],
                f: 0,
                alert: true,
                title: 'Lista peliculas',
                movies: [],
                actors: [],
                submitted: false,
                error: false,
                aux: []
            }
        },

        mounted: function () {

            // GET /someUrl
            this.$http.get('http://localhost:8081/actors')
                .then(response=> {
                // get body data
                this.users = response.body;
            console.log('users', this.users);
            },
            response =>
            {// error callback
                console.log('error cargando lista');
            }
        );

            this.$http.get('http://localhost:8081/films')
                .then(response=> {
                this.movies = response.body;
            console.log('movies', this.movies)
        },
            response =>
            {// error callback
                console.log('Error cargando lista de peliculas');
            }
        );

        },

        methods:{

            findFilms(value){
                console.log(value);
                this.$http.get('http://localhost:8081/actors/'+value+'/films')
                    .then(response=>{
                    //get films from actor
                    this.film = response.body;
                console.log(this.film)
                console.log('películas leídas')

            },response => {
                    console.log('error leyendo peliculas');
                });
            },

            findActors(value){
                console.log(value);
                this.$http.get('http://localhost:8081/films/'+value+'/actors')
                    .then(response=>{
                    //get films from actor
                    this.actors = response.body;
            },response => {
                    console.log('error leyendo peliculas');
                });
            },

            sendData (value,value1) {
                console.log( value );
                /*this.$http.post('http://localhost:8081/actors/create', this.actor).then((response) => {
            }, (response) => {
                    this.error=true;
                };
            }*/
            }
        }
    }
</script>

<style scoped>

</style>