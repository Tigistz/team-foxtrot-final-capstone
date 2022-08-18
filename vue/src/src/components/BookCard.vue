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
    <p id="isbn-display">
      <span class="isbn-hidden">ISBN</span>
      <span class="isbn-unhidden">ISBN: {{ book.isbn }}</span>
    </p>

    <b-alert class="alert" v-if="alertMessage" show variant="danger"
      >Already Exists</b-alert
    >

    <div class="example-thing">
      <button
        type="button"
        class="btn btn-outline-secondary"
        v-on:click.prevent="addBookToInventory()"
        v-if="isSearchPage && loggedIn && !alertMessage"
      >
        Add to My Books
      </button>

      <!-- <div v-if="!isSearchPage">
        <b-dropdown text="Add to List" variant="transparent" id="selectAdd" class="m-2">
          <b-dropdown-item
            v-for="item in userReadingLists"
            
            :key="item.id"
            v-model="listToChangeTo"
          >
            {{ item.listName }}</b-dropdown-item
          >
        </b-dropdown>
      </div> -->

      <div v-if="!isSearchPage">
        <b-dropdown
          id="ddCommodity"
          name="ddCommodity"
          v-model="bookSelector.listSelection"
          text="Add to List"
          variant="light bg-transparent text-white"
          class="m-2"
        >
          <!-- <b-dropdown-item disabled value="0">Select an Item</b-dropdown-item> -->
          <b-dropdown-item-button
            v-for="item in userReadingLists"
            :key="item.listId"
            :value="item.listId"
            @click="changeBookList(item.listId)"
          >
            {{ item.listName }}
          </b-dropdown-item-button>

          <b-dropdown-item-button @click="deleteBook()">
            Delete Book
          </b-dropdown-item-button>
        </b-dropdown>
      </div>
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
        title: this.book.title,
        author: this.book.author,
        genre: this.book.subject,
        isbn: this.book.isbn,
      },
      updateBook: {
        bookId: this.bookId,
        readingListId: "",
      },

      listToChangeTo: "",

      alertMessage: false,

      someOtherProperty: null,
      bookSelector: {
        originalValue: [],
        listSelection: "Value1",
        disabled: false,
        readonly: false,
        visible: true,
        color: "",
      },

      // userReadingLists: [], //this is the group of user's reading lists
    };
  },
  props: {
    book: {
      type: Object,
      required: true,
    },
    userReadingLists: {
      type: Array,
    },
  },

  computed: {
    volumeInfo() {
      return this.book.volumeInfo;
    },
    isSearchPage() {
      return this.$route.name === "search";
    },
    loggedIn(){
      return this.$store.state.token != '';
    }
  },

  methods: {
    getBooks() {},
    addBookToInventory() {
      BookService.addBook(this.newBook)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push("/mybooks");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 418) {
            //alert("This book already exists in your reading list!");
            this.alertMessage = true;
          }
        });
    },

    createList() {
      BookService.createList(this.listName).then((response) => {
        if (response.status === 201) {
          this.$router.push("/mybooks");
        }
      });
    },

    deleteBook() {
      this.updateBook.readingListId = this.book.readingListId;
      this.updateBook.bookId = this.book.bookId;
      
      BookService.deleteBook(this.updateBook.readingListId, this.updateBook.bookId)
      .then((response) => {
        if (response.status === 204) {
          this.$router.go();
        } else {
          alert("There was an error!");
        }
      });
    },
    setThisId(id) {
      this.listToChangeTo = id;
    },

    changeBookList(id) {
      this.bookSelector.listSelection = id;
      this.updateBook.readingListId = id;
      this.updateBook.bookId = this.book.bookId;
      BookService.updateBookListId(this.updateBook).then((response) => {
        if (response.status === 200) {
          this.$router.go();
        } else {
          alert("There was an error!");
        }
      });
      console.log(id);
    },
  },
};
</script>



<style scoped>

.isbn-unhidden {
  display: none;
}

p:hover .isbn-hidden {
  display: none;
}

p:hover .isbn-unhidden {
  display: inline;
}



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
  background-color: rgba(0, 0, 0, 0.6);
  /* border: 1px solid black; */
  text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
}

.alert {
  /* styling for alert here */
  background-color: transparent;
  color: white;
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

#selectAdd {
  color: rgba(255, 255, 255, 0.884);
  border-color: rgba(255, 255, 255, 0.884);
}





</style>