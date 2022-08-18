<template>
  <div class="container">
    <form v-on:submit.prevent="search">
      <div class="search-box">
        <input
          type="text"
          class="search-bar"
          placeholder="Search titles, authors, subject ..."
          v-model="query"
        />
        
      </div>

    <b-form-group v-slot="{ ariaDescribedby }">
      <b-form-radio-group
        id="btn-radios-1"
        v-model="searchType"
        :options="options"
        :aria-describedby="ariaDescribedby"
        name="radios-btn-default"
        buttons
      ></b-form-radio-group>
    </b-form-group>
      <!-- <input type="submit" value="Search" class="btn btn-outline-secondary btn-lg" /> -->
      <button type="submit" class="button">Search</button>
      <!-- <div>
        <label for="filter">Search By</label>&nbsp;
        <select name="filter" v-model="inputType">
          <option value="title">Title</option>
          <option value="author">Author</option>
          <option value="isbn:">ISBN</option> comment this out
          <option value="subject">Subject</option>
        </select>
      </div> -->
    </form>


    <div class="content">
      <book-list v-if="loadState == 'success'" :books="books" />
      <div class="loading" v-if="loadState == 'loading'"></div>
    </div>
  </div>
</template>

<script>
import BookList from "./BookList.vue";
export default {
  name: "app",  //this used to be app
  data() {
    return {
      options: [
        { text: ' Title', value: 'title' },
        { text: ' Author', value: 'author' },
        { text: ' Subject', value: 'subject' }
      ],
      api_key: "AIzaSyA2SB7helUW9bOBwnGTglWfkA31h0ovovg",
      url_base: " https://www.googleapis.com/books/v1/volumes?q=",
      searchType: 'title', //THIS IS TEMPORARY NEEDS TO CHANGE
      query: "",
      book: {
        title: "",
        author: "",
        isbn: "",
        subject: ""
      },
      loadState:'',
      books: []
    };
  },
  components: {
    BookList,
  },
  methods: {
    search() {
      this.loadState = 'loading'
      fetch(
        `http://openlibrary.org/search.json?${this.searchType}=${this.query}&limit=15`
      ).then((response) => {
        response.json().then((data) => {
          console.log(data);

          this.books = [];
          data.docs.forEach(item =>{
            this.book = {};
            this.book.title = item.title;
            this.book.author = item.author_name[0];
            this.book.isbn = item.isbn[3];
            // this.book.subject = item.subject[0];
            this.books.push(this.book);
            
          })
          this.loadState = 'success'
          //this.books = data.docs; this is the old method
        });
      });
    },
  },

};
</script>


<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: "montserrat", sans-serif;
}

#app {
  /* background-image: url("./assets/home-page-books-image.jpg"); */
  background-size: cover;
  background-position: bottom;
  transition: 0.4s;
}

main {
  min-height: 100vh;
  padding: 25px;

  background-image: linear-gradient(
    to bottom,
    rgba(0, 0, 0, 0.25),
    rgba(0, 0, 0, 0.75)
  );
}

.search-box {
  width: 100%;
  margin-bottom: 2vh;
  margin-top: 2vh;
}

.search-box .search-bar {
  display: block;
  width: 100%;
  padding: 15px;

  color: #313131;
  font-size: 20px;

  appearance: none;
  border: none;
  outline: none;
  background: none;

  box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.25);
  background-color: rgba(255, 255, 255, 0.7);
  border-radius: 0px 16px 0px 16px;
  transition: 0.4s;
}

.search-box .search-bar:focus {
  box-shadow: 0px 0px 16px rgba(0, 0, 0, 0.25);
  background-color: rgba(255, 255, 255, 0.75);
  border-radius: 16px 0px 16px 0px;
}

.location-box .location {
  color: #fff;
  font-size: 32px;
  font-weight: 500;
  text-align: center;
  text-shadow: 1px 3px rgba(0, 0, 0, 0.25);
}

.location-box .date {
  color: #fff;
  font-size: 20px;
  font-weight: 300;
  font-style: italic;
  text-align: center;
}

/* Loader: shamelessly taken from https://codepen.io/veganben/pen/GAgsH */
.loading {
  height: 0;
  width: 0;
  padding: 15px;
  border: 9px solid #ccc;
  border-right-color: #2c3e50;
  border-radius: 28px;
  -webkit-animation: rotate 1s infinite linear;
  position: absolute;
  left: 49%;
  top: 50%;
}

@-webkit-keyframes rotate {
  /* 100% keyframe for  clockwise. 
     use 0% instead for anticlockwise */
  100% {
    -webkit-transform: rotate(360deg);
  }
}


#btn-radios-1{
  
}

.button {
  
  background-color:#f73e06; 
  
  /* #e75123;  */
  border: none;
  color: white;
  padding: 10px 50px;
  text-align: center;
  font-size: 20px;
  margin: 4px 2px;
  opacity: 0.8;
  transition: 0.1s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  border-radius: 3px;
  margin-top: 2vh;
}

.button:hover {opacity: 1}


</style>
