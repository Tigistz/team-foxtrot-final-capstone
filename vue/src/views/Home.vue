<template>

   <main>

   <div class=container>  
     <div class="slogan">
    <h1>Explore books and create custom reading lists. For free.</h1>
</div>

<div class="context">
<h4>Foxtrot Book Library allows you to search a world class collection, build your own reading lists, </h4>
<h4>and even add your own books. We help you figure out what to read next and serve as your virtual book shelf.</h4>
</div>


     <img 
    src="../assets/Fox-Logo.png"
    class="image-Two" 
    /> 


    
   <router-link class="have" :to="{ name: 'search' }">
 <button type="submit" class="button">Start Your Journey</button>
 </router-link>

 



</div>

  </main>  

  

</template>



<script>
// import BookSearch from '../components/BookSearch.vue';
export default {
  components: { 
    // BookSearch,
  },
  name: "home"
};
</script>


<style scoped>



 /* * {
  margin: 0;
   padding: 0;
  box-sizing: border-box; */

/* } */

body {
  font-family: 'montserrat', sans-serif;
}

home {
  /* background-image: url('/assets/home-page-books-image.jpg'); */
  background-size: cover;
  background-position: bottom;
  transition: 0.4s;
}



main {
  min-height: 100vh;
  /* padding: 25px; */
  display: flex;

  /* background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.25), rgba(0, 0, 0, 0.75)); */
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}


.image-Two {
  justify-content: center;
  width:320px;
  flex-direction: column;
  align-items: center;
  /* margin-left: 42%;
  margin-top:0%; */

  /* background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.), rgba(0, 0, 0, 0.8)); */
}


.slogan {
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color:white;
  display:flex;
  margin-top: 10%
}


.context {

  color:white;
}

.button {
  
  background-color:#f73e06; 
  
  /* #e75123;  */
  border: none;
  color: white;
  padding: 10px 72px;
  text-align: center;
  font-size: 2.4vh;
  margin-top: 1.5vh;
  opacity: 0.85;
  transition: 0.1s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  border-radius: 3px;
  margin-bottom: 7vh;
  
}

.button:hover {
  opacity: 0.97;
  /* transform: scale(1.01, 1.01); */
  }

h1 {
  margin-bottom: 3vh;
  text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
  font-weight: 700;
}

h4 {
  text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;

}





     
</style>