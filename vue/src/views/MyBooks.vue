<template>
  <div class="container">
    <div class="welcome-banner">
      <h1 class="myBooks">My Books</h1>
      <h2 class="welcome">Welcome {{ $store.state.user.username }}!</h2>

      <div>
        <b-button-group>
          <b-button
            variant="dark"
            v-for="list in userReadingLists"
            :key="list.listId"
            v-on:click="displaySelectedReadingList()"
            >{{ list.listName }}</b-button
          >
        </b-button-group>
      </div>
    </div>

    <book-list :books="books" :userReadingLists="userReadingLists" />

    <div>
      <form class="list-form" v-on:submit.prevent="createList()">
        <div class="form-group">
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
            placeholder="List Name... (required)"
            required="true;"
            v-model="list.listName"
          />
        </div>
        <button class="submit-button" v-on:click.prevent="createList()">
          Create List
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import BookList from "../components/BookList.vue";
import BookService from "../services/BookService.js";

export default {
  name: "myBooks",
  data() {
    return {
      books: [], //this is the book objects we feed into the bookcards
      list: {  //this is the create new list name
        listId: "",
        listName: "",
      },
      userReadingLists: [], //this is the group of user's reading lists
    };
  },
  components: {
    BookList,
  },
  methods: {
    getBooks() {},

    createList() {
      BookService.createList(this.list).then((response) => {
        if (response.status === 201) {
          // this.$router.push("/mybooks");
          // alert("Success!");
          this.$router.go();
        }
      });
    },
    displaySelectedReadingList(){
      BookService.retrieveSelectedList(this.list.listId)
      .then((response) => {
        this.books = response.data;
      });
    }
  },
  created() {
    BookService.getMyBooks().then((response) => {
      this.books = response.data;
      console.log(response.data);
    }),
      BookService.retrieveLists().then((response) => {
        this.userReadingLists = response.data;
        console.log(response.data);
      });
  },
};
</script>

<style scoped>
.welcome-banner {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 45vw;
  margin: 30px;
  text-align: left;
  background-color: rgba(0, 0, 0, 0.5);
  color: rgba(255, 255, 255, 0.884);
  text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

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
  /* min-height: 100vh; */
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

h2 h1 {
  color: rgba(255, 255, 255, 0.884);
}
</style>
