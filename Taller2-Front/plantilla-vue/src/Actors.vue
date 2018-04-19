<template>
  <div class="center">
    <h2>{{title}}</h2>
    <ul class="user-list">
      <li v-for="u,i in users">
        <img :src="'https://robohash.org/'+i+'?size=50x50'" />
        <span>{{u.firstName}} {{u.lastName}}</span>
        <span class="date">{{Date(u.lastUpdate)}}</span>
        
        <button @click=findFilms(u.id)>Ver películas</button>


      </li>
    </ul>
  </div>
</template>


<script>
export default {
  data(){
    return{
      title:'Actores',
      users:[],
      film:[],
      f:0
    }
  },
  mounted:function(){
    console.log('Index.vue');

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
        console.log('películas leídas')
        console.log(JSON.stringify(this.film, null, 2))

      },response => {
        console.log('error leyendo peliculas');
      });
    }
  }
}
</script>
