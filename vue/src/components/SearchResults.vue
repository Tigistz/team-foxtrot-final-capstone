<template>
  <div>
      <book-search />
      <book-card />

    
  </div>
</template>

<script>

import bookService from '../services/BookService';
import BookCard from './BookCard.vue';
import BookSearch from './BookSearch.vue';

export default {
  components: { 
      BookCard,
      BookSearch },
    name: 'search',
    data() {
        return {
            books: [],
        }
    },
    methods: {
        getData() {
            bookService.search().then( (response) => {
                this.info = response.data;
            });
        }
    }

}
</script>

<style>

</style>