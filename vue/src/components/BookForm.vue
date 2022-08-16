<template>
  <div id="add-your-book">
    <h1>Add Your Own Book!</h1>
    <div class="form-entire-form">
      <!-- form -->

      <form class="new-book-form" v-on:submit.prevent="addBookToInventory">
        <div class="form-group">
          <!-- <label for="exampleFormControlInput1">Book Title</label> -->
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
            placeholder="Book Title... (required)"
            required="true;"
            v-model="newBook.title"
          />
        </div>
        <div class="form-group">
          <!-- <label for="exampleFormControlInput1">Book Author</label> -->
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
            placeholder="Author Name..."
            v-model="newBook.author"
          />
        </div>
        <div class="form-group">
          <!-- <label for="exampleFormControlInput1">Book Author</label> -->
          <input
            type="text"
            class="form-control"
            id="exampleFormControlInput1"
            placeholder="ISBN Number..."
            v-model="newBook.isbn"
          />
        </div>
          <div class="form-group">
            <!-- <label for="exampleFormControlInput1">Book Title</label> -->
            <input
              type="text"
              class="form-control"
              id="exampleFormControlInput1"
              placeholder="Book Genre..."
              required="false;"
              v-model="newBook.subject"
            />
          </div>
        

        <button class="submit-button" v-on:click.prevent="addBookToInventory()">
          Add to My Books
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import BookService from "../services/BookService";
export default {
  name: "bookForm",
  data() {
    return {
      newBook: {
        title: "",
        author: "",
        isbn: "",
        genre: "",
      },
    };
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
  },
};
</script>

<style scoped>
#add-your-book {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  width: 40vw;
  height: 50vh;
  border-radius:10px;
}

h1 {
 color:rgba(255, 255, 255, 0.884);
  margin-top: 4vh;
  margin-bottom: 2vh;
}

/* .form-entire-form {
  display: flex;
  justify-content: center;
  margin-top: 5vh;
} */

.form-group {
  width: 30vw;
  margin: 2vh;
}
.submit-button {
  color: rgba(255, 255, 255, 0.884);
  border-color: rgb(255, 94, 0);
  background-color: rgb(255, 94, 0);

}
</style>