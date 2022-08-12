<template>
<div class="book">
    <h5>{{ book.title }}</h5>
    <p>{{ book.author}}</p>

    <div class="imageParent">
      <img
        class="imageOne image"
        v-if="book.isbn"
        v-bind:src="
          'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
        "
      />
      <img src="../assets/No_Preview_image.png" class="imageTwo image" />
    </div>
    <p>ISBN: {{ book.isbn }}</p>

    <div class="example-thing">
      <button class="submit-button" v-on:click.prevent="">
        Mark Read
      </button>
    </div>
  </div>
</template>

<script>

//Instead of button click adding to reading list, it needs to post to ./myBooks as the book object


export default {
    name: 'book-card',
    data() {
      return {

      }
    },
    props: {
      book:{
        type: Object,
        required: true
      }
    },
    
    computed: {
      bookInfo(){
        return this.myBook
      }
    },
    

    methods: {
      getBooks() {
          
      },
      
    }
}
</script>



<style scoped>
.submit-button {
  /* justify-self: flex-end; */
}

.imageParent {
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
  /* justify-content: space-evenly; */
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