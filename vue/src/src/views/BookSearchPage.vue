

<template>
  <div>
    
           <home-search />
    
  </div>
</template>

<script>


export default {
  name: "book-search",
  data() {
    return{
      titleFilter:''};
    },
    computed: {filteredBooks(){
      const books= this.$store.title.books;
      return books.filter(books => {
        return this.titleFilter == ''? true: this.titleFilter == books.title;
      })
    }
 
    }
    
  

}
</script>

<style>

</style>
    