import axios from 'axios';

export default {

   search() {
       return axios.get('/books')
   },

   addBooks(book) {
       return axios.post('/books', book)
   }

}
