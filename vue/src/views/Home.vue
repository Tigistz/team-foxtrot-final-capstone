<template>

   <main>


     <div class="slogan">
    <h1>Explore books and create custom reading lists. For free.</h1>
</div>


<div class="context">
<h5>Foxtrot Book Library allows you to search a world class collection,build your own reading lists, </h5>
<h5>and even add your own books.We help you figure out what to read next and serve as your virtual book shelf.</h5>
</div>

     <img 
    src="../assets/Fox-Logo.png"
    class="image-Two" 
    /> 


    
   <router-link class="have" :to="{ name: 'search' }">
 <button type="submit" class="button">Journey Starts Here</button>
</router-link>

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


<style>

 * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;

}

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
  padding: 25px;

  /* background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.25), rgba(0, 0, 0, 0.75)); */
}


.image-Two {
  display:grid;
  width:300px;
  margin-left: 20%;
  margin-top:0%;

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
  font-size: 20px;
  margin: 4px 2px;
  opacity: 0.6;
  transition: 0.1s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  border-radius: 250px;
}

.button:hover {opacity: 1}



</style>
