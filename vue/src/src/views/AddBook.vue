<template>
  <div class="container">
    <book-form/>
  </div>
</template>

<script>
import BookForm from '../components/BookForm.vue'
export default {
    name: 'addBook',
  components: { BookForm },

}
</script>

<style>
.container {
  min-height: 100vh;
}
</style>