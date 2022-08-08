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
      url_base: " https://www.googleapis.com/books/v1/volumes?q=", 
      inputType: "",
      query: "",
      books: [],
    };
  },
  methods: {
    fetchBooks(e) {
      if (e.key == "Enter") {
        fetch(
          `${this.url_base}${this.inputType}${this.query}`
        )
          .then((response) => {
            // return response.json();
            this.handleResponse(response);
          })
          .then(this.setResults);
      }
    },
    setResults(results) {
      this.book = results;
    },
    handleResponse(response) {
      let title = '';
      let thumbnail = '';
      let author = '';
      for (let i = 0; i < 8; i++) {
        let item = response.items[i];
        title = item.volumeInfo.title;
        author = item.volumeInfo.authors[0];
        if('imageLinks' in item.volumeInfo){
            thumbnail = item.volumeInfo.imageLinks.thumbnail;
               
        } 
        else{
            thumbnail = '';
        }
        console.log(title + author + thumbnail);
      }
    }
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
