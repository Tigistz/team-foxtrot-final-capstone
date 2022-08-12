<template>
  <div class="container">
    <form v-on:submit.prevent="search">
      <div class="search-box">
        <input
          type="text"
          class="search-bar"
          placeholder="Search titles, authors,isbn ..."
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


      <input type="submit" value="Search" class="button" />

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

      <!-- <input id="two" type="radio" value="two" v-model="searchType"/> -->


      <!-- Old Radio Buttons vvvvvvv -->
      <!-- <div class="btn-group btn-group-toggle" data-toggle="buttons">
        <label class="btn btn-secondary active">
          <input
            type="radio"
            name="options"
            id="title"
            autocomplete="off"
            
            value="title"
            v-model="searchType"
            checked
          />
          Title
        </label>
        <label class="btn btn-secondary">
          <input type="radio" name="options" id="author" autocomplete="off" 
            v-bind:value="author"
            v-model="searchType"
          />
          Author
        </label>
        <label class="btn btn-secondary">
          <input type="radio" name="options" id="subject" autocomplete="off" 
            value="subject"
            v-model="searchType"
            />
          Subject
        </label>
      
      </div> -->



    <div>
      <book-list :books="books" />
    </div>
  </div>
</template>

<script>
import BookList from "./BookList.vue";
export default {
  name: "app",
  data() {
    return {
      options: [
        { text: 'Title', value: 'title' },
        { text: 'Author', value: 'author' },
        { text: 'Subject', value: 'subject' }
      ],
      api_key: "AIzaSyA2SB7helUW9bOBwnGTglWfkA31h0ovovg",
      url_base: " https://www.googleapis.com/books/v1/volumes?q=",
      searchType: 'title', //THIS IS TEMPORARY NEEDS TO CHANGE
      query: "",
      book: {
        title: "",
        author: "",
        isbn: "",
      },
      books: [],
      testArray: [],
      googleApiBooks: [],
    };
  },
  components: {
    BookList,
  },
  methods: {
    search() {
      fetch(
        `http://openlibrary.org/search.json?${this.searchType}=${this.query}&limit=15`
      ).then((response) => {
        response.json().then((data) => {
          console.log(data);

          this.testArray = [];
          data.docs.forEach(item =>{
            this.book = {};
            this.book.title = item.title;
            this.book.author = item.author_name[0];
            this.book.isbn = item.isbn[0];
            // console.log(this.book.title)
            this.testArray.push(this.book);
          })

          this.books = data.docs;
        });
      });
    },
  },
  //https://www.googleapis.com/books/v1/volumes?q=${this.inputType}${this.query}&orderBy=relevance&maxResults=9&key=AIzaSyA2SB7helUW9bOBwnGTglWfkA31h0ovovg
  //          console.log(data);
  // this.books = data.items;
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
  background-color: rgba(255, 255, 255, 0.5);
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

.weather-box {
  text-align: center;
}

.weather-box .temp {
  display: inline-block;
  padding: 10px 25px;
  color: #fff;
  font-size: 102px;
  font-weight: 900;

  text-shadow: 3px 6px rgba(0, 0, 0, 0.25);
  background-color: rgba(255, 255, 255, 0.25);
  border-radius: 16px;
  margin: 30px 0px;

  box-shadow: 3px 6px rgba(0, 0, 0, 0.25);
}

.weather-box .weather {
  color: #fff;
  font-size: 48px;
  font-weight: 700;
  font-style: italic;
  text-shadow: 3px 6px rgba(0, 0, 0, 0.25);
}
</style>
