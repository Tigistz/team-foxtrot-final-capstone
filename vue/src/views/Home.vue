<template>

  <!-- <main> -->
    <div class="container">
      <!-- <img 
    src="../assets/home-page-books-image.jpg"
    class="imageTwo" 
    /> -->
    
    <div class="content">
    <h1 class="top-container">Foxtrot Book Library</h1>
    <h2>Nothing is pleasanter than exploring a library.</h2>
    <p>Top 250 Most Beautiful Quotations About Libraries,
       Librar, Library and Information Science. Famous quotes
        describing why librarie and cataloging important and 
        librarians and catalogers indispensable.</p>
     
  </div>
  <router-link class="nav-link" v-bind:to="{ name: 'search'}"><button class="button">Find Your Books</button></router-link>
    </div>
  <!-- </main> -->
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
.container{
   /* background-image:url("../assets/Home-Background.jpeg");  */
  margin: 0;
   padding: 0;
  box-sizing: border-box;
 background-size: cover;
 background-position: center center;
  display: flex;
   width: 100%;
  height: 100%;
  justify-content: center;
  align-items: center;
  
  
}
.container .content {
  position:absolute; /* Position the background text */
  align-items: center; /* At the bottom. Use top:0 to append it to the top */
  top: 3em;
  background: linear-gradient(to top, rgba(0, 0, 0, 0.85), transparent);
   /* background: rgb(241, 240, 243); 
   background: rgba(243, 242, 248, 0.5); */
  color: #e9dcdc; /* Grey text */
  width: 50%; /* Full width */
  padding:5px; /* Some padding */
  }
 .container.content.btn {
  color: dodgerblue;
  background: mediumturquoise;
  border: 5px solid #FFFF00;
  display: flex;
  justify-content: center;
  
  }
  .content{
    margin: 0 auto;
  }



  .top-container {
  position: relative;
  height: 100px;
  margin: 0 auto;
  text-align: center;
} 

.button {
  justify-content: center;
  /* position: fixed; */
  bottom: 0;
  padding: 15px 25px;
  font-size: 24px;
  text-align: center;
  cursor: pointer;
  outline: none;
  background: linear-gradient(to top, rgba(0, 0, 0, 0.85), transparent);
  color: rgb(238, 228, 225);
  background-color: #f8f7fc;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}


.button:active {
  
 background-color: #c9d5dd; 
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

  /* position: fixed;
  bottom: 0;
  /* background-color:lightskyblue;  */
  /* transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  cursor: pointer;
  border: none;
  color: rgb(143, 40, 8);
  box-shadow: 0 9px #999;
  padding: 20px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 12px;
  background: rgb(241, 240, 243); 
   background: rgba(243, 242, 248, 0.5);
   bottom: 0; */ 



/* .container{
  background-image:url("../assets/Home-Background.jpeg"); 
   /* background-image:url("../assets/Home-Background.jpeg") ;  */
  /* margin: 0;
  padding: 0;
  box-sizing: border-box;
 background-size: cover;
 background-position: center center;
 display: flex;
 width: 100%;
  height: auto;
  justify-content: center;
  align-items: center;
  
} */

 

/* /* * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: 'montserrat', sans-serif;
}

 /* home {
   background-image: url('/assets/home-page-books-image.png'); */
   /* background-size: cover;
  background-position: bottom;
  transition: 0.4s; */




 /* main {
  min-height: 100vh;
  padding: 25px; 

   background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.25), rgba(0, 0, 0, 0.75)); 
} */

/* .search-box {
  width: 100%;
  margin-bottom: 30px;
} */

/* .search-box .search-bar {
  display: block;
  width: 100%;
  padding: 15px;
  
  color: #313131;
  font-size: 20px;

  appearance: none;
  border:none;
  outline: none;
  background: none;

  box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.25);
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 0px 16px 0px 16px;
  transition: 0.4s;
} */

/* .search-box .search-bar:focus {
  box-shadow: 0px 0px 16px rgba(0, 0, 0, 0.25);
  background-color: rgba(255, 255, 255, 0.75);
  border-radius: 16px 0px 16px 0px;
} */

/* .location-box .location {
  color: #FFF;
  font-size: 32px;
  font-weight: 500;
  text-align: center;
  text-shadow: 1px 3px rgba(0, 0, 0, 0.25);
} */

/* .location-box .date {
  color: #FFF;
  font-size: 20px;
  font-weight: 300;
  font-style: italic;
  text-align: center;
} */

/* .weather-box {
  text-align: center;
} */

/* .weather-box .temp {
  display: inline-block;
  padding: 10px 25px;
  color: #FFF;
  font-size: 102px;
  font-weight: 900;

  text-shadow: 3px 6px rgba(0, 0, 0, 0.25);
  background-color:rgba(255, 255, 255, 0.25);
  border-radius: 16px;
  margin: 30px 0px;

  box-shadow: 3px 6px rgba(0, 0, 0, 0.25);
} */

/* .weather-box .weather {
  color: #FFF;
  font-size: 48px;
  font-weight: 700;
  font-style: italic;
  text-shadow: 3px 6px rgba(0, 0, 0, 0.25);
} */
/* 
/* .imageTwo {
  /* background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.), rgba(0, 0, 0, 0.8)); 
   } */
     
</style>
  