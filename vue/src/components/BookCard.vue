<template>
  <div class="book">
    <h4>{{volumeInfo.title}}</h4>
    <div class="author" v-if="volumeInfo.authors"> 
      <p>{{volumeInfo.authors[0]}}</p>
    </div>

    <div class="image" v-if="volumeInfo.imageLinks">
        <img :src="volumeInfo.imageLinks.thumbnail">
    </div>

    <button v-on:click.prevent="addToReadingList(book)">Add to My Books</button> 

  </div>
 

</template>

<script>
//Instead of button click adding to reading list, it needs to post to ./myBooks as the book object


export default {
    name: 'book-card',
    props: {
      book:{
        type: Object,
        required: true
      }
    },
    
    computed: {
      volumeInfo(){
        return this.book.volumeInfo
      }
    },
    

    methods: {
      getBooks() {
          
      },
      addToReadingList(book){
        let addedBook = Object.assign({read: false}, book);
        this.$store.commit('SAVE_BOOK', addedBook);
      }
    }
}
</script>



<style>
.book {  
  display: inline-block;
  width: 230px;
  height: 390px;
  box-shadow: 0 0 20px #aaa;
  margin: 25px;
  padding: 10px 10px 0 10px;
  vertical-align: top;
  transition: height 1s;
}

.book-cover {
    width: 100%;
    height: auto;
    display: block;

}

.book-title {
   margin-top: 12px;
   font-size: 20px;
   text-align: center; 
}

.book-author {

}

</style>