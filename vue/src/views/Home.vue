<template>

  
    <div class="container">
    
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


<style scoped>
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


     
</style>