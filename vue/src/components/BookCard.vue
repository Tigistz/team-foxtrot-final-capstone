<template>
  <div class="book">

    <h5>{{book.title}}</h5>
    <p v-if="book.author_name[0]">{{book.author_name[0]}}</p>
    
    <div class="imageParent">
    <img class="imageOne image" v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn[1] + '-M.jpg'" />
    <img 
    src="../assets/No_Preview_image.png"
    class="imageTwo image" 
    />
    </div>
    <p>ISBN: {{book.isbn[1]}}</p>



    <!-- <h4>{{volumeInfo.title}}</h4>
    <div class="author" v-if="volumeInfo.authors"> 
      <p>{{volumeInfo.authors[0]}}</p>
    </div>

    <div class="image" v-if="volumeInfo.imageLinks">
        <img :src="volumeInfo.imageLinks.thumbnail">
    </div> -->

    <button class="submit-button" v-on:click.prevent="addBookToInventory()">Add to My Books</button> 

  </div>
 

</template>

<script>
import BookService from '../services/BookService';
//Instead of button click adding to reading list, it needs to post to ./myBooks as the book object


export default {
    name: 'book-card',
    data() {
      return {
      newBook: {
        // title: this.book.volumeInfo.title,
        // author: this.book.volumeInfo.authors[0],
        // genre: this.book.volumeInfo.categories[0],
        title: this.book.title,
        author: this.book.author_name[0],
        genre: this.book.subject[0],
      }
      }
    },
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
      addBookToInventory() {
      BookService.addBook(this.newBook).then( (response) => {
       if (response.status === 201) {
         this.$router.push('/mybooks');
       }
    })
    },
    // checkAuthor(){
    //   if('imageLinks' in item.volumeInfo){
    //       thumbnail = item.volumeInfo.imageLinks.thumbnail;
              
    //   } 
    //   else{
    //       thumbnail = '';
    //   }
   // }
      }
    }
</script>



<style scoped>

.submit-button {
  /* justify-self: flex-end; */
}

.imageParent{
  position: relative;
  top: 0;
  left: 0;
}

.image {
    position: relative;
    width: 150px;
    height: 200px;
    /* border: 1px solid red; */
}
.imageOne {
    position: relative;
  top: 0;
  left: 0;
    z-index: 1;
}
.imageTwo {
    position: absolute;
    top: 0px;
    left: 15px;
    z-index: 0;
}
.book {  
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  width: 200px;
  height: 450px;
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