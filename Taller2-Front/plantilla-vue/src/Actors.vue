<template>

  <div class="center">
    <h2>Actores:</h2>
    <ul class="user-list">
      <li v-for="u,i in users">
        <img :src="'https://robohash.org/'+i+'?size=50x50'" />
        <span>{{u.id}}.-  {{u.firstName}} {{u.lastName}}</span>
        <hr>
           <button class="button_miau" @click=findFilms(u.id)>+</button>
      </li>
           <ul class="user-list">
            <li v-for="pelicula in film">
              <div class="isa_info"> <i class="fa fa-info-circle"></i>{{pelicula.firstName}}
              </div>

            </li>
           </ul>
    </ul>
  </div>


</template>


<script>



export default {
  data(){
    return{
      users:[],
      film:[],
      f:0,
        alert: true
    }
  },
  mounted:function(){

    // GET /someUrl
    this.$http.get('http://localhost:8081/actors')
    .then(response=>{
      // get body data
      this.users = response.body;
      console.log('users',this.users)
    },response=>{
      // error callback
      console.log('error cargando lista');
    })
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
    }
  }
}
</script>
