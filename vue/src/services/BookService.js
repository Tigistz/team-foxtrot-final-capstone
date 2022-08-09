import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
  });

export default {

   search() {
       return axios.get('/books')
   },

   addBook(book) {
       return http.post('/mybooks', book)
   }

}
