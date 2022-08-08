

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