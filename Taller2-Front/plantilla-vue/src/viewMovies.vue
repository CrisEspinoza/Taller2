<template>
    <div class="center">
        <h2>{{title}}</h2>
        <ul class = "user-list">
            <li v-for="u,i in movies">
                    <img :src="'https://robohash.org/'+i+'?size=50x50'" />
                    <span>{{u.id}}.- {{u.firstName}}</span>
<hr>
            <button class="button_miau" @click=findActors(u.id)>+</button>
            </li>
            <ul class="user-list">
                <li v-for="actor in actors">
                    <div class="isa_info"> <i class="fa fa-info-circle"></i>{{actor.firstName}} {{actor.lastName}}
                    </div>

                </li>
            </ul>

        </ul>
    </div>


</template>

<script>

export default {
      data(){
        //Datos objeto peliculas
        return{
          title:'Lista peliculas',
          movies: [],
            actors: [],
          submitted: false,
          error:false
        }
      },

      mounted:function(){
        console.log('Index.vue');
        this.$http.get('http://localhost:8081/films')
            .then(response=>{
                this.movies = response.body;
                console.log('movies',this.movies)
            }, response=>{
               // error callback
               console.log('Error cargando lista de peliculas');
            })
      },

    methods:{
        findActors(value){
            console.log(value);
            this.$http.get('http://localhost:8081/films/'+value+'/actors')
                .then(response=>{
                    //get films from actor
                    this.actors = response.body;


                },response => {
                    console.log('error leyendo peliculas');
                });
        }
    }
}

</script>