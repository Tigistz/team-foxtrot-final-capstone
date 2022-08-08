<!--<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
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


<script>

export default {
  name: "App",
  components: {
  },
};
</script>

<style scoped>
</style>



