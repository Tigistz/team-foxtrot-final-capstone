<template>
  <div class="book-list">
    <BookCard v-for="book in books" :key="book.id" :book="book" :userReadingLists="userReadingLists"/>
  </div>
</template>

<script>
import BookCard from "./BookCard";



export default {
  //comment out data section later and uncomment props section, delete dummy data
  data(){
      return{
        
      }
  },  
  props: {
    books: {
      type: Array
    },
    userReadingLists: {
      type: Array
    }
  },
  components: {
    BookCard
  },
  
};
</script>

<style>
.book-list{
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: 96px 0px 96px 0px;
}
</style>
