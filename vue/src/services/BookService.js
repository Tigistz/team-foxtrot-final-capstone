import axios from 'axios';

// const http = axios.create({
//     baseURL: "http://localhost:9000"
//   });

export default {

   search() {
       return axios.get('/books')
   },

   addBook(book) {
       return axios.post('/mybooks', book)
   },

   getMyBooks() {
       return axios.get('/mybooks')
   },

   createList(listName) {
       return axios.post('/readinglists', listName)
   },

   retrieveLists(){
       return axios.get('/readinglists')
   },

   retrieveSelectedList(id){
       return axios.get(`/readinglists/${id}`);
   }

}
