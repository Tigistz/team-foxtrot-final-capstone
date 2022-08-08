<<<<<<< HEAD



<template>
=======
<!--<template>
>>>>>>> 484a502d2c16d2ce40b4e2c36bad2744bc6936c3
  <div id="app">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
    <the-header />
    <router-view />
    <the-footer />
  </div>


</template> -->


<template>
  <!-- <v-app class="app">
    <v-main :class="this.$route.meta.homePage ? 'homepage' : 'grey lighten-4'">
      <Navbar v-if="!this.$route.meta.hideNavigation" class="mx-4" />
      <v-container :class="{ 'mx-5': !this.$route.meta.homePage }">
        <router-view></router-view>
      </v-container>
    </v-main>
  </v-app> -->

  <div>
    <router-view></router-view>
  </div>  
</template>

<<<<<<< HEAD
<script>

  import TheHeader from './components/TheHeader.vue';
  import TheFooter from './components/TheFooter.vue';

  export default {

       name: 'App',
       components: {
         TheHeader,
         TheFooter
       }
  }


</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

router-vue {
  display:flex;
  justify-content: center;
  flex-direction: column;
}

=======

<script>

export default {
  name: "App",
  components: {
  },
};
</script>

<style scoped>
>>>>>>> 484a502d2c16d2ce40b4e2c36bad2744bc6936c3
</style>



