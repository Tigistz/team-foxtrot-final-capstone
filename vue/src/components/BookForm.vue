<template>
  <div>
    <h2>Add Your Own Book</h2>
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
h2 {
  margin-top: 5vh;
  color:white
}

.form-entire-form {
  display: flex;
  justify-content: center;
  margin-top: 5vh;
}

.form-group {
  width: 50vw;
  margin: 2vh;
}
</style>