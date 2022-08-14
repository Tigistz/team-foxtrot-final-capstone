<template>
  <div class="book">
    <h5>{{ book.title }}</h5>
    <p v-if="book.author">{{ book.author }}</p>

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

      <button type="button" class="btn btn-outline-secondary" 
      v-on:click.prevent="addBookToInventory()"
      v-if="isSearchPage"
      >
        Add to My Books
      </button>

      <button type="button" class="btn btn-outline-secondary" 
      v-on:click.prevent=""
      v-if="!isSearchPage"
      >
        Remove From My Books
      </button>

    </div>
  </div>
</template>

<script>
import BookService from "../services/BookService";
//Instead of button click adding to reading list, it needs to post to ./myBooks as the book object

export default {
  name: "book-card",
  data() {
    return {
      newBook: {
        // title: this.book.volumeInfo.title,
        // author: this.book.volumeInfo.authors[0],
        // genre: this.book.volumeInfo.categories[0],
        title: this.book.title,
        author: this.book.author,
        genre: this.book.subject,
        isbn: this.book.isbn
      },
    };
  },
  props: {
    book: {
      type: Object,
      required: true,
    },
  },

  computed: {
    volumeInfo() {
      return this.book.volumeInfo;
    },
    isSearchPage() {
     return this.$route.name === 'search'
  }
  },

  methods: {
    getBooks() {},
    addBookToInventory() {
      BookService.addBook(this.newBook).then((response) => {
        if (response.status === 201) {
          this.$router.push("/mybooks");
        }
      });
    },
    removeBookFromInventory(){
      //bookservice.delete(this.book).then((response) => {
      //  if(response.status === 200) {
      //    this.$router.push("/mybooks");
      //}  
      //})
    }
  },
};
</script>



<style scoped>
.btn-outline-secondary {
  /* justify-self: flex-end; */
  background-color: rgba(0, 0, 0, 0.5);
  color: rgba(255, 255, 255, 0.884);
  border-color: rgba(255, 255, 255, 0.884);
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
  justify-content: space-evenly;
  width: 200px;
  height: 450px;
  /* box-shadow: 0 0 20px #aaa; */
  margin: 25px;
  padding: 10px 10px 0 10px;
  vertical-align: top;
  transition: height 1s;
  background-color: rgba(0, 0, 0, 0.5);
  text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
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


p {
  color: rgba(255, 255, 255, 0.884);
}

h5 {
  color: rgba(255, 255, 255, 0.884);
}

</style>