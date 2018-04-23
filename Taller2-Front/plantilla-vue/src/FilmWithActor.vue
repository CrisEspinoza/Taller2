<template>

    <div class="center">
        <h2>Actor:</h2>
        <select v-model="aux">
            <option v-for="r , j in users">
                {{ r.id }}
            </option>
        </select>
        <span>Seleccionado 1: {{aux}}</span>
        <h2> Asociar a la pelicula: </h2>
        <select v-model="auxi">
            <option v-for="m , i in movies">
                {{m.id}}
            </option>
        </select>
        <span>Seleccionado 2: {{auxi}}</span>


        <button class="button" @click=sendData(aux,auxi)>+</button>
        <hr/>
        <div class="isa_info">
            <i class="fa fa-info-circle"></i>
            Seleccione las opciones que desea vincular.
        </div>

        <div v-if="submitted">
            <h2>¡Actor añadido!</h2>
            <div class="isa_success">
                <i class="fa fa-check"></i>
                La relación ha sido añadida exitosamente.
            </div>
        </div>

        <div v-if="error">
            <h2>¡Error!</h2>
            <div class="isa_error">
                <i class="fa fa-times"></i>
                No se pudo añadir la relación.
            </div>
        </div>

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
                aux: '',
                auxi: ''
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

            sendData(value, valuee) {
                this.$http.post('http://localhost:8081/films/'+valuee+'/actors/'+value).then((response) => {
                    this.submitted=true;
                    this.error=false;
                    console.log(valuee, value);
                }, (response) => {
                    this.error=true;
                    cosole.log('error');
                });
            }
        }

    }
</script>