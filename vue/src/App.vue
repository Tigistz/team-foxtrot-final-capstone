<template>

  <div id="app">

    <the-header />
    <router-view />
    <!-- <the-footer /> -->
  </div>


</template>

<script>

  import TheHeader from './components/TheHeader.vue';
  // import TheFooter from './components/TheFooter.vue';

  export default {

       name: 'App',
       components: {
         TheHeader,
        //  TheFooter
       }
  }


</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

  background-image: 
  linear-gradient(to bottom, rgba(0, 0, 0, 0.05), rgba(0, 0, 0, 0.5)),
  url('./assets/background-eleven.jpg');
  background-attachment: fixed;
  background-repeat: no-repeat;
  
  background-size: cover;
  background-position: center;
  transition: 0.4s;
  /* height: 100vh; */
  
  
  /* margin-top: 60px; */
}

router-vue {
  display:flex;
  justify-content: center;
  flex-direction: column;

  
}


</style>



