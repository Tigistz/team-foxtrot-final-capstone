<template>
  <div >
    <!-- <h1>Add Your Own Book!</h1> -->
    <!-- <div class="form-entire-form"> -->
      <!-- form id="add-your-book" -->

      <form id="add-your-book" class="new-book-form" v-on:submit.prevent="addBookToInventory">
        <h2>Add Your Own Book!</h2>
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
        

        <!-- <button class="submit-button" v-on:click.prevent="addBookToInventory()"> -->
         <button type="submit" class="btn btn-danger">Add to My Books</button>
          
        <!-- </button> -->
      </form>
    </div>
  <!-- </div> -->
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
  display:flex;
  
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  width: 30vw;
  height: 50vh;
  margin-left: 28%;
  margin-top: 15%;
  border-radius: 15px;
  
  
  
  
}

h2 {
 color:rgba(255, 255, 255, 0.884);
  margin-top: 2vh;
  margin-bottom: 2vh;
}

/* .form-entire-form {
  display: flex;
  justify-content: center;
  margin-top: 5vh;
} */

.form-group {
  width: 20vw;
  margin: 1vh;
}
.btn-danger, .btn-danger:hover {
 
  color: rgba(255, 255, 255, 0.884);
  border-color: rgb(255, 94, 0);
  background-color: rgb(255, 94, 0);
  margin-top: 1vh;
  
}

/* .submit-button {
  color: rgba(255, 255, 255, 0.884);
  border-color: rgb(255, 94, 0);
  background-color: rgb(255, 94, 0);
   */
  /* justify-content: center; */
  /* position: fixed;
  bottom: 0;
  padding: 15px 25px;
  font-size: 24px;
  text-align: center;
  cursor: pointer;
  outline: none;
  background: linear-gradient(to top, rgba(0, 0, 0, 0.85), transparent);
  color: rgb(238, 228, 225);
  background-color: #f8f7fc;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999; */

.button:active {
  
 background-color: #c9d5dd; 
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>