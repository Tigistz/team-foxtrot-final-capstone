<template>
  <div class="book-list">
    <BookCard v-for="book in books" :key="book.id" :book="book"/>
  </div>
</template>

<script>
import BookCard from "./BookCard";

export default {
  //comment out data section later and uncomment props section, delete dummy data
  // data(){
  //     return{
  //         books: []
  //     }
  // },  
  props: {
    books: {
      type: Array
    }
  },
  components: {
    BookCard
  }
};
</script>

<style>
</style>
