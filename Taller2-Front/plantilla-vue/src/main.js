import Vue from 'vue';
import VueRouter from 'vue-router';
import Index from './Index.vue';
import Actors from './Actors.vue';
import addActors from './addActors.vue';
import addMovie from  './addMovie.vue';
import viewMovies from './viewMovies.vue';
import VueResource from 'vue-resource';
require("./style.scss");

import App from './App.vue';
Vue.use(VueRouter);
Vue.use(VueResource);

const routes = [
  { path: '/index', alias: '/', component: Index},
  { path:'/actors', component: Actors},
  { path:'/addActors', component: addActors},
    { path: '/viewMovies', component: viewMovies},
    { path: '/addMovie', component: addMovie}
]

// Create the router instance and pass the `routes` option
const router = new VueRouter({
  routes
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)

})


