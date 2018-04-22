<template>

    <div class="center">
        <h2>Añadir película</h2>
        <hr></hr>
        <form  @submit.prevent="sendData">
            <label for="nombre">
                Título:
            </label>
            <input id="nombre"  type="text" v-model="film.firstName"   required /><br>
            <hr></hr>
            <button type="submit" class="button"
            >Agregar película</button>
        </form>

        <div class="isa_info">
            <i class="fa fa-info-circle"></i>
            Ingrese el nombre y descripción de la película según corresponda.
        </div>

        <div v-if="submitted">
            <h2>¡Película añadida!</h2>
            <div class="isa_success">
                <i class="fa fa-check"></i>
                La película ha sido añadida exitosamente.
            </div>
            <!--Añadir otro actor
            <button class="button" v-on:click="refresh">Agregar otro actor</button>-->
        </div>

        <div v-if="error">
            <h2>¡Error!</h2>
            <div class="isa_error">
                <i class="fa fa-times"></i>
                No se pudo añadir la película.
            </div>
            <!--Añadir otro actor
            <button class="button" v-on:click="refresh">Agregar otro actor</button>-->
        </div>


    </div>
</template>


<script>
    export default {
        data(){
            //Datos objeto actor
            return{
                film:{
                    firstName:''
                },
                submitted: false,
                error:false
            }
        },

        methods:{
            //Metodo para agregar actores

            sendData() {
                console.log("llego aca");
                this.$http.post('http://localhost:8081/films/create', this.film).then((response) => {
                    this.film.firstName='';
                    this.submitted=true;
                    this.error=false;
                }, (response) => {
                    this.error=true;
                });
            }
        },

    }
</script>