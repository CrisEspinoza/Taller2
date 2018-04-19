<template>

  <div class="center">
    <h2>{{title}}</h2>
    <!--//Formulario actor nuevo-->
    <hr></hr>
    <form  @submit.prevent="sendData">
      <label for="nombre">
        Nombre:
      </label>
      <input id="nombre"  type="text" v-model="actor.firstName"   required /><br>
      <label for="apellido"><br>Apellido:</label><br>
      <input id="apellido" type="text" v-model="actor.lastName"   required /><br>
     <hr></hr>
      <button type="submit" class="button"
       >Agregar actor</button>

    </form>

    <div class="isa_info">
      <i class="fa fa-info-circle"></i>
        Ingrese su Nombre y Apellido según corresponda.
    </div>

    <div v-if="submitted">
      <h2>¡Actor añadido!</h2>
      <div class="isa_success">
           <i class="fa fa-check"></i>
           El usuario ha sido añadido exitosamente.
      </div>
      <!--Añadir otro actor
      <button class="button" v-on:click="refresh">Agregar otro actor</button>-->
    </div>

    <div v-if="error">
      <h2>¡Error!</h2>
      <div class="isa_error">
           <i class="fa fa-times"></i>
          No se pudo añadir usuario.
      </div>
      <!--Añadir otro actor
      <button class="button" v-on:click="refresh">Agregar otro actor</button>-->
    </div>

    </ul>
  </div>
</template>


<script>
export default {
  data(){
    //Datos objeto actor
    return{
      title:'Nuevo Actor',
      actor:{
        firstName:'',
        lastName:''
      },
      submitted: false,
      error:false
    }
  },

  methods:{
    //Metodo para agregar actores

    sendData() {
      console.log("llego aca");
      this.$http.post('http://localhost:8081/actors/create', this.actor).then((response) => {
         this.actor.firstName='';
         this.actor.lastName='';
         this.submitted=true;
         this.error=false;
        }, (response) => {
          this.error=true;
      });
    }
  },

}
</script>
