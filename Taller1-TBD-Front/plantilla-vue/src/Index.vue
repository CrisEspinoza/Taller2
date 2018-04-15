<template>

<div class="center">
  <h2>{{title}}</h2>
    <img class="logo-big" src="./img/usach.png" />
    <p>
    Universidad de Santiago de Chile
    </p>
</div>
</template>
<script>
export default{
  data(){
    return{
      title:'Grupo 7 - Taller 1'
    }
  },
  mounted:function(){
    console.log('Index.vue')
  }
}
</script>
