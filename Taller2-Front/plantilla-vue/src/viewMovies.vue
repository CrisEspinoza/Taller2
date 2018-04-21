<template>
    <div class="center">
        <h2>{{title}}</h2>
        <ul class = "movies-list">
            <li v-for="u,i in movies">
                    <img :src="'https://robohash.org/'+i+'?size=50x50'" />
                    <span>{{u.firstName}}</span>
            </li>
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
      }
}

</script>