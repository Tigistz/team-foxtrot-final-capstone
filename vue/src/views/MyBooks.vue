<template>
  <div>
    <h1 class="myBooks">My Books</h1>
    <h2 class="welcome">Welcome jiahui8!</h2>


    <book-list />
  </div>
</template>

<script>

import BookList from '../components/BookList.vue';

export default {
    components: {
        BookList
    },
    methods: {
        
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