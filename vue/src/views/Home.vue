<!--<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <h3 id="intro">ALPHA Book Library</h3>
    <img src="https://unsplash.com/photos/FKqxZ58bVjU" alt="">
  </div>
</template> -->

<template>
  
    <!--<main>
      <div class="search-box">
      <div class="home">
        <input 
          type="text" 
          class="search-bar" 
          placeholder="Search titles, authors,isbn ..."
          v-model="query"
          @keypress="fetchBooks"
        />
      </div>
      </div>
 </main> -->
  
  <book-search />
</template>



<script>
import BookSearch from '../components/BookSearch.vue';
export default {
  components: { 
    BookSearch,
  },
  name: "home"
};
</script>


<style>

</style>
