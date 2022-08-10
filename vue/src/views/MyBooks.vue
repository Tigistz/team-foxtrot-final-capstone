<template>
  <div>
    <h1 class="myBooks">My Books</h1>
    <h2 class="welcome">Welcome jiahui8!</h2>


    <my-book-list :books="books"/>
  </div>
</template>

<script>

import MyBookList from '../components/MyBookList.vue';
import BookService from '../services/BookService.js';

export default {
    name: 'myBooks',
    data() {
        return {
            books: []
        }
    },
    components: {
        MyBookList,
    },
    methods: {
        getBooks() {

        }
        
    },
    created() {
        BookService.getMyBooks().then( (response) => {
               this.books = response.data;
               console.log(response.data);
    })
    }

}
</script>

<style>
    .myBooks {
        margin: 30px;
        text-align: left;
    }
    .welcome {
        margin: 30px;
        text-align: left;
    }
</style>