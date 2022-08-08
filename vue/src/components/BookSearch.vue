<<<<<<< HEAD


<template>
  <div>
    <div id="container">
      <div id="search">
        <label for="title"ls
          >Enter Book Name</label
        >
        <input type="text" name="zip" v-model="titleFilter"/>
      </div>
      <p v-if="filteredBooks.length == 0">No books found</p>
      <div id="main-div" v-if="filteredbooks.length > 0">
        <div class="divTable minimalistBlack">
          <div class="divTableHeading">
            <div class="divTableRow">
              <div class="divTableHead">Image</div>
              <div class="divTableHead">title</div>
              <div class="divTableHead">author</div>
              <div class="divTableHead">isbn</div>
              <div class="divTableHead">genre</div>
            </div>
          </div>
          <div class="divTableBody">
            <div class="divTableRow" v-for="book in filteredBooks" v-bind:key="book.isbn">
              <div class="divTableCell">
                   <img v-bind:src=getImageURL(book.imageName)>
                   <div>ISBN# {{book.isbn}}</div>
              </div>
              <div class="divTableCell">{{book.title}} 
                   <div>    
                     {{book.title}}, {{home.author}} {{home.genre}}
                  </div>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import bookService from "../services/BookService.js";

export default {

  name: "book-search",
  data() {
    return {
       titleFilter: '',
       books: []
    };
  },
  computed: {

      filteredBook() {
   
        return this.books.filter( book => {
             return this.titleFilter == '' ? true : this.titleFilter == book.title;
        });

      }

  },
  created() {

    bookService.search().then( response => {
       this.books = response.data;
    })

  },
  methods : {

     getImageURL(pic) {
      return require('../assets/' + pic)
    }
   
  }

  

};
</script>

<style scoped>

#container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

#search {
    margin:40px;
}

input[type=text] {
    margin:30px;
    padding: 12px 20px;
    border: 2px solid green;
    border-radius: 3px;
}

img{
   width:150px;
   height:150px;

/*Scale down will take the necessary specified space that is 100px x 100px without stretching the image*/
    object-fit:scale-down;

}


div.minimalistBlack {
  margin: auto;
  border: 2px solid #06b712;
  width: 80%;
  text-align: left;
  border-collapse: collapse;
}
.divTable.minimalistBlack .divTableCell,
.divTable.minimalistBlack .divTableHead {
  border: 1px solid #000000;
  padding: 5px 4px;
}

.divTable.minimalistBlack .divTableBody .divTableCell {
  font-size: 14px;
}
.divTable.minimalistBlack .divTableHeading {
  background: #1dff2c;
  background: -moz-linear-gradient(top, #55ff61 0%, #33ff41 66%, #1dff2c 100%);
  background: -webkit-linear-gradient(
    top,
    #55ff61 0%,
    #33ff41 66%,
    #1dff2c 100%
  );
  background: linear-gradient(to bottom, #55ff61 0%, #33ff41 66%, #1dff2c 100%);
  border-bottom: 3px solid #0f9a39;
}
.divTable.minimalistBlack .divTableHeading .divTableHead {
  font-size: 15px;
  font-weight: bold;
  color: #109902;
  text-align: left;
}
.minimalistBlack .tableFootStyle {
  font-size: 14px;
}
/* DivTable.com */
.divTable {
  display: table;
  table-layout: fixed;
}
.divTableRow {
  display: table-row;
}
.divTableHeading {
  display: table-header-group;
}
.divTableCell,
.divTableHead {
  display: table-cell;
}
.divTableHeading {
  display: table-header-group;
}
.divTableFoot {
  display: table-footer-group;
}
.divTableBody {
  display: table-row-group;
}
</style>
=======
<template>
    <div class="container">
      <div class="search-box">
        <input
          type="text"
          class="search-bar"
          placeholder="Search titles, authors,isbn ..."
          v-model="query"
          @keypress="fetchBooks"
        />
      </div>
      <button>Press Enter to Continue</button>
    </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      api_key: "AIzaSyA2SB7helUW9bOBwnGTglWfkA31h0ovovg",
      url_base: " https://www.googleapis.com/books/v1/volumes?=",
      query: "",
      books: {},
    };
  },
  methods: {
    fetchBooks(e) {
      if (e.key == "Enter") {
        fetch(
          `${this.url_base}books?q=${this.query}&APPID=${this.api_key}`
        )
          .then((response) => {
            return response.json();
          })
          .then(this.setResults);
      }
    },
    setResults(results) {
      this.book = results;
    },
  },
};
</script>

<style>
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
  margin-bottom: 30px;
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
>>>>>>> 484a502d2c16d2ce40b4e2c36bad2744bc6936c3
