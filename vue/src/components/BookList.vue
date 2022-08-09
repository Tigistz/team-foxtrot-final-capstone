<template>
  <div class="book-list">
    <BookCard v-for="book in books" :key="book.id" :book="book"/>
  </div>
</template>

<script>
import BookCard from "./BookCard";

export default {
  //comment out data section later and uncomment props section, delete dummy data
  data(){
      return{
          books: [
            {
          title: "Kafka on the Shore",
          author: "Haruki Murakami",
          read: false,
          isbn: "9781400079278",
          genre:"Fiction" 
        },
        {
          title: "The Girl With All the Gifts",
          author: "M.R. Carey",
          read: true,
          isbn: "9780356500157",
          genre:"Non-Fiction" 
        },
        {
          title: "The Old Man and the Sea",
          author: "Ernest Hemingway",
          read: true,
          isbn: "9780684830490",
          genre:"Non-Fiction" 
        },
        {
          title: "Le Petit Prince",
          author: "Antoine de Saint-Exupéry",
          read: false,
          isbn: "9783125971400",
          genre:"Fiction" 
        }
          ]
      }
  },  
  // props: {
  //   books: {
  //     type: Array
  //   }
  // },
  components: {
    BookCard
  }
};
</script>

<style>
</style>
