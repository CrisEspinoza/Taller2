<template>
  <div>
    <header>
      <div class="branding">
        <img class ="logo-small" src="./img/icono.png" />
        <span></span>
      </div>
      <nav>
        <a href="#/">Home</a>
        <a href="#/actors">Actores</a>
        <a href="#/addActors">Agregar actor</a>
        <a href="#/viewMovies">Peliculas</a>
        <a href="#/addMovie">Agregar película</a>
      </nav>
    </header>

    <main class="container">
      <router-view></router-view>
    </main>
    <footer>
    </footer>
</div>
</template>

<script>
export default {

}
</script>
