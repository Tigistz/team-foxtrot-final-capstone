<template>
  <div class="book-list">
    <MyBookCard v-for="book in books" :key="book.id" :book="book"/>
  </div>
</template>

<script>
import MyBookCard from "./MyBookCard";
// import BookService from '../services/BookService';


export default {
  name: "myBooks",
  //comment out data section later and uncomment props section, delete dummy data
  // data(){
  //     return{
  //         books: []
  //     }
  // },  
  props: {
    books: {
      type: Array
    },
  },
  components: {
    MyBookCard
  },
//   created() {
//      retrieveFromInventory() {
//       BookService.getMyBooks().then( (response) => {
//        this.book = response.data;
//        }
//       )} 
//   }
};
</script>

<style>
</style>