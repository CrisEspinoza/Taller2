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
        <a href="#/FilmWithActor">Asociar pelicula con un actor</a>
        <a href="#/ActorWithFilm">Asociar actor con una pelicula</a>
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
